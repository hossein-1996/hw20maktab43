import Dao.DirectionDao;
import Util.JPAUtil;
import entity.Direction;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        HttpSession session=req.getSession();
        String userName = (String) session.getAttribute("username");
        DirectionDao directionDao = new DirectionDao(entityManager);
        resp.setContentType("text/html");


        Date date = stringtodate(req.getParameter("tarikh"));
        String beginning = req.getParameter("beginning");
        String destination = req.getParameter("Destination");
        System.out.println(date +"+"+beginning+"+"+destination);
        List<Direction> directions = directionDao.loadDirection(beginning,destination,date);

        req.setAttribute("directions", directions);

        session.setAttribute("username",userName);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/history.jsp");
        dispatcher.forward(req, resp);



    }
        public static java.util.Date stringtodate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return  dateFormat.parse(date);
    }
}