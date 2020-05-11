import DBconnection.CategoryDataBase;
import DBconnection.ProductDataBase;
import Data.Category;
import Data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));*/
        ArrayList<Product> products = ProductDataBase.select();
        for (Object var:products) {
            System.out.println(var);
        }
        ArrayList<Category> categories = CategoryDataBase.select();
        request.setAttribute("products", products);
        request.setAttribute("categories",categories);


       /* request.setAttribute("products", products);*/
        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}