package bigPack.Year_2020.Day_3;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day3Logic {
    private ArrayList<String> map = new ArrayList<>();

    public ArrayList<String> getMap() {
        return map;
    }
    public void setMap(ArrayList<String> map) {
        this.map = map;
    }

    public Day3Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_3\\PuzzleInput.txt");
        setMap(tal.getArray());
    }

    public int getMapRowSize(){
        return map.get(0).length();
    }
    public int getMapColSize(){
        return map.size();
    }

    public int getTreesOnSlope(int slopeRow, int slopeCol){
        int currentRow = 0, currentCol = 0, treesOnSlope = 0;

        while(currentCol < getMapColSize()){
            if(charIsTree(map.get(currentCol).charAt(currentRow)))
                treesOnSlope++;

            currentRow += slopeRow;
            currentCol += slopeCol;

            if(currentRow >= getMapRowSize())
                currentRow = currentRow - getMapRowSize();
        }

        return treesOnSlope;
    }

    public boolean charIsTree(char potentialTree){
        return potentialTree == '#';
    }
}
