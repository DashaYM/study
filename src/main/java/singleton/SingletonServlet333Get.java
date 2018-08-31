package singleton;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SingletonServlet333Get", urlPatterns = {"/SingletonServlet333Get"})
public class SingletonServlet333Get extends HttpServlet {

    @EJB
    SingletonBean singletonBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            out.println("Startup time: " + singletonBean.get("startup"));
            out.println("333");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
