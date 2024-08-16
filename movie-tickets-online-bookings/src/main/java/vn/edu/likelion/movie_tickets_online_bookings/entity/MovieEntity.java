package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieEntity extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    @NotNull
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "release_date")
    LocalDate releaseDate;

    @ElementCollection
    @CollectionTable(name = "movie_cast", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "cast_member")
    List<String> cast;

    @Column(name = "trailer_url")
    String trailer;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "rating")
    Double rating;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShowtimeEntity> showtimes;
}
