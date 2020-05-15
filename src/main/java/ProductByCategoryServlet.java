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
import java.util.Calendar;

@WebServlet("/productByCategory")
public class ProductByCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameCategory= request.getParameter("categoryName");
        ArrayList<Product> products = ProductDataBase.findByCategory(nameCategory);
        ArrayList<Category> categories = CategoryDataBase.select();
        request.setAttribute("categories", categories);
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }
}
