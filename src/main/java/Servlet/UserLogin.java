package Servlet;

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
import java.util.List;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int uid = Integer.parseInt(request.getParameter("userId"));
        String upassword=request.getParameter("upassword");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customerList = session.createQuery("from Customer ").list();
        HttpSession session2 = request.getSession();
        boolean flag=false;
        for(Customer customer:customerList){
            if(customer.getCustomerId()==uid && customer.getCustomerpassword().equals(upassword)){
                flag=true;
                session2.setAttribute("customerId", customer.getCustomerId());
                session.close();
                sessionFactory.close();
                RequestDispatcher rd = request.getRequestDispatcher("CustomerPanel.jsp");
                rd.forward(request, response);
            }
        }
        if(flag==false){
            session.close();
            sessionFactory.close();
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            request.setAttribute("errorMsg", "Data not found Contact Admin");
            rd.include(request, response);
        }


    }
}
