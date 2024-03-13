package bg.uni.fmi.lab01.baseline;


import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;

public class Flights {
    Map<String, List<FlightLeg>> flights;

    public Flights() {
        flights = new HashMap<>();
    }

    public void addFlight(String aircraft, FlightLeg leg) {
        if (aircraft == null || leg == null) {
            throw new NullPointerException();
        }

        if(flights.get(aircraft) == null) {
            List<FlightLeg> list = new ArrayList<>();
            list.add(leg);
            flights.putIfAbsent(aircraft, list);
        }else {
            flights.get(aircraft).add(leg);
        }

        //Alternative solution
        //flights.computeIfAbsent(aircraft, k -> new ArrayList<>()).add(leg);

    }

    public List<FlightLeg> extractFrom(String fromAirport) {
        List<FlightLeg> res = new ArrayList<>();

        for (var cur : flights.keySet()) {
            for (var cur_flight : flights.get(cur)) {
                if (cur_flight.fromAirport().equals(fromAirport)) {
                    res.add(cur_flight);
                }
            }
        }

        return res;
    }

    public List<FlightLeg> extractTo(String toAirport) {
        List<FlightLeg> res = new ArrayList<>();

        for (var cur : flights.keySet()) {
            for (var cur_flight : flights.get(cur)) {
                if (cur_flight.toAirport().equals(toAirport)) {
                    res.add(cur_flight);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Flights flights = new Flights();
        LocalDate date = LocalDate.of(2024, 12, 31);

        flights.addFlight("pedal", new FlightLeg("SS", "SO", date));
        flights.addFlight("pedal", new FlightLeg("SS", "SL", date));
        flights.addFlight("pedal", new FlightLeg("SS", "SA", date));

        System.out.println(flights.extractTo("SO"));
    }
}
