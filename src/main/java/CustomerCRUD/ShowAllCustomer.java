package CustomerCRUD;

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
import java.util.List;
@WebServlet("/showAllCustomer")
public class ShowAllCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction =session1.beginTransaction();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Employee> list =session1.createQuery("from Customer ").list();
        request.setAttribute("crmList", list);
        transaction.commit();
        session1.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-list.jsp");
        dispatcher.forward(request, response);
    }
}
