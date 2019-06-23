package com.kaochong.teaching.elasticjobdemo;

import com.kaochong.teaching.elasticjobdemo.util.CronUtils;
import com.kaochong.teaching.elasticjobdemo.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by liuqingqian on 2019-06-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticjobDemoApplication.class)
public class TestCronUtils {


    @Test
    public void testGetCron(){
        System.out.println(DateUtil.getCurrent());
        System.out.println(CronUtils.getCron(new Date()));
    }
}
