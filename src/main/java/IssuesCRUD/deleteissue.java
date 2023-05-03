package IssuesCRUD;

import Pojos.Customer;
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

@WebServlet("/deleteissue")
public class deleteissue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        int id = Integer.parseInt(request.getParameter("id"));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Issues issues = session.find(Issues.class,id);
        session.delete(issues);
        transaction.commit();
        session.close();
        sessionFactory.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("showMyCustomerIssues");
        dispatcher.forward(request, response);
    }
}
