package com.hyj.demo.config.data_source.mybatis;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuanjia
 * @date 2019/6/22 11:11
 * 解决druid无法批量更新问题
 */
@Configuration
public class DBConfig {


    @Autowired
    WallFilter wallFilter;

    @Bean(name = "dataSource", destroyMethod = "close")    //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        // filter
        List<Filter> filters = new ArrayList<>();
        filters.add(wallFilter);
        datasource.setProxyFilters(filters);

        return datasource;
    }

    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    public WallFilter wallFilter(WallConfig wallConfig){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }

    @Bean(name = "wallConfig")
    public WallConfig wallConfig(){
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);//允许一次执行多条语句
        wallConfig.setNoneBaseStatementAllow(true);//允许一次执行多条语句
        return wallConfig;
    }


}
