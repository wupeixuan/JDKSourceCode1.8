/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing;

import java.awt.Component;

/**
 * Defines the requirements for an object responsible for
 * "rendering" (displaying) a value.
 *
 * @author Arnaud Weber
 */
public interface Renderer {
    /**
     * Specifies the value to display and whether or not the
     * value should be portrayed as "currently selected".
     *
     * @param aValue      an Object object
     * @param isSelected  a boolean
     */
    void setValue(Object aValue,boolean isSelected);
    /**
     * Returns the component used to render the value.
     *
     * @return the Component responsible for displaying the value
     */
    Component getComponent();
}
