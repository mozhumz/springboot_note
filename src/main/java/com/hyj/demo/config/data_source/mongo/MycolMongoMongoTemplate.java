package com.hyj.demo.config.data_source.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hyj.demo.util.ExecutionOrderUtil;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/** 
* @author mozhumz 
* @date 2018年11月22日 下午9:35:17 
* 
*/
@Configuration
//配置dao层位置
@EnableMongoRepositories(basePackages = "com.hyj.demo.dao.mongo.mongo1", mongoTemplateRef = "mycolMongo")
public class MycolMongoMongoTemplate {
    @Autowired
    @Qualifier("mycolMongoProperties")
    private MongoProperties mongoProperties;

    @Primary
    @Bean(name = "mycolMongo")
    public MongoTemplate mycolMongoTemplate() throws Exception {
    	System.out.println(ExecutionOrderUtil.MONGO_INIT_ORDER++);
    	System.out.println("mycolMongoTemplate init");
        return new MongoTemplate(mycolFactory(this.mongoProperties));
    }

    @Bean
    @Primary
    public MongoDbFactory mycolFactory(MongoProperties mongoProperties) throws Exception {
    	System.out.println(ExecutionOrderUtil.MONGO_INIT_ORDER++);
    	System.out.println("mycolFactory init");
        ServerAddress serverAdress = new ServerAddress(mongoProperties.getUri());

        return new SimpleMongoDbFactory(new MongoClient(serverAdress), mongoProperties.getDatabase());

    }
}
