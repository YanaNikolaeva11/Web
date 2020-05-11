import DBconnection.BasketDataBase;
import DBconnection.Product_PurchaseDataBase;
import DBconnection.PurchaseDataBase;
import Data.Product;
import Data.Product_Purchase;
import Data.Purchase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("ID");
        request.setAttribute("ID", id);

        Purchase purchase = new Purchase(Integer.parseInt(id));
        PurchaseDataBase.insert(purchase);

        ArrayList<Product> products = BasketDataBase.select();
        Purchase purchaseAll = PurchaseDataBase.selectOneonIdCust(Integer.parseInt(id));
        for( Product obj : products){
            Product_Purchase product_purchase = new Product_Purchase(obj.getIdProduct(), purchaseAll.getIdPurchase());
            Product_PurchaseDataBase.insert(product_purchase);
        }

        getServletContext().getRequestDispatcher("/tripProduct.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
