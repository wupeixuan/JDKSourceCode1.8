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

package javax.print;

import javax.print.attribute.Attribute;

/**
 * Interface AttributeException is a mixin interface which a subclass of
 * {@link
 * PrintException PrintException} can implement to report an error condition
 * involving one or more printing attributes that a particular Print
 * Service instance does not support. Either the attribute is not supported at
 * all, or the attribute is supported but the particular specified value is not
 * supported. The Print Service API does not define any print exception
 * classes that implement interface AttributeException, that being left to the
 * Print Service implementor's discretion.
 *
 */

public interface AttributeException {


    /**
     * Returns the array of printing attribute classes for which the Print
     * Service instance does not support the attribute at all, or null if
     * there are no such attributes. The objects in the returned array are
     * classes that extend the base interface
     * {@link javax.print.attribute.Attribute Attribute}.
     *
     * @return unsupported attribute classes
     */
    public Class[] getUnsupportedAttributes();

    /**
     * Returns the array of printing attributes for which the Print Service
     * instance supports the attribute but does not support that particular
     * value of the attribute, or null if there are no such attribute values.
     *
     * @return unsupported attribute values
     */
    public Attribute[] getUnsupportedValues();

    }
