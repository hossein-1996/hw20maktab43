import entity.Employee;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Employee employee=new Employee();
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        EmployeeDao employeeDao=new EmployeeDao(entityManager);
        EmployeeDao employeeDao1=null;
   //  List<entity.Employee> employee1=employeeDao1.loadall();
       Employee employee4=employeeDao.load(2);
    //    entity.Employee employee5=employeeDao1.load(2);

        PrintWriter out =resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n");
//        for(entity.Employee object:employee1)
//            {
     //           out.println(  ""+object.getfirstName()+" "+object.getLastname()  );
//            }
        out.println(  ""+employee4.getfirstName()+" "   );

        out.println(    "\n" +
                "\n" +
                "</body>\n" +
                "</html>");

        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();

    }
}