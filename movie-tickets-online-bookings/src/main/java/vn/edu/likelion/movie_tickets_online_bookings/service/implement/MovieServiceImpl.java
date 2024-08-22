package vn.edu.likelion.movie_tickets_online_bookings.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.MovieRequestDTO;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.MovieResponseDTO;
import vn.edu.likelion.movie_tickets_online_bookings.entity.MovieEntity;
import vn.edu.likelion.movie_tickets_online_bookings.exception.ResourceAlreadyExistsException;
import vn.edu.likelion.movie_tickets_online_bookings.exception.ResourceNotFoundException;
import vn.edu.likelion.movie_tickets_online_bookings.mapper.MovieMapper;
import vn.edu.likelion.movie_tickets_online_bookings.repository.MovieRepo;
import vn.edu.likelion.movie_tickets_online_bookings.service.CloudinaryService;
import vn.edu.likelion.movie_tickets_online_bookings.service.MovieService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepository;
    private final MovieMapper movieMapper;
    private final CloudinaryService cloudinaryService;

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepository, MovieMapper movieMapper, CloudinaryService cloudinaryService) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public MovieResponseDTO create(MovieRequestDTO dto, MultipartFile imageFile) {
        // Check if the movie name already exists
        if (movieRepository.findByNameAndDeletedIsFalse(dto.getName()).isPresent()) {
            throw new ResourceAlreadyExistsException("A movie with the name '" + dto.getName() + "' already exists.");
        }

        // Upload the image to Cloudinary and get the URL
        String imageUrl = cloudinaryService.uploadFile(imageFile);
        dto.setImageUrl(imageUrl);

        MovieEntity entity = movieMapper.toEntity(dto);
        MovieEntity savedEntity = movieRepository.save(entity);
        return movieMapper.toResponseDTO(savedEntity);
    }


    @Override
    public MovieResponseDTO create(MovieRequestDTO movieRequestDTO) {
        return null;
    }

    @Override
    public Iterable<MovieResponseDTO> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public List<MovieResponseDTO> findAll(boolean statusInDBOfMovie, int pageNo, int pageSize, String sortBy, String sortDir) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        Page<MovieEntity> pagedResult = movieRepository.findAllByDeleted(pageRequest, statusInDBOfMovie);

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
    public MovieResponseDTO update(MovieRequestDTO dto, int id, MultipartFile imageFile) throws IOException {
        MovieEntity entity = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));

        // Check if the updated name is already taken by another movie
        Optional<MovieEntity> existingMovie = movieRepository.findByNameAndDeletedIsFalse(dto.getName());
        if (existingMovie.isPresent() && existingMovie.get().getId() != id) {
            throw new ResourceAlreadyExistsException("A movie with the name '" + dto.getName() + "' already exists.");
        }

        // Upload new image if provided and update the entity's imageUrl
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = cloudinaryService.uploadFile(imageFile);
            dto.setImageUrl(imageUrl);
        }

        // Update other fields
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
        MovieEntity entity = movieRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
        return movieMapper.toResponseDTO(entity);
    }

    @Override
    public MovieResponseDTO findByName(String name) {
        MovieEntity entity = movieRepository.findByNameAndDeletedIsFalse(name)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with name " + name));
        return movieMapper.toResponseDTO(entity);
    }
}