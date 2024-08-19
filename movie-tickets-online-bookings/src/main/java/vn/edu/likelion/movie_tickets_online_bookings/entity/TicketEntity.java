package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import vn.edu.likelion.movie_tickets_online_bookings.entity.enums.TicketStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity extends BaseEntity {

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    BigDecimal price;

    @Enumerated(EnumType.STRING)
    TicketStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    SeatEntity seat;

    @ManyToOne(fetch = FetchType.LAZY)
    ShowtimeEntity showtime;

    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity staff;

    @Column(name = "booking_time")
    LocalDateTime bookingTime;

}