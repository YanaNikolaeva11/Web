import DBconnection.SpecificationsDataBase;
import Data.Specifications;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addInfoPhone")
public class InformationAddPhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String OC = request.getParameter("OC");
        String Screen = request.getParameter("Screen");
        String Processor = request.getParameter("Processor");
        String id = request.getParameter("infoID");
        Specifications s1 = new Specifications(Integer.parseInt(id), "OC", OC);
        Specifications s2 = new Specifications(Integer.parseInt(id), "Screen", Screen);
        Specifications s3 = new Specifications(Integer.parseInt(id), "Processor", Processor);

        SpecificationsDataBase.insert(s1);
        SpecificationsDataBase.insert(s2);
        SpecificationsDataBase.insert(s3);

        String path = request.getContextPath() +"/admin";
        response.sendRedirect(path);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
