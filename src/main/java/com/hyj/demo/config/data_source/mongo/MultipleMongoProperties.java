package com.hyj.demo.config.data_source.mongo;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.hyj.demo.util.ExecutionOrderUtil;

/** 
* @author mozhumz 
* @date 2018年11月22日 下午9:33:23 
* 
*/
@Configuration
public class MultipleMongoProperties {
    @Bean(name="mycolMongoProperties")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.mongodb.mycol")
    public MongoProperties statisMongoProperties() {
    	System.out.println(ExecutionOrderUtil.MONGO_INIT_ORDER++);
        System.out.println("-------------------- mycolMongoProperties init ---------------------");
        return new MongoProperties();
    }

    @Bean(name="adminMongoProperties")
    @ConfigurationProperties(prefix="spring.datasource.mongodb.admin")
    public MongoProperties listMongoProperties() {
    	System.out.println(ExecutionOrderUtil.MONGO_INIT_ORDER++);
        System.out.println("-------------------- adminMongoProperties init ---------------------");
        return new MongoProperties();
    }

}
