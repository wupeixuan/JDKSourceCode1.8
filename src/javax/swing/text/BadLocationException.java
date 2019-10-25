/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.text;

/**
 * This exception is to report bad locations within a document model
 * (that is, attempts to reference a location that doesn't exist).
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author  Timothy Prinzing
 */
@SuppressWarnings("serial")
public class BadLocationException extends Exception
{
    /**
     * Creates a new BadLocationException object.
     *
     * @param s         a string indicating what was wrong with the arguments
     * @param offs      offset within the document that was requested &gt;= 0
     */
    public BadLocationException(String s, int offs) {
        super(s);
        this.offs = offs;
    }

    /**
     * Returns the offset into the document that was not legal.
     *
     * @return the offset &gt;= 0
     */
    public int offsetRequested() {
        return offs;
    }

    private int offs;
}
