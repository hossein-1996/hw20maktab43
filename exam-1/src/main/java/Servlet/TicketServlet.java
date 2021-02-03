package Servlet;

import Dao.DirectionDao;
import Dao.TicketDao;
import Dao.TicketListDao;
import Dao.UserDao;
import Util.JPAUtil;
import entity.Direction;
import entity.Ticket;
import entity.TicketList;
import entity.User;

import javax.jws.soap.SOAPBinding;
import javax.naming.directory.DirContext;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TicketServlet extends HttpServlet {

    static EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    static TicketDao ticketDao = new TicketDao(entityManager);
    static DirectionDao directionDao = new DirectionDao(entityManager);
    static TicketListDao ticketListDao = new TicketListDao(entityManager);
    static UserDao userDao = new UserDao(entityManager);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        HttpSession session=req.getSession();
        String username = (String) session.getAttribute("username");
        String username2 = req.getParameter("username");



        try {
            switch (action) {
                case "/buy":
                    Integer id=Integer.parseInt(req.getParameter("id"));
                    buyTicket(req, resp,id,username);
                    break;
                case "/ticketbuyed":
                    loadAllTicketBy(req, resp,username2);
                    break;
                case "/show":
                    Integer id2=Integer.parseInt(req.getParameter("id"));
                    showTicket(req, resp,id2);
                    break;
                case "/cancel":
                    Integer id3=Integer.parseInt(req.getParameter("id"));
                    cancelTicket(req, resp,id3);
                    break;
            }
        } catch (Exception ex) {
        throw new ServletException(ex);
    }
    }
    public void buyTicket(HttpServletRequest req, HttpServletResponse resp,Integer id,String userName) throws ServletException, IOException {
        entityManager.getTransaction().begin();
        Ticket ticket = new Ticket();
        String fullname= req.getParameter("fullName");
        String gender = req.getParameter("selectBox");

        User user = userDao.loadUserByUsername(userName);

        Direction direction = directionDao.loadDirectionById(id);
        TicketList ticketList = new TicketList();
        ticketList.setDate(direction.getDateOfDeparture());
        ticketList.setUser(user);
        ticketListDao.save(ticketList);

        ticket.setBeginning(direction.getBeginning());
        ticket.setDateOfDeparture(direction.getDateOfDeparture());
        ticket.setHourOfDeparture(direction.getHourOfDeparture());
        ticket.setDestination(direction.getDestination());
        ticket.setDirection(direction);
        ticket.setGender(gender);
        ticket.setName(fullname);
        ticket.setTicketList(ticketList);
        ticketDao.save(ticket);
        HttpSession session=req.getSession();
        session.setAttribute("fullname",fullname);
        if(gender.equals("male")){
            session.setAttribute("gender","Mr.");
        }else {
            session.setAttribute("gender", "Ms.");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("BuySuccessfully.jsp");
        dispatcher.forward(req, resp);
        entityManager.getTransaction().commit();
    }
    public void loadAllTicketBy(HttpServletRequest req, HttpServletResponse resp,String username) throws ServletException, IOException {

        entityManager.getTransaction().begin();
        List<Ticket> ticketLists=ticketDao.loadUser(username);

        req.setAttribute("ticketlist", ticketLists);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ShowAllTicket.jsp");
        dispatcher.forward(req, resp);
        entityManager.getTransaction().commit();
    }
    public void showTicket(HttpServletRequest req, HttpServletResponse resp,Integer id) throws ServletException, IOException {

        entityManager.getTransaction().begin();
        Ticket ticket = ticketDao.loadTicketById(id);
        req.setAttribute("ticket", ticket);
        RequestDispatcher dispatcher = req.getRequestDispatcher("show2.jsp");
        dispatcher.forward(req, resp);
        entityManager.getTransaction().commit();
    }
    public void cancelTicket(HttpServletRequest req, HttpServletResponse resp,Integer id) throws ServletException, IOException {
        entityManager.getTransaction().begin();
        Ticket ticket = ticketDao.loadTicketById(id);
        if (ticket != null) {
            ticketDao.delete(ticket);
            RequestDispatcher dispatcher = req.getRequestDispatcher("SuccessfullyCancel.jsp");
            dispatcher.forward(req, resp);
        }
        entityManager.getTransaction().commit();
    }
}
