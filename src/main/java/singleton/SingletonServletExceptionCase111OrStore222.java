package singleton;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SingletonServletExceptionCase111OrStore222", urlPatterns={"/SingletonServletExceptionCase111OrStore222"})
public class SingletonServletExceptionCase111OrStore222 extends HttpServlet {

    @EJB
    SingletonBean singletonBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Object getBeanValueStartup = singletonBean.get("startup");
            if (getBeanValueStartup != null && getBeanValueStartup.equals("111")) {
                singletonBean.throwsException();
            }
            singletonBean.store("startup", getBeanValueStartup + " 222");
            out.println("Startup time: " + singletonBean.get("startup"));
        } finally {
            out.close();
        }
    }
}
