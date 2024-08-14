package vn.edu.likelion.movie_tickets_online_bookings.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
