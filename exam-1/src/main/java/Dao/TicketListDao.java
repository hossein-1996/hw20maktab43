package Dao;

import entity.Ticket;
import entity.TicketList;
import entity.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class TicketListDao extends AbstractJpaDao<TicketList,Integer> {
    public TicketListDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<TicketList> getEntityClass() {
        return TicketList.class;
    }


}
