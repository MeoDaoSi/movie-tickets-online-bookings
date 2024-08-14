package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "seat_number", nullable = false)
    String seatNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    HallEntity hall;

    @OneToMany(mappedBy = "seat")
    private List<TicketEntity> tickets;

}
