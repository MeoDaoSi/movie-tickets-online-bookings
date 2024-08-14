package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieEntity extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<ShowtimeEntity> showtimes;

}
