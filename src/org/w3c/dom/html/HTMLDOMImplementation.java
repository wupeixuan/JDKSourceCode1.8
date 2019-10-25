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
 *
 *
 *
 *
 *
 * Copyright (c) 2000 World Wide Web Consortium,
 * (Massachusetts Institute of Technology, Institut National de
 * Recherche en Informatique et en Automatique, Keio University). All
 * Rights Reserved. This program is distributed under the W3C's Software
 * Intellectual Property License. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See W3C License http://www.w3.org/Consortium/Legal/ for more
 * details.
 */

package org.w3c.dom.html;

import org.w3c.dom.DOMImplementation;

/**
 *  The <code>HTMLDOMImplementation</code> interface extends the
 * <code>DOMImplementation</code> interface with a method for creating an
 * HTML document instance.
 * @since DOM Level 2
 */
public interface HTMLDOMImplementation extends DOMImplementation {
    /**
     *  Creates an <code>HTMLDocument</code> object with the minimal tree made
     * of the following elements: <code>HTML</code> , <code>HEAD</code> ,
     * <code>TITLE</code> , and <code>BODY</code> .
     * @param title  The title of the document to be set as the content of the
     *   <code>TITLE</code> element, through a child <code>Text</code> node.
     * @return  A new <code>HTMLDocument</code> object.
     */
    public HTMLDocument createHTMLDocument(String title);

}
