package entity;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;

@Data
@Entity
public class TicketList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    @Temporal(DATE)
    private Date date;

    @OneToMany(mappedBy = "ticketList",cascade = CascadeType.ALL)
    private List<Ticket> tickets;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
