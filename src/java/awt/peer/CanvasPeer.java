/*
 * Copyright (c) 1995, 2007, Oracle and/or its affiliates. All rights reserved.
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
package java.awt.peer;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;

/**
 * The peer interface for {@link Canvas}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface CanvasPeer extends ComponentPeer {
    /**
     * Requests a GC that best suits this Canvas. The returned GC may differ
     * from the requested GC passed as the argument to this method. This method
     * must return a non-null value (given the argument is non-null as well).
     *
     * @since 1.7
     */
    GraphicsConfiguration getAppropriateGraphicsConfiguration(
            GraphicsConfiguration gc);
}
