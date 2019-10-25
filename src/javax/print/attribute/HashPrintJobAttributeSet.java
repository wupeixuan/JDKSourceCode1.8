/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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


package javax.print.attribute;

import java.io.Serializable;

/**
 * Class HashPrintJobAttributeSet provides an attribute set
 * which inherits its implementation from class {@link HashAttributeSet
 * HashAttributeSet} and enforces the semantic restrictions of interface
 * {@link PrintJobAttributeSet PrintJobAttributeSet}.
 * <P>
 *
 * @author  Alan Kaminsky
 */
public class HashPrintJobAttributeSet extends HashAttributeSet
    implements PrintJobAttributeSet, Serializable {

    private static final long serialVersionUID = -4204473656070350348L;

    /**
     * Construct a new, empty hash print job attribute set.
     */
    public HashPrintJobAttributeSet() {
        super(PrintJobAttribute.class);
    }

    /**
     * Construct a new hash print job attribute set,
     * initially populated with the given value.
     *
     * @param  attribute  Attribute value to add to the set.
     *
     * @exception  NullPointerException
     *     (unchecked exception) Thrown if <CODE>attribute</CODE> is null.
     */
    public HashPrintJobAttributeSet(PrintJobAttribute attribute) {
        super(attribute, PrintJobAttribute.class);
    }

    /**
     * Construct a new hash print job attribute set,
     * initially populated with the values from the given array.
     * The new attribute set is populated
     * by adding the elements of <CODE>attributes</CODE> array to the set in
     * sequence, starting at index 0. Thus, later array elements may replace
     * earlier array elements if the array contains duplicate attribute
     * values or attribute categories.
     *
     * @param  attributes Array of attribute values to add to the set.
     *                    If null, an empty attribute set is constructed.
     *
     * @exception  NullPointerException (unchecked exception)
     * Thrown if any element of <CODE>attributes</CODE>  is null.
     */
    public HashPrintJobAttributeSet(PrintJobAttribute[] attributes) {
        super (attributes, PrintJobAttribute.class);
    }

    /**
     * Construct a new attribute set, initially populated with the
     * values from the  given set where the members of the attribute set
     * are restricted to the <code>PrintJobAttribute</code> interface.
     *
     * @param  attributes set of attribute values to initialise the set. If
     *                    null, an empty attribute set is constructed.
     *
     * @exception  ClassCastException
     *     (unchecked exception) Thrown if any element of
     * <CODE>attributes</CODE> is not an instance of
     * <CODE>PrintJobAttribute</CODE>.
     */
    public HashPrintJobAttributeSet(PrintJobAttributeSet attributes) {
        super(attributes, PrintJobAttribute.class);
    }
}
