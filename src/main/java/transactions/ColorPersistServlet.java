package transactions;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;
import java.io.IOException;

@WebServlet(name = "ColorPersistServlet", urlPatterns = {"/ColorPersistServlet"})
public class ColorPersistServlet extends HttpServlet {

    @EJB
    ColorModule colorModule;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("doGet");

        try {
            colorModule.persistEntities5();
        } catch(Exception e) {

        }

    }
}
