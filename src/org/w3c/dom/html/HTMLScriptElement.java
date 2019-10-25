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

/**
 *  Script statements. See the  SCRIPT element definition in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLScriptElement extends HTMLElement {
    /**
     *  The script content of the element.
     */
    public String getText();
    public void setText(String text);

    /**
     *  Reserved for future use.
     */
    public String getHtmlFor();
    public void setHtmlFor(String htmlFor);

    /**
     *  Reserved for future use.
     */
    public String getEvent();
    public void setEvent(String event);

    /**
     *  The character encoding of the linked resource. See the  charset
     * attribute definition in HTML 4.0.
     */
    public String getCharset();
    public void setCharset(String charset);

    /**
     *  Indicates that the user agent can defer processing of the script.  See
     * the  defer attribute definition in HTML 4.0.
     */
    public boolean getDefer();
    public void setDefer(boolean defer);

    /**
     *  URI designating an external script. See the  src attribute definition
     * in HTML 4.0.
     */
    public String getSrc();
    public void setSrc(String src);

    /**
     *  The content type of the script language. See the  type attribute
     * definition in HTML 4.0.
     */
    public String getType();
    public void setType(String type);

}
