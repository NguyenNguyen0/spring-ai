package main.springai.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDetails {
    private String number;
    private String firstName;
    private String lastName;
    private String from;
    private String to;
    private String date;
}
