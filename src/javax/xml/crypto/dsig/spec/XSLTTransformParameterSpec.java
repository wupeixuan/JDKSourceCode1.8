/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
 * $Id: XSLTTransformParameterSpec.java,v 1.4 2005/05/10 16:40:18 mullan Exp $
 */
package javax.xml.crypto.dsig.spec;

import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.XMLStructure;

/**
 * Parameters for the <a href="http://www.w3.org/TR/1999/REC-xslt-19991116">
 * XSLT Transform Algorithm</a>.
 * The parameters include a namespace-qualified stylesheet element.
 *
 * <p>An <code>XSLTTransformParameterSpec</code> is instantiated with a
 * mechanism-dependent (ex: DOM) stylesheet element. For example:
 * <pre>
 *   DOMStructure stylesheet = new DOMStructure(element)
 *   XSLTTransformParameterSpec spec = new XSLTransformParameterSpec(stylesheet);
 * </pre>
 * where <code>element</code> is an {@link org.w3c.dom.Element} containing
 * the namespace-qualified stylesheet element.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see Transform
 */
public final class XSLTTransformParameterSpec implements TransformParameterSpec{
    private XMLStructure stylesheet;

    /**
     * Creates an <code>XSLTTransformParameterSpec</code> with the specified
     * stylesheet.
     *
     * @param stylesheet the XSLT stylesheet to be used
     * @throws NullPointerException if <code>stylesheet</code> is
     *    <code>null</code>
     */
    public XSLTTransformParameterSpec(XMLStructure stylesheet) {
        if (stylesheet == null) {
            throw new NullPointerException();
        }
        this.stylesheet = stylesheet;
    }

    /**
     * Returns the stylesheet.
     *
     * @return the stylesheet
     */
    public XMLStructure getStylesheet() {
        return stylesheet;
    }
}
