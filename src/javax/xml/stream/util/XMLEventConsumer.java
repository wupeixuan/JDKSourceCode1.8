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

package javax.xml.stream.util;

import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLStreamException;

/**
 * This interface defines an event consumer interface.  The contract of the
 * of a consumer is to accept the event.  This interface can be used to
 * mark an object as able to receive events.  Add may be called several
 * times in immediate succession so a consumer must be able to cache
 * events it hasn't processed yet.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface XMLEventConsumer {

  /**
   * This method adds an event to the consumer. Calling this method
   * invalidates the event parameter. The client application should
   * discard all references to this event upon calling add.
   * The behavior of an application that continues to use such references
   * is undefined.
   *
   * @param event the event to add, may not be null
   */
  public void add(XMLEvent event)
    throws XMLStreamException;
}
