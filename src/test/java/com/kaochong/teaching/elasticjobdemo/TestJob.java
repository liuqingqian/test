package com.kaochong.teaching.elasticjobdemo;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.kaochong.teaching.elasticjobdemo.job.SimpleJobDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * Created by liuqingqian on 2019-06-04.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticjobDemoApplication.class)
public class TestJob {

    @Autowired
    ZookeeperRegistryCenter zookeeperRegistryCenter;

    @Test
    public void testSimpleJob() {

        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("demoSimpleJob", "0/15 * * * * ?", 10).build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, SimpleJobDemo.class.getCanonicalName());
        // 定义Lite作业根配置
//        JobRootConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
        JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, simpleJobRootConfig);
        jobScheduler.init();


    }

    @Test
    public void test() {
        String deadline = LocalDate.now().minusDays(1).toString();
        System.out.println(deadline);
    }

}
