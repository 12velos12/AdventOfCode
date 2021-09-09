package bigPack.Year_2020.Day_11;

import java.util.ArrayList;

public class Ferry {
    ArrayList<String> ferryLayout;

    public Ferry(ArrayList<String> ferryLayout){
        this.ferryLayout = ferryLayout;
    }

    public ArrayList<String> getFerryLayout() {
        return ferryLayout;
    }

    public int getRowLength(){
        return ferryLayout.get(0).length();
    }

    public int getColLength(){
        return ferryLayout.size();
    }

    public void occupySeat(int row, int col){
        String ferryRow = ferryLayout.get(row);
        char[] ferryRowArray = ferryRow.toCharArray();
        ferryRowArray[col] = '#';
        ferryRow = "";
        for(char spot : ferryRowArray){
            ferryRow += spot;
        }
        ferryLayout.set(row, ferryRow);
    }

    public void emptySeat(int row, int col){
        String ferryRow = ferryLayout.get(row);
        char[] ferryRowArray = ferryRow.toCharArray();
        ferryRowArray[col] = 'L';
        ferryRow = "";
        for(char spot : ferryRowArray){
            ferryRow += spot;
        }
        ferryLayout.set(row, ferryRow);
    }

    public boolean seatIsEmpty(int row, int col){
        String ferryRow = ferryLayout.get(row);
        char[] ferryRowArray = ferryRow.toCharArray();
        return ferryRowArray[col] == 'L';
    }

    public boolean seatIsOccupied(int row, int col){
        String ferryRow = ferryLayout.get(row);
        char[] ferryRowArray = ferryRow.toCharArray();
        return ferryRowArray[col] == '#';
    }

    public boolean seatExists(int row, int col){
        String ferryRow = ferryLayout.get(row);
        char[] ferryRowArray = ferryRow.toCharArray();
        return ferryRowArray[col] != '.';
    }

    public int seatNeighborAmount(int row, int col){
        int neighborAmount = 0;

        try{ //Above
            if(seatIsOccupied(row - 1, col - 1))
                neighborAmount++;
        } catch (Exception e) {}
        try{
            if(seatIsOccupied(row - 1, col))
                neighborAmount++;
        } catch (Exception e) {}
        try{
            if(seatIsOccupied(row - 1, col + 1))
                neighborAmount++;
        } catch (Exception e) {}

        try{ //Below
            if(seatIsOccupied(row + 1, col - 1))
                neighborAmount++;
        } catch (Exception e) {}
        try{
            if(seatIsOccupied(row + 1, col))
                neighborAmount++;
        } catch (Exception e) {}
        try{
            if(seatIsOccupied(row + 1, col + 1))
                neighborAmount++;
        } catch (Exception e) {}

        try{ //Left and Right
            if(seatIsOccupied(row, col - 1))
                neighborAmount++;
        } catch (Exception e) {}
        try{
            if(seatIsOccupied(row, col + 1))
                neighborAmount++;
        } catch (Exception e) {}

        return neighborAmount;
    }

    public int visibleOccupiedSeatsAmount(int row, int col){
        int visibleOccupiedSeatsAmount = 0;
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row + i, col)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row + i, col)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row - i, col)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row - i, col)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row, col + i)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row, col + i)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row, col - i)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row, col - i)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row + i, col + i)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row + i, col + i)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row - i, col + i)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row - i, col + i)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row - i, col - i)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row - i, col - i)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}
        try{
            int i = 1;
            while(true){
                if(seatIsOccupied(row + i, col - i)){
                    visibleOccupiedSeatsAmount++;
                    break;
                }
                else if(seatIsEmpty(row + i, col - i)){
                    break;
                }
                i++;
            }
        } catch (Exception e) {}

        return visibleOccupiedSeatsAmount;
    }

    public int totalOccupiedSeats(){
        int totalOccupiedSeats = 0;

        for(String row : ferryLayout){
            char[] rowArray = row.toCharArray();
            for(char seat : rowArray){
                if(seat == '#'){
                    totalOccupiedSeats++;
                }
            }
        }

        return totalOccupiedSeats;
    }

    public Ferry advanceRoundP1(){
        Ferry nextFerry = copyFerry();
        for(int row = 0; row < ferryLayout.size(); row++){
            for(int col = 0; col < ferryLayout.get(0).length(); col++){
                if(!seatExists(row, col)){
                    continue;
                }
                if(seatIsEmpty(row,col) && seatNeighborAmount(row,col) == 0){
                    nextFerry.occupySeat(row,col);
                }
                else if(seatIsOccupied(row,col) && seatNeighborAmount(row,col) >= 4){
                    nextFerry.emptySeat(row,col);
                }
            }
        }

        ferryLayout = nextFerry.getFerryLayout();
        return copyFerry();
    }

    public Ferry advanceRoundP2(){
        Ferry nextFerry = copyFerry();
        for(int row = 0; row < ferryLayout.size(); row++){
            for(int col = 0; col < ferryLayout.get(0).length(); col++){
                if(!seatExists(row, col)){
                    continue;
                }
                if(seatIsEmpty(row,col) && visibleOccupiedSeatsAmount(row,col) == 0){
                    nextFerry.occupySeat(row,col);
                }
                else if(seatIsOccupied(row,col) && visibleOccupiedSeatsAmount(row,col) >= 5){
                    nextFerry.emptySeat(row,col);
                }
            }
        }

        ferryLayout = nextFerry.getFerryLayout();
        return copyFerry();
    }

    public Ferry copyFerry(){
        ArrayList<String> ferryLayout = new ArrayList<>();
        for(String row : this.ferryLayout){
            ferryLayout.add(row);
        }
        return new Ferry(ferryLayout);
    }

    public boolean equals(Ferry inputFerry){
        if(ferryLayout.size() != inputFerry.getFerryLayout().size()){
            return false;
        }

        for(int i = 0; i < ferryLayout.size(); i++){
            if(!ferryLayout.get(i).equals(inputFerry.getFerryLayout().get(i))){
                return false;
            }
        }

        return true;
    }
}
