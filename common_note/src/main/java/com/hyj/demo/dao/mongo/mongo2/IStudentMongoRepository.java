package com.hyj.demo.dao.mongo.mongo2;

import com.hyj.demo.model.po.StudentPO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** 
* @author mozhumz 
* @date 2018年11月22日 下午9:51:21 
* 
*/
@Repository
public interface IStudentMongoRepository extends MongoRepository<StudentPO, ObjectId>
 {

}

