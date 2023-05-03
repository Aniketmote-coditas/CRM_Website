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
import java.time.LocalDate;
import java.util.List;

@WebServlet("/submitIssue")
public class AddIssues extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        int cId = (int) session.getAttribute("customerId");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();


        String i_name = request.getParameter("issue-name");
        String i_desc = request.getParameter("issue-desc");



        Customer customer = session1.find(Customer.class, cId);


        LocalDate reportDate = LocalDate.now();
        LocalDate deadline = reportDate.plusDays(7);

        Issues issues = new Issues();
        issues.setIssue_Name(i_name);
        issues.setDescription(i_desc);
        issues.setToday(reportDate);
        issues.setDeadline(deadline);
        issues.setCustomer(customer);

        session1.save(issues);
        transaction.commit();
        session1.close();
        sessionFactory.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("IssueForm.jsp");
        request.setAttribute("addissue", "Issue Add successfully");
        dispatcher.forward(request, response);


    }
}
