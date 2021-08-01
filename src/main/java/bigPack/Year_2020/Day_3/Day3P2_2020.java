package bigPack.Year_2020.Day_3;

public class Day3P2_2020 {
    public Day3P2_2020(){
        Day3Logic logic = new Day3Logic();

        int p2Answer = 0;
        p2Answer = logic.getTreesOnSlope(1, 1);
        p2Answer *= logic.getTreesOnSlope(3, 1);
        p2Answer *= logic.getTreesOnSlope(5, 1);
        p2Answer *= logic.getTreesOnSlope(7, 1);
        p2Answer *= logic.getTreesOnSlope(1, 2);
        System.out.println(p2Answer);
    }
}
