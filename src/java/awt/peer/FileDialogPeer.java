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

import java.awt.FileDialog;
import java.io.FilenameFilter;

/**
 * The peer interface for {@link FileDialog}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface FileDialogPeer extends DialogPeer {

    /**
     * Sets the selected file for this file dialog.
     *
     * @param file the file to set as selected file, or {@code null} for
     *        no selected file
     *
     * @see FileDialog#setFile(String)
     */
    void setFile(String file);

    /**
     * Sets the current directory for this file dialog.
     *
     * @param dir the directory to set
     *
     * @see FileDialog#setDirectory(String)
     */
    void setDirectory(String dir);

    /**
     * Sets the filename filter for filtering the displayed files.
     *
     * @param filter the filter to set
     *
     * @see FileDialog#setFilenameFilter(FilenameFilter)
     */
    void setFilenameFilter(FilenameFilter filter);
}
