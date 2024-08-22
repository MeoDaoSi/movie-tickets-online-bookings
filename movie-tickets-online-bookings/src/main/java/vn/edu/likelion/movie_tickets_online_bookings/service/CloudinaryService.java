package vn.edu.likelion.movie_tickets_online_bookings.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadFile(MultipartFile multipartFile);
}
