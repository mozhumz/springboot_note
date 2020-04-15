package com.hyj.demo.annotation;

import java.lang.annotation.*;
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
