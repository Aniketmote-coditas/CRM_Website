package CustomerCRUD;

import Pojos.Customer;
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

@WebServlet("/customerdeleteAccount")
public class DeleteByCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        HttpSession sessionx = request.getSession(false);

        int id = (int)sessionx.getAttribute("customerId");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer employee = session.find(Customer.class,id);
        session.delete(employee);
        transaction.commit();
        session.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        request.setAttribute("accDelete", "Account Deleted Succefully");
        dispatcher.forward(request, response);
    }
}
