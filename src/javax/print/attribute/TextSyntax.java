/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable;
import java.util.Locale;

/**
 * Class TextSyntax is an abstract base class providing the common
 * implementation of all attributes whose value is a string. The text attribute
 * includes a locale to indicate the natural language. Thus, a text attribute
 * always represents a localized string. Once constructed, a text attribute's
 * value is immutable.
 * <P>
 *
 * @author  David Mendenhall
 * @author  Alan Kaminsky
 */
public abstract class TextSyntax implements Serializable, Cloneable {

    private static final long serialVersionUID = -8130648736378144102L;

    /**
     * String value of this text attribute.
     * @serial
     */
    private String value;

    /**
     * Locale of this text attribute.
     * @serial
     */
    private Locale locale;

    /**
     * Constructs a TextAttribute with the specified string and locale.
     *
     * @param  value   Text string.
     * @param  locale  Natural language of the text string. null
     * is interpreted to mean the default locale for as returned
     * by <code>Locale.getDefault()</code>
     *
     * @exception  NullPointerException
     *     (unchecked exception) Thrown if <CODE>value</CODE> is null.
     */
    protected TextSyntax(String value, Locale locale) {
        this.value = verify (value);
        this.locale = verify (locale);
    }

    private static String verify(String value) {
        if (value == null) {
            throw new NullPointerException(" value is null");
        }
        return value;
    }

    private static Locale verify(Locale locale) {
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    /**
     * Returns this text attribute's text string.
     * @return the text string.
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns this text attribute's text string's natural language (locale).
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Returns a hashcode for this text attribute.
     *
     * @return  A hashcode value for this object.
     */
    public int hashCode() {
        return value.hashCode() ^ locale.hashCode();
    }

    /**
     * Returns whether this text attribute is equivalent to the passed in
     * object. To be equivalent, all of the following conditions must be true:
     * <OL TYPE=1>
     * <LI>
     * <CODE>object</CODE> is not null.
     * <LI>
     * <CODE>object</CODE> is an instance of class TextSyntax.
     * <LI>
     * This text attribute's underlying string and <CODE>object</CODE>'s
     * underlying string are equal.
     * <LI>
     * This text attribute's locale and <CODE>object</CODE>'s locale are
     * equal.
     * </OL>
     *
     * @param  object  Object to compare to.
     *
     * @return  True if <CODE>object</CODE> is equivalent to this text
     *          attribute, false otherwise.
     */
    public boolean equals(Object object) {
        return(object != null &&
               object instanceof TextSyntax &&
               this.value.equals (((TextSyntax) object).value) &&
               this.locale.equals (((TextSyntax) object).locale));
    }

    /**
     * Returns a String identifying this text attribute. The String is
     * the attribute's underlying text string.
     *
     * @return  A String identifying this object.
     */
    public String toString(){
        return value;
    }

}
