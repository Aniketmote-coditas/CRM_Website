package CustomerCRUD;

import Pojos.Customer;
import Pojos.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveCustomer")
public class SaveCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();

        int id = Integer.parseInt(request.getParameter("empId"));
        String name = request.getParameter("empName");
        String email = request.getParameter("empEmail");
        String password = request.getParameter("empPassword");
        String city = request.getParameter("empCity");

        Customer employee = session.get(Customer.class,id);
        employee.setCustomerId(id);
        employee.setCustomername(name);
        employee.setCustomeremail(email);
        employee.setCustomerpassword(password);
        employee.setCustomercity(city);

        session.saveOrUpdate(employee);
        transaction.commit();
        session.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("showMyCustomer");
        dispatcher.include(request, response);
    }
}
