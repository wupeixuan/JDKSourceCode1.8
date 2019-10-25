/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;


/** An IDL struct in the CORBA module that
 *  stores information about a CORBA service available in the
 *  ORB implementation and is obtained from the <tt>ORB.get_service_information</tt>
 *  method.
 */
public final class ServiceInformation implements org.omg.CORBA.portable.IDLEntity
{
    /** Array of ints representing service options.
    */
    public int[] service_options;

    /** Array of ServiceDetails giving more details about the service.
    */
    public org.omg.CORBA.ServiceDetail[] service_details;

    /** Constructs a ServiceInformation object with empty service_options
    * and service_details.
    */
    public ServiceInformation() { }

    /** Constructs a ServiceInformation object with the given service_options
    * and service_details.
    * @param __service_options An array of ints describing the service options.
    * @param __service_details An array of ServiceDetails describing the service
    * details.
    */
    public ServiceInformation(int[] __service_options,
                              org.omg.CORBA.ServiceDetail[] __service_details)
    {
        service_options = __service_options;
        service_details = __service_details;
    }
}
