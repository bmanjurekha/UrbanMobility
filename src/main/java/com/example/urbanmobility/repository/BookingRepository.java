package com.example.urbanmobility.repository;

import com.example.urbanmobility.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Long> {

    BookingDetails findByTripid(long id);

    @Override
    List<BookingDetails> findAll();

    void deleteByTripid(long id );
}
