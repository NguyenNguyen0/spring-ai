package main.springai.service;

import main.springai.model.BookingDetails;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Tool(name = "getBookingDetails", description = "Get Booking detail by booking number and user name.")
    public BookingDetails getBookingDetails(@ToolParam(description = "booking id") String number, @ToolParam(description = "user first name") String first, @ToolParam(description = "user last name") String last) {
        return new BookingDetails(number, first, last, "Hanoi", "Tokyo", "2025-11-05");
    }

    @Tool(name = "changeBooking", description = "Change booking destination")
    public String changeBooking(@ToolParam(description = "booking id") String bookingNumber, @ToolParam(description = "new destination") String newDestination) {
        // Mock logic for changing booking
        return "Booking " + bookingNumber + " has been successfully changed to destination: " + newDestination;
    }

    @Tool(name = "cancelBooking", description = "Cancel a fly booking")
    public String cancelBooking(@ToolParam(description = "booking id") String bookingNumber) {
        // Mock logic for canceling booking
        return "Booking " + bookingNumber + " has been successfully cancelled. Refund will be processed within 3-5 business days.";
    }
}
