/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.jpeg;

import javax.imageio.IIOException;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;

import java.io.IOException;

import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

/**
 * An Adobe APP14 (Application-Specific) marker segment.
 */
class AdobeMarkerSegment extends MarkerSegment {
    int version;
    int flags0;
    int flags1;
    int transform;
    private static final int ID_SIZE = 5;

    AdobeMarkerSegment(int transform) {
        super(JPEG.APP14);
        version = 101;
        flags0 = 0;
        flags1 = 0;
        this.transform = transform;
    }

    AdobeMarkerSegment(JPEGBuffer buffer) throws IOException {
        super(buffer);
        buffer.bufPtr += ID_SIZE; // Skip the id
        version = (buffer.buf[buffer.bufPtr++] & 0xff) << 8;
        version |= buffer.buf[buffer.bufPtr++] & 0xff;
        flags0 = (buffer.buf[buffer.bufPtr++] & 0xff) << 8;
        flags0 |= buffer.buf[buffer.bufPtr++] & 0xff;
        flags1 = (buffer.buf[buffer.bufPtr++] & 0xff) << 8;
        flags1 |= buffer.buf[buffer.bufPtr++] & 0xff;
        transform = buffer.buf[buffer.bufPtr++] & 0xff;
        buffer.bufAvail -= length;
    }

    AdobeMarkerSegment(Node node) throws IIOInvalidTreeException {
        this(0); // default transform will be changed
        updateFromNativeNode(node, true);
    }

    IIOMetadataNode getNativeNode() {
        IIOMetadataNode node = new IIOMetadataNode("app14Adobe");
        node.setAttribute("version", Integer.toString(version));
        node.setAttribute("flags0", Integer.toString(flags0));
        node.setAttribute("flags1", Integer.toString(flags1));
        node.setAttribute("transform", Integer.toString(transform));

        return node;
    }

    void updateFromNativeNode(Node node, boolean fromScratch)
        throws IIOInvalidTreeException {
        // Only the transform is required
        NamedNodeMap attrs = node.getAttributes();
        transform = getAttributeValue(node, attrs, "transform", 0, 2, true);
        int count = attrs.getLength();
        if (count > 4) {
            throw new IIOInvalidTreeException
                ("Adobe APP14 node cannot have > 4 attributes", node);
        }
        if (count > 1) {
            int value = getAttributeValue(node, attrs, "version",
                                          100, 255, false);
            version = (value != -1) ? value : version;
            value = getAttributeValue(node, attrs, "flags0", 0, 65535, false);
            flags0 = (value != -1) ? value : flags0;
            value = getAttributeValue(node, attrs, "flags1", 0, 65535, false);
            flags1 = (value != -1) ? value : flags1;
        }
    }

    /**
     * Writes the data for this segment to the stream in
     * valid JPEG format.
     */
    void write(ImageOutputStream ios) throws IOException {
        length = 14;
        writeTag(ios);
        byte [] id = {0x41, 0x64, 0x6F, 0x62, 0x65};
        ios.write(id);
        write2bytes(ios, version);
        write2bytes(ios, flags0);
        write2bytes(ios, flags1);
        ios.write(transform);
    }

    static void writeAdobeSegment(ImageOutputStream ios, int transform)
        throws IOException {
        (new AdobeMarkerSegment(transform)).write(ios);
    }

    void print () {
        printTag("Adobe APP14");
        System.out.print("Version: ");
        System.out.println(version);
        System.out.print("Flags0: 0x");
        System.out.println(Integer.toHexString(flags0));
        System.out.print("Flags1: 0x");
        System.out.println(Integer.toHexString(flags1));
        System.out.print("Transform: ");
        System.out.println(transform);
    }
}
