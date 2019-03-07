package timeService;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TimeServiceServlet", urlPatterns = {"/TimeServiceServlet"})
public class TimeServiceServlet extends HttpServlet {

    @EJB
    private TimeServiceBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bean.createTimer();
    }
}
