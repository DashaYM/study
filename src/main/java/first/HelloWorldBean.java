package first;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class HelloWorldBean {

    private static Logger logger = Logger.getLogger(HelloWorldBean.class.getName());

    @EJB
    SecondBean secondBean;

    public HelloWorldBean() {
        logger.info("HelloWorldBean Constructor " + this);
    }

    public String sayHello() {
        logger.info("HelloWorldBean SayHello " + this);
        return "Hello World !!!";
    }

    public String askSecondBean() {
        return secondBean.nameYourself();
    }

    @PostConstruct
    public void doAfterStartup() {
        logger.info("HelloWorldBean PostConstruct");
    }

    @PreDestroy
    public void doBeforeCleanup() {
        logger.info("HelloWorldBean PreDestroy");
    }

    public void throwsException() {
        throw new RuntimeException();
    }
}
