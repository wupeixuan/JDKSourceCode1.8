/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.util.spi;

import java.util.Locale;

/**
 * An abstract class for service providers that
 * provide localized time zone names for the
 * {@link java.util.TimeZone TimeZone} class.
 * The localized time zone names available from the implementations of
 * this class are also the source for the
 * {@link java.text.DateFormatSymbols#getZoneStrings()
 * DateFormatSymbols.getZoneStrings()} method.
 *
 * @since        1.6
 */
public abstract class TimeZoneNameProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected TimeZoneNameProvider() {
    }

    /**
     * Returns a name for the given time zone ID that's suitable for
     * presentation to the user in the specified locale. The given time
     * zone ID is "GMT" or one of the names defined using "Zone" entries
     * in the "tz database", a public domain time zone database at
     * <a href="ftp://elsie.nci.nih.gov/pub/">ftp://elsie.nci.nih.gov/pub/</a>.
     * The data of this database is contained in a file whose name starts with
     * "tzdata", and the specification of the data format is part of the zic.8
     * man page, which is contained in a file whose name starts with "tzcode".
     * <p>
     * If <code>daylight</code> is true, the method should return a name
     * appropriate for daylight saving time even if the specified time zone
     * has not observed daylight saving time in the past.
     *
     * @param ID a time zone ID string
     * @param daylight if true, return the daylight saving name.
     * @param style either {@link java.util.TimeZone#LONG TimeZone.LONG} or
     *    {@link java.util.TimeZone#SHORT TimeZone.SHORT}
     * @param locale the desired locale
     * @return the human-readable name of the given time zone in the
     *     given locale, or null if it's not available.
     * @exception IllegalArgumentException if <code>style</code> is invalid,
     *     or <code>locale</code> isn't one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @exception NullPointerException if <code>ID</code> or <code>locale</code>
     *     is null
     * @see java.util.TimeZone#getDisplayName(boolean, int, java.util.Locale)
     */
    public abstract String getDisplayName(String ID, boolean daylight, int style, Locale locale);

    /**
     * Returns a generic name for the given time zone {@code ID} that's suitable
     * for presentation to the user in the specified {@code locale}. Generic
     * time zone names are neutral from standard time and daylight saving
     * time. For example, "PT" is the short generic name of time zone ID {@code
     * America/Los_Angeles}, while its short standard time and daylight saving
     * time names are "PST" and "PDT", respectively. Refer to
     * {@link #getDisplayName(String, boolean, int, Locale) getDisplayName}
     * for valid time zone IDs.
     *
     * <p>The default implementation of this method returns {@code null}.
     *
     * @param ID a time zone ID string
     * @param style either {@link java.util.TimeZone#LONG TimeZone.LONG} or
     *    {@link java.util.TimeZone#SHORT TimeZone.SHORT}
     * @param locale the desired locale
     * @return the human-readable generic name of the given time zone in the
     *     given locale, or {@code null} if it's not available.
     * @exception IllegalArgumentException if <code>style</code> is invalid,
     *     or <code>locale</code> isn't one of the locales returned from
     *     {@link LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @exception NullPointerException if <code>ID</code> or <code>locale</code>
     *     is {@code null}
     * @since 1.8
     */
    public String getGenericDisplayName(String ID, int style, Locale locale) {
        return null;
    }
}
