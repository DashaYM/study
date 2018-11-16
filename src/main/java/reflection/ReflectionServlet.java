package reflection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReflectionServlet", urlPatterns = {"/ReflectionServlet"})
public class ReflectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                try {
            Builder builder = new Builder();
            Class aClass = builder.outputReflectionClass(ReflectionClass.class);
            ReflectionClass instance = (ReflectionClass) aClass.newInstance();
            System.out.println(instance.getFieldA());
            System.out.println(instance.getFieldB());

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
