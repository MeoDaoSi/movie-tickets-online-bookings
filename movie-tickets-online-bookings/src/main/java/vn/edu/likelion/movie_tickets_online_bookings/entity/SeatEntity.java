package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatEntity extends BaseEntity {

    @Column(name = "seat_number", nullable = false, length = 10)
    @NotNull
    String seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    HallEntity hall;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<TicketEntity> tickets;
}
