import DBconnection.BasketDataBase;
import Data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/multy")
public class MultyPriceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /*   int count = Integer.parseInt(request.getParameter("count"));
        int id = Integer.parseInt(request.getParameter("deleteID"));

        BasketDataBase.editPrice(count,id);
        String path = request.getContextPath() +"/basket";
        response.sendRedirect(path);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = Integer.parseInt(request.getParameter("count"));
        int id = Integer.parseInt(request.getParameter("ID"));
        BasketDataBase.editPrice(count,id);
        ArrayList<Product> products = BasketDataBase.select();
        int sum = BasketDataBase.getSum();
        request.setAttribute("summary",sum);
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/basket.jsp").forward(request, response);

    }
}
