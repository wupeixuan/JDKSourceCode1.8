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
 * $Id: XMLValidateContext.java,v 1.8 2005/05/10 16:03:49 mullan Exp $
 */
package javax.xml.crypto.dsig;

import javax.xml.crypto.XMLCryptoContext;

/**
 * Contains context information for validating XML Signatures. This interface
 * is primarily intended for type-safety.
 *
 * <p>Note that <code>XMLValidateContext</code> instances can contain
 * information and state specific to the XML signature structure it is
 * used with. The results are unpredictable if an
 * <code>XMLValidateContext</code> is used with different signature structures
 * (for example, you should not use the same <code>XMLValidateContext</code>
 * instance to validate two different {@link XMLSignature} objects).
 * <p>
 * <b><a name="Supported Properties"></a>Supported Properties</b>
 * <p>The following properties can be set by an application using the
 * {@link #setProperty setProperty} method.
 * <ul>
 *   <li><code>javax.xml.crypto.dsig.cacheReference</code>: value must be a
 *      {@link Boolean}. This property controls whether or not the
 *      {@link Reference#validate Reference.validate} method will cache the
 *      dereferenced content and pre-digested input for subsequent retrieval via
 *      the {@link Reference#getDereferencedData Reference.getDereferencedData}
 *      and {@link Reference#getDigestInputStream
 *      Reference.getDigestInputStream} methods. The default value if not
 *      specified is <code>Boolean.FALSE</code>.
 * </ul>
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see XMLSignature#validate(XMLValidateContext)
 * @see Reference#validate(XMLValidateContext)
 */
public interface XMLValidateContext extends XMLCryptoContext {}
