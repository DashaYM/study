package stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class StatelessHelloWorldBean {

    private static Logger logger = Logger.getLogger(StatelessHelloWorldBean.class.getName());

    @EJB
    StatelessBean statelessBean;

    public StatelessHelloWorldBean() {
        logger.info("StatelessHelloWorldBean Constructor " + this);
    }

    public String sayHello() {
        logger.info("StatelessHelloWorldBean SayHello " + this);
        return "Hello World !!!";
    }

    public String askSecondBean() {
        return statelessBean.nameYourself();
    }

    @PostConstruct
    public void doAfterStartup() {
        logger.info("StatelessHelloWorldBean PostConstruct");
    }

    @PreDestroy
    public void doBeforeCleanup() {
        logger.info("StatelessHelloWorldBean PreDestroy");
    }

    public void throwsException() {
        throw new RuntimeException();
    }
}
