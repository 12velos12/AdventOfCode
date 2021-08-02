package bigPack.Year_2020.Day_5;

import bigPack.txt_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Day5Logic {
    ArrayList<String> boardingPassList;
    private static final int minRow = 0, maxRow = 127;
    private static final int minCol = 0, maxCol = 7;

    public ArrayList<String> getBoardingPassList() {
        return boardingPassList;
    }
    public void setBoardingPassList(ArrayList<String> boardingPassList) {
        this.boardingPassList = boardingPassList;
    }

    public Day5Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_5\\PuzzleInput.txt");
        setBoardingPassList(tal.getArray());
    }

    public int generateSeatRow(String seatLocation){
        int currentMinRow = minRow, currentMaxRow = maxRow;

        for(int i = 0; currentMinRow != currentMaxRow; i++){
            if(seatLocation.charAt(i) == 'F'){
                currentMaxRow -= (currentMaxRow-currentMinRow)/2 + 1;
            }
            else if(seatLocation.charAt(i) == 'B'){
                currentMinRow += (currentMaxRow-currentMinRow)/2 + 1;
            }
            else{
                System.out.println("Error: GenerateSeatRow() - SeatLocation char: " + seatLocation.charAt(i) + " not recognized");
            }
        }

        return currentMinRow;
    }

    public int generateSeatCol(String seatLocation){
        int currentMinCol = minCol, currentMaxCol= maxCol;
        seatLocation = seatLocation.substring(7); //This will need to change if size of plane is variable

        for(int i = 0; currentMinCol != currentMaxCol; i++){
            if(seatLocation.charAt(i) == 'L'){
                currentMaxCol -= (currentMaxCol-currentMinCol)/2 + 1;
            }
            else if(seatLocation.charAt(i) == 'R'){
                currentMinCol += (currentMaxCol-currentMinCol)/2 + 1;
            }
            else{
                System.out.println("Error: generateColRow() - SeatLocation char: " + seatLocation.charAt(i) + " not recognized");
            }
        }

        return currentMinCol;
    }

    public int generateSeatID(String seatLocation){
        int seatRow = generateSeatRow(seatLocation);
        int seatCol = generateSeatCol(seatLocation);
        return seatRow * 8 + seatCol;
    }

    public int getHighestSeatID(){
        int highestSeatID = Integer.MIN_VALUE;

        for (String seatLocation : getBoardingPassList()){
            int currentSeatID = generateSeatID(seatLocation);

            if (highestSeatID < currentSeatID)
                highestSeatID = currentSeatID;
        }

        return highestSeatID;
    }

    public ArrayList<Integer> generateSeatIDList(){
        ArrayList<Integer> seatIDList = new ArrayList<>();

        for (String seatLocation : getBoardingPassList()){
            int currentSeatID = generateSeatID(seatLocation);
            seatIDList.add(currentSeatID);
        }
        Collections.sort(seatIDList);

        return seatIDList;
    }

    public int getMissingSeatID(ArrayList<Integer> seatIDList){
        int currentSeatID = seatIDList.get(0);

        for(int i = 0; i < seatIDList.size(); i++){
            if(seatIDList.get(i) != currentSeatID)
                return currentSeatID;
            currentSeatID++;
        }

        System.out.println("Error: getMissingSeatID() - Could not find missing seatID");
        return -1;
    }
}
