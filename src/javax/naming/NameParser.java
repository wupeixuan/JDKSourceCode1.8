/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming;

/**
  * This interface is used for parsing names from a hierarchical
  * namespace.  The NameParser contains knowledge of the syntactic
  * information (like left-to-right orientation, name separator, etc.)
  * needed to parse names.
  *
  * The equals() method, when used to compare two NameParsers, returns
  * true if and only if they serve the same namespace.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see CompoundName
  * @see Name
  * @since 1.3
  */

public interface NameParser {
        /**
          * Parses a name into its components.
          *
          * @param name The non-null string name to parse.
          * @return A non-null parsed form of the name using the naming convention
          * of this parser.
          * @exception InvalidNameException If name does not conform to
          *     syntax defined for the namespace.
          * @exception NamingException If a naming exception was encountered.
          */
        Name parse(String name) throws NamingException;
}
