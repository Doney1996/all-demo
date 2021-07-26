package doney.demo;

import com.alipay.sofa.rpc.config.ConsumerConfig;

import java.util.Date;

/**
 * Quick Start client
 */
public class QuickStartClient {
    public static void main(String[] args) {
        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
            .setInterfaceId(HelloService.class.getName()) // Specify the interface
            .setProtocol("bolt") // Specify the protocol.setDirectUrl
            .setDirectUrl("bolt://127.0.0.1:12200"); // Specify the direct connection address
        // Generate the proxy class
        HelloService helloService = consumerConfig.refer();
        while (true) {
            System.out.println(helloService.sayHello(new Date().toString()));
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
}