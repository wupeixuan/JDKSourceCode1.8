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

import javax.print.DocPrintJob;
import javax.print.attribute.AttributeSetUtilities;
import javax.print.attribute.PrintJobAttributeSet;

/**
 * Class PrintJobAttributeEvent encapsulates an event a PrintService
 * reports to let the client know that one or more printing attributes for a
 * PrintJob have changed.
 */

public class PrintJobAttributeEvent extends PrintEvent {

    private static final long serialVersionUID = -6534469883874742101L;

    private PrintJobAttributeSet attributes;

    /**
     * Constructs a PrintJobAttributeEvent object.
     * @param source the print job generating  this event
     * @param attributes the attribute changes being reported
     * @throws IllegalArgumentException if <code>source</code> is
     *         <code>null</code>.
     */
    public PrintJobAttributeEvent (DocPrintJob source,
                                   PrintJobAttributeSet attributes)  {
        super(source);

        this.attributes = AttributeSetUtilities.unmodifiableView(attributes);
    }


    /**
     * Determine the Print Job to which this print job event pertains.
     *
     * @return  Print Job object.
     */
    public DocPrintJob getPrintJob() {

        return (DocPrintJob) getSource();
    }


    /**
     * Determine the printing attributes that changed and their new values.
     *
     * @return  Attributes containing the new values for the print job
     * attributes that changed. The returned set may not be modifiable.
     */
    public PrintJobAttributeSet getAttributes() {

        return attributes;

    }

}
