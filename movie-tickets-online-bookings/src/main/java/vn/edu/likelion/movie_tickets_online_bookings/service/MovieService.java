package vn.edu.likelion.movie_tickets_online_bookings.service;

import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;

import java.util.List;

public interface MovieService extends BaseService<MovieRequestDTO, MovieResponseDTO> {
    List<MovieResponseDTO> findAll(boolean statusInDBOfMovie, int pageNo, int pageSize, String sortBy, String sortDir);
    MovieResponseDTO update(MovieRequestDTO dto, int id);
}
