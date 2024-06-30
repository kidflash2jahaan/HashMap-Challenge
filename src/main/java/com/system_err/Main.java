package com.system_err;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Location road = new Location("road", "at the end of the road", new HashMap<>());
        Location hill = new Location("hill", "on top of hill with a view in all directions", new HashMap<>());
        Location wellHouse = new Location("well house", "inside a well house for a small spring", new HashMap<>());
        Location valley = new Location("valley", "in a forest valley beside a tumbling stream", new HashMap<>());
        Location forest = new Location("forest", "at the edge of a thick dark forest", new HashMap<>());
        Location lake = new Location("lake", "by an alpine lake surrounded by wildflowers", new HashMap<>());
        Location stream = new Location("stream", "near a stream with a rocky bed", new HashMap<>());

        road.nextPlaces().putAll(Map.of('W', hill, 'E', wellHouse, 'S', valley, 'N', forest));
        hill.nextPlaces().putAll(Map.of('N', forest, 'E', road));
        wellHouse.nextPlaces().putAll(Map.of('W', road, 'N', lake, 'S', stream));
        valley.nextPlaces().putAll(Map.of('N', road, 'W', hill, 'E', stream));
        forest.nextPlaces().putAll(Map.of('S', road, 'E', lake));
        lake.nextPlaces().putAll(Map.of('W', forest, 'S', wellHouse));
        stream.nextPlaces().putAll(Map.of('W', valley, 'N', wellHouse));

        Location currentLocation = road;

        while (true) {
            currentLocation = currentLocation.move();
        }
    }
}