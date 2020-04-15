package com.hyj.demo.dao.mongo.mongo1;

import com.hyj.demo.entity.po.mongo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** 
* @author mozhumz 
* @date 2018年11月22日 下午9:39:31 
* 
*/
@Repository
public interface ICustomerRepository extends MongoRepository<Customer, String>
 {

}
