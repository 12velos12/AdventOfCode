package bigPack.Year_2020.Day_9;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day9Logic {
    ArrayList<Long> longInputList;
    int preambleLength;

    Day9Logic(int preambleLength){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_9\\PuzzleInput.txt");
        ArrayList<String> strInputList = tal.getArray();
        ArrayList<Long> numInputList = new ArrayList<>();
        for(String numStr : strInputList){
            numInputList.add(Long.parseLong(numStr));
        }

        this.preambleLength = preambleLength;
        this.longInputList = numInputList;
    }

    public long getInvalidNumber(){
        for(int i = preambleLength; i < longInputList.size(); i++){
            if(indexIsInvalid(i)){
                return longInputList.get(i);
            }
        }

        throw new IllegalArgumentException("No invalid number found.");
    }

    private boolean indexIsInvalid(int index){
        long inputValue = longInputList.get(index);

        for(int i = index - preambleLength; i < index - 1; i++){
            long expectedValue = inputValue - longInputList.get(i);
            for(int j = i + 1; j < index; j++){
                if(expectedValue == longInputList.get(j)){
                    return false;
                }
            }
        }

        return true;
    }

    public ArrayList<Long> getContinguousSetOfLong(long inputLong){
        for(int currIndex = 0; currIndex < longInputList.size() - 1; currIndex++) {
            ArrayList<Long> contiguousList = new ArrayList<>();
            long contiguousSum = longInputList.get(currIndex);
            contiguousList.add(longInputList.get(currIndex));
            for(int i = currIndex + 1; i < longInputList.size() && contiguousSum < inputLong; i++){
                contiguousSum += longInputList.get(i);
                contiguousList.add(longInputList.get(i));
            }
            if(contiguousSum == inputLong){
                return contiguousList;
            }
        }

        throw new IllegalArgumentException("No contiguous set found.");
    }
}
