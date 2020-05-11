import DBconnection.SpecificationsDataBase;
import Data.Specifications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/info")
public class InformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProduct = request.getParameter("infoID");
        int id = Integer.parseInt (idProduct);
        ArrayList<Specifications> specifications = SpecificationsDataBase.selectMore(id);
        request.setAttribute("specifications", specifications);
        getServletContext().getRequestDispatcher("/information.jsp").forward(request, response);
    }
}
