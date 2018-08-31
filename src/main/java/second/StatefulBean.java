package second;

import interceptors.LoggerInterceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.logging.Logger;

@Stateful
@SessionScoped
@Interceptors(LoggerInterceptor.class)
public class StatefulBean implements Serializable{

    private int balance = 0;

    private static Logger logger = Logger.getLogger(StatefulBean.class.getName());

    public StatefulBean() {
        logger.info("StatefulBean Constructor " + this);
    }

    public void increase() {
        logger.info("current balance is "  + balance + " " + this);
        balance = balance + 5;
        logger.info("increased balance is "  + balance + " " + this);
    }

    public void decrease() {
        logger.info("current balance is "  + balance + " " + this);
        balance = balance - 4;
        logger.info("decreased balance is "  + balance + " " + this);
    }

    @Remove
    public void removeMethod() {
        logger.info("current balance is "  + balance + " " + this);
        logger.info("StatefulBean Remove");
    }

    @PostConstruct
    public void doAfterStartup() {
        logger.info("StatefulBean PostConstruct");
    }

    @PreDestroy
    public void doBeforeCleanup() {
        logger.info("StatefulBean PreDestroy");
    }

    @PostActivate
    public void doAfterActivate() {
        logger.info("StatefulBean PostActivate");
    }

    @PrePassivate
    public void doBeforePassivate() {
        logger.info("StatefulBean PrePassivate");
    }
}
