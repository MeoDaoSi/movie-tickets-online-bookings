package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity extends BaseEntity {

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    @NonNull
    BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NonNull
    TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UserEntity user;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    SeatEntity seat;

    @ManyToOne
    @JoinColumn(name = "showtime_id", referencedColumnName = "id")
    ShowtimeEntity showtime;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    UserEntity staff;

    @Column(name = "booking_time", nullable = true)
    @NonNull
    LocalDateTime bookingTime;

    // Enum for ticket status
    public enum TicketStatus {
        BOOKED,
        AVAILABLE,
        CANCELED,
        REFUNDED
    }
}