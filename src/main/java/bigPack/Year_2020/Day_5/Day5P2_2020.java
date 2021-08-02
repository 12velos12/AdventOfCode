package bigPack.Year_2020.Day_5;

public class Day5P2_2020 {
    public Day5P2_2020(){
        Day5Logic logic = new Day5Logic();
        System.out.println(logic.getMissingSeatID(logic.generateSeatIDList()));
    }
}
