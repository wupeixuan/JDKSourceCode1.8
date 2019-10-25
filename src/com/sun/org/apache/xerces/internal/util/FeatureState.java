/*
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

/*
 * Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 */

/*
 * $Id: FeatureState.java 3024 2011-03-01 03:46:13Z joehw $
 */

package com.sun.org.apache.xerces.internal.util;

public class FeatureState {

    public final Status status;
    public final boolean state;

    public static final FeatureState SET_ENABLED = new FeatureState(Status.SET, true);
    public static final FeatureState SET_DISABLED = new FeatureState(Status.SET, false);
    public static final FeatureState UNKNOWN = new FeatureState(Status.UNKNOWN, false);
    public static final FeatureState RECOGNIZED = new FeatureState(Status.RECOGNIZED, false);
    public static final FeatureState NOT_SUPPORTED = new FeatureState(Status.NOT_SUPPORTED, false);
    public static final FeatureState NOT_RECOGNIZED = new FeatureState(Status.NOT_RECOGNIZED, false);
    public static final FeatureState NOT_ALLOWED = new FeatureState(Status.NOT_ALLOWED, false);

    public FeatureState(Status status, boolean state) {
        this.status = status;
        this.state = state;
    }

    public static FeatureState of(Status status) {
        return new FeatureState(status, false);
    }

    public static FeatureState is(boolean value) {
        return new FeatureState(Status.SET, value);
    }

    public boolean isExceptional() {
        return this.status.isExceptional();
    }
}
