package com.court.Court_Booking.controllers;


import com.court.Court_Booking.models.Booking;
import com.court.Court_Booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://ritesh-kumar-verma.github.io/court-booking/"
})
public class BookingsController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/getavailability")
    public List<String> getAvailability(@RequestBody Map<String,String> body){

        String date = body.get("date");

        return bookingService.getAvailability(date);
    }

    @PostMapping("/addbookings")
    public List<Booking> addBookings(@RequestBody List<Booking> bookings){

        return bookingService.addBookings(bookings);

    }

    @PostMapping("/getbookings")
    public List<Booking> getBookings(@RequestBody Map<String , String> body){
        String userName = body.get("userName");
        String mobileNumber = body.get("mob");
        return bookingService.getBookings(userName,mobileNumber);


    }

}
