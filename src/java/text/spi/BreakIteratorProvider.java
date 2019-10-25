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

package java.text.spi;

import java.text.BreakIterator;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

/**
 * An abstract class for service providers that
 * provide concrete implementations of the
 * {@link java.text.BreakIterator BreakIterator} class.
 *
 * @since        1.6
 */
public abstract class BreakIteratorProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected BreakIteratorProvider() {
    }

    /**
     * Returns a new <code>BreakIterator</code> instance
     * for <a href="../BreakIterator.html#word">word breaks</a>
     * for the given locale.
     * @param locale the desired locale
     * @return A break iterator for word breaks
     * @exception NullPointerException if <code>locale</code> is null
     * @exception IllegalArgumentException if <code>locale</code> isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @see java.text.BreakIterator#getWordInstance(java.util.Locale)
     */
    public abstract BreakIterator getWordInstance(Locale locale);

    /**
     * Returns a new <code>BreakIterator</code> instance
     * for <a href="../BreakIterator.html#line">line breaks</a>
     * for the given locale.
     * @param locale the desired locale
     * @return A break iterator for line breaks
     * @exception NullPointerException if <code>locale</code> is null
     * @exception IllegalArgumentException if <code>locale</code> isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @see java.text.BreakIterator#getLineInstance(java.util.Locale)
     */
    public abstract BreakIterator getLineInstance(Locale locale);

    /**
     * Returns a new <code>BreakIterator</code> instance
     * for <a href="../BreakIterator.html#character">character breaks</a>
     * for the given locale.
     * @param locale the desired locale
     * @return A break iterator for character breaks
     * @exception NullPointerException if <code>locale</code> is null
     * @exception IllegalArgumentException if <code>locale</code> isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @see java.text.BreakIterator#getCharacterInstance(java.util.Locale)
     */
    public abstract BreakIterator getCharacterInstance(Locale locale);

    /**
     * Returns a new <code>BreakIterator</code> instance
     * for <a href="../BreakIterator.html#sentence">sentence breaks</a>
     * for the given locale.
     * @param locale the desired locale
     * @return A break iterator for sentence breaks
     * @exception NullPointerException if <code>locale</code> is null
     * @exception IllegalArgumentException if <code>locale</code> isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @see java.text.BreakIterator#getSentenceInstance(java.util.Locale)
     */
    public abstract BreakIterator getSentenceInstance(Locale locale);
}
