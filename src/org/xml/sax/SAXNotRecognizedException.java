/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

// SAXNotRecognizedException.java - unrecognized feature or value.
// http://www.saxproject.org
// Written by David Megginson
// NO WARRANTY!  This class is in the Public Domain.
// $Id: SAXNotRecognizedException.java,v 1.3 2004/11/03 22:55:32 jsuttor Exp $

package org.xml.sax;


/**
 * Exception class for an unrecognized identifier.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>An XMLReader will throw this exception when it finds an
 * unrecognized feature or property identifier; SAX applications and
 * extensions may use this class for other, similar purposes.</p>
 *
 * @since SAX 2.0
 * @author David Megginson
 * @see org.xml.sax.SAXNotSupportedException
 */
public class SAXNotRecognizedException extends SAXException
{

    /**
     * Default constructor.
     */
    public SAXNotRecognizedException ()
    {
        super();
    }


    /**
     * Construct a new exception with the given message.
     *
     * @param message The text message of the exception.
     */
    public SAXNotRecognizedException (String message)
    {
        super(message);
    }

    // Added serialVersionUID to preserve binary compatibility
    static final long serialVersionUID = 5440506620509557213L;
}

// end of SAXNotRecognizedException.java
