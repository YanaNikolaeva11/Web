import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCategory = request.getParameter("idCategory");
        String idProduct = request.getParameter("idProduct");

        if(Integer.parseInt(idCategory)==1){
            request.setAttribute("product", idProduct);
            getServletContext().getRequestDispatcher("/phoneInfoUpdate.jsp").forward(request, response);
        }
        if(Integer.parseInt(idCategory)==2){
            request.setAttribute("product", idProduct);
            getServletContext().getRequestDispatcher("/computerInfoUpdate.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
