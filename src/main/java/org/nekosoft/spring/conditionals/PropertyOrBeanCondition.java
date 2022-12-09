package org.nekosoft.spring.conditionals;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class PropertyOrBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnPropertyOrBean.class.getName());
        String beanName = "builtinBean";
        String propName = "require-builtin-bean";
        if (attributes != null) {
            beanName = attributes.get("beanName").toString();
            propName = attributes.get("propertyName").toString();
        }
        BeanFactory factory = context.getBeanFactory();
        boolean builtinBeanExists = factory != null && factory.containsBean(beanName);
        Environment env = context.getEnvironment();
        String propertyValue = env.getProperty(propName, "true");
        boolean builtinBeanNotRequired = propertyValue.equals("false");
        return builtinBeanExists || builtinBeanNotRequired;
    }
}
