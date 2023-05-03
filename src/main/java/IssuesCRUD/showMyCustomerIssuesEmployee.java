package IssuesCRUD;

import Pojos.Customer;
import Pojos.Employee;
import Pojos.Issues;
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

@WebServlet("/showMyCustomerIssues")
public class showMyCustomerIssuesEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        Employee employee = (Employee) session.getAttribute("emp");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction =session1.beginTransaction();

        //List<Customer> list =session1.createQuery("from Customer where:=").list();



        List<Issues> list =session1.createQuery("from Issues where customer.employee.id=:id").setParameter("id",employee.getEmpid()).list();
        request.setAttribute("crmList", list);
        transaction.commit();
        session1.close();
        sessionFactory.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("IssuesEmployeePanel-list.jsp");
        dispatcher.forward(request, response);
    }
}
