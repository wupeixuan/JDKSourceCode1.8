/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.beans;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Indicates that an attribute called "transient"
 * should be declared with the given {@code value}
 * when the {@link Introspector} constructs
 * a {@link PropertyDescriptor} or {@link EventSetDescriptor}
 * classes associated with the annotated code element.
 * A {@code true} value for the "transient" attribute
 * indicates to encoders derived from {@link Encoder}
 * that this feature should be ignored.
 * <p>
 * The {@code Transient} annotation may be be used
 * in any of the methods that are involved
 * in a {@link FeatureDescriptor} subclass
 * to identify the transient feature in the annotated class and its subclasses.
 * Normally, the method that starts with "get" is the best place
 * to put the annotation and it is this declaration
 * that takes precedence in the case of multiple annotations
 * being defined for the same feature.
 * <p>
 * To declare a feature non-transient in a class
 * whose superclass declares it transient,
 * use {@code @Transient(false)}.
 * In all cases, the {@link Introspector} decides
 * if a feature is transient by referring to the annotation
 * on the most specific superclass.
 * If no {@code Transient} annotation is present
 * in any superclass the feature is not transient.
 *
 * @since 1.7
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface Transient {
    /**
     * Returns whether or not the {@code Introspector} should
     * construct artifacts for the annotated method.
     * @return whether or not the {@code Introspector} should
     * construct artifacts for the annotated method
     */
    boolean value() default true;
}
