/*
 * Copyright (c) 1998, 1999, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.text.html.parser;

/**
 * SGML constants used in a DTD. The names of the
 * constants correspond the the equivalent SGML constructs
 * as described in "The SGML Handbook" by  Charles F. Goldfarb.
 *
 * @see DTD
 * @see Element
 * @author Arthur van Hoff
 */
public
interface DTDConstants {
    // Attribute value types
    int CDATA           = 1;
    int ENTITY          = 2;
    int ENTITIES        = 3;
    int ID              = 4;
    int IDREF           = 5;
    int IDREFS          = 6;
    int NAME            = 7;
    int NAMES           = 8;
    int NMTOKEN         = 9;
    int NMTOKENS        = 10;
    int NOTATION        = 11;
    int NUMBER          = 12;
    int NUMBERS         = 13;
    int NUTOKEN         = 14;
    int NUTOKENS        = 15;

    // Content model types
    int RCDATA          = 16;
    int EMPTY           = 17;
    int MODEL           = 18;
    int ANY             = 19;

    // Attribute value modifiers
    int FIXED           = 1;
    int REQUIRED        = 2;
    int CURRENT         = 3;
    int CONREF          = 4;
    int IMPLIED         = 5;

    // Entity types
    int PUBLIC          = 10;
    int SDATA           = 11;
    int PI              = 12;
    int STARTTAG        = 13;
    int ENDTAG          = 14;
    int MS              = 15;
    int MD              = 16;
    int SYSTEM          = 17;

    int GENERAL         = 1<<16;
    int DEFAULT         = 1<<17;
    int PARAMETER       = 1<<18;
}
