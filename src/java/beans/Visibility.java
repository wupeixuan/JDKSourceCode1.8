/*
 * Copyright (c) 1996, 1998, Oracle and/or its affiliates. All rights reserved.
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

package java.beans;

/**
 * Under some circumstances a bean may be run on servers where a GUI
 * is not available.  This interface can be used to query a bean to
 * determine whether it absolutely needs a gui, and to advise the
 * bean whether a GUI is available.
 * <p>
 * This interface is for expert developers, and is not needed
 * for normal simple beans.  To avoid confusing end-users we
 * avoid using getXXX setXXX design patterns for these methods.
 */

public interface Visibility {

    /**
     * Determines whether this bean needs a GUI.
     *
     * @return True if the bean absolutely needs a GUI available in
     *          order to get its work done.
     */
    boolean needsGui();

    /**
     * This method instructs the bean that it should not use the Gui.
     */
    void dontUseGui();

    /**
     * This method instructs the bean that it is OK to use the Gui.
     */
    void okToUseGui();

    /**
     * Determines whether this bean is avoiding using a GUI.
     *
     * @return true if the bean is currently avoiding use of the Gui.
     *   e.g. due to a call on dontUseGui().
     */
    boolean avoidingGui();

}
