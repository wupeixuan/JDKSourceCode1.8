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

package java.net;

/**
 * CookiePolicy implementations decide which cookies should be accepted
 * and which should be rejected. Three pre-defined policy implementations
 * are provided, namely ACCEPT_ALL, ACCEPT_NONE and ACCEPT_ORIGINAL_SERVER.
 *
 * <p>See RFC 2965 sec. 3.3 and 7 for more detail.
 *
 * @author Edward Wang
 * @since 1.6
 */
public interface CookiePolicy {
    /**
     * One pre-defined policy which accepts all cookies.
     */
    public static final CookiePolicy ACCEPT_ALL = new CookiePolicy(){
        public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return true;
        }
    };

    /**
     * One pre-defined policy which accepts no cookies.
     */
    public static final CookiePolicy ACCEPT_NONE = new CookiePolicy(){
        public boolean shouldAccept(URI uri, HttpCookie cookie) {
            return false;
        }
    };

    /**
     * One pre-defined policy which only accepts cookies from original server.
     */
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER  = new CookiePolicy(){
        public boolean shouldAccept(URI uri, HttpCookie cookie) {
            if (uri == null || cookie == null)
                return false;
            return HttpCookie.domainMatches(cookie.getDomain(), uri.getHost());
        }
    };


    /**
     * Will be called to see whether or not this cookie should be accepted.
     *
     * @param uri       the URI to consult accept policy with
     * @param cookie    the HttpCookie object in question
     * @return          {@code true} if this cookie should be accepted;
     *                  otherwise, {@code false}
     */
    public boolean shouldAccept(URI uri, HttpCookie cookie);
}
