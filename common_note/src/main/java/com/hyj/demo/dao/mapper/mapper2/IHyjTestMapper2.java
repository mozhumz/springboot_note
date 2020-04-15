package com.hyj.demo.dao.mapper.mapper2;


import com.hyj.demo.model.po.HyjTestPO;
import tk.mybatis.mapper.common.Mapper;


public interface IHyjTestMapper2 extends Mapper<HyjTestPO>{
	HyjTestPO findOne();
	
}
