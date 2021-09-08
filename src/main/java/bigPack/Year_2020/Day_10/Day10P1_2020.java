package bigPack.Year_2020.Day_10;

import java.util.Arrays;

public class Day10P1_2020 {
    public Day10P1_2020(){
        Day10Logic logic = new Day10Logic();
        int[] differences = logic.getAllAdaptersChainDifference();
        System.out.println(Arrays.toString(differences));
        System.out.println(differences[0] * differences[2]);
    }
}
