package bigPack.Year_2020.Day_11;

import bigPack.txt_ArrayList;

public class Day11Logic {
    Ferry ferry;

    public Day11Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_11\\PuzzleInput.txt");
        Ferry ferry = new Ferry(tal.getArray());
        this.ferry = ferry;
    }

    public int musicalChairsP1(){
        Ferry prevRoundFerry;
        do{
            prevRoundFerry = ferry.copyFerry();
            ferry.advanceRoundP1();
        }while(!ferry.equals(prevRoundFerry));

        return ferry.totalOccupiedSeats();
    }

    public int musicalChairsP2(){
        Ferry prevRoundFerry;
        do{
            prevRoundFerry = ferry.copyFerry();
            ferry.advanceRoundP2();
        }while(!ferry.equals(prevRoundFerry));

        return ferry.totalOccupiedSeats();
    }

}
