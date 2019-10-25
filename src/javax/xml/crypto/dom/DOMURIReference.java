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
 * $Id: DOMURIReference.java,v 1.5 2005/05/09 18:33:26 mullan Exp $
 */
package javax.xml.crypto.dom;

import javax.xml.crypto.URIReference;
import org.w3c.dom.Node;

/**
 * A DOM-specific {@link URIReference}. The purpose of this class is to
 * provide additional context necessary for resolving XPointer URIs or
 * same-document references.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public interface DOMURIReference extends URIReference {

    /**
     * Returns the here node.
     *
     * @return the attribute or processing instruction node or the
     *    parent element of the text node that directly contains the URI
     */
    Node getHere();
}
