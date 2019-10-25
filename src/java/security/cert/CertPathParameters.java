/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security.cert;

/**
 * A specification of certification path algorithm parameters.
 * The purpose of this interface is to group (and provide type safety for)
 * all {@code CertPath} parameter specifications. All
 * {@code CertPath} parameter specifications must implement this
 * interface.
 *
 * @author      Yassir Elley
 * @see         CertPathValidator#validate(CertPath, CertPathParameters)
 * @see         CertPathBuilder#build(CertPathParameters)
 * @since       1.4
 */
public interface CertPathParameters extends Cloneable {

  /**
   * Makes a copy of this {@code CertPathParameters}. Changes to the
   * copy will not affect the original and vice versa.
   *
   * @return a copy of this {@code CertPathParameters}
   */
  Object clone();
}
