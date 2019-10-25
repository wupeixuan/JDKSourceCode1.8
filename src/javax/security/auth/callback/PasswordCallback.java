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
 * <p> Underlying security services instantiate and pass a
 * {@code PasswordCallback} to the {@code handle}
 * method of a {@code CallbackHandler} to retrieve password information.
 *
 * @see javax.security.auth.callback.CallbackHandler
 */
public class PasswordCallback implements Callback, java.io.Serializable {

    private static final long serialVersionUID = 2267422647454909926L;

    /**
     * @serial
     * @since 1.4
     */
    private String prompt;
    /**
     * @serial
     * @since 1.4
     */
    private boolean echoOn;
    /**
     * @serial
     * @since 1.4
     */
    private char[] inputPassword;

    /**
     * Construct a {@code PasswordCallback} with a prompt
     * and a boolean specifying whether the password should be displayed
     * as it is being typed.
     *
     * <p>
     *
     * @param prompt the prompt used to request the password. <p>
     *
     * @param echoOn true if the password should be displayed
     *                  as it is being typed.
     *
     * @exception IllegalArgumentException if {@code prompt} is null or
     *                  if {@code prompt} has a length of 0.
     */
    public PasswordCallback(String prompt, boolean echoOn) {
        if (prompt == null || prompt.length() == 0)
            throw new IllegalArgumentException();

        this.prompt = prompt;
        this.echoOn = echoOn;
    }

    /**
     * Get the prompt.
     *
     * <p>
     *
     * @return the prompt.
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Return whether the password
     * should be displayed as it is being typed.
     *
     * <p>
     *
     * @return the whether the password
     *          should be displayed as it is being typed.
     */
    public boolean isEchoOn() {
        return echoOn;
    }

    /**
     * Set the retrieved password.
     *
     * <p> This method makes a copy of the input <i>password</i>
     * before storing it.
     *
     * <p>
     *
     * @param password the retrieved password, which may be null.
     *
     * @see #getPassword
     */
    public void setPassword(char[] password) {
        this.inputPassword = (password == null ? null : password.clone());
    }

    /**
     * Get the retrieved password.
     *
     * <p> This method returns a copy of the retrieved password.
     *
     * <p>
     *
     * @return the retrieved password, which may be null.
     *
     * @see #setPassword
     */
    public char[] getPassword() {
        return (inputPassword == null ? null : inputPassword.clone());
    }

    /**
     * Clear the retrieved password.
     */
    public void clearPassword() {
        if (inputPassword != null) {
            for (int i = 0; i < inputPassword.length; i++)
                inputPassword[i] = ' ';
        }
    }
}
