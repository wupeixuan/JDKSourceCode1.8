/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.event;

import javax.print.PrintService;
import javax.print.attribute.AttributeSetUtilities;
import javax.print.attribute.PrintServiceAttributeSet;

/**
 *
 * Class PrintServiceAttributeEvent encapsulates an event a
 * Print Service instance reports to let the client know of
 * changes in the print service state.
 */

public class PrintServiceAttributeEvent extends PrintEvent {

    private static final long serialVersionUID = -7565987018140326600L;

    private PrintServiceAttributeSet attributes;

    /**
     * Constructs a PrintServiceAttributeEvent object.
     *
     * @param source the print job generating  this event
     * @param attributes the attribute changes being reported
     * @throws IllegalArgumentException if <code>source</code> is
     *         <code>null</code>.
     */
    public PrintServiceAttributeEvent(PrintService source,
                                      PrintServiceAttributeSet attributes) {

        super(source);
        this.attributes = AttributeSetUtilities.unmodifiableView(attributes);
    }


    /**
     * Returns the print service.

     * @return  Print Service object.
     */
    public PrintService getPrintService() {

        return (PrintService) getSource();
    }


    /**
     * Determine the printing service attributes that changed and their new
     * values.
     *
     * @return  Attributes containing the new values for the service
     * attributes that changed. The returned set may be unmodifiable.
     */
    public PrintServiceAttributeSet getAttributes() {

        return attributes;
    }

}
