package vn.edu.likelion.movie_tickets_online_bookings.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.UserRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.UserResponse;
import vn.edu.likelion.movie_tickets_online_bookings.entity.UserEntity;
import vn.edu.likelion.movie_tickets_online_bookings.entity.enums.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T14:07:11+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private PasswordEncoderMapper passwordEncoderMapper;

    @Override
    public UserEntity toEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.password( passwordEncoderMapper.encode( userRequest.getPassword() ) );
        userEntity.name( userRequest.getName() );
        userEntity.email( userRequest.getEmail() );
        userEntity.phoneNumber( userRequest.getPhoneNumber() );

        userEntity.role( Role.USER );

        return userEntity.build();
    }

    @Override
    public UserResponse toResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( userEntity.getId() );
        userResponse.name( userEntity.getName() );
        userResponse.email( userEntity.getEmail() );
        userResponse.phoneNumber( userEntity.getPhoneNumber() );
        userResponse.createdAt( userEntity.getCreatedAt() );

        return userResponse.build();
    }
}
