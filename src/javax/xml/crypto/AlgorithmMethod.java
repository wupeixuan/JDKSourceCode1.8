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
 * $Id: AlgorithmMethod.java,v 1.4 2005/05/10 15:47:41 mullan Exp $
 */
package javax.xml.crypto;

import java.security.spec.AlgorithmParameterSpec;

/**
 * An abstract representation of an algorithm defined in the XML Security
 * specifications. Subclasses represent specific types of XML security
 * algorithms, such as a {@link javax.xml.crypto.dsig.Transform}.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public interface AlgorithmMethod {

    /**
     * Returns the algorithm URI of this <code>AlgorithmMethod</code>.
     *
     * @return the algorithm URI of this <code>AlgorithmMethod</code>
     */
    String getAlgorithm();

    /**
     * Returns the algorithm parameters of this <code>AlgorithmMethod</code>.
     *
     * @return the algorithm parameters of this <code>AlgorithmMethod</code>.
     *    Returns <code>null</code> if this <code>AlgorithmMethod</code> does
     *    not require parameters and they are not specified.
     */
    AlgorithmParameterSpec getParameterSpec();
}
