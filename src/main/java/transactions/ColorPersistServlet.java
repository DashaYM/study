package transactions;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ColorPersistServlet", urlPatterns = {"/ColorPersistServlet"})
public class ColorPersistServlet extends HttpServlet {

    @EJB
    ColorDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");

        Colour colour = new Colour();
        colour.setColourCode("23").setDescription("descr").setRgbValue("rgb");
        dao.simpleMerge(colour);


    }
}
