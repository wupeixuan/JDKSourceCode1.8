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
/**
 * An interface for handling Entity Declarations
 *
 * This interface is used to record and report unparsed entity declarations.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface EntityDeclaration extends XMLEvent {

  /**
   * The entity's public identifier, or null if none was given
   * @return the public ID for this declaration or null
   */
  String getPublicId();

  /**
   * The entity's system identifier.
   * @return the system ID for this declaration or null
   */
  String getSystemId();

  /**
   * The entity's name
   * @return the name, may not be null
   */
  String getName();

  /**
   * The name of the associated notation.
   * @return the notation name
   */
  String getNotationName();

  /**
   * The replacement text of the entity.
   * This method will only return non-null
   * if this is an internal entity.
   * @return null or the replacment text
   */
  String getReplacementText();

  /**
   * Get the base URI for this reference
   * or null if this information is not available
   * @return the base URI or null
   */
  String getBaseURI();

}
