package vn.edu.likelion.movie_tickets_online_bookings.service.implement;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.UserRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.UserResponse;
import vn.edu.likelion.movie_tickets_online_bookings.entity.UserEntity;
import vn.edu.likelion.movie_tickets_online_bookings.entity.enums.Role;
import vn.edu.likelion.movie_tickets_online_bookings.exception.UserException;
import vn.edu.likelion.movie_tickets_online_bookings.mapper.UserMapper;
import vn.edu.likelion.movie_tickets_online_bookings.repository.UserRepo;
import vn.edu.likelion.movie_tickets_online_bookings.service.UserService;

import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(UserRequest userRequest) {
        log.info("Performing email validation");
        if(isEmailExists(userRequest.getEmail())){
            throw new UserException("User is already exist ...!");
        }

        log.info("validating password");
        if(!matchesRegex(userRequest.getPassword())){
            throw new UserException("Invalid Password!");
        }

        UserEntity userEntity = buildUserEntity(userRequest);
        userRepo.save(userEntity);

        log.info("Registration successfully");
        return buildCustomerResponse(userEntity);

    }

    @Override
    public Iterable<UserResponse> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public UserResponse findById(int id) {
        return null;
    }

    // custom validation
    private boolean isEmailExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    private boolean matchesRegex(String input) {
        if(input.length()<8)
            return false;
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        return Pattern.compile(regex).matcher(input).matches();
    }

    private UserEntity buildUserEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail()).password(passwordEncoder.encode(userRequest.getPassword()))
                .phoneNumber(userRequest.getPhoneNumber())
                .role(Role.USER)
                .tickets(new ArrayList<>())
                .build();
    }

    private UserResponse buildCustomerResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhoneNumber())
                .createdAt(userEntity.getCreatedAt())
                .build();
    }
}
