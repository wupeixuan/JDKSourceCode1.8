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
 *  The <code>LINK</code> element specifies a link to an external resource,
 * and defines this document's relationship to that resource (or vice versa).
 *  See the  LINK element definition in HTML 4.0  (see also the
 * <code>LinkStyle</code> interface in the  module).
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLLinkElement extends HTMLElement {
    /**
     *  Enables/disables the link. This is currently only used for style sheet
     * links, and may be used to activate or deactivate style sheets.
     */
    public boolean getDisabled();
    public void setDisabled(boolean disabled);

    /**
     *  The character encoding of the resource being linked to. See the
     * charset attribute definition in HTML 4.0.
     */
    public String getCharset();
    public void setCharset(String charset);

    /**
     *  The URI of the linked resource. See the  href attribute definition in
     * HTML 4.0.
     */
    public String getHref();
    public void setHref(String href);

    /**
     *  Language code of the linked resource. See the  hreflang attribute
     * definition in HTML 4.0.
     */
    public String getHreflang();
    public void setHreflang(String hreflang);

    /**
     *  Designed for use with one or more target media. See the  media
     * attribute definition in HTML 4.0.
     */
    public String getMedia();
    public void setMedia(String media);

    /**
     *  Forward link type. See the  rel attribute definition in HTML 4.0.
     */
    public String getRel();
    public void setRel(String rel);

    /**
     *  Reverse link type. See the  rev attribute definition in HTML 4.0.
     */
    public String getRev();
    public void setRev(String rev);

    /**
     *  Frame to render the resource in. See the  target attribute definition
     * in HTML 4.0.
     */
    public String getTarget();
    public void setTarget(String target);

    /**
     *  Advisory content type. See the  type attribute definition in HTML 4.0.
     */
    public String getType();
    public void setType(String type);

}
