package bg.uni.fmi.lab01.baseline;

import java.time.LocalDate;

public record FlightLeg(String fromAirport, String toAirport, LocalDate date) {
}
