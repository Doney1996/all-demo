package com.doney;

import com.doney.service.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @author ODC-ODL
 */
public class Comsumer {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "114.96.105.111");

    public static void main(String[] args) {
        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(GreetingsService.class);
        GreetingsService service = reference.get();
        String message = service.sayHi("dubbo");
        System.out.println(message);
    }
    public String getAppName(){
        return "name";
    }
    public String getAppName201(){
        return "name";
    }
    public String getAppName2(){
        return "name";
    }

}
