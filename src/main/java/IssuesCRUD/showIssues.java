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
import java.util.List;

@WebServlet("/showIssues")
public class showIssues extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int cId = (int) session.getAttribute("customerId");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();




        //List<Employee> list =session1.createQuery("from Issues where Issues.id=:cid").setParameter("cid",cId).list();

//        List<Issues> issuesList = session1.createQuery("from Issues where Issues.customer.id=:cid", Issues.class)
//                .setParameter("cid", cId)
//                .list();

        List<Issues> list = session1.createQuery("FROM Issues WHERE customer.id ="+cId+"").list();
        request.setAttribute("crmList", list);
        transaction.commit();
        session1.close();
        sessionFactory.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("IssueList.jsp");
        dispatcher.forward(request, response);
    }


}
