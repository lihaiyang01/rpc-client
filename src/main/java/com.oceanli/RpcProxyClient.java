package com.oceanli;

import java.lang.reflect.Proxy;

public class RpcProxyClient {

    private String host;
    private int port;


    public <T> T createProxy(final Class<T> interfaceCls, final String host, final int port) {
        this.host = host;
        this.port = port;
        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[] {interfaceCls}, new RemoteInvocationHandler(host, port));
    }

}
