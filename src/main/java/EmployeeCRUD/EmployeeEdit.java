package EmployeeCRUD;

import Pojos.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit")
public class EmployeeEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        int id = Integer.parseInt(request.getParameter("id"));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Employee> list = session.createQuery("FROM Employee e WHERE e.empid = :empId")
                .setParameter("empId", id).list();

        request.setAttribute("crmList", list);
        transaction.commit();
        session.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeEditForm.jsp");
        dispatcher.forward(request, response);


    }
}
