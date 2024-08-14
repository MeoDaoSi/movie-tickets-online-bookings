package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.edu.likelion.movie_tickets_online_bookings.enums.TicketStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity extends BaseEntity {

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    BigDecimal price;

    @Enumerated(EnumType.STRING)
    TicketStatus status;

    @ManyToOne
    UserEntity user;

    @ManyToOne
    SeatEntity seat;

    @ManyToOne
    ShowtimeEntity showtime;

    @ManyToOne
    UserEntity staff;

    @Column(name = "booking_time", nullable = true)
    LocalDateTime bookingTime;

}