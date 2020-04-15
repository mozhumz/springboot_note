package com.hyj.demo.dao.mapper.mapper1;


import com.hyj.demo.model.po.HyjTestPO;
import tk.mybatis.mapper.common.Mapper;


public interface IHyjTestMapper extends Mapper<HyjTestPO>{
	HyjTestPO findOne();
	
}
