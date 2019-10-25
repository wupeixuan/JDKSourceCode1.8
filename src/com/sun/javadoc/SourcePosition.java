/*
 * Copyright (c) 2001, 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javadoc;

import java.io.File;

/**
 * This interface describes a source position: filename, line number,
 * and column number.
 *
 * @since 1.4
 * @author Neal M Gafter
 */
public interface SourcePosition {
    /** The source file. Returns null if no file information is
     *  available. */
    File file();

    /** The line in the source file. The first line is numbered 1;
     *  0 means no line number information is available. */
    int line();

    /** The column in the source file. The first column is
     *  numbered 1; 0 means no column information is available.
     *  Columns count characters in the input stream; a tab
     *  advances the column number to the next 8-column tab stop.
     */
    int column();

    /** Convert the source position to the form "Filename:line". */
    String toString();
}
