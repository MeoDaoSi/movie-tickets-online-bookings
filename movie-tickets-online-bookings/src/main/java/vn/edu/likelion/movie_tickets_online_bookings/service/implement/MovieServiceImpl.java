package vn.edu.likelion.movie_tickets_online_bookings.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.entity.MovieEntity;
import vn.edu.likelion.movie_tickets_online_bookings.exception.ResourceNotFoundException;
import vn.edu.likelion.movie_tickets_online_bookings.mapper.MovieMapper;
import vn.edu.likelion.movie_tickets_online_bookings.repository.MovieRepo;
import vn.edu.likelion.movie_tickets_online_bookings.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieResponseDTO create(MovieRequestDTO dto) {
        MovieEntity entity = movieMapper.toEntity(dto);
        MovieEntity savedEntity = movieRepository.save(entity);
        return movieMapper.toResponseDTO(savedEntity);
    }

    @Override
    public Iterable<MovieResponseDTO> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public List<MovieResponseDTO> findAll(boolean statusInDBOfMovie, int pageNo, int pageSize, String sortBy, String sortDir) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        Page<MovieEntity> pagedResult = movieRepository.findAllByIsDeleted(pageRequest, statusInDBOfMovie);

        return pagedResult
                .stream()
                .map(movieMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponseDTO update(MovieRequestDTO movieRequestDTO) {
        return null;
    }

    @Override
    public MovieResponseDTO update(MovieRequestDTO dto, int id) {
        MovieEntity entity = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));

        movieMapper.updateEntityFromDTO(dto, entity);
        MovieEntity updatedEntity = movieRepository.save(entity);
        return movieMapper.toResponseDTO(updatedEntity);
    }

    @Override
    public void delete(int id) {
        MovieEntity entity = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
        entity.setDeleted(true);
        movieRepository.save(entity);
    }

    @Override
    public MovieResponseDTO findById(int id) {
        MovieEntity entity = movieRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
        return movieMapper.toResponseDTO(entity);
    }
}
