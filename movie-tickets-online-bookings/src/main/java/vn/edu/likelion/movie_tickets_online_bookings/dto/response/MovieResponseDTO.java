package vn.edu.likelion.movie_tickets_online_bookings.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieResponseDTO {

    private int id;

    private String name;

    private String description;

    private LocalDate releaseDate;

    private List<String> cast;

    private String trailer;

    private String imageUrl;

    private Double rating;
}
