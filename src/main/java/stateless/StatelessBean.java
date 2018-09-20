package stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class StatelessBean {

    private static Logger logger = Logger.getLogger(StatelessBean.class.getName());

    public StatelessBean(){
        logger.info("StatelessBean Constructor "  + this);
    }

    public String nameYourself() {
        logger.info("StatelessBean nameYourself " + this);
        return "I'm a StatelessBean!";
    }

    @PostConstruct
    public void doAfterStartup() {
        logger.info("StatelessBean PostConstruct");
    }

    @PreDestroy
    public void doBeforeCleanup() {
        logger.info("StatelessBean PreDestroy");
    }
}
