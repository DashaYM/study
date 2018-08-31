//package MDB;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(name = "SimpleMessageBeanServletServlet1", urlPatterns = {"/SimpleMessageBeanServletServlet1"})
//public class SimpleMessageBeanServlet1 extends HttpServlet{
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.println("SimpleMessageBeanServletServlet1");
//        new SimpleMessageClient().sendMessages();
//    }
//}
