package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.edu.likelion.movie_tickets_online_bookings.enums.Role;

import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column( name = "name", nullable = false )
    String name;

    @Column( name = "username", unique = true, nullable = false )
    String username;

    @Column( name = "password", nullable = false )
    String password;

    @Column( name = "email", unique = true, nullable = false )
    String email;

    @Column( name = "phone_number", unique = true )
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany( mappedBy = "user", fetch = FetchType.EAGER )
    List<TicketEntity> tickets;

}
