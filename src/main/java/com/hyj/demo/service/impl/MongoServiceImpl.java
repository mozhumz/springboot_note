package com.hyj.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hyj.demo.config.data_source.mongo.AdminMongoTemplate;
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
	@Resource
	private ICustomerRepository customerRepository;
	
	@Resource
	private ITestRepository testRepository;

	@Override
	public void testMycol() {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer.setCarNumber("1");
		System.out.println(customerRepository.insert(customer));
		
	}

	@Override
	public void testAdmin() {
		// TODO Auto-generated method stub
		TestPO testPO=new TestPO();
		testPO.setName("hyj");
		System.out.println(testRepository.insert(testPO));
		

	}

}
