/*
 * Copyright (c) 1997, 2004, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Enumeration;

/**
 * A generic interface for a mutable collection of unique attributes.
 *
 * Implementations will probably want to provide a constructor of the
 * form:<tt>
 * public XXXAttributeSet(ConstAttributeSet source);</tt>
 *
 */
public interface MutableAttributeSet extends AttributeSet {

    /**
     * Creates a new attribute set similar to this one except that it contains
     * an attribute with the given name and value.  The object must be
     * immutable, or not mutated by any client.
     *
     * @param name the name
     * @param value the value
     */
    public void addAttribute(Object name, Object value);

    /**
     * Creates a new attribute set similar to this one except that it contains
     * the given attributes and values.
     *
     * @param attributes the set of attributes
     */
    public void addAttributes(AttributeSet attributes);

    /**
     * Removes an attribute with the given <code>name</code>.
     *
     * @param name the attribute name
     */
    public void removeAttribute(Object name);

    /**
     * Removes an attribute set with the given <code>names</code>.
     *
     * @param names the set of names
     */
    public void removeAttributes(Enumeration<?> names);

    /**
     * Removes a set of attributes with the given <code>name</code>.
     *
     * @param attributes the set of attributes
     */
    public void removeAttributes(AttributeSet attributes);

    /**
     * Sets the resolving parent.  This is the set
     * of attributes to resolve through if an attribute
     * isn't defined locally.
     *
     * @param parent the parent
     */
    public void setResolveParent(AttributeSet parent);

}
