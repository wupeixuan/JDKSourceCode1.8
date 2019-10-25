/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
package javax.accessibility;


/**
 * <P>The AccessibleTextSequence provides information about
 * a contiguous sequence of text.
 *
 * @see Accessible
 * @see Accessible#getAccessibleContext
 * @see AccessibleContext
 * @see AccessibleContext#getAccessibleText
 * @see AccessibleAttributeSequence
 *
 * @author       Lynn Monsanto
 */

/**
 * This class collects together key details of a span of text.  It
 * is used by implementors of the class <code>AccessibleExtendedText</code> in
 * order to return the requested triplet of a <code>String</code>, and the
 * start and end indicies/offsets into a larger body of text that the
 * <code>String</code> comes from.
 *
 * @see javax.accessibility.AccessibleExtendedText
 */
public class AccessibleTextSequence {

    /** The start index of the text sequence */
    public int startIndex;

    /** The end index of the text sequence */
    public int endIndex;

    /** The text */
    public String text;

    /**
     * Constructs an <code>AccessibleTextSequence</code> with the given
     * parameters.
     *
     * @param start the beginning index of the span of text
     * @param end the ending index of the span of text
     * @param txt the <code>String</code> shared by this text span
     *
     * @since 1.6
     */
    public AccessibleTextSequence(int start, int end, String txt) {
        startIndex = start;
        endIndex = end;
        text = txt;
    }
};
