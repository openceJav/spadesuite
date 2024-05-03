package org.opencejav.spadesuite.annotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Single Member Annotation to Signify that Certain Class is a Base Class.
 * @require className:String = "BaseClass"
 */
@Documented
@Target({TYPE, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseClass {
    String className() default "BaseClass";
}
