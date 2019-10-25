/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

import javax.print.attribute.Attribute;
import javax.print.attribute.EnumSyntax;
import javax.print.attribute.PrintServiceAttribute;

/**
 * Class PDLOverrideSupported is a printing attribute class, an enumeration,
 * that expresses the printer's ability to attempt to override processing
 * instructions embedded in documents' print data with processing instructions
 * specified as attributes outside the print data.
 * <P>
 * <B>IPP Compatibility:</B> The category name returned by
 * <CODE>getName()</CODE> is the IPP attribute name.  The enumeration's
 * integer value is the IPP enum value.  The <code>toString()</code> method
 * returns the IPP string representation of the attribute value.
 * <P>
 *
 * @author  Alan Kaminsky
 */
public class PDLOverrideSupported extends EnumSyntax
    implements PrintServiceAttribute {

    private static final long serialVersionUID = -4393264467928463934L;

    /**
     * The printer makes no attempt to make the external job attribute values
     * take precedence over embedded instructions in the documents' print
     * data.
     */
    public static final PDLOverrideSupported
        NOT_ATTEMPTED = new PDLOverrideSupported(0);

    /**
     * The printer attempts to make the external job attribute values take
     * precedence over embedded instructions in the documents' print data,
     * however there is no guarantee.
     */
    public static final PDLOverrideSupported
        ATTEMPTED = new PDLOverrideSupported(1);


    /**
     * Construct a new PDL override supported enumeration value with the given
     * integer value.
     *
     * @param  value  Integer value.
     */
    protected PDLOverrideSupported(int value) {
        super (value);
    }

    private static final String[] myStringTable = {
        "not-attempted",
        "attempted"
    };

    private static final PDLOverrideSupported[] myEnumValueTable = {
        NOT_ATTEMPTED,
        ATTEMPTED
    };

    /**
     * Returns the string table for class PDLOverrideSupported.
     */
    protected String[] getStringTable() {
        return (String[])myStringTable.clone();
    }

    /**
     * Returns the enumeration value table for class PDLOverrideSupported.
     */
    protected EnumSyntax[] getEnumValueTable() {
        return (EnumSyntax[])myEnumValueTable.clone();
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <P>
     * For class PDLOverrideSupported and any vendor-defined subclasses, the
     * category is class PDLOverrideSupported itself.
     *
     * @return  Printing attribute class (category), an instance of class
     *          {@link java.lang.Class java.lang.Class}.
     */
    public final Class<? extends Attribute> getCategory() {
        return PDLOverrideSupported.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <P>
     * For class PDLOverrideSupported and any vendor-defined subclasses, the
     * category name is <CODE>"pdl-override-supported"</CODE>.
     *
     * @return  Attribute category name.
     */
    public final String getName() {
        return "pdl-override-supported";
    }

}
