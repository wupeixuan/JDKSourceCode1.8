/*
 * Copyright (c) 1996, 1997, Oracle and/or its affiliates. All rights reserved.
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
 * The ParameterDescriptor class allows bean implementors to provide
 * additional information on each of their parameters, beyond the
 * low level type information provided by the java.lang.reflect.Method
 * class.
 * <p>
 * Currently all our state comes from the FeatureDescriptor base class.
 */

public class ParameterDescriptor extends FeatureDescriptor {

    /**
     * Public default constructor.
     */
    public ParameterDescriptor() {
    }

    /**
     * Package private dup constructor.
     * This must isolate the new object from any changes to the old object.
     */
    ParameterDescriptor(ParameterDescriptor old) {
        super(old);
    }

}
