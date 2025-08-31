package com.court.Court_Booking.repo;

import com.court.Court_Booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingsRepo extends JpaRepository<Booking,Integer > {
    Booking findByBookingDateAndBookingTime(String bookingDate, String bookingTime);

    List<Booking> findByUserNameAndMobileNumber(String userName, String mobileNumber);
}
