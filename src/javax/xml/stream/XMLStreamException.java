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

package javax.xml.stream;

/**
 * The base exception for unexpected processing errors.  This Exception
 * class is used to report well-formedness errors as well as unexpected
 * processing conditions.
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */

public class XMLStreamException extends Exception {

  protected Throwable nested;
  protected Location location;

  /**
   * Default constructor
   */
  public XMLStreamException(){
    super();
  }

  /**
   * Construct an exception with the assocated message.
   *
   * @param msg the message to report
   */
  public XMLStreamException(String msg) {
    super(msg);
  }

  /**
   * Construct an exception with the assocated exception
   *
   * @param th a nested exception
   */
  public XMLStreamException(Throwable th) {
      super(th);
    nested = th;
  }

  /**
   * Construct an exception with the assocated message and exception
   *
   * @param th a nested exception
   * @param msg the message to report
   */
  public XMLStreamException(String msg, Throwable th) {
    super(msg, th);
    nested = th;
  }

  /**
   * Construct an exception with the assocated message, exception and location.
   *
   * @param th a nested exception
   * @param msg the message to report
   * @param location the location of the error
   */
  public XMLStreamException(String msg, Location location, Throwable th) {
    super("ParseError at [row,col]:["+location.getLineNumber()+","+
          location.getColumnNumber()+"]\n"+
          "Message: "+msg);
    nested = th;
    this.location = location;
  }

  /**
   * Construct an exception with the assocated message, exception and location.
   *
   * @param msg the message to report
   * @param location the location of the error
   */
  public XMLStreamException(String msg,
                            Location location) {
    super("ParseError at [row,col]:["+location.getLineNumber()+","+
          location.getColumnNumber()+"]\n"+
          "Message: "+msg);
    this.location = location;
  }


  /**
   * Gets the nested exception.
   *
   * @return Nested exception
   */
  public Throwable getNestedException() {
    return nested;
  }

  /**
   * Gets the location of the exception
   *
   * @return the location of the exception, may be null if none is available
   */
  public Location getLocation() {
    return location;
  }

}
