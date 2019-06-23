package com.kaochong.teaching.elasticjobdemo.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.kaochong.teaching.elasticjobdemo.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuqingqian on 2019-06-04.
 */
public class MyElasticJobListener implements ElasticJobListener {
    private static final Logger logger = LoggerFactory.getLogger(MyElasticJobListener.class);

    private long beginTime = 0;

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();

        logger.info("===>{} JOB BEGIN TIME: {} <===", shardingContexts.getJobName(), DateUtil.format(beginTime, DateUtil.DATE_FORMAT_1));
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        long endTime = System.currentTimeMillis();
        logger.info("===>{} JOB END TIME: {},TOTAL CAST: {} <===", shardingContexts.getJobName(), DateUtil.format(endTime, DateUtil.DATE_FORMAT_1), endTime - beginTime);
    }
}
