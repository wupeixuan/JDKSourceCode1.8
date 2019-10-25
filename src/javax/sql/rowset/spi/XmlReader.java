/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.sql.rowset.spi;

import java.sql.SQLException;
import java.io.Reader;

import javax.sql.RowSetReader;
import javax.sql.rowset.*;

/**
 * A specialized interface that facilitates an extension of the
 * <code>SyncProvider</code> abstract class for XML orientated
 * synchronization providers.
 * <P>
 * <code>SyncProvider</code>  implementations that supply XML data reader
 * capabilities such as output XML stream capabilities can implement this
 * interface to provide standard <code>XmlReader</code> objects to
 * <code>WebRowSet</code> implementations.
 * <p>
 * An <code>XmlReader</code> object is registered as the
 * XML reader for a <code>WebRowSet</code> by being assigned to the
 * rowset's <code>xmlReader</code> field. When the <code>WebRowSet</code>
 * object's <code>readXml</code> method is invoked, it in turn invokes
 * its XML reader's <code>readXML</code> method.
 */
public interface XmlReader extends RowSetReader {

  /**
   * Reads and parses the given <code>WebRowSet</code> object from the given
   * input stream in XML format. The <code>xmlReader</code> field of the
   * given <code>WebRowSet</code> object must contain this
   * <code>XmlReader</code> object.
   * <P>
   * If a parsing error occurs, the exception that is thrown will
   * include information about the location of the error in the
   * original XML document.
   *
   * @param caller the <code>WebRowSet</code> object to be parsed, whose
   *        <code>xmlReader</code> field must contain a reference to
   *        this <code>XmlReader</code> object
   * @param reader the <code>java.io.Reader</code> object from which
   *        <code>caller</code> will be read
   * @throws SQLException if a database access error occurs or
   *            this <code>XmlReader</code> object is not the reader
   *            for the given rowset
   */
  public void readXML(WebRowSet caller, java.io.Reader reader)
    throws SQLException;

}
