/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

/**
 * ChangedCharSetException as the name indicates is an exception
 * thrown when the charset is changed.
 *
 * @author Sunita Mani
 */
public class ChangedCharSetException extends IOException {

    String charSetSpec;
    boolean charSetKey;

    public ChangedCharSetException(String charSetSpec, boolean charSetKey) {
        this.charSetSpec = charSetSpec;
        this.charSetKey = charSetKey;
    }

    public String getCharSetSpec() {
        return charSetSpec;
    }

    public boolean keyEqualsCharSet() {
        return charSetKey;
    }

}
