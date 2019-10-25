/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.filechooser;

import java.io.File;

/**
 * <code>FileFilter</code> is an abstract class used by {@code JFileChooser}
 * for filtering the set of files shown to the user. See
 * {@code FileNameExtensionFilter} for an implementation that filters using
 * the file name extension.
 * <p>
 * A <code>FileFilter</code>
 * can be set on a <code>JFileChooser</code> to
 * keep unwanted files from appearing in the directory listing.
 * For an example implementation of a simple file filter, see
 * <code><i>yourJDK</i>/demo/jfc/FileChooserDemo/ExampleFileFilter.java</code>.
 * For more information and examples see
 * <a href="https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html">How to Use File Choosers</a>,
 * a section in <em>The Java Tutorial</em>.
 *
 * @see FileNameExtensionFilter
 * @see javax.swing.JFileChooser#setFileFilter
 * @see javax.swing.JFileChooser#addChoosableFileFilter
 *
 * @author Jeff Dinkins
 */
public abstract class FileFilter {
    /**
     * Whether the given file is accepted by this filter.
     */
    public abstract boolean accept(File f);

    /**
     * The description of this filter. For example: "JPG and GIF Images"
     * @see FileView#getName
     */
    public abstract String getDescription();
}
