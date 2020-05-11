import DBconnection.SpecificationsDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/informationAdd")
public class InformationAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCategory = request.getParameter("infoIDCategory");
        String idProduct = request.getParameter("infoID");

        if(SpecificationsDataBase.selectOne(Integer.parseInt(idProduct)) != null){
            request.setAttribute("product", idProduct);
            request.setAttribute("category", idCategory);
            getServletContext().getRequestDispatcher("/warningAboutProductInfo.jsp").forward(request, response);
        }
        if(Integer.parseInt(idCategory)==1){
            request.setAttribute("product", idProduct);
            getServletContext().getRequestDispatcher("/phoneInfo.jsp").forward(request, response);
        }
        if(Integer.parseInt(idCategory)==2){
            request.setAttribute("product", idProduct);
            getServletContext().getRequestDispatcher("/computerInfo.jsp").forward(request, response);
        }
    }
}
