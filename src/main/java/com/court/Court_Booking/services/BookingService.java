package com.court.Court_Booking.services;

import com.court.Court_Booking.models.Booking;
import com.court.Court_Booking.repo.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private String[] timeSlots = {
            "10:00 AM - 11:00 AM",
            "11:00 AM - 12:00 PM",
            "12:00 PM - 1:00 PM",
            "1:00 PM - 2:00 PM",
            "2:00 PM - 3:00 PM",
            "3:00 PM - 4:00 PM",
            "4:00 PM - 5:00 PM"
    };

    @Autowired
    BookingsRepo bookingsRepo;


    public List<Booking> addBookings(List<Booking> bookings) {

        for(Booking b : bookings){
            bookingsRepo.save(b);
        }
        return bookings;
    }

    public List<String> getAvailability(String date) {
        List<String> result = new ArrayList<>();
        for(String slot : timeSlots){
            Booking b = bookingsRepo.findByBookingDateAndBookingTime(date,slot);
            if(b == null){
                result.add(slot);
            }
        }
        return result;
    }

    public List<Booking> getBookings(String userName, String mobileNumber) {
        List<Booking> bookings = bookingsRepo.findByUserNameAndMobileNumber(userName,mobileNumber);
        return bookings;
    }
}
