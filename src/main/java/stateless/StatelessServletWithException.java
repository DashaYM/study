package stateless;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatelessServletWithException", urlPatterns = {"/StatelessServletWithException"})
public class StatelessServletWithException extends HttpServlet {
    @EJB
    private StatelessHelloWorldBean statelessHelloWorldBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/test.jsp").forward(request, response);

        throwSystemException();

    }

    private void throwSystemException(){
        //throw new RuntimeException();
        statelessHelloWorldBean.throwsException();//
    }
}