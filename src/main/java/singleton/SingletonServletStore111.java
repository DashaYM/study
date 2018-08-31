package singleton;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SingletonServletStore111", urlPatterns = {"/SingletonServletStore111"})
public class SingletonServletStore111 extends HttpServlet {

    @EJB
    SingletonBean singletonBean;

    @Override
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            singletonBean.store("startup", "111");
            out.println("Startup time: " + singletonBean.get("startup"));
            out.println("111");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
