package singleton;

import interceptors.LoggerInterceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Singleton
public class SingletonBean {

    private Map map;

    private static Logger logger = Logger.getLogger(SingletonBean.class.getName());

    @PostConstruct
    public void initCache(){
        map = new HashMap();
        logger.info("SingletonBean PostConstruct");
    }

    @Lock(LockType.READ)
    public Object get(String key){
        logger.info(String.valueOf(map.size()));
        return map.get(key);
    }

    @Interceptors(LoggerInterceptor.class)
    @Lock(LockType.WRITE)
    public void store(String key,Object value){
        map.put(key, value);
        /*try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @PreDestroy
    public void remove(){
        map = new HashMap();
        logger.info("SingletonBean PreDestroy");
    }

    public void throwsException() {
        throw new RuntimeException();
    }

}
