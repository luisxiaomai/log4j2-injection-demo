package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginHandler {
    static Logger logger;
    static {
        logger = LogManager.getLogger(LoginHandler.class);
    }

    public void receiveUsername(String username){
        logger.info("username: {}",username);
    }
}
