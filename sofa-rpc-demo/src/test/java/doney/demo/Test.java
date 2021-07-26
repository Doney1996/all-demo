package doney.demo;

import com.alipay.sofa.rpc.common.struct.ScheduledService;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        int reconnect = 10000;
        ScheduledService reconThread = new ScheduledService("CLI-RC-" + "spi", ScheduledService.MODE_FIXEDDELAY, new
                Runnable() {
                    @Override
                    public void run() {
                        try {
                            doReconnect();
                        } catch (Throwable e) {
                            System.out.println("Exception when retry connect to provider");
                        }
                    }
                }, reconnect, reconnect, TimeUnit.MILLISECONDS).start();
        Thread.sleep(Long.MAX_VALUE);

    }

    private static void doReconnect() {
        System.out.println("doReconnect");
    }
}
