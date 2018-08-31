package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
public class LoggerInterceptor implements Serializable{

    @AroundInvoke
    public Object sayHello(InvocationContext ctx) throws Exception {
        System.out.println("Hello Interceptor!");
        return ctx.proceed();
    }
}
