/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

import javax.lang.model.element.Name;

/**
 * A tree node for the end of an HTML element.
 *
 * <p>
 * &lt;/ name &gt;
 *
 * @since 1.8
 */
@jdk.Exported
public interface EndElementTree extends DocTree {
    Name getName();
}
