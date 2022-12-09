package org.nekosoft.spring.conditionals;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD})
@Retention(RUNTIME) // This is necessary!
@Documented
@Conditional(PropertyOrBeanCondition.class)
public @interface ConditionalOnPropertyOrBean {
    String beanName() default "builtinBean";
    String propertyName() default "require-builtin-bean";
}
