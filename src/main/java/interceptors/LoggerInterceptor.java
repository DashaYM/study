package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
public class LoggerInterceptor implements Serializable {
    @AroundInvoke
    public Object sayHello(InvocationContext ctx) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.getTarget().getClass().getCanonicalName());
        sb.append("::");
        sb.append(ctx.getMethod().getName());
        System.out.println("method" + sb);
        return ctx.proceed();
    }
}
