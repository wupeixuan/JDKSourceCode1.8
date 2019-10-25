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

/**
 * An annotation used to indicate what options an annotation processor
 * supports.  The {@link Processor#getSupportedOptions} method can
 * construct its result from the value of this annotation, as done by
 * {@link AbstractProcessor#getSupportedOptions}.  Only {@linkplain
 * Processor#getSupportedOptions strings conforming to the
 * grammar} should be used as values.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface SupportedOptions {
    /**
     * Returns the supported options.
     * @return the supported options
     */
    String [] value();
}
