/**
 * 
 */
package com.hyj.demo.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author huyuanjia
 *
 */
@Data
@Entity
public class Test
{
    @Id
    @GeneratedValue
    private String id;
    
    private String name;
    
    private String json;

}
