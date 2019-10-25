/*
 * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.lang;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;

class CharacterName {

    private static SoftReference<byte[]> refStrPool;
    private static int[][] lookup;

    private static synchronized byte[] initNamePool() {
        byte[] strPool = null;
        if (refStrPool != null && (strPool = refStrPool.get()) != null)
            return strPool;
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new InflaterInputStream(
                AccessController.doPrivileged(new PrivilegedAction<InputStream>()
                {
                    public InputStream run() {
                        return getClass().getResourceAsStream("uniName.dat");
                    }
                })));

            lookup = new int[(Character.MAX_CODE_POINT + 1) >> 8][];
            int total = dis.readInt();
            int cpEnd = dis.readInt();
            byte ba[] = new byte[cpEnd];
            dis.readFully(ba);

            int nameOff = 0;
            int cpOff = 0;
            int cp = 0;
            do {
                int len = ba[cpOff++] & 0xff;
                if (len == 0) {
                    len = ba[cpOff++] & 0xff;
                    // always big-endian
                    cp = ((ba[cpOff++] & 0xff) << 16) |
                         ((ba[cpOff++] & 0xff) <<  8) |
                         ((ba[cpOff++] & 0xff));
                }  else {
                    cp++;
                }
                int hi = cp >> 8;
                if (lookup[hi] == null) {
                    lookup[hi] = new int[0x100];
                }
                lookup[hi][cp&0xff] = (nameOff << 8) | len;
                nameOff += len;
            } while (cpOff < cpEnd);
            strPool = new byte[total - cpEnd];
            dis.readFully(strPool);
            refStrPool = new SoftReference<>(strPool);
        } catch (Exception x) {
            throw new InternalError(x.getMessage(), x);
        } finally {
            try {
                if (dis != null)
                    dis.close();
            } catch (Exception xx) {}
        }
        return strPool;
    }

    public static String get(int cp) {
        byte[] strPool = null;
        if (refStrPool == null || (strPool = refStrPool.get()) == null)
            strPool = initNamePool();
        int off = 0;
        if (lookup[cp>>8] == null ||
            (off = lookup[cp>>8][cp&0xff]) == 0)
            return null;
        @SuppressWarnings("deprecation")
        String result = new String(strPool, 0, off >>> 8, off & 0xff);  // ASCII
        return result;
    }
}
