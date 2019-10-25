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

package javax.annotation.processing;

import java.lang.annotation.*;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;
import javax.lang.model.SourceVersion;


/**
 * An annotation used to indicate the latest source version an
 * annotation processor supports.  The {@link
 * Processor#getSupportedSourceVersion} method can construct its
 * result from the value of this annotation, as done by {@link
 * AbstractProcessor#getSupportedSourceVersion}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface SupportedSourceVersion {
    /**
     * Returns the latest supported source version.
     * @return the latest supported source version
     */
    SourceVersion value();
}
