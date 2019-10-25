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
 * Interface SupportedValuesAttribute is a tagging interface which a printing
 * attribute class implements to indicate the attribute describes the supported
 * values for another attribute. For example, if a Print Service instance
 * supports the {@link javax.print.attribute.standard.Copies Copies}
 * attribute, the Print Service instance will have a {@link
 * javax.print.attribute.standard.CopiesSupported CopiesSupported} attribute,
 * which is a SupportedValuesAttribute giving the legal values a client may
 * specify for the {@link javax.print.attribute.standard.Copies Copies}
 * attribute.
 * <P>
 *
 * @author  Alan Kaminsky
 */
public interface SupportedValuesAttribute extends Attribute {
}
