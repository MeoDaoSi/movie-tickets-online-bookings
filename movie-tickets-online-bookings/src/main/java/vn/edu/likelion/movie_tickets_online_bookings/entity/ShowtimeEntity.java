package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "showtimes")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowtimeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "showtime_date", nullable = false)
    @NonNull
    LocalDate showtime_date;

    @Column(name = "start_time", nullable = false)
    @NonNull
    LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @NonNull
    LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    MovieEntity movie;

    @ManyToOne(fetch = FetchType.LAZY)
    HallEntity hall;

    @OneToMany(mappedBy = "showtime", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<TicketEntity> tickets;

}
