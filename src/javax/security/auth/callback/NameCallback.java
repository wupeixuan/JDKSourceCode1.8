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
 * {@code NameCallback} to the {@code handle}
 * method of a {@code CallbackHandler} to retrieve name information.
 *
 * @see javax.security.auth.callback.CallbackHandler
 */
public class NameCallback implements Callback, java.io.Serializable {

    private static final long serialVersionUID = 3770938795909392253L;

    /**
     * @serial
     * @since 1.4
     */
    private String prompt;
    /**
     * @serial
     * @since 1.4
     */
    private String defaultName;
    /**
     * @serial
     * @since 1.4
     */
    private String inputName;

    /**
     * Construct a {@code NameCallback} with a prompt.
     *
     * <p>
     *
     * @param prompt the prompt used to request the name.
     *
     * @exception IllegalArgumentException if {@code prompt} is null
     *                  or if {@code prompt} has a length of 0.
     */
    public NameCallback(String prompt) {
        if (prompt == null || prompt.length() == 0)
            throw new IllegalArgumentException();
        this.prompt = prompt;
    }

    /**
     * Construct a {@code NameCallback} with a prompt
     * and default name.
     *
     * <p>
     *
     * @param prompt the prompt used to request the information. <p>
     *
     * @param defaultName the name to be used as the default name displayed
     *                  with the prompt.
     *
     * @exception IllegalArgumentException if {@code prompt} is null,
     *                  if {@code prompt} has a length of 0,
     *                  if {@code defaultName} is null,
     *                  or if {@code defaultName} has a length of 0.
     */
    public NameCallback(String prompt, String defaultName) {
        if (prompt == null || prompt.length() == 0 ||
            defaultName == null || defaultName.length() == 0)
            throw new IllegalArgumentException();

        this.prompt = prompt;
        this.defaultName = defaultName;
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
     * Get the default name.
     *
     * <p>
     *
     * @return the default name, or null if this {@code NameCallback}
     *          was not instantiated with a {@code defaultName}.
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * Set the retrieved name.
     *
     * <p>
     *
     * @param name the retrieved name (which may be null).
     *
     * @see #getName
     */
    public void setName(String name) {
        this.inputName = name;
    }

    /**
     * Get the retrieved name.
     *
     * <p>
     *
     * @return the retrieved name (which may be null)
     *
     * @see #setName
     */
    public String getName() {
        return inputName;
    }
}
