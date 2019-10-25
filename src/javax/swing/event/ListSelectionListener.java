/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.event;


import java.util.EventListener;


/**
 * The listener that's notified when a lists selection value
 * changes.
 *
 * @see javax.swing.ListSelectionModel
 *
 * @author Hans Muller
 */

public interface ListSelectionListener extends EventListener
{
  /**
   * Called whenever the value of the selection changes.
   * @param e the event that characterizes the change.
   */
  void valueChanged(ListSelectionEvent e);
}
