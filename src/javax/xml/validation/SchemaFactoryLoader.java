/*
 * Copyright (c) 2004, 2006, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.validation;

/**
 * <p>Factory that creates {@link SchemaFactory}.</p>
 *
 * <p><b>DO NOT USE THIS CLASS</b></p>
 *
 * <p>
 * This class was introduced as a part of an early proposal during the
 * JSR-206 standardization process. The proposal was eventually abandoned
 * but this class accidentally remained in the source tree, and made its
 * way into the final version.
 * </p><p>
 * This class does not participate in any JAXP 1.3 or JAXP 1.4 processing.
 * It must not be used by users or JAXP implementations.
 * </p>
 *
 * @author <a href="Kohsuke.Kawaguchi@Sun.com">Kohsuke Kawaguchi</a>
 * @since 1.5
 */
public abstract class SchemaFactoryLoader {

    /**
     * A do-nothing constructor.
     */
    protected SchemaFactoryLoader() {
    }

    /**
     * Creates a new {@link SchemaFactory} object for the specified
     * schema language.
     *
     * @param schemaLanguage
     *      See <a href="SchemaFactory.html#schemaLanguage">
     *      the list of available schema languages</a>.
     *
     * @throws NullPointerException
     *      If the <tt>schemaLanguage</tt> parameter is null.
     *
     * @return <code>null</code> if the callee fails to create one.
     */
    public abstract SchemaFactory newFactory(String schemaLanguage);
}
