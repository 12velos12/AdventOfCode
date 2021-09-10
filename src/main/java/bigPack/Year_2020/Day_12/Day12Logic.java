package bigPack.Year_2020.Day_12;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day12Logic {
    ArrayList<Direction> directionsInput;

    public Day12Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_12\\PuzzleInput.txt");
        ArrayList<String> rawDirectionsInput = tal.getArray();
        ArrayList<Direction> directionsInput = new ArrayList<>();

        for(String directionString : rawDirectionsInput){
            directionsInput.add(new Direction(directionString));
        }

        this.directionsInput = directionsInput;
    }

    public Ship followPath(){
        Ship ship = new Ship();

        for(Direction direction: directionsInput){
            ship.move(direction);
//            System.out.println("Latitude: " + ship.currLatitude + ", Longitude: " + ship.currLongitude);
        }

        return ship;
    }

    public Ship followWaypoint(){
        Ship ship = new Ship();
        Waypoint waypoint = new Waypoint();

        for(Direction direction: directionsInput){
            waypoint.move(direction, ship);
//            System.out.println("WLatitude: " + waypoint.getCurrLatitude() + ", WLongitude: " + waypoint.getCurrLongitude());
//            System.out.println("SLatitude: " + ship.getCurrLatitude() + ", SLongitude: " + ship.getCurrLongitude());
        }

        return ship;
    }

    public int getManhattanDistance(Ship ship){
        return Math.abs(ship.getCurrLatitude()) + Math.abs(ship.getCurrLongitude());
    }
}
