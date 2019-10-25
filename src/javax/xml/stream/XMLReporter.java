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
 * Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 */

package javax.xml.stream;

/**
 * This interface is used to report non-fatal errors.
 * Only warnings should be echoed through this interface.
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface XMLReporter {

    /**

     * Report the desired message in an application specific format.

     * Only warnings and non-fatal errors should be reported through

     * this interface.

     * Fatal errors should be thrown as XMLStreamException.

     *

     * @param message the error message

     * @param errorType an implementation defined error type

     * @param relatedInformation information related to the error, if available

     * @param location the location of the error, if available

     * @throws XMLStreamException

     */
    public void report(String message, String errorType, Object relatedInformation, Location location)
            throws XMLStreamException;
}
