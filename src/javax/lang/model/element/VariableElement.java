/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.lang.model.element;

import javax.lang.model.util.Elements;

/**
 * Represents a field, {@code enum} constant, method or constructor
 * parameter, local variable, resource variable, or exception
 * parameter.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public interface VariableElement extends Element {

    /**
     * Returns the value of this variable if this is a {@code final}
     * field initialized to a compile-time constant.  Returns {@code
     * null} otherwise.  The value will be of a primitive type or a
     * {@code String}.  If the value is of a primitive type, it is
     * wrapped in the appropriate wrapper class (such as {@link
     * Integer}).
     *
     * <p>Note that not all {@code final} fields will have
     * constant values.  In particular, {@code enum} constants are
     * <em>not</em> considered to be compile-time constants.  To have a
     * constant value, a field's type must be either a primitive type
     * or {@code String}.
     *
     * @return the value of this variable if this is a {@code final}
     * field initialized to a compile-time constant, or {@code null}
     * otherwise
     *
     * @see Elements#getConstantExpression(Object)
     * @jls 15.28 Constant Expression
     * @jls 4.12.4 final Variables
     */
    Object getConstantValue();

    /**
     * Returns the simple name of this variable element.
     *
     * <p>For method and constructor parameters, the name of each
     * parameter must be distinct from the names of all other
     * parameters of the same executable.  If the original source
     * names are not available, an implementation may synthesize names
     * subject to the distinctness requirement above.
     *
     * @return the simple name of this variable element
     */
    @Override
    Name getSimpleName();

    /**
     * Returns the enclosing element of this variable.
     *
     * The enclosing element of a method or constructor parameter is
     * the executable declaring the parameter.
     *
     * @return the enclosing element of this variable
     */
    @Override
    Element getEnclosingElement();
}
