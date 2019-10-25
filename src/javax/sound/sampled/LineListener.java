/*
 * Copyright (c) 1999, 2002, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.sampled;



/**
 * Instances of classes that implement the <code>LineListener</code> interface can register to
 * receive events when a line's status changes.
 *
 * @author Kara Kytle
 *
 * @see Line
 * @see Line#addLineListener
 * @see Line#removeLineListener
 * @see LineEvent
 *
 * @since 1.3
 */
/*
 * Instances of classes that implement the <code>LineListener</code> interface can register to
 * receive events when a line's status changes.
 *
 * @see Line
 * @see Line#addLineListener
 * @see Line#removeLineListener
 * @see LineEvent
 *
 * @author Kara Kytle
 */
public interface LineListener extends java.util.EventListener {

    /**
     * Informs the listener that a line's state has changed.  The listener can then invoke
     * <code>LineEvent</code> methods to obtain information about the event.
     * @param event a line event that describes the change
     */
    /*
     * Informs the listener that a line's state has changed.  The listener can then invoke
     * <code>LineEvent</code> methods to obtain information about the event.
     * @param event a line event that describes the change
     */
    public void update(LineEvent event);

} // interface LineListener
