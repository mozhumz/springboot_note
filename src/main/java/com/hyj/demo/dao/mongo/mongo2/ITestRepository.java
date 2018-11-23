package com.hyj.demo.dao.mongo.mongo2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hyj.demo.entity.po.mongo.TestPO;

/** 
* @author mozhumz 
* @date 2018年11月22日 下午9:51:21 
* 
*/
@Repository
public interface ITestRepository extends MongoRepository<TestPO, String>
 {

}

