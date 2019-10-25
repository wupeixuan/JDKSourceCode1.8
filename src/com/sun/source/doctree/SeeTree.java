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

/**
 *
 * A tree node for an @see block tag.
 *
 * <p>
 * &#064;see "string" <br>
 * &#064;see &lt;a href="URL#value"&gt; label &lt;/a&gt; <br>
 * &#064;see reference
 *
 * @since 1.8
 */
@jdk.Exported
public interface SeeTree extends BlockTagTree {
    List<? extends DocTree> getReference();
}
