package com.hyj.demo.service.impl;

import com.hyj.demo.dao.mapper.mapper1.IStudentMapper;
import com.hyj.demo.dao.mongo.mongo1.ICustomerRepository;
import com.hyj.demo.dao.mongo.mongo2.IStudentMongoRepository;
import com.hyj.demo.dao.mongo.mongo2.ITestRepository;
import com.hyj.demo.entity.po.mongo.Customer;
import com.hyj.demo.entity.po.mongo.TestPO;
import com.hyj.demo.model.po.StudentPO;
import com.hyj.demo.model.qo.BaseQo;
import com.hyj.demo.service.IMongoService;
import com.hyj.demo.util.MongoUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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

	@Resource
	private IStudentMapper studentMapper;

	@Resource
	private IStudentMongoRepository studentMongoRepository;
	
//	@Resource
//	private PrimaryMongoConfig primaryMongoConfig;
//	
//	@Resource
//	private SecondaryMongoConfig secondaryMongoConfig;
	
	@Resource(name="mongoTemplate")
	private MongoTemplate primaryMongoTemplate;

	@Resource(name="secondaryMongoTemplate")
	private MongoTemplate secondaryMongoTemplate;

	@Override
	public void testMycol() {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer.setCarNumber("2");
//		primaryMongoTemplate.insert(customer);
		
		System.out.println(customerRepository.insert(customer));
	}

	@Override
	public void testAdmin() {
		// TODO Auto-generated method stub
		TestPO testPO=new TestPO();
		testPO.setName("hyj2");
//		secondaryMongoConfig.getMongoTemplate().insert(testPO);
			System.out.println(testRepository.insert(testPO));
	}

	/**
	 * 多线程-将学生数据导入mongodb的roommanage数据库
	 */
	@Override
	public void importStudent2Mongo() {
		//线程池
		ExecutorService pool = Executors.newFixedThreadPool(20);
		BaseQo baseQo=new BaseQo();
		int start=0;
		double total=studentMapper.findStudentPOListTotal();
		int totalPage= (int) Math.ceil(total/baseQo.getSize());
		for(int page=1;page<=totalPage;page++){
			start=(page-1)*baseQo.getSize();
			baseQo.setStart(start);
			baseQo.setPage(page);

			List<StudentPO>list=studentMapper.findStudentPOList(baseQo);
			pool.submit(addStudentList(list));
			int num = ((ThreadPoolExecutor) pool).getActiveCount();
			System.out.println("num:"+num);
		}

	}



	@Override
	public void getStudentTotal() {
		try {
			BaseQo baseQo=new BaseQo();
			baseQo.setStart(0);
			baseQo.setPage(1);
			baseQo.setSize(2);
			List<StudentPO>list=studentMapper.findStudentPOList(baseQo);
//			list.get(0).setId(null);
//			studentMongoRepository.insert(list.get(0));
			secondaryMongoTemplate.getCollection("student").insert(MongoUtil.bean2DBObject(list.get(1)));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public Callable<Integer> addStudentList(final List<StudentPO >list) {
		Callable<Integer> c = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				try {
					System.out.println(studentMongoRepository.insert(list));
				}catch (Exception e){
					e.printStackTrace();
					return 2;
				}
				return 1;
			}
		};
		return c;
	}

}
