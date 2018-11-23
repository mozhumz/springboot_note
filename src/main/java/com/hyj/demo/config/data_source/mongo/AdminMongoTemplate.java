//package com.hyj.demo.config.data_source.mongo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import com.hyj.demo.util.ExecutionOrderUtil;
//import com.mongodb.MongoClient;
//import com.mongodb.ServerAddress;
//
///** 
//* @author mozhumz 
//* @date 2018年11月22日 下午9:35:17 
//* 
//*/
//@Configuration
//@EnableMongoRepositories(basePackages = "com.hyj.demo.dao.mongo.mongo2", mongoTemplateRef = "adminMongo")
//public class AdminMongoTemplate {
//    @Autowired
//    @Qualifier("adminMongoProperties")
//    private MongoProperties mongoProperties;
//
//    @Bean(name = "adminMongo")
//    public MongoTemplate adminTemplate() throws Exception {
//    	System.out.println(ExecutionOrderUtil.MONGO_INIT_ORDER++);
//    	System.out.println("adminTemplate init");
//        return new MongoTemplate(adminFactory(this.mongoProperties));
//    }
//
//    @Bean
//    public MongoDbFactory adminFactory(MongoProperties mongoProperties) throws Exception {
//    	System.out.println(ExecutionOrderUtil.MONGO_INIT_ORDER++);
//    	System.out.println("adminFactory init");
//        ServerAddress serverAdress = new ServerAddress(mongoProperties.getUri());
//
//        return new SimpleMongoDbFactory(new MongoClient(serverAdress), mongoProperties.getDatabase());
//
//    }
//}
