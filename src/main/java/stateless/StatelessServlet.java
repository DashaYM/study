package stateless;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatelessServlet", urlPatterns = {"/StatelessServlet"})
public class StatelessServlet extends HttpServlet {

    @EJB
    StatelessHelloWorldBean bean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");

        PrintWriter out = response.getWriter();
        out.println(bean.sayHello());

        out = response.getWriter();
        out.println(bean.askSecondBean());


    }
}
