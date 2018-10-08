package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

public class HelloInterceptor implements Serializable{

    @AroundInvoke
    public Object sayHello(InvocationContext ctx) throws Exception {
        System.out.println("Hello Interceptor!" + this);
        System.out.println(ctx.getContextData().get("loggerInterceptorData"));
        Object proceed = ctx.proceed();

        System.out.println("Bye");
        return proceed;
    }
}
