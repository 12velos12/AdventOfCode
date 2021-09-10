package bigPack.Year_2020.Day_12;

public class Day12P2_2020 {
    public Day12P2_2020(){
        Day12Logic logic = new Day12Logic();
        Ship ship = logic.followWaypoint();
        System.out.println(logic.getManhattanDistance(ship));
    }
}
