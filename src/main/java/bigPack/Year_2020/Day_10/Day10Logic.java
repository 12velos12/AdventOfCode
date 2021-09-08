package bigPack.Year_2020.Day_10;

import bigPack.txt_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Day10Logic {
    ArrayList<Integer> inputAdapterList;

    public Day10Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_10\\PuzzleInput.txt");
        ArrayList<String> strInputList = tal.getArray();
        ArrayList<Integer> numInputList = new ArrayList<>();
        for(String numStr : strInputList){
            numInputList.add(Integer.parseInt(numStr));
        }

        this.inputAdapterList = numInputList;
    }

    public int[] getAllAdaptersChainDifference(){
        ArrayList<Integer> sortedAdapterList = copyIntArrayList(inputAdapterList);
        sortedAdapterList.add(0); //to represent outlet
        Collections.sort(sortedAdapterList);
        int[] adapterJoltageDifferences = new int[3];
        for(int i = 0; i < adapterJoltageDifferences.length; i++){
            adapterJoltageDifferences[i] = 0;
        }

        for(int i = 0; i < sortedAdapterList.size() - 1; i++){
            int adapterDifference = sortedAdapterList.get(i + 1) - sortedAdapterList.get(i);
            adapterJoltageDifferences[adapterDifference - 1]++;
        }
        adapterJoltageDifferences[2]++; //to account for device's built-in adapter

        return adapterJoltageDifferences;
    }

    public long getDistinctAdapterArrangements(){
        ArrayList<Integer> sortedAdapterList = copyIntArrayList(inputAdapterList);
        sortedAdapterList.add(0); //to represent outlet
        Collections.sort(sortedAdapterList);
        sortedAdapterList.add(sortedAdapterList.get(sortedAdapterList.size() - 1) + 3);
        ArrayList<Long> memoAdapterArrangementList = new ArrayList<>();
        for(int adapter : sortedAdapterList){
            memoAdapterArrangementList.add((long) 0);
        }
        memoAdapterArrangementList.set(memoAdapterArrangementList.size() - 1, (long) 1);

        return getDistinctAdapterArrangementsRecursion(sortedAdapterList,0, memoAdapterArrangementList);
    }

    public long getDistinctAdapterArrangementsRecursion(ArrayList<Integer> sortedAdapterList, int startIndex, ArrayList<Long> memoAdapterArrangementList){
        long numOfNextAdapters = getNumOfNextAdaptersPossible(sortedAdapterList, startIndex);
        long distinctAdapterArrangements = 0;

        if(memoAdapterArrangementList.get(startIndex) != 0){
            return memoAdapterArrangementList.get(startIndex);
        }

        for(int i = 1; i <= numOfNextAdapters; i++){
            distinctAdapterArrangements += getDistinctAdapterArrangementsRecursion(sortedAdapterList, startIndex + i, memoAdapterArrangementList);
        }

        memoAdapterArrangementList.set(startIndex, distinctAdapterArrangements);
        return distinctAdapterArrangements;
    }

    public int getNumOfNextAdaptersPossible(ArrayList<Integer> sortedAdapterList, int index){
        int indexJoltage = sortedAdapterList.get(index);
        int numOfNextAdaptersPossible = 0;

        if(index == sortedAdapterList.size() - 1){
            return 1;
        }

        for(int i = 1; i <= 3 && i + index != sortedAdapterList.size(); i++){
            if(indexJoltage + 3 >= sortedAdapterList.get(i + index)){
                numOfNextAdaptersPossible++;
            }
            else{
                break;
            }
        }

        return numOfNextAdaptersPossible;
    }

    public ArrayList<Integer> copyIntArrayList(ArrayList<Integer> inputArray){
        ArrayList<Integer> arrayCopy = new ArrayList<>();
        for(int value : inputArray){
            arrayCopy.add(value);
        }
        return arrayCopy;
    }
}
