package main.java.com.bobozhuang;

import com.bobozhuang.mina.handler.ClientToProxyIoHandler;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * description：
 * author Hubery
 * date 2020-08-09
 * version v0.0.1
 * since v0.0.1
 **/
public class MinaServer {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println(MinaServer.class.getName()
                    + " <proxy-port> <server-hostname> <server-port>");
            return;
        }

        // Create TCP/IP acceptor.
        NioSocketAcceptor acceptor = new NioSocketAcceptor();

        // Create TCP/IP connector.
        IoConnector connector = new NioSocketConnector();

        // Set connect timeout.
        connector.setConnectTimeoutMillis(30 * 1000L);

        ClientToProxyIoHandler handler = new ClientToProxyIoHandler(connector,
                new InetSocketAddress(args[1], Integer.parseInt(args[2])));

        // Start proxy.
        acceptor.setHandler(handler);
        acceptor.bind(new InetSocketAddress(Integer.parseInt(args[0])));

        System.out.println("Listening on port " + Integer.parseInt(args[0]));
    }
}
