/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package javax.imageio;

/**
 * An interface to be implemented by objects that can determine the
 * settings of an <code>IIOParam</code> object, either by putting up a
 * GUI to obtain values from a user, or by other means.  This
 * interface merely specifies a generic <code>activate</code> method
 * that invokes the controller, without regard for how the controller
 * obtains values (<i>i.e.</i>, whether the controller puts up a GUI
 * or merely computes a set of values is irrelevant to this
 * interface).
 *
 * <p> Within the <code>activate</code> method, a controller obtains
 * initial values by querying the <code>IIOParam</code> object's
 * <code>get</code> methods, modifies values by whatever means, then
 * invokes the <code>IIOParam</code> object's <code>set</code> methods
 * to modify the appropriate settings.  Normally, these
 * <code>set</code> methods will be invoked all at once at a final
 * commit in order that a cancel operation not disturb existing
 * values.  In general, applications may expect that when the
 * <code>activate</code> method returns <code>true</code>, the
 * <code>IIOParam</code> object is ready for use in a read or write
 * operation.
 *
 * <p> Vendors may choose to provide GUIs for the
 * <code>IIOParam</code> subclasses they define for a particular
 * plug-in.  These can be set up as default controllers in the
 * corresponding <code>IIOParam</code> subclasses.
 *
 * <p> Applications may override any default GUIs and provide their
 * own controllers embedded in their own framework.  All that is
 * required is that the<code>activate</code> method behave modally
 * (not returning until either cancelled or committed), though it need
 * not put up an explicitly modal dialog.  Such a non-modal GUI
 * component would be coded roughly as follows:
 *
 * <br>
 * <pre>
 * class MyGUI extends SomeComponent implements IIOParamController {
 *
 *    public MyGUI() {
 *        // ...
 *        setEnabled(false);
 *    }
 *
 *    public boolean activate(IIOParam param) {
 *        // disable other components if desired
 *        setEnabled(true);
 *        // go to sleep until either cancelled or committed
 *        boolean ret = false;
 *        if (!cancelled) {
 *            // set values on param
 *            ret = true;
 *        }
 *        setEnabled(false);
 *        // enable any components disabled above
 *        return ret;
 *    }
 * </pre>
 *
 * <p> Alternatively, an algorithmic process such as a database lookup
 * or the parsing of a command line could be used as a controller, in
 * which case the <code>activate</code> method would simply look up or
 * compute the settings, call the <code>IIOParam.setXXX</code>
 * methods, and return <code>true</code>.
 *
 * @see IIOParam#setController
 * @see IIOParam#getController
 * @see IIOParam#getDefaultController
 * @see IIOParam#hasController
 * @see IIOParam#activateController
 *
 */
public interface IIOParamController {

    /**
     * Activates the controller.  If <code>true</code> is returned,
     * all settings in the <code>IIOParam</code> object should be
     * ready for use in a read or write operation.  If
     * <code>false</code> is returned, no settings in the
     * <code>IIOParam</code> object will be disturbed (<i>i.e.</i>,
     * the user canceled the operation).
     *
     * @param param the <code>IIOParam</code> object to be modified.
     *
     * @return <code>true</code> if the <code>IIOParam</code> has been
     * modified, <code>false</code> otherwise.
     *
     * @exception IllegalArgumentException if <code>param</code> is
     * <code>null</code> or is not an instance of the correct class.
     */
    boolean activate(IIOParam param);
}
