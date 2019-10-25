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
 *  Regroups the <code>COL</code> and <code>COLGROUP</code> elements. See the
 * COL element definition in HTML 4.0.
 * <p>See also the <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLTableColElement extends HTMLElement {
    /**
     *  Horizontal alignment of cell data in column. See the  align attribute
     * definition in HTML 4.0.
     */
    public String getAlign();
    public void setAlign(String align);

    /**
     *  Alignment character for cells in a column. See the  char attribute
     * definition in HTML 4.0.
     */
    public String getCh();
    public void setCh(String ch);

    /**
     *  Offset of alignment character. See the  charoff attribute definition
     * in HTML 4.0.
     */
    public String getChOff();
    public void setChOff(String chOff);

    /**
     *  Indicates the number of columns in a group or affected by a grouping.
     * See the  span attribute definition in HTML 4.0.
     */
    public int getSpan();
    public void setSpan(int span);

    /**
     *  Vertical alignment of cell data in column. See the  valign attribute
     * definition in HTML 4.0.
     */
    public String getVAlign();
    public void setVAlign(String vAlign);

    /**
     *  Default column width. See the  width attribute definition in HTML 4.0.
     */
    public String getWidth();
    public void setWidth(String width);

}
