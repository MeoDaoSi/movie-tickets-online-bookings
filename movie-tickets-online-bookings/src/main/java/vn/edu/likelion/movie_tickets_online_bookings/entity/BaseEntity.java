package vn.edu.likelion.movie_tickets_online_bookings.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@MappedSuperclass
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = true, updatable = false)
    LocalDate createTime = LocalDate.now();

    @Column(nullable = true, insertable = false)
    LocalDate updateTime;

    @Column
    int isDeleted;
}
