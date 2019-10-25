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

package javax.xml.transform.sax;

import javax.xml.transform.*;

import org.xml.sax.ContentHandler;

/**
 * A SAX ContentHandler that may be used to process SAX
 * parse events (parsing transformation instructions) into a Templates object.
 *
 * <p>Note that TemplatesHandler does not need to implement LexicalHandler.</p>
 */
public interface TemplatesHandler extends ContentHandler {

    /**
     * When a TemplatesHandler object is used as a ContentHandler
     * for the parsing of transformation instructions, it creates a Templates object,
     * which the caller can get once the SAX events have been completed.
     *
     * @return The Templates object that was created during
     * the SAX event process, or null if no Templates object has
     * been created.
     *
     */
    public Templates getTemplates();

    /**
     * Set the base ID (URI or system ID) for the Templates object
     * created by this builder.  This must be set in order to
     * resolve relative URIs in the stylesheet.  This must be
     * called before the startDocument event.
     *
     * @param systemID Base URI for this stylesheet.
     */
    public void setSystemId(String systemID);

    /**
     * Get the base ID (URI or system ID) from where relative
     * URLs will be resolved.
     * @return The systemID that was set with {@link #setSystemId}.
     */
    public String getSystemId();
}
