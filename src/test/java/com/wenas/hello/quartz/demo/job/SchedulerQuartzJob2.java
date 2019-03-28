package com.wenas.hello.quartz.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <p>Description: </p>
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/3/28 0028 8:52
 */
public class SchedulerQuartzJob2 implements Job {
    private void before(){
        System.out.println("任务2开始执行");
    }

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        before();
        System.out.println("开始2："+System.currentTimeMillis());
        // TODO 业务
        System.out.println("结束2："+System.currentTimeMillis());
        after();
    }

    private void after(){
        System.out.println("任务2开始执行");
    }

}
