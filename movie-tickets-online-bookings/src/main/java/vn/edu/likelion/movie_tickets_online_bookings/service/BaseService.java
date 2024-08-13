package vn.edu.likelion.movie_tickets_online_bookings.service;

public interface BaseService<T> {
    T create(T t);
    Iterable<T> findAll(int pageNo, int pageSize, String sortBy, String sortDir);
    T update(T t);
    void delete(int id);
    T findById(int id);
}
