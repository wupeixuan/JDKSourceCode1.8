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

package javax.swing;


/**
 * Constants used to control the window-closing operation.
 * The <code>setDefaultCloseOperation</code> and
 * <code>getDefaultCloseOperation</code> methods
 * provided by <code>JFrame</code>,
 * <code>JInternalFrame</code>, and
 * <code>JDialog</code>
 * use these constants.
 * For examples of setting the default window-closing operation, see
 * <a
 href="https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html#windowevents">Responding to Window-Closing Events</a>,
 * a section in <em>The Java Tutorial</em>.
 * @see JFrame#setDefaultCloseOperation(int)
 * @see JDialog#setDefaultCloseOperation(int)
 * @see JInternalFrame#setDefaultCloseOperation(int)
 *
 *
 * @author Amy Fowler
 */
public interface WindowConstants
{
    /**
     * The do-nothing default window close operation.
     */
    public static final int DO_NOTHING_ON_CLOSE = 0;

    /**
     * The hide-window default window close operation
     */
    public static final int HIDE_ON_CLOSE = 1;

    /**
     * The dispose-window default window close operation.
     * <p>
     * <b>Note</b>: When the last displayable window
     * within the Java virtual machine (VM) is disposed of, the VM may
     * terminate.  See <a href="../../java/awt/doc-files/AWTThreadIssues.html">
     * AWT Threading Issues</a> for more information.
     * @see java.awt.Window#dispose()
     * @see JInternalFrame#dispose()
     */
    public static final int DISPOSE_ON_CLOSE = 2;

    /**
     * The exit application default window close operation. Attempting
     * to set this on Windows that support this, such as
     * <code>JFrame</code>, may throw a <code>SecurityException</code> based
     * on the <code>SecurityManager</code>.
     * It is recommended you only use this in an application.
     *
     * @since 1.4
     * @see JFrame#setDefaultCloseOperation
     */
    public static final int EXIT_ON_CLOSE = 3;

}
