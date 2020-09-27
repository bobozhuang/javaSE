package com.bobozhuang.mina.handler;

import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.proxy.AbstractProxyIoHandler;

import java.net.SocketAddress;

/**
 * description：
 * author Hubery
 * date 2020-08-09
 * version v0.0.1
 * since v0.0.1
 **/
public class ClientToProxyIoHandler extends AbstractProxyIoHandler {
    private final ServerToProxyIoHandler connectorHandler = new ServerToProxyIoHandler();

    private final IoConnector connector;

    private final SocketAddress remoteAddress;

    public ClientToProxyIoHandler(IoConnector connector,
                                  SocketAddress remoteAddress) {
        this.connector = connector;
        this.remoteAddress = remoteAddress;
        connector.setHandler(connectorHandler);
    }

    @Override
    public void proxySessionOpened(final IoSession session) throws Exception {

        connector.connect(remoteAddress).addListener(new IoFutureListener<ConnectFuture>() {
            public void operationComplete(ConnectFuture future) {
                try {
//                    future.getSession().setAttribute(OTHER_IO_SESSION, session);
//                    session.setAttribute(OTHER_IO_SESSION, future.getSession());
                    IoSession session2 = future.getSession();
                    session2.resumeRead();
                    session2.resumeWrite();
                } catch (RuntimeIoException e) {
                    // Connect failed
                    session.close(true);
                } finally {
                    session.resumeRead();
                    session.resumeWrite();
                }
            }
        });
    }
}

