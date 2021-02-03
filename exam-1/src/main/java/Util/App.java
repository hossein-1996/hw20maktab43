package Util;

import Dao.DirectionDao;
import Dao.TicketDao;
import Dao.TicketListDao;
import Dao.UserDao;
import entity.Ticket;
import entity.TicketList;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class App {
//    public static java.util.Date stringtodate(String date) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        return  dateFormat.parse(date);
//    }
    public static void main(String[] args) throws ParseException {
        EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
//        UserDao userDao = new UserDao(entityManager);
//        DirectionDao directionDao = new DirectionDao(entityManager);
//        System.out.println(userDao.loadUserByUsername("hosein1996"));
        TicketDao ticketDao = new TicketDao(entityManager);
        List<Ticket> ticketLists=ticketDao.loadUser("hosein1996");

        System.out.println(ticketLists);
//        System.out.println(directionDao.loadDirection("tehran","esfahan",stringtodate("1399-11-08")));
        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();
    }
}
