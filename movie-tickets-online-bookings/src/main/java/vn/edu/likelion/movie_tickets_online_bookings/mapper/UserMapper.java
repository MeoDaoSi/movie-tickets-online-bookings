package vn.edu.likelion.movie_tickets_online_bookings.mapper;

import org.mapstruct.Mapper;
import vn.edu.likelion.movie_tickets_online_bookings.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}
