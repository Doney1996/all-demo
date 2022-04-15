package com.doney.advanced.spring.retry;

import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.concurrent.TimeUnit;

public class RetryDemo {
    public static void main(String[] args) throws InterruptedException {
        RetryTemplate template = new RetryTemplate();

        TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
        policy.setTimeout(2000L);


        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(5);

        //template.setRetryPolicy(policy);
        template.setRetryPolicy(retryPolicy);

        String result = template.execute(context -> {

            System.out.println("TestAll.main()1");
            TimeUnit.SECONDS.sleep(1L);
            throw new IllegalArgumentException();
        });
        System.out.println("result:" + result);

    }
}
