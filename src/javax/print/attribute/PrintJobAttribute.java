/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.attribute;

/**
 * PrintJobAttribute is a tagging interface which a printing attribute
 * class implements to indicate the attribute describes the status of a Print
 * Job or some other characteristic of a Print Job. A Print Service
 * instance adds a number of PrintJobAttributes to a Print Job's attribute set
 * to report the Print Job's status. If an attribute implements {@link
 * PrintRequestAttribute PrintRequestAttribute} as well as PrintJobAttribute,
 * the client may include the attribute in a attribute set to
 * specify the attribute's value for the Print Job.
 * <P>
 *
 * @see PrintRequestAttributeSet
 * @see PrintJobAttributeSet
 *
 * @author  Alan Kaminsky
 */
public interface PrintJobAttribute extends Attribute {
}
