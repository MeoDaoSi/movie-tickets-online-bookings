package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "showtimes")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowtimeEntity extends BaseEntity {

    @Column(name = "showtime_date", nullable = false)
    @NotNull
    LocalDate showtimeDate;

    @Column(name = "start_time", nullable = false)
    @NotNull
    LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @NotNull
    LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    MovieEntity movie;

    @ManyToOne(fetch = FetchType.LAZY)
    HallEntity hall;

    @OneToMany(mappedBy = "showtime", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<TicketEntity> tickets;

}
