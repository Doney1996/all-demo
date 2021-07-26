package doney.demo;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;

/**
 * Quick Start Server
 */
public class QuickStartServer {

    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig()
                .setProtocol("bolt") // Set a protocol, which is bolt by default
                .setPort(12200) // set a port, which is 12200 by default
                .setDaemon(false); // non-daemon thread

        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // Specify the interface
                .setRef(new HelloServiceImpl()) // Specify the implementation
                .setServer(serverConfig); // Specify the server

        providerConfig.export (); // Publish service
    }
}