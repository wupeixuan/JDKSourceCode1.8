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

package javax.annotation;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * The Generated annotation is used to mark source code that has been generated.
 * It can also be used to differentiate user written code from generated code
 * in a single file. When used, the value element must have the name of the
 * code generator. The recommended convention is to use the fully qualified
 * name of the code generator in the value field .
 * <p>For example: com.company.package.classname.
 * The date element is used to indicate the date the source was generated.
 * The date element must follow the ISO 8601 standard. For example the date
 * element would have the following value 2001-07-04T12:08:56.235-0700
 * which represents 2001-07-04 12:08:56 local time in the U.S. Pacific
 * Time time zone.</p>
 * <p>The comment element is a place holder for any comments that the code
 * generator may want to include in the generated code.</p>
 *
 * @since Common Annotations 1.0
 */

@Documented
@Retention(SOURCE)
@Target({PACKAGE, TYPE, ANNOTATION_TYPE, METHOD, CONSTRUCTOR, FIELD,
        LOCAL_VARIABLE, PARAMETER})
public @interface Generated {
   /**
    * The value element MUST have the name of the code generator.
    * The recommended convention is to use the fully qualified name of the
    * code generator. For example: com.acme.generator.CodeGen.
    */
   String[] value();

   /**
    * Date when the source was generated.
    */
   String date() default "";

   /**
    * A place holder for any comments that the code generator may want to
    * include in the generated code.
    */
   String comments() default "";
}
