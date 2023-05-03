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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/s")
public class AddCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession sessions = request.getSession(false); // do not create a new session if one doesn't exist
        int userId=0;
        // check if the user is logged in
        if (sessions != null && sessions.getAttribute("empId") != null) {
            // get the user's id from the session object
            userId = (int) sessions.getAttribute("empId");
        } else {
            response.sendRedirect("login.jsp");
        }


        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();

        String name = request.getParameter("cName");
        String email = request.getParameter("cEmail");
        String password = request.getParameter("cPassword");
        String city = request.getParameter("cCity");


        Employee employee = session.find(Employee.class, userId);


        Customer customer = new Customer();
        customer.setCustomername(name);
        customer.setCustomeremail(email);
        customer.setCustomerpassword(password);
        customer.setCustomercity(city);
        customer.setEmployee(employee);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        employee.setCustomers(customerList);


        session.save(employee);
        transaction.commit();
        session.close();
        sessionFactory.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("AddCustomer.jsp");
        dispatcher.include(request, response);
    }
}
