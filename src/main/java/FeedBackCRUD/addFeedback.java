package FeedBackCRUD;

import Pojos.Customer;
import Pojos.Feedback;
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
import java.util.Currency;

@WebServlet("/FeedBack")
public class addFeedback extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        HttpSession session1 = request.getSession(false);
        int id = (int)session1.getAttribute("customerId");

        String crmName = request.getParameter("crm-name");
        String FeedBackdesc = request.getParameter("feedback-desc");

        Customer customer = session.find(Customer.class,id);

        Feedback feedback = new Feedback();
        feedback.setCrmName(crmName);
        feedback.setFeebackdesc(FeedBackdesc);
        feedback.setCustomer(customer);

        session.save(feedback);
        transaction.commit();
        session.close();
        sessionFactory.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("FeedBack.jsp");
        request.setAttribute("s", "FeedBack Send Succesfully");
        dispatcher.include(request, response);
    }
}
