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
import java.util.List;

@WebServlet("/showMyCustomer")
public class ShowCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session2 = request.getSession(false);
        int empid  = (int) session2.getAttribute("empId");
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session3 = sessionFactory.openSession();
        Transaction transaction =session3.beginTransaction();


        /*List<Customer> list = session3.createQuery("from Customer where employee_empid= :eid")
                .setParameter("eid", eid)
                .list();*/
        List<Customer> list = session3.createQuery("FROM Customer WHERE employee.empid ="+empid+"").list();
        request.setAttribute("crmList", list);
        transaction.commit();
        session3.close();
        sessionFactory.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_list_EmployeeLogin.jsp");
        dispatcher.forward(request, response);
    }
}
