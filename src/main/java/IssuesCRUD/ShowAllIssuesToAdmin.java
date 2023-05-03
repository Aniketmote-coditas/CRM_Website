package IssuesCRUD;

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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showAllIssues")
public class ShowAllIssuesToAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Issues.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction =session1.beginTransaction();
        response.setContentType("text/html");

        List<Issues> list =session1.createQuery("from Issues ").list();
        request.setAttribute("crmList", list);
        transaction.commit();
        session1.close();
        sessionFactory.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("IssuesAdminPanel-list.jsp");
        dispatcher.forward(request, response);
    }
}
