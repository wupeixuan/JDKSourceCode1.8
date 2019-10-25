/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.util.prefs;

import java.io.NotSerializableException;

/**
 * An event emitted by a <tt>Preferences</tt> node to indicate that
 * a preference has been added, removed or has had its value changed.<p>
 *
 * Note, that although PreferenceChangeEvent inherits Serializable interface
 * from EventObject, it is not intended to be Serializable. Appropriate
 * serialization methods are implemented to throw NotSerializableException.
 *
 * @author  Josh Bloch
 * @see Preferences
 * @see PreferenceChangeListener
 * @see NodeChangeEvent
 * @since   1.4
 * @serial exclude
 */
public class PreferenceChangeEvent extends java.util.EventObject {

    /**
     * Key of the preference that changed.
     *
     * @serial
     */
    private String key;

    /**
     * New value for preference, or <tt>null</tt> if it was removed.
     *
     * @serial
     */
    private String newValue;

    /**
     * Constructs a new <code>PreferenceChangeEvent</code> instance.
     *
     * @param node  The Preferences node that emitted the event.
     * @param key  The key of the preference that was changed.
     * @param newValue  The new value of the preference, or <tt>null</tt>
     *                  if the preference is being removed.
     */
    public PreferenceChangeEvent(Preferences node, String key,
                                 String newValue) {
        super(node);
        this.key = key;
        this.newValue = newValue;
    }

    /**
     * Returns the preference node that emitted the event.
     *
     * @return  The preference node that emitted the event.
     */
    public Preferences getNode() {
        return (Preferences) getSource();
    }

    /**
     * Returns the key of the preference that was changed.
     *
     * @return  The key of the preference that was changed.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the new value for the preference.
     *
     * @return  The new value for the preference, or <tt>null</tt> if the
     *          preference was removed.
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Throws NotSerializableException, since NodeChangeEvent objects
     * are not intended to be serializable.
     */
     private void writeObject(java.io.ObjectOutputStream out)
                                               throws NotSerializableException {
         throw new NotSerializableException("Not serializable.");
     }

    /**
     * Throws NotSerializableException, since PreferenceChangeEvent objects
     * are not intended to be serializable.
     */
     private void readObject(java.io.ObjectInputStream in)
                                               throws NotSerializableException {
         throw new NotSerializableException("Not serializable.");
     }

    // Defined so that this class isn't flagged as a potential problem when
    // searches for missing serialVersionUID fields are done.
    private static final long serialVersionUID = 793724513368024975L;
}
