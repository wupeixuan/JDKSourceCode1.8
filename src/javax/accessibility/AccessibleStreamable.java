/*
 * Copyright (c) 2003, 2006, Oracle and/or its affiliates. All rights reserved.
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

package javax.accessibility;

import java.io.InputStream;
import java.awt.datatransfer.DataFlavor;

/**
 *
 * The <code>AccessibleStreamable</code> interface should be implemented
 * by the <code>AccessibleContext</code> of any component that presents the
 * raw stream behind a component on the display screen.  Examples of such
 * components are HTML, bitmap images and MathML.  An object that implements
 * <code>AccessibleStreamable</code> provides two things: a list of MIME
 * types supported by the object and a streaming interface for each MIME type to
 * get the data.
 *
 * @author Lynn Monsanto
 * @author Peter Korn
 *
 * @see javax.accessibility.AccessibleContext
 * @since 1.5
 */
public interface AccessibleStreamable {
    /**
      * Returns an array of DataFlavor objects for the MIME types
      * this object supports.
      *
      * @return an array of DataFlavor objects for the MIME types
      * this object supports.
      */
     DataFlavor[] getMimeTypes();

    /**
      * Returns an InputStream for a DataFlavor
      *
      * @param flavor the DataFlavor
      * @return an ImputStream if an ImputStream for this DataFlavor exists.
      * Otherwise, null is returned.
      */
     InputStream getStream(DataFlavor flavor);
}
