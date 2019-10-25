/*
 * Copyright (c) 2001, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.gif;

import java.util.Arrays;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.metadata.IIOMetadataFormat;
import javax.imageio.metadata.IIOMetadataFormatImpl;

public class GIFImageMetadataFormat extends IIOMetadataFormatImpl {

    private static IIOMetadataFormat instance = null;

    private GIFImageMetadataFormat() {
        super(GIFImageMetadata.nativeMetadataFormatName,
              CHILD_POLICY_SOME);

        // root -> ImageDescriptor
        addElement("ImageDescriptor",
                   GIFImageMetadata.nativeMetadataFormatName,
                   CHILD_POLICY_EMPTY);
        addAttribute("ImageDescriptor", "imageLeftPosition",
                     DATATYPE_INTEGER, true, null,
                     "0", "65535", true, true);
        addAttribute("ImageDescriptor", "imageTopPosition",
                     DATATYPE_INTEGER, true, null,
                     "0", "65535", true, true);
        addAttribute("ImageDescriptor", "imageWidth",
                     DATATYPE_INTEGER, true, null,
                     "1", "65535", true, true);
        addAttribute("ImageDescriptor", "imageHeight",
                     DATATYPE_INTEGER, true, null,
                     "1", "65535", true, true);
        addBooleanAttribute("ImageDescriptor", "interlaceFlag",
                            false, false);

        // root -> LocalColorTable
        addElement("LocalColorTable",
                   GIFImageMetadata.nativeMetadataFormatName,
                   2, 256);
        addAttribute("LocalColorTable", "sizeOfLocalColorTable",
                     DATATYPE_INTEGER, true, null,
                     Arrays.asList(GIFStreamMetadata.colorTableSizes));
        addBooleanAttribute("LocalColorTable", "sortFlag",
                            false, false);

        // root -> LocalColorTable -> ColorTableEntry
        addElement("ColorTableEntry", "LocalColorTable",
                   CHILD_POLICY_EMPTY);
        addAttribute("ColorTableEntry", "index",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);
        addAttribute("ColorTableEntry", "red",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);
        addAttribute("ColorTableEntry", "green",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);
        addAttribute("ColorTableEntry", "blue",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);

        // root -> GraphicControlExtension
        addElement("GraphicControlExtension",
                   GIFImageMetadata.nativeMetadataFormatName,
                   CHILD_POLICY_EMPTY);
        addAttribute("GraphicControlExtension", "disposalMethod",
                     DATATYPE_STRING, true, null,
                     Arrays.asList(GIFImageMetadata.disposalMethodNames));
        addBooleanAttribute("GraphicControlExtension", "userInputFlag",
                            false, false);
        addBooleanAttribute("GraphicControlExtension", "transparentColorFlag",
                            false, false);
        addAttribute("GraphicControlExtension", "delayTime",
                     DATATYPE_INTEGER, true, null,
                     "0", "65535", true, true);
        addAttribute("GraphicControlExtension", "transparentColorIndex",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);

        // root -> PlainTextExtension
        addElement("PlainTextExtension",
                   GIFImageMetadata.nativeMetadataFormatName,
                   CHILD_POLICY_EMPTY);
        addAttribute("PlainTextExtension", "textGridLeft",
                     DATATYPE_INTEGER, true, null,
                     "0", "65535", true, true);
        addAttribute("PlainTextExtension", "textGridTop",
                     DATATYPE_INTEGER, true, null,
                     "0", "65535", true, true);
        addAttribute("PlainTextExtension", "textGridWidth",
                     DATATYPE_INTEGER, true, null,
                     "1", "65535", true, true);
        addAttribute("PlainTextExtension", "textGridHeight",
                     DATATYPE_INTEGER, true, null,
                     "1", "65535", true, true);
        addAttribute("PlainTextExtension", "characterCellWidth",
                     DATATYPE_INTEGER, true, null,
                     "1", "65535", true, true);
        addAttribute("PlainTextExtension", "characterCellHeight",
                     DATATYPE_INTEGER, true, null,
                     "1", "65535", true, true);
        addAttribute("PlainTextExtension", "textForegroundColor",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);
        addAttribute("PlainTextExtension", "textBackgroundColor",
                     DATATYPE_INTEGER, true, null,
                     "0", "255", true, true);

        // root -> ApplicationExtensions
        addElement("ApplicationExtensions",
                   GIFImageMetadata.nativeMetadataFormatName,
                   1, Integer.MAX_VALUE);

        // root -> ApplicationExtensions -> ApplicationExtension
        addElement("ApplicationExtension", "ApplicationExtensions",
                   CHILD_POLICY_EMPTY);
        addAttribute("ApplicationExtension", "applicationID",
                     DATATYPE_STRING, true, null);
        addAttribute("ApplicationExtension", "authenticationCode",
                     DATATYPE_STRING, true, null);
        addObjectValue("ApplicationExtension", byte.class,
                       0, Integer.MAX_VALUE);

        // root -> CommentExtensions
        addElement("CommentExtensions",
                   GIFImageMetadata.nativeMetadataFormatName,
                   1, Integer.MAX_VALUE);

        // root -> CommentExtensions -> CommentExtension
        addElement("CommentExtension", "CommentExtensions",
                   CHILD_POLICY_EMPTY);
        addAttribute("CommentExtension", "value",
                     DATATYPE_STRING, true, null);
    }

    public boolean canNodeAppear(String elementName,
                                 ImageTypeSpecifier imageType) {
        return true;
    }

    public static synchronized IIOMetadataFormat getInstance() {
        if (instance == null) {
            instance = new GIFImageMetadataFormat();
        }
        return instance;
    }
}
