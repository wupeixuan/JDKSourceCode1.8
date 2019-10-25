/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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


package javax.security.auth.callback;

/**
 * <p> Implementations of this interface are passed to a
 * {@code CallbackHandler}, allowing underlying security services
 * the ability to interact with a calling application to retrieve specific
 * authentication data such as usernames and passwords, or to display
 * certain information, such as error and warning messages.
 *
 * <p> {@code Callback} implementations do not retrieve or
 * display the information requested by underlying security services.
 * {@code Callback} implementations simply provide the means
 * to pass such requests to applications, and for applications,
 * if appropriate, to return requested information back to the
 * underlying security services.
 *
 * @see javax.security.auth.callback.CallbackHandler
 * @see javax.security.auth.callback.ChoiceCallback
 * @see javax.security.auth.callback.ConfirmationCallback
 * @see javax.security.auth.callback.LanguageCallback
 * @see javax.security.auth.callback.NameCallback
 * @see javax.security.auth.callback.PasswordCallback
 * @see javax.security.auth.callback.TextInputCallback
 * @see javax.security.auth.callback.TextOutputCallback
 */
public interface Callback { }
