/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
package java.util.stream;

/**
 * An enum describing the known shape specializations for stream abstractions.
 * Each will correspond to a specific subinterface of {@link BaseStream}
 * (e.g., {@code REFERENCE} corresponds to {@code Stream}, {@code INT_VALUE}
 * corresponds to {@code IntStream}).  Each may also correspond to
 * specializations of value-handling abstractions such as {@code Spliterator},
 * {@code Consumer}, etc.
 *
 * @apiNote
 * This enum is used by implementations to determine compatibility between
 * streams and operations (i.e., if the output shape of a stream is compatible
 * with the input shape of the next operation).
 *
 * <p>Some APIs require you to specify both a generic type and a stream shape
 * for input or output elements, such as {@link TerminalOp} which has both
 * generic type parameters for its input types, and a getter for the
 * input shape.  When representing primitive streams in this way, the
 * generic type parameter should correspond to the wrapper type for that
 * primitive type.
 *
 * @since 1.8
 */
enum StreamShape {
    /**
     * The shape specialization corresponding to {@code Stream} and elements
     * that are object references.
     */
    REFERENCE,
    /**
     * The shape specialization corresponding to {@code IntStream} and elements
     * that are {@code int} values.
     */
    INT_VALUE,
    /**
     * The shape specialization corresponding to {@code LongStream} and elements
     * that are {@code long} values.
     */
    LONG_VALUE,
    /**
     * The shape specialization corresponding to {@code DoubleStream} and
     * elements that are {@code double} values.
     */
    DOUBLE_VALUE
}
