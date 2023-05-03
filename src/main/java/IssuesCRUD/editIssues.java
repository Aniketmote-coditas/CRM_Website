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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/editissue")
public class editIssues extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();

        int i_id = Integer.parseInt(request.getParameter("issue-Id"));


        String i_name = request.getParameter("issue-name");
        String i_desc = request.getParameter("issue-desc");

        Issues issues = session.get(Issues.class,i_id);
        issues.setIssue_Name(i_name);
        issues.setDescription(i_desc);

        session.saveOrUpdate(issues);
        transaction.commit();
        session.close();
        sessionFactory.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("showIssues");
        dispatcher.include(request, response);


    }
}
