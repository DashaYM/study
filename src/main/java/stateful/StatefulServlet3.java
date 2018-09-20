package stateful;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatefulServlet3", urlPatterns = {"/StatefulServlet3"})
public class StatefulServlet3 extends HttpServlet {

    @Inject
    StatefulBean bean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("I'm a StatefulServlet3");

        bean.increase();
        bean.decrease();
        //bean.removeMethod();

    }

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("I'm a StatefulServlet3");

        StatefulBean bean = (StatefulBean) request.getSession().getAttribute("bean_name");
        if (bean == null) {
            bean = getBean(StatefulBean.class);
            request.getSession().setAttribute("bean_name", bean);
        }

        bean.increase();
        bean.decrease();
        bean.removeMethod();

    }


    public static <T> T getBean(Class<T> beanClass) {
        try {
            InitialContext ictx = new InitialContext();
            String beanName = "java:module/" + beanClass.getSimpleName();
            return (T) ictx.lookup(beanName);
        } catch (NamingException e) {
//            logger.error("Error during bean [" + beanClass.getSimpleName() + "] look up", e);
            return null;
        }

    }*/
}
