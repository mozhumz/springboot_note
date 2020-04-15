package com.hyj.demo.annotation;

import lombok.Data;

/** 
* @author mozhumz 
* @date 2018年10月17日 下午8:38:14 
* 
*/
@Data
public class User
{
    @Validate(min = 2, max = 5)
    private String name;

    @Validate(isNotNull = false)
    private String age;

}
