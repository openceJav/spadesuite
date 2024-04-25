package org.opencejav.spadesuite.annotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Single Member Annotation to Signify that a Certain Class is a Utility Class
 * @require className:String = "UtilityClass"
 */
@Inherited
@Documented
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UtilityClass {
    String className() default "UtilityClass";
}
