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
 * Represents a location within a document.  It is intended to abstract away
 * implementation details of the document and enable specification of
 * positions within the document that are capable of tracking of change as
 * the document is edited.
 * <p>
 * A {@code Position} object points at a location between two characters.
 * As the surrounding content is altered, the {@code Position} object
 * adjusts its offset automatically to reflect the changes. If content is
 * inserted or removed before the {@code Position} object's location, then the
 * {@code Position} increments or decrements its offset, respectively,
 * so as to point to the same location. If a portion of the document is removed
 * that contains a {@code Position}'s offset, then the {@code Position}'s
 * offset becomes that of the beginning of the removed region. For example, if
 * a {@code Position} has an offset of 5 and the region 2-10 is removed, then
 * the {@code Position}'s offset becomes 2.
 * <p>
 * {@code Position} with an offset of 0 is a special case. It never changes its
 * offset while document content is altered.
 *
 * @author  Timothy Prinzing
 */
public interface Position {

    /**
     * Fetches the current offset within the document.
     *
     * @return the offset &gt;= 0
     */
    public int getOffset();

    /**
     * A typesafe enumeration to indicate bias to a position
     * in the model.  A position indicates a location between
     * two characters.  The bias can be used to indicate an
     * interest toward one of the two sides of the position
     * in boundary conditions where a simple offset is
     * ambiguous.
     */
    public static final class Bias {

        /**
         * Indicates to bias toward the next character
         * in the model.
         */
        public static final Bias Forward = new Bias("Forward");

        /**
         * Indicates a bias toward the previous character
         * in the model.
         */
        public static final Bias Backward = new Bias("Backward");

        /**
         * string representation
         */
        public String toString() {
            return name;
        }

        private Bias(String name) {
            this.name = name;
        }

        private String name;
    }
}
