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

package javax.print;


 /** Interface MultiPrintService is the factory for a MultiDocPrintJob.
  * A MultiPrintService
  * describes the capabilities of a Printer and can be queried regarding
  * a printer's supported attributes.
  */
public interface MultiDocPrintService extends PrintService {

    /**
     * Create a job which can print a multiDoc.
     * @return a MultiDocPrintJob
     */
    public MultiDocPrintJob createMultiDocPrintJob();

}
