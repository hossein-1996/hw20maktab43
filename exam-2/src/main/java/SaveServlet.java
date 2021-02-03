

import entity.Employee;
import entity.EmployeeDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        HttpSession session= req.getSession();
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/save":
                    saveEmployee(req,resp);
                    break;
                case "/showDetails":
                    Integer id=Integer.parseInt(req.getParameter("id"));
                    System.out.println(id +"id");
                    showDetails(req,resp,id);
                    break;
                case "/delete":
                    Integer id2=Integer.parseInt(req.getParameter("id"));
                    System.out.println(id2);
                    deleteEmployee(req, resp,id2);
                    break;
                case "/update":
                    Integer id3=Integer.parseInt(req.getParameter("id"));
                    updateEmployee(req, resp,id3);
                    break;
                case "/viewAll" :
                    viewAll(req,resp);
                    break;
                case "/saveUpdate" :
                    Integer id4=Integer.parseInt(req.getParameter("id"))  ;

                    saveUpdate(req,resp,id4);
                    break;

                case "/saveDetails" :
                    Integer id5=Integer.parseInt(req.getParameter("id"));

                    saveDetails(req,resp,id5);
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void saveDetails(HttpServletRequest req, HttpServletResponse resp, Integer id5) throws ServletException, IOException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        entityManager.getTransaction().begin();
        EmployeeDetailsDao employeeDetailsDao = new EmployeeDetailsDao(entityManager);
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        HttpSession session= req.getSession();
        String fathername = req.getParameter("fatherName");
        String nationalCode = req.getParameter("nationalCode");
        String address = req.getParameter("address");
        String idNumber= req.getParameter("idNumber");

        Employee employee = employeeDao.loadEmployeeById(id5);

        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.setFatherName(fathername);
        employeeDetails.setNationalCode(nationalCode);
        employeeDetails.setAddress(address);
        employeeDetails.setIdNumber(idNumber);
        employeeDetails.setEmployee(employee);
        employeeDetailsDao.save(employeeDetails);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        entityManager.getTransaction().commit();
    }

    private void saveUpdate(HttpServletRequest req, HttpServletResponse resp, Integer id4) throws ServletException, IOException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String username= req.getParameter("username");
        System.out.println(firstName + "+" +lastName+ "+" +email+ "+" +username);
        Employee employee = employeeDao.loadEmployeeById(id4);
        Employee employee1 = new Employee();
        employee.setfirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(username);
        employee.setEmail(email);
        employeeDao.update(employee);

        entityManager.getTransaction().commit();

        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

    private void viewAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();
        List<Employee> employees = employeeDao.loadall();

        System.out.println(employees);
        req.setAttribute("employeeList",employees);
        req.getRequestDispatcher("/EmployeeList.jsp").forward(req,resp);
        entityManager.getTransaction().commit();
    }

    public  void saveEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        HttpSession session= req.getSession();
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String username= req.getParameter("username");
        System.out.println(firstName + "+" +lastName+ "+" +email+ "+" +username);
        Employee employee = new Employee();
        employee.setfirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(username);
        employee.setEmail(email);

        entityManager.getTransaction().begin();

        employeeDao.save(employee);

        entityManager.getTransaction().commit();


        session.setAttribute("username",username);
        req.getRequestDispatcher("/Successfullysave.jsp").include(req,resp);
    }
    public void showDetails(HttpServletRequest req, HttpServletResponse resp, Integer id) throws ServletException, IOException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        EmployeeDetailsDao employeeDetailsDao = new EmployeeDetailsDao(entityManager);
        entityManager.getTransaction().begin();


        try {
            EmployeeDetails employeeDetails = employeeDetailsDao.loadEmployeeDetailsById(id);
            entityManager.getTransaction().commit();
            req.setAttribute("employeeDetails",employeeDetails);
            req.getRequestDispatcher("/ShowEmployeeDetails.jsp").forward(req,resp);
        }catch (NoResultException noResultException){
            req.setAttribute("id",id);
            req.getRequestDispatcher("/SaveEmployeeDetails.jsp").forward(req,resp);
        }







    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp,Integer id) throws ServletException, IOException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();

        Employee employee = employeeDao.loadEmployeeById(id);
        employeeDao.delete(employee);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        entityManager.getTransaction().commit();

    }
    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp, Integer id) throws ServletException, IOException {
        EntityManagerFactory entityManagerfactory =  JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerfactory.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();

        Employee employee = employeeDao.loadEmployeeById(id);

        req.setAttribute("employee",employee);
        req.getRequestDispatcher("/EditEmployee.jsp").forward(req,resp);
        entityManager.getTransaction().commit();

    }
}
