package main.springai.service;

import main.springai.model.BookingDetails;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    public BookingDetails getBookingDetails(String number, String first, String last) {
        return new BookingDetails(number, first, last, "Hanoi", "Tokyo", "2025-11-05");
    }

    public String changeBooking(String bookingNumber, String newDestination) {
        // Mock logic for changing booking
        return "Booking " + bookingNumber + " has been successfully changed to destination: " + newDestination;
    }

    public String cancelBooking(String bookingNumber) {
        // Mock logic for canceling booking
        return "Booking " + bookingNumber + " has been successfully cancelled. Refund will be processed within 3-5 business days.";
    }
}
