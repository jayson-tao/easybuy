package com.yaorange.service.impl;

import com.yaorange.service.QuartzService;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.yaorange.exception.BisException;
import com.yaorange.query.QuartzJobInfo;
import com.yaorange.utils.MainJob;
import com.yaorange.utils.QuartzUtils;


/**
 * quartz业务类
 */
@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private SchedulerFactoryBean schedulerFactory;

    @Override
    public void addJob(QuartzJobInfo info) {
        Scheduler scheduler = schedulerFactory.getScheduler();
        QuartzUtils.addJob(scheduler, info.getJobName(), MainJob.class, info, info.getCronj());
    }

    @Override
    public void delJob(String jobName) {
        try {
            Scheduler sche = schedulerFactory.getScheduler();
            QuartzUtils.removeJob(sche, jobName);
        } catch (Exception e) {
            throw BisException.me().setInfo(e.getLocalizedMessage());
        }
    }

}
