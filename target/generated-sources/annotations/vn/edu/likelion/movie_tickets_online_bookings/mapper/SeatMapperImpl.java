package vn.edu.likelion.movie_tickets_online_bookings.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.SeatRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.SeatResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.entity.HallEntity;
import vn.edu.likelion.movie_tickets_online_bookings.entity.SeatEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-19T09:30:40+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class SeatMapperImpl implements SeatMapper {

    @Override
    public SeatEntity toEntity(SeatRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SeatEntity seatEntity = new SeatEntity();

        seatEntity.setHall( seatRequestDTOToHallEntity( dto ) );
        seatEntity.setSeatNumber( dto.getSeatNumber() );

        return seatEntity;
    }

    @Override
    public SeatResponseDTO toResponseDTO(SeatEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SeatResponseDTO seatResponseDTO = new SeatResponseDTO();

        seatResponseDTO.setHallId( entityHallId( entity ) );
        seatResponseDTO.setId( entity.getId() );
        seatResponseDTO.setSeatNumber( entity.getSeatNumber() );

        return seatResponseDTO;
    }

    @Override
    public void updateEntityFromDTO(SeatRequestDTO dto, SeatEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( entity.getHall() == null ) {
            entity.setHall( new HallEntity() );
        }
        seatRequestDTOToHallEntity1( dto, entity.getHall() );
        if ( dto.getSeatNumber() != null ) {
            entity.setSeatNumber( dto.getSeatNumber() );
        }
    }

    protected HallEntity seatRequestDTOToHallEntity(SeatRequestDTO seatRequestDTO) {
        if ( seatRequestDTO == null ) {
            return null;
        }

        HallEntity hallEntity = new HallEntity();

        if ( seatRequestDTO.getHallId() != null ) {
            hallEntity.setId( seatRequestDTO.getHallId() );
        }

        return hallEntity;
    }

    private int entityHallId(SeatEntity seatEntity) {
        if ( seatEntity == null ) {
            return 0;
        }
        HallEntity hall = seatEntity.getHall();
        if ( hall == null ) {
            return 0;
        }
        int id = hall.getId();
        return id;
    }

    protected void seatRequestDTOToHallEntity1(SeatRequestDTO seatRequestDTO, HallEntity mappingTarget) {
        if ( seatRequestDTO == null ) {
            return;
        }

        if ( seatRequestDTO.getHallId() != null ) {
            mappingTarget.setId( seatRequestDTO.getHallId() );
        }
    }
}
