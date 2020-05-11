import DBconnection.BasketDataBase;
import DBconnection.CustomerDataBase;
import DBconnection.ProductDataBase;
import Data.Customer;
import Data.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        /*String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String gender = request.getParameter("gender");
        String role = request.getParameter("role");*/
        String password = request.getParameter("password");
        /*String country = request.getParameter("country");
        int idCountry = Integer.parseInt (country);*/

        /*Customer customer = new Customer(idCountry, password, name, surname, patronymic, gender, role );*/
        Customer customer = new Customer(password, name);
        if(CustomerDataBase.selectone(customer, name)){
            String roleCustomer = CustomerDataBase.selectoneRole(customer,name);
            if(roleCustomer.equalsIgnoreCase("adm")){
                String path = request.getContextPath() +"/admin";
                response.sendRedirect(path);
            }
            else{


                // получаем сессию
                HttpSession session = request.getSession();
                // получаем объект name
                session.setAttribute("ID", CustomerDataBase.selectoneID(customer, name));
                System.out.println("Session data are set");

                ArrayList<Product> products = BasketDataBase.select();
                for (Product var:products) {
                    BasketDataBase.delete(var.getIdProduct());
                }
                /*request.setAttribute("idCustomer", CustomerDataBase.selectoneID(customer, name));*/
                String path = request.getContextPath() +"/user";
                response.sendRedirect(path);
            }
        }
        else{
            String path = "/Error.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        System.out.println("SignInServletGo");
    }
}
