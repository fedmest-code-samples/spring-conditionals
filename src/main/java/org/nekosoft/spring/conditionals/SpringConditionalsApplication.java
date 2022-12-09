package org.nekosoft.spring.conditionals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringConditionalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConditionalsApplication.class, args);
    }

    @Bean
    public Object builtinBean() {
        return "A Built-in Bean";
    }

    @Bean
    public Object neededBean() {
        return "A Needed Bean";
    }

    @Bean
//    @Conditional(PropertyOrBeanCondition.class)
    @ConditionalOnPropertyOrBean(beanName = "neededBean", propertyName = "require-bean")
    public Object dependentBean() {
        System.out.println(">>>> Creating the dependent bean!");
        return "A Dependent Bean";
    }

}
