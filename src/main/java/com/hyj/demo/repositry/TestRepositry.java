/**
 * 
 */
package com.hyj.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hyj.demo.po.Test;

/**
 * @author huyuanjia
 *
 */
public interface TestRepositry extends JpaRepository<Test,String>
{


}
