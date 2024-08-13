package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", length = 255, nullable = false)
    @NonNull
    String name;

    @Column(name = "description", length = 255)
    String description;

    @OneToMany(mappedBy = "movie")
    private List<ShowtimeEntity> showtimes;
}
