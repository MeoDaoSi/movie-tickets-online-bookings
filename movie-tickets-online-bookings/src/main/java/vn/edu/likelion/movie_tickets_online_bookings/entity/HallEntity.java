package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    String name;

    @Column(name = "capacity", nullable = false)
    @NotNull
    int capacity;

    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SeatEntity> seats;

    @OneToMany(mappedBy = "hall", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShowtimeEntity> showtimes;
}
