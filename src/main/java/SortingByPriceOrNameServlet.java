import DBconnection.ProductDataBase;
import Data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/sortingByPriceorName")
public class SortingByPriceOrNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sorting = request.getParameter("sorting");
        int sort = Integer.parseInt (sorting);

        if(sort==1){
            ArrayList<Product> products = ProductDataBase.sortByPrice();
            for (Object var:products) {
                System.out.println(var);
            }
            request.setAttribute("products", products);
            getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
        }
        else{
            ArrayList<Product> products = ProductDataBase.sortByName();
            for (Object var:products) {
                System.out.println(var);
            }
            request.setAttribute("products", products);
            getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
        }



    }
}
