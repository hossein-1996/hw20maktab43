package Dao;

import entity.Ticket;
import entity.TicketList;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketDao extends  AbstractJpaDao<Ticket,Integer> {
    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
    public List<Ticket> loadUser(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = cb.createQuery(Ticket.class);
        Root<User> fromUser = criteriaQuery.from(User.class);
        Root<TicketList> fromTicketList = criteriaQuery.from(TicketList.class);
        Root<Ticket> ticketRoot = criteriaQuery.from(Ticket.class);

        Predicate predicate =cb.and(cb.equal(fromUser.get("userName"),username),cb.equal(fromTicketList.get("user"),fromUser.get("id")),
                cb.equal(fromTicketList.get("id"),ticketRoot.get("ticketList")));

        criteriaQuery.select(ticketRoot).where(predicate);


        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public Ticket loadTicketById(Integer id ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery = cb.createQuery(Ticket.class);
        Root<Ticket> ticketRoot = criteriaQuery.from(Ticket.class);

        criteriaQuery.select(ticketRoot).where(cb.equal(ticketRoot.get("id"),id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

}
