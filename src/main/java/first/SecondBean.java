package first;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class SecondBean {

    private static Logger logger = Logger.getLogger(SecondBean.class.getName());

    public SecondBean(){
        logger.info("SecondBean Constructor "  + this);
    }

    public String nameYourself() {
        logger.info("SecondBean nameYourself " + this);
        return "I'm a SecondBean!";
    }

    @PostConstruct
    public void doAfterStartup() {
        logger.info("SecondBean PostConstruct");
    }

    @PreDestroy
    public void doBeforeCleanup() {
        logger.info("SecondBean PreDestroy");
    }
}
