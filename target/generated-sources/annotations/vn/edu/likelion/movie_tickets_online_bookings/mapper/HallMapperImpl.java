package vn.edu.likelion.movie_tickets_online_bookings.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.HallRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.HallResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.entity.HallEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T10:29:01+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class HallMapperImpl implements HallMapper {

    @Override
    public HallEntity toEntity(HallRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        HallEntity hallEntity = new HallEntity();

        hallEntity.setName( dto.getName() );
        hallEntity.setCapacity( dto.getCapacity() );

        return hallEntity;
    }

    @Override
    public HallResponseDTO toResponseDTO(HallEntity entity) {
        if ( entity == null ) {
            return null;
        }

        HallResponseDTO hallResponseDTO = new HallResponseDTO();

        hallResponseDTO.setId( entity.getId() );
        hallResponseDTO.setName( entity.getName() );
        hallResponseDTO.setCapacity( entity.getCapacity() );

        return hallResponseDTO;
    }

    @Override
    public void updateEntityFromDTO(HallRequestDTO dto, HallEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        entity.setCapacity( dto.getCapacity() );
    }
}
