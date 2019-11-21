package com.wenas.hello.quartz.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        before();
//        long timeStart = System.currentTimeMillis();
//        // TODO 业务
//        System.out.println("工作 SchedulerQuartzJob1 业务，当前执行时间" + new Date().toString());
//        long timeEnd = timeStart - System.currentTimeMillis();
//        System.out.println("执行时间长度：" + timeEnd);
//        after();
        String[] patternMatch = {"([\\w\\s]+)+([+\\-/*])+([\\w\\s]+)",
                "([\\w\\s]+)+([+\\-/*])+([\\w\\s]+)+([+\\-/*])+([\\w\\s]+)"};
        List<String> patternList = new ArrayList<String>();

        patternList.add("Avg Volume Units product A + Volume Units product A");
        patternList.add("Avg Volume Units /  Volume Units product A");
        patternList.add("Avg retailer On Hand / Volume Units Plan / Store Count");
        patternList.add("Avg Hand Volume Units Plan Store Count");
        patternList.add("1 - Avg merchant Volume Units");
        patternList.add("Total retailer shipment Count");

        for (String s : patternList) {
            for (int i = 0; i < patternMatch.length; i++) {
                Pattern pattern = Pattern.compile(patternMatch[i]);

                Matcher matcher = pattern.matcher(s);
                System.out.println(s);
                //CPU飙升根源
                if (matcher.matches()) {

                    System.out.println("Passed");
                } else {
                    System.out.println("Failed;");
                }
            }
        }
    }

    private void after(){
        System.out.println("任务after开始执行");
    }

}