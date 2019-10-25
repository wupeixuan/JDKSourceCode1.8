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
 *  Create a horizontal rule. See the  HR element definition in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLHRElement extends HTMLElement {
    /**
     *  Align the rule on the page. See the  align attribute definition in
     * HTML 4.0. This attribute is deprecated in HTML 4.0.
     */
    public String getAlign();
    public void setAlign(String align);

    /**
     *  Indicates to the user agent that there should be no shading in the
     * rendering of this element. See the  noshade attribute definition in
     * HTML 4.0. This attribute is deprecated in HTML 4.0.
     */
    public boolean getNoShade();
    public void setNoShade(boolean noShade);

    /**
     *  The height of the rule. See the  size attribute definition in HTML
     * 4.0. This attribute is deprecated in HTML 4.0.
     */
    public String getSize();
    public void setSize(String size);

    /**
     *  The width of the rule. See the  width attribute definition in HTML
     * 4.0. This attribute is deprecated in HTML 4.0.
     */
    public String getWidth();
    public void setWidth(String width);

}
