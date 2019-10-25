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

package javax.xml.stream.events;

import java.util.List;

/**
 * This is the top level interface for events dealing with DTDs
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface DTD extends XMLEvent {

  /**
   * Returns the entire Document Type Declaration as a string, including
   * the internal DTD subset.
   * This may be null if there is not an internal subset.
   * If it is not null it must return the entire
   * Document Type Declaration which matches the doctypedecl
   * production in the XML 1.0 specification
   */
  String getDocumentTypeDeclaration();

  /**
   * Returns an implementation defined representation of the DTD.
   * This method may return null if no representation is available.
   */
  Object getProcessedDTD();

  /**
   * Return a List containing the notations declared in the DTD.
   * This list must contain NotationDeclaration events.
   * @see NotationDeclaration
   * @return an unordered list of NotationDeclaration events
   */
  List getNotations();

  /**
   * Return a List containing the general entities,
   * both external and internal, declared in the DTD.
   * This list must contain EntityDeclaration events.
   * @see EntityDeclaration
   * @return an unordered list of EntityDeclaration events
   */
  List getEntities();
}
