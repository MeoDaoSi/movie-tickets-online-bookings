package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "halls")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HallEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NonNull
    String name;

    @Column(name = "capacity", nullable = false)
    @NonNull
    int capacity;

    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SeatEntity> seats;

    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShowtimeEntity> showtimes;
}
