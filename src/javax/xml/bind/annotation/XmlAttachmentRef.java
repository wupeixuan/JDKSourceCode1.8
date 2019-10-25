/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.bind.annotation;

import javax.activation.DataHandler;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Marks a field/property that its XML form is a uri reference to mime content.
 * The mime content is optimally stored out-of-line as an attachment.
 *
 * A field/property must always map to the {@link DataHandler} class.
 *
 * <h2>Usage</h2>
 * <pre>
 * &#64;{@link XmlRootElement}
 * class Foo {
 *   &#64;{@link XmlAttachmentRef}
 *   &#64;{@link XmlAttribute}
 *   {@link DataHandler} data;
 *
 *   &#64;{@link XmlAttachmentRef}
 *   &#64;{@link XmlElement}
 *   {@link DataHandler} body;
 * }
 * </pre>
 * The above code maps to the following XML:
 * <pre>
 * &lt;xs:element name="foo" xmlns:ref="http://ws-i.org/profiles/basic/1.1/xsd">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element name="body" type="ref:swaRef" minOccurs="0" />
 *     &lt;/xs:sequence>
 *     &lt;xs:attribute name="data" type="ref:swaRef" use="optional" />
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 *
 * <p>
 * The above binding supports WS-I AP 1.0 <a href="http://www.ws-i.org/Profiles/AttachmentsProfile-1.0-2004-08-24.html#Referencing_Attachments_from_the_SOAP_Envelope">WS-I Attachments Profile Version 1.0.</a>
 *
 * @author Kohsuke Kawaguchi
 * @since JAXB2.0
 */
@Retention(RUNTIME)
@Target({FIELD,METHOD,PARAMETER})
public @interface XmlAttachmentRef {
}
