import DBconnection.CustomerDataBase;
import DBconnection.ProductDataBase;
import Data.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String idCustomer = request.getParameter("editID");
        String roleCustomer =request.getParameter("role");
        Customer customer = CustomerDataBase.selectOne(Integer.parseInt(idCustomer));
        customer.setRole(roleCustomer);
        CustomerDataBase.update(customer);

        /*ArrayList<Customer> customers = CustomerDataBase.select();
        request.setAttribute("customers", customers);*/
        String path = request.getContextPath() +"/role";
        response.sendRedirect(path);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
