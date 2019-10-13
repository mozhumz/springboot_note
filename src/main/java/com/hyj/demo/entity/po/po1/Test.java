/**
 * 
 */
package com.hyj.demo.entity.po.po1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
