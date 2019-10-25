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
 * This interface is used to resolve resources during an XML parse.  If an application wishes to
 * perform custom entity resolution it must register an instance of this interface with
 * the XMLInputFactory using the setXMLResolver method.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface XMLResolver {

  /**
   * Retrieves a resource.  This resource can be of the following three return types:
   * (1) java.io.InputStream (2) javax.xml.stream.XMLStreamReader (3) java.xml.stream.XMLEventReader.
   * If this method returns null the processor will attempt to resolve the entity using its
   * default mechanism.
   *
   * @param publicID The public identifier of the external entity being referenced, or null if none was supplied.
   * @param systemID The system identifier of the external entity being referenced.
   * @param baseURI  Absolute base URI associated with systemId.
   * @param namespace The namespace of the entity to resolve.
   * @return The resource requested or null.
   * @throws XMLStreamException if there was a failure attempting to resolve the resource.
   */
  public Object resolveEntity(String publicID,
                              String systemID,
                              String baseURI,
                              String namespace)
    throws XMLStreamException;
}
