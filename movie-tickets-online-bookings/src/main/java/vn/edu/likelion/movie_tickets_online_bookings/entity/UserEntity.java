package vn.edu.likelion.movie_tickets_online_bookings.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.edu.likelion.movie_tickets_online_bookings.entity.enums.Role;

import java.util.List;

@EqualsAndHashCode( callSuper = false )
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NonNull
    String name;

    @Column(name = "password", length = 60, nullable = false)
    @NonNull
    String password;

    @Column(name = "email", unique = true, nullable = false)
    @NonNull
    String email;

    @Column(name = "phone_number", unique = true)
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<TicketEntity> tickets;
}
