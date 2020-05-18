import DBconnection.BasketDataBase;
import DBconnection.ProductDataBase;
import Data.Basket;
import Data.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String idProduct = request.getParameter("buyID");

        BasketDataBase.insert(ProductDataBase.selectOne(Integer.parseInt(idProduct)));
        ArrayList<Product> basket = BasketDataBase.select();
        int size = basket.size();
        request.setAttribute("count", size);

        String path = request.getContextPath() +"/user";
        response.sendRedirect(path);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*int idCustomer = Integer.parseInt(request.getParameter("customerID"));*/
        ArrayList<Product> products = BasketDataBase.select();
        for (Object var:products) {
            System.out.println(var);
        }

        HttpSession session = request.getSession();
        // получаем объект id
        int id = (int) session.getAttribute("ID");

        request.setAttribute("products", products);
        int sum = BasketDataBase.getSum();
        request.setAttribute("summary",sum);
        request.setAttribute("ID", id);
        getServletContext().getRequestDispatcher("/basket.jsp").forward(request, response);
        System.out.println("BasketServletGo");


    }
}
