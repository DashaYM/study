package stateful;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatefulServlet", urlPatterns = {"/StatefulServlet"})
public class StatefulServlet extends HttpServlet {

    @EJB
    StatefulBean bean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("I'm a StatelessServlet");

        bean.increase();

        bean.decrease();

        bean.increase();

    }

}
