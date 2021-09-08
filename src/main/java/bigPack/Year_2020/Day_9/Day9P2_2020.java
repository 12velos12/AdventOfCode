package bigPack.Year_2020.Day_9;

import java.util.ArrayList;
import java.util.Collections;

public class Day9P2_2020 {
    public Day9P2_2020(){
        Day9Logic logic = new Day9Logic(25);
        long invalidNum = logic.getInvalidNumber();
        ArrayList<Long> contiguousSet = logic.getContinguousSetOfLong(invalidNum);
        System.out.println(contiguousSet);
        Collections.sort(contiguousSet);
        System.out.println(contiguousSet.get(0) + contiguousSet.get(contiguousSet.size() - 1));
    }
}
