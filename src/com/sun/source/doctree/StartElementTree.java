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

import java.util.List;
import javax.lang.model.element.Name;

/**
 * A tree node for the start of an HTML element.
 *
 * <p>
 * &lt; name [attributes] [/]&gt;
 *
 * @since 1.8
 */
@jdk.Exported
public interface StartElementTree extends DocTree {
    Name getName();
    List<? extends DocTree> getAttributes();
    boolean isSelfClosing();
}
