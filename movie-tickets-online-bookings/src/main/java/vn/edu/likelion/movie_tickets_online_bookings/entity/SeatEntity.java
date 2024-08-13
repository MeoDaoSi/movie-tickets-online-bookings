package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "seat_number", nullable = false, length = 10)
    @NonNull
    String seatNumber;

    @Column(name = "hall_id", nullable = false)
    @NonNull
    int hallId;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private HallEntity hall;

    @OneToMany(mappedBy = "seat")
    private List<TicketEntity> tickets;

}
