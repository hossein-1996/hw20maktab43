package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String beginning;

    @Column
    private String Destination;

    @Column
    @Temporal(DATE)
    private Date DateOfDeparture;

    @Column
    private String HourOfDeparture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketList_id")
    private TicketList ticketList;

}
