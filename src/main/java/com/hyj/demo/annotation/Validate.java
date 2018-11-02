package com.hyj.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/** 
* @author mozhumz 
* @date 2018年10月17日 下午8:35:06 
* 
*/
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate
{
    public int min() default 1;

    public int max() default 10;

    public boolean isNotNull() default true;
}
