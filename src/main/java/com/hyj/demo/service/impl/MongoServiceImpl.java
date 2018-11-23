package com.hyj.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hyj.demo.config.data_source.mongo.PrimaryMongoConfig;
import com.hyj.demo.config.data_source.mongo.SecondaryMongoConfig;
import com.hyj.demo.dao.mongo.mongo1.ICustomerRepository;
import com.hyj.demo.dao.mongo.mongo2.ITestRepository;
import com.hyj.demo.entity.po.mongo.Customer;
import com.hyj.demo.entity.po.mongo.TestPO;
import com.hyj.demo.service.IMongoService;

/** 
* @author mozhumz 
* @date 2018年11月22日 下午10:01:20 
* 
*/
@Service("mongoService")
public class MongoServiceImpl implements IMongoService {
//	@Resource
//	private ICustomerRepository customerRepository;
//	
//	@Resource
//	private ITestRepository testRepository;
	
	@Resource
	private PrimaryMongoConfig primaryMongoConfig;
	
	@Resource
	private SecondaryMongoConfig secondaryMongoConfig;
	
	@Resource(name="mongoTemplate")
	private MongoTemplate primaryMongoTemplate;

	@Override
	public void testMycol() {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer.setCarNumber("1");
		primaryMongoTemplate.insert(customer);
		
	}

	@Override
	public void testAdmin() {
		// TODO Auto-generated method stub
		TestPO testPO=new TestPO();
		testPO.setName("hyj");
		secondaryMongoConfig.getMongoTemplate().insert(testPO);

	}

}
