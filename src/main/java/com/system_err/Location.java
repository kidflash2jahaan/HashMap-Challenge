package com.system_err;

import java.util.Map;
import java.util.Scanner;

public record Location(String name, String description, Map<Character, Location> nextPlaces) {
    public Location move() {
        StringBuilder details = new StringBuilder();
        details.append("\n\n*** You're standing ").append(description).append(" ***\n").append("From here, you can see:\n");

        nextPlaces.forEach((direction, place) -> {
            String directionFull = switch (direction) {
                case ('N') -> "North";
                case ('E') -> "East";
                case ('S') -> "South";
                case ('W') -> "West";
                default -> throw new IllegalArgumentException("Invalid direction: " + direction);
            };

            details.append("- A ").append(place.name).append(" to the ").append(directionFull).append(" (").append(direction).append(")\n");
        });

        details.append("Select Your Compass Direction (Q to quit) >> ");
        System.out.print(details);

        char directionToGo = new Scanner(System.in).next().toUpperCase().charAt(0);
        if (nextPlaces.containsKey(directionToGo)) {
            return nextPlaces.get(directionToGo);
        } else if (directionToGo == 'Q') {
            System.exit(0);
        } else {
            throw new IllegalArgumentException("Invalid direction: " + directionToGo);
        }
        
        return null;
    }
}
