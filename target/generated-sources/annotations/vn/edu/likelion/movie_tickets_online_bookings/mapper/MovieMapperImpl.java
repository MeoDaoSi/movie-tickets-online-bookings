package vn.edu.likelion.movie_tickets_online_bookings.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.entity.MovieEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T14:07:11+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieEntity toEntity(MovieRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setName( dto.getName() );
        movieEntity.setDescription( dto.getDescription() );
        movieEntity.setReleaseDate( dto.getReleaseDate() );
        List<String> list = dto.getCast();
        if ( list != null ) {
            movieEntity.setCast( new ArrayList<String>( list ) );
        }
        movieEntity.setTrailer( dto.getTrailer() );
        movieEntity.setImageUrl( dto.getImageUrl() );
        movieEntity.setRating( dto.getRating() );

        linkShowtimes( movieEntity );

        return movieEntity;
    }

    @Override
    public MovieResponseDTO toResponseDTO(MovieEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MovieResponseDTO movieResponseDTO = new MovieResponseDTO();

        movieResponseDTO.setId( entity.getId() );
        movieResponseDTO.setName( entity.getName() );
        movieResponseDTO.setDescription( entity.getDescription() );
        movieResponseDTO.setReleaseDate( entity.getReleaseDate() );
        List<String> list = entity.getCast();
        if ( list != null ) {
            movieResponseDTO.setCast( new ArrayList<String>( list ) );
        }
        movieResponseDTO.setTrailer( entity.getTrailer() );
        movieResponseDTO.setImageUrl( entity.getImageUrl() );
        movieResponseDTO.setRating( entity.getRating() );

        return movieResponseDTO;
    }

    @Override
    public void updateEntityFromDTO(MovieRequestDTO dto, MovieEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getReleaseDate() != null ) {
            entity.setReleaseDate( dto.getReleaseDate() );
        }
        if ( entity.getCast() != null ) {
            List<String> list = dto.getCast();
            if ( list != null ) {
                entity.getCast().clear();
                entity.getCast().addAll( list );
            }
        }
        else {
            List<String> list = dto.getCast();
            if ( list != null ) {
                entity.setCast( new ArrayList<String>( list ) );
            }
        }
        if ( dto.getTrailer() != null ) {
            entity.setTrailer( dto.getTrailer() );
        }
        if ( dto.getImageUrl() != null ) {
            entity.setImageUrl( dto.getImageUrl() );
        }
        if ( dto.getRating() != null ) {
            entity.setRating( dto.getRating() );
        }

        linkShowtimes( entity );
    }
}
