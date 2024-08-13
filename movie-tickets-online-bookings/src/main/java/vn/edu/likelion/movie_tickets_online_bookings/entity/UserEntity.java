package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "name", length = 255, nullable = false)
    @NonNull
    String name;

    @Column(name = "username", length = 255, unique = true, nullable = false)
    @NonNull
    String username;

    @Column(name = "password", length = 60, nullable = false)
    @NonNull
    String password;

    @Column(name = "email", length = 255, unique = true, nullable = false)
    @NonNull
    String email;

    @Column(name = "phone_number", length = 20, unique = true)
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    Role role;

    public enum Role {
        ADMIN, STAFF, CUSTOMER
    }

    @OneToMany(mappedBy = "user")
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "staff")
    private List<TicketEntity> managedTickets;

}
