package com.yaorange.utils;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.yaorange.consts.bis.JobTypeConsts;
import com.yaorange.query.QuartzJobInfo;
import com.yaorange.service.JobRunner;

/**
 * 定时任务
 */
public class MainJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        QuartzJobInfo info = (QuartzJobInfo) jobDataMap.get("params");
        byte type = info.getType();
        Map<String, Long> params = info.getParams();
        Long secKillId = params.get("secKillId");
        switch (type) {
            case JobTypeConsts.SECKILL_PRE_JOB:
                JobRunner.preHandle(secKillId);
                break;
            case JobTypeConsts.SECKILL_BEGIN_JOB:
                JobRunner.beginHandle(secKillId);
                break;
            case JobTypeConsts.SECKILL_END_JOB:
                JobRunner.endHandle(secKillId);
                break;

            default:
                break;
        }

    }

}
