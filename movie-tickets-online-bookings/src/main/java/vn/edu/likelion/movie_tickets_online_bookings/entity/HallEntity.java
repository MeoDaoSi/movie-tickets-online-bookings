package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "halls")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HallEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, length = 255)
    @NonNull
    String name;

    @Column(name = "capacity", nullable = false)
    @NonNull
    int capacity;

    @OneToMany(mappedBy = "hall")
    private List<SeatEntity> seats;

    @OneToMany(mappedBy = "hall")
    private List<ShowtimeEntity> showtimes;
}
