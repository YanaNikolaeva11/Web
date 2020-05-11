import DBconnection.ProductDataBase;
import DBconnection.Rate;
import Data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/rate")
public class RateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double rate = Double.parseDouble(request.getParameter("rate"));
        int id= Integer.parseInt(request.getParameter("id"));
        Rate.insert(id,rate);
        double avgRate=0;
        avgRate = Rate.getRate(id);
        ArrayList<Product> products = ProductDataBase.select();
        for (Object var:products) {
            System.out.println(var);
        }
        request.setAttribute("rating", avgRate);
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}