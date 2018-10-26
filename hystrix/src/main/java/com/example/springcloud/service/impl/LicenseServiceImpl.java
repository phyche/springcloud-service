package com.example.springcloud.service.impl;

import com.example.springcloud.dao.LicenseDao;
import com.example.springcloud.module.License;
import com.example.springcloud.service.LicenseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("licenseService")
@Transactional
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    private LicenseDao licenseDao;

    @Override
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            },
            fallbackMethod = "buildFallBackLicenseList",
            threadPoolKey = "licenseByOrgThreadPool",//定义线程池的唯一名称
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "30"),//定义线程池中最大数量
                    @HystrixProperty(name = "maxQueueSize",value = "10")//位于线程池前的队列，它可以对传入的请求进行排队
            }
            /*commandProperties = {
                //考虑断路器跳闸之前，在10s之内必须发生的连续调用数量
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                //超过上面值之后在断路器跳闸之前必须达到的调用失败百分比
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "75"),
                //断路器跳闸之后，允许另一个调用通过以便查看服务是否恢复健康之前的休眠时间
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "7000"),
                //用于监视服务调用问题的窗口大小，默认是10000(即10s)
                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "15000"),
                //控制定义的滚动窗口中收集统计信息的次数
                @HystrixProperty(name = "metrics.rollingStats.numBuckets",value = "5")
            }*/
            /*commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE")//隔离策略 THREAD（线程）和SEMAPHORE（信号量）
            }*/
    )
    public List getLicensesByOrg(String organizationId) {
        List<License> licenseList = licenseDao.getLicensesByOrg(organizationId);
        return licenseList;
    }

    public List buildFallBackLicenseList(String organizationId){
        List<String> list = new ArrayList<>();
        list.add("getLicensesByOrg is time out");
        return list;
    }
    private void randomlyRunLong() {
        Random random = new Random();
        int randomNum = random.nextInt((3-1) + 1) + 1;
        if (randomNum == 3) sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
