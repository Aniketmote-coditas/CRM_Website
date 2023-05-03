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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class loginSerrvlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id =Integer.parseInt(request.getParameter("empId"));
        String password = request.getParameter("epassword");

        if(id==100 && password.equals("admin")){
            response.sendRedirect("adminpanel.jsp");
        }

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Transaction transaction =session1.beginTransaction();

        HttpSession session2 = request.getSession();
        HttpSession session3 = request.getSession();
        if(id<100) {
            List<Employee> employeeList = session1.createQuery("from Employee").list();
            boolean flag=false;
            for (Employee employee : employeeList) {
                if (employee.getEmpid() == id && employee.getPassword().equals(password)) {
                    flag=true;
                    session2.setAttribute("empId", employee.getEmpid());
                    session2.setAttribute("emp", employee);
                    session1.close();
                    sessionFactory.close();
                    RequestDispatcher rd = request.getRequestDispatcher("EmployeePanel.jsp");
                    rd.forward(request, response);
                }

            }
            if(flag==false){
                session1.close();
                sessionFactory.close();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                request.setAttribute("errorMsg", "Data not found Contact Admin");
                rd.include(request, response);
            }
        }else{
            boolean flag=false;
            List<Customer> customers = session1.createQuery("from Customer").list();
            session1.close();
            sessionFactory.close();
            for (Customer customer : customers) {
                if (customer.getCustomerId() == id && customer.getCustomerpassword().equals(password)) {
                    session3.setAttribute("customerId", customer.getCustomerId());

                    RequestDispatcher rd = request.getRequestDispatcher("CustomerPanel.jsp");
                    rd.forward(request, response);
                }

            }
            if(flag==false){
                session1.close();
                sessionFactory.close();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                request.setAttribute("errorMsg", "Data not found Contact Admin");
                rd.include(request, response);
            }
        }

    }
}
