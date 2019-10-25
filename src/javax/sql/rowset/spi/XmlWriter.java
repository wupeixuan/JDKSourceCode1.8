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
import java.io.Writer;

import javax.sql.RowSetWriter;
import javax.sql.rowset.*;

/**
 * A specialized interface that facilitates an extension of the
 * <code>SyncProvider</code> abstract class for XML orientated
 * synchronization providers.
 * <p>
 * <code>SyncProvider</code>  implementations that supply XML data writer
 * capabilities such as output XML stream capabilities can implement this
 * interface to provide standard <code>XmlWriter</code> objects to
 * <code>WebRowSet</code> implementations.
 * <P>
 * Writing a <code>WebRowSet</code> object includes printing the
 * rowset's data, metadata, and properties, all with the
 * appropriate XML tags.
 */
public interface XmlWriter extends RowSetWriter {

  /**
   * Writes the given <code>WebRowSet</code> object to the specified
   * <code>java.io.Writer</code> output stream as an XML document.
   * This document includes the rowset's data, metadata, and properties
   * plus the appropriate XML tags.
   * <P>
   * The <code>caller</code> parameter must be a <code>WebRowSet</code>
   * object whose <code>XmlWriter</code> field contains a reference to
   * this <code>XmlWriter</code> object.
   *
   * @param caller the <code>WebRowSet</code> instance to be written,
   *        for which this <code>XmlWriter</code> object is the writer
   * @param writer the <code>java.io.Writer</code> object that serves
   *        as the output stream for writing <code>caller</code> as
   *        an XML document
   * @throws SQLException if a database access error occurs or
   *            this <code>XmlWriter</code> object is not the writer
   *            for the given <code>WebRowSet</code> object
   */
  public void writeXML(WebRowSet caller, java.io.Writer writer)
    throws SQLException;



}
