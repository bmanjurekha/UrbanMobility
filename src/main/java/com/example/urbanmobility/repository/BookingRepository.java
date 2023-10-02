package com.example.urbanmobility.repository;

import com.example.urbanmobility.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Long> {

    BookingDetails findByTripid(long id);

    void deleteByTripid(long id );
}
