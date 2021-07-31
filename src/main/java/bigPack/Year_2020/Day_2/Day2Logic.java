package bigPack.Year_2020.Day_2;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day2Logic {
    private ArrayList<String> passwordArray;

    public Day2Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_2\\PuzzleInput.txt");
        setPasswordArray(tal.getArray());
    }

    public ArrayList<String> getPasswordArray(){
        return this.passwordArray;
    }
    private void setPasswordArray(ArrayList<String> passwordArray) {
        this.passwordArray = passwordArray;
    }

    public int getValidPasswordAmountP1(){
        int validPasswordAmount = 0;

        for(String passwordMetaString: passwordArray){
            PasswordMeta passwordMeta = new PasswordMeta(passwordMetaString);
            if(passwordMeta.isValidPasswordP1())
                validPasswordAmount++;
        }

        return validPasswordAmount;
    }

    public int getValidPasswordAmountP2(){
        int validPasswordAmount = 0;

        for(String passwordMetaString: passwordArray){
            PasswordMeta passwordMeta = new PasswordMeta(passwordMetaString);
            if(passwordMeta.isValidPasswordP2())
                validPasswordAmount++;
        }

        return validPasswordAmount;
    }
}
