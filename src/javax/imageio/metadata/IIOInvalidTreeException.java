/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package javax.imageio.metadata;

import javax.imageio.IIOException;
import org.w3c.dom.Node;

/**
 * An <code>IIOInvalidTreeException</code> is thrown when an attempt
 * by an <code>IIOMetadata</code> object to parse a tree of
 * <code>IIOMetadataNode</code>s fails.  The node that led to the
 * parsing error may be stored.  As with any parsing error, the actual
 * error may occur at a different point that that where it is
 * detected.  The node returned by <code>getOffendingNode</code>
 * should merely be considered as a clue to the actual nature of the
 * problem.
 *
 * @see IIOMetadata#setFromTree
 * @see IIOMetadata#mergeTree
 * @see IIOMetadataNode
 *
 */
public class IIOInvalidTreeException extends IIOException {

    /**
     * The <code>Node</code> that led to the parsing error, or
     * <code>null</code>.
     */
    protected Node offendingNode = null;

    /**
     * Constructs an <code>IIOInvalidTreeException</code> with a
     * message string and a reference to the <code>Node</code> that
     * caused the parsing error.
     *
     * @param message a <code>String</code> containing the reason for
     * the parsing failure.
     * @param offendingNode the DOM <code>Node</code> that caused the
     * exception, or <code>null</code>.
     */
    public IIOInvalidTreeException(String message, Node offendingNode) {
        super(message);
        this.offendingNode = offendingNode;
    }

    /**
     * Constructs an <code>IIOInvalidTreeException</code> with a
     * message string, a reference to an exception that caused this
     * exception, and a reference to the <code>Node</code> that caused
     * the parsing error.
     *
     * @param message a <code>String</code> containing the reason for
     * the parsing failure.
     * @param cause the <code>Throwable</code> (<code>Error</code> or
     * <code>Exception</code>) that caused this exception to occur,
     * or <code>null</code>.
     * @param offendingNode the DOM <code>Node</code> that caused the
     * exception, or <code>null</code>.
     */
    public IIOInvalidTreeException(String message, Throwable cause,
                                   Node offendingNode) {
        super(message, cause);
        this.offendingNode = offendingNode;
    }

    /**
     * Returns the <code>Node</code> that caused the error in parsing.
     *
     * @return the offending <code>Node</code>.
     */
    public Node getOffendingNode() {
        return offendingNode;
    }
}
