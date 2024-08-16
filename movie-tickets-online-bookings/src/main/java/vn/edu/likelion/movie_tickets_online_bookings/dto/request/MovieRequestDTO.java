package vn.edu.likelion.movie_tickets_online_bookings.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieRequestDTO implements Serializable {

    @NotBlank(message = "Movie name cannot be blank")
    private String name;

    private String description;

    private LocalDate releaseDate;

    private List<String> cast;

    private String trailer;

    private String imageUrl;

    private Double rating;
}
