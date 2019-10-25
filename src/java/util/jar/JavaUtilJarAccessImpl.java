/*
 * Copyright (c) 2002, 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.util.jar;

import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.List;
import sun.misc.JavaUtilJarAccess;

class JavaUtilJarAccessImpl implements JavaUtilJarAccess {
    public boolean jarFileHasClassPathAttribute(JarFile jar) throws IOException {
        return jar.hasClassPathAttribute();
    }

    public CodeSource[] getCodeSources(JarFile jar, URL url) {
        return jar.getCodeSources(url);
    }

    public CodeSource getCodeSource(JarFile jar, URL url, String name) {
        return jar.getCodeSource(url, name);
    }

    public Enumeration<String> entryNames(JarFile jar, CodeSource[] cs) {
        return jar.entryNames(cs);
    }

    public Enumeration<JarEntry> entries2(JarFile jar) {
        return jar.entries2();
    }

    public void setEagerValidation(JarFile jar, boolean eager) {
        jar.setEagerValidation(eager);
    }

    public List<Object> getManifestDigests(JarFile jar) {
        return jar.getManifestDigests();
    }

    public Attributes getTrustedAttributes(Manifest man, String name) {
        return man.getTrustedAttributes(name);
    }

    public void ensureInitialization(JarFile jar) {
        jar.ensureInitialization();
    }
}
