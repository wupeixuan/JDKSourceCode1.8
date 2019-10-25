/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.management;

/**
 * Types of {@link MemoryPoolMXBean memory pools}.
 *
 * @author  Mandy Chung
 * @since   1.5
 */
public enum MemoryType {

    /**
     * Heap memory type.
     * <p>
     * The Java virtual machine has a <i>heap</i>
     * that is the runtime data area from which
     * memory for all class instances and arrays are allocated.
     */
    HEAP("Heap memory"),

    /**
     * Non-heap memory type.
     * <p>
     * The Java virtual machine manages memory other than the heap
     * (referred as <i>non-heap memory</i>).  The non-heap memory includes
     * the <i>method area</i> and memory required for the internal
     * processing or optimization for the Java virtual machine.
     * It stores per-class structures such as a runtime
     * constant pool, field and method data, and the code for
     * methods and constructors.
     */
    NON_HEAP("Non-heap memory");

    private final String description;

    private MemoryType(String s) {
        this.description = s;
    }

    /**
     * Returns the string representation of this <tt>MemoryType</tt>.
     * @return the string representation of this <tt>MemoryType</tt>.
     */
    public String toString() {
        return description;
    }

    private static final long serialVersionUID = 6992337162326171013L;
}
