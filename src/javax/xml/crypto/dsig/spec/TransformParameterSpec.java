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
 * $Id: TransformParameterSpec.java,v 1.3 2005/05/10 16:40:17 mullan Exp $
 */
package javax.xml.crypto.dsig.spec;

import javax.xml.crypto.dsig.Transform;
import java.security.spec.AlgorithmParameterSpec;

/**
 * A specification of algorithm parameters for a {@link Transform}
 * algorithm. The purpose of this interface is to group (and provide type
 * safety for) all transform parameter specifications. All transform parameter
 * specifications must implement this interface.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see Transform
 */
public interface TransformParameterSpec extends AlgorithmParameterSpec {}
