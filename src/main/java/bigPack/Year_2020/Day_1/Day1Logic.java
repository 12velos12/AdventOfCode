package bigPack.Year_2020.Day_1;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day1Logic {

    public int sumOfTwoEquals(int sumTarget){
        int[] sumNums = findSumTwoNums(sumTarget);
        return sumNums[0] * sumNums[1];
    }

    public int[] findSumTwoNums(int sumTarget){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_1\\puzzleInput.txt");
        ArrayList<String> numList = tal.getArray();
        int[] sumNums = new int[2];

        for(int i = 0; i < numList.size(); i++){
            for(int j = i+1; j < numList.size(); j++){
                if(Integer.parseInt(numList.get(i)) + Integer.parseInt(numList.get(j)) == sumTarget) {
                    sumNums[0] = Integer.parseInt(numList.get(i));
                    sumNums[1] = Integer.parseInt(numList.get(j));
                    return sumNums;
                }
            }
        }

        return sumNums;
    }

    public int sumOfThreeEquals(int sumTarget){
        int[] sumNums = findSumThreeNums(sumTarget);
        return sumNums[0] * sumNums[1] * sumNums[2];
    }

    public int[] findSumThreeNums(int sumTarget){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_1\\puzzleInput.txt");
        ArrayList<String> numList = tal.getArray();
        int[] sumNums = new int[3];

        for(int i = 0; i < numList.size(); i++){
            for(int j = i+1; j < numList.size(); j++){
                for(int k = j+1; k < numList.size(); k++){
                    if(Integer.parseInt(numList.get(i)) + Integer.parseInt(numList.get(j)) + Integer.parseInt(numList.get(k)) == sumTarget) {
                        sumNums[0] = Integer.parseInt(numList.get(i));
                        sumNums[1] = Integer.parseInt(numList.get(j));
                        sumNums[2] = Integer.parseInt(numList.get(k));
                        return sumNums;
                    }

                }
            }
        }

        return sumNums;
    }

    public void printInput(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_1\\Example1Input.txt");
        ArrayList<String> input = tal.getArray();

        for(int i = 0; i < input.size(); i++){
            System.out.println(input.get(i));
        }
    }
}
