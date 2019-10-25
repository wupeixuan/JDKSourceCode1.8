/*
 * Copyright (c) 2000, 2007, Oracle and/or its affiliates. All rights reserved.
 *
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
 *
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.charset;


/**
 * Unchecked exception thrown when no support is available
 * for a requested charset.
 *
 * @since 1.4
 */

public class UnsupportedCharsetException
    extends IllegalArgumentException
{

    private static final long serialVersionUID = 1490765524727386367L;

    private String charsetName;

    /**
     * Constructs an instance of this class.
     *
     * @param  charsetName
     *         The name of the unsupported charset
     */
    public UnsupportedCharsetException(String charsetName) {
        super(String.valueOf(charsetName));
	this.charsetName = charsetName;
    }

    /**
     * Retrieves the name of the unsupported charset.
     *
     * @return  The name of the unsupported charset
     */
    public String getCharsetName() {
        return charsetName;
    }

}
