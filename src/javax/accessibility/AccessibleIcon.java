/*
 * Copyright (c) 1999, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * The AccessibleIcon interface should be supported by any object
 * that has an associated icon (e.g., buttons). This interface
 * provides the standard mechanism for an assistive technology
 * to get descriptive information about icons.
 * Applications can determine
 * if an object supports the AccessibleIcon interface by first
 * obtaining its AccessibleContext (see
 * {@link Accessible}) and then calling the
 * {@link AccessibleContext#getAccessibleIcon} method.
 * If the return value is not null, the object supports this interface.
 *
 * @see Accessible
 * @see AccessibleContext
 *
 * @author      Lynn Monsanto
 * @since 1.3
 */
public interface AccessibleIcon {

    /**
     * Gets the description of the icon.  This is meant to be a brief
     * textual description of the object.  For example, it might be
     * presented to a blind user to give an indication of the purpose
     * of the icon.
     *
     * @return the description of the icon
     */
    public String getAccessibleIconDescription();

    /**
     * Sets the description of the icon.  This is meant to be a brief
     * textual description of the object.  For example, it might be
     * presented to a blind user to give an indication of the purpose
     * of the icon.
     *
     * @param description the description of the icon
     */
    public void setAccessibleIconDescription(String description);

    /**
     * Gets the width of the icon
     *
     * @return the width of the icon.
     */
    public int getAccessibleIconWidth();

    /**
     * Gets the height of the icon
     *
     * @return the height of the icon.
     */
    public int getAccessibleIconHeight();

}
