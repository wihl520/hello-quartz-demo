package com.wenas.hello.quartz.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/3/28 0028 8:51
 */
public class SchedulerQuartzJob1 implements Job {
    private void before(){
        System.out.println("任务 SchedulerQuartzJob1 开始执行");
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        long timeStart = System.currentTimeMillis();
        // TODO 业务
        System.out.println("工作 SchedulerQuartzJob1 业务，当前执行时间" + new Date().toString());
        long timeEnd = timeStart - System.currentTimeMillis();
        System.out.println("执行时间长度：" + timeEnd);
        after();
    }

    private void after(){
        System.out.println("任务after开始执行");
    }

}