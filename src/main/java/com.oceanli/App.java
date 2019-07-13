package com.oceanli;

import com.oceanli.IHelloService;
import com.oceanli.RpcProxyClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*RpcProxyClient rpcProxyClient = new RpcProxyClient();*/
        AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient rpcProxyClient = context.getBean(RpcProxyClient.class);
        IHelloService helloService = rpcProxyClient.createProxy(IHelloService.class, "localhost", 8080);
        System.out.println(helloService.sayHello("oceanli"));
        User user = new User();
        user.setName("aaa");
        user.setAge(18);
        user.setSex("男");
        System.out.println(helloService.saveUser(user));
    }
}
