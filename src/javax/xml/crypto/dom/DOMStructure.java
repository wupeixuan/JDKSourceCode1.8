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
 * $Id: DOMStructure.java,v 1.6 2005/05/09 18:33:26 mullan Exp $
 */
package javax.xml.crypto.dom;

import org.w3c.dom.Node;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.XMLSignature;

/**
 * A DOM-specific {@link XMLStructure}. The purpose of this class is to
 * allow a DOM node to be used to represent extensible content (any elements
 * or mixed content) in XML Signature structures.
 *
 * <p>If a sequence of nodes is needed, the node contained in the
 * <code>DOMStructure</code> is the first node of the sequence and successive
 * nodes can be accessed by invoking {@link Node#getNextSibling}.
 *
 * <p>If the owner document of the <code>DOMStructure</code> is different than
 * the target document of an <code>XMLSignature</code>, the
 * {@link XMLSignature#sign(XMLSignContext)} method imports the node into the
 * target document before generating the signature.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public class DOMStructure implements XMLStructure {

    private final Node node;

    /**
     * Creates a <code>DOMStructure</code> containing the specified node.
     *
     * @param node the node
     * @throws NullPointerException if <code>node</code> is <code>null</code>
     */
    public DOMStructure(Node node) {
        if (node == null) {
            throw new NullPointerException("node cannot be null");
        }
        this.node = node;
    }

    /**
     * Returns the node contained in this <code>DOMStructure</code>.
     *
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /**
     * @throws NullPointerException {@inheritDoc}
     */
    public boolean isFeatureSupported(String feature) {
        if (feature == null) {
            throw new NullPointerException();
        } else {
            return false;
        }
    }
}
