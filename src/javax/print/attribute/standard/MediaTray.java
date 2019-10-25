/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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
package javax.print.attribute.standard;

import java.util.Locale;

import javax.print.attribute.Attribute;
import javax.print.attribute.EnumSyntax;


/**
 * Class MediaTray is a subclass of Media.
 * Class MediaTray is a printing attribute class, an enumeration, that
 * specifies the media tray or bin for the job.
 * This attribute can be used instead of specifying MediaSize or MediaName.
 * <p>
 * Class MediaTray declares keywords for standard media kind values.
 * Implementation- or site-defined names for a media kind attribute may also
 * be created by defining a subclass of class MediaTray.
 * <P>
 * <B>IPP Compatibility:</B> MediaTray is a representation class for
 * values of the IPP "media" attribute which name paper trays.
 * <P>
 *
 */
public class MediaTray extends Media implements Attribute {

    private static final long serialVersionUID = -982503611095214703L;

    /**
     * The top input tray in the printer.
     */
    public static final MediaTray TOP = new MediaTray(0);

    /**
     * The middle input tray in the printer.
     */
    public static final MediaTray MIDDLE = new MediaTray(1);

    /**
     * The bottom input tray in the printer.
     */
    public static final MediaTray BOTTOM = new MediaTray(2);

    /**
     * The envelope input tray in the printer.
     */
    public static final MediaTray ENVELOPE = new MediaTray(3);

    /**
     * The manual feed input tray in the printer.
     */
    public static final MediaTray MANUAL = new MediaTray(4);

    /**
     * The large capacity input tray in the printer.
     */
    public static final MediaTray LARGE_CAPACITY = new MediaTray(5);

    /**
     * The main input tray in the printer.
     */
    public static final MediaTray MAIN = new MediaTray(6);

    /**
     * The side input tray.
     */
    public static final MediaTray SIDE = new MediaTray(7);

    /**
     * Construct a new media tray enumeration value with the given integer
     * value.
     *
     * @param  value  Integer value.
     */
    protected MediaTray(int value) {
        super (value);
    }

    private static final String[] myStringTable ={
        "top",
        "middle",
        "bottom",
        "envelope",
        "manual",
        "large-capacity",
        "main",
        "side"
    };

    private static final MediaTray[] myEnumValueTable = {
        TOP,
        MIDDLE,
        BOTTOM,
        ENVELOPE,
        MANUAL,
        LARGE_CAPACITY,
        MAIN,
        SIDE
    };

    /**
     * Returns the string table for class MediaTray.
     */
    protected String[] getStringTable()
    {
        return (String[])myStringTable.clone();
    }

    /**
     * Returns the enumeration value table for class MediaTray.
     */
    protected EnumSyntax[] getEnumValueTable() {
        return (EnumSyntax[])myEnumValueTable.clone();
    }


}
