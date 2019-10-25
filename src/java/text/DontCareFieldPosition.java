/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package java.text;

/**
 * DontCareFieldPosition defines no-op FieldDelegate. Its
 * singleton is used for the format methods that don't take a
 * FieldPosition.
 */
class DontCareFieldPosition extends FieldPosition {
    // The singleton of DontCareFieldPosition.
    static final FieldPosition INSTANCE = new DontCareFieldPosition();

    private final Format.FieldDelegate noDelegate = new Format.FieldDelegate() {
        public void formatted(Format.Field attr, Object value, int start,
                              int end, StringBuffer buffer) {
        }
        public void formatted(int fieldID, Format.Field attr, Object value,
                              int start, int end, StringBuffer buffer) {
        }
    };

    private DontCareFieldPosition() {
        super(0);
    }

    Format.FieldDelegate getFieldDelegate() {
        return noDelegate;
    }
}
