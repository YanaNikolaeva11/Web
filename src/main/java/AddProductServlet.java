import DBconnection.ProductDataBase;
import Data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        int idCategory = Integer.parseInt (category);
        Product product = new Product(idCategory, name, Integer.parseInt(price), 0);
        ProductDataBase.insert(product);

        ArrayList<Product> products = ProductDataBase.select();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
