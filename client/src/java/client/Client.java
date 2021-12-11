package client;


import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        String uri = "rmi://127.0.0.1:1234/exec";
        Context ctx = new InitialContext();
        ctx.lookup(uri);
    }
}