package vn.edu.likelion.movie_tickets_online_bookings.service;

import org.springframework.web.multipart.MultipartFile;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;

import java.io.IOException;
import java.util.List;

public interface MovieService extends BaseService<MovieRequestDTO, MovieResponseDTO> {
    List<MovieResponseDTO> findAll(boolean statusInDBOfMovie, int pageNo, int pageSize, String sortBy, String sortDir);
    MovieResponseDTO update(MovieRequestDTO dto, int id, MultipartFile imageFile) throws IOException;
//    MovieResponseDTO findByName(String name);
    MovieResponseDTO create(MovieRequestDTO dto, MultipartFile imageFile);
    List<MovieResponseDTO> findByName(String name);
}
