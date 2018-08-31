package test;

import first.HelloWorldBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @EJB
    private HelloWorldBean helloWorldBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/test.jsp").forward(request, response);

        throwSystemException();

    }

    private void throwSystemException(){
        //throw new RuntimeException();
        helloWorldBean.throwsException();//
    }
}