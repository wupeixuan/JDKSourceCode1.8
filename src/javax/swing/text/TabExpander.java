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
 * Simple interface to allow for different types of
 * implementations of tab expansion.
 *
 * @author  Timothy Prinzing
 */
public interface TabExpander {

    /**
     * Returns the next tab stop position given a reference
     * position.  Values are expressed in points.
     *
     * @param x the position in points &gt;= 0
     * @param tabOffset the position within the text stream
     *   that the tab occurred at &gt;= 0.
     * @return the next tab stop &gt;= 0
     */
    float nextTabStop(float x, int tabOffset);

}
