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
 * An interface for handling Entity events.
 *
 * This event reports entities that have not been resolved
 * and reports their replacement text unprocessed (if
 * available).  This event will be reported if javax.xml.stream.isReplacingEntityReferences
 * is set to false.  If javax.xml.stream.isReplacingEntityReferences is set to true
 * entity references will be resolved transparently.
 *
 * Entities are handled in two possible ways:
 *
 * (1) If javax.xml.stream.isReplacingEntityReferences is set to true
 * all entity references are resolved and reported as markup transparently.
 * (2) If javax.xml.stream.isReplacingEntityReferences is set to false
 * Entity references are reported as an EntityReference Event.
 *
 * @version 1.0
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @since 1.6
 */
public interface EntityReference extends XMLEvent {

  /**
   * Return the declaration of this entity.
   */
  EntityDeclaration getDeclaration();

  /**
   * The name of the entity
   * @return the entity's name, may not be null
   */
  String getName();
}
