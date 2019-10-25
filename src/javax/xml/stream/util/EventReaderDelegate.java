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

import javax.xml.namespace.QName;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;

/**
 * This is the base class for deriving an XMLEventReader
 * filter.
 *
 * This class is designed to sit between an XMLEventReader and an
 * application's XMLEventReader.  By default each method
 * does nothing but call the corresponding method on the
 * parent interface.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @see javax.xml.stream.XMLEventReader
 * @see StreamReaderDelegate
 * @since 1.6
 */

public class EventReaderDelegate implements XMLEventReader {
  private XMLEventReader reader;

  /**
   * Construct an empty filter with no parent.
   */
  public EventReaderDelegate(){}

  /**
   * Construct an filter with the specified parent.
   * @param reader the parent
   */
  public EventReaderDelegate(XMLEventReader reader) {
    this.reader = reader;
  }

  /**
   * Set the parent of this instance.
   * @param reader the new parent
   */
  public void setParent(XMLEventReader reader) {
    this.reader = reader;
  }

  /**
   * Get the parent of this instance.
   * @return the parent or null if none is set
   */
  public XMLEventReader getParent() {
    return reader;
  }

  public XMLEvent nextEvent()
    throws XMLStreamException
  {
    return reader.nextEvent();
  }

  public Object next() {
    return reader.next();
  }

  public boolean hasNext()
  {
    return reader.hasNext();
  }

  public XMLEvent peek()
    throws XMLStreamException
  {
    return reader.peek();
  }

  public void close()
    throws XMLStreamException
  {
    reader.close();
  }

  public String getElementText()
    throws XMLStreamException
  {
    return reader.getElementText();
  }

  public XMLEvent nextTag()
    throws XMLStreamException
  {
    return reader.nextTag();
  }

  public Object getProperty(java.lang.String name)
    throws java.lang.IllegalArgumentException
  {
    return reader.getProperty(name);
  }

  public void remove() {
    reader.remove();
  }
}
