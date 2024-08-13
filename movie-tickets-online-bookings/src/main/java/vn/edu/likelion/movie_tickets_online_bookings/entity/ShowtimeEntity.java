package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "showtimes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowtimeEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "date", nullable = false)
    @NonNull
    LocalDate date;

    @Column(name = "start_time", nullable = false)
    @NonNull
    LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @NonNull
    LocalTime endTime;

    @Column(name = "movie_id", nullable = false)
    @NonNull
    int movieId;

    @Column(name = "hall_id", nullable = false)
    @NonNull
    int hallId;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private HallEntity hall;

    @OneToMany(mappedBy = "showtime")
    private List<TicketEntity> tickets;

}
