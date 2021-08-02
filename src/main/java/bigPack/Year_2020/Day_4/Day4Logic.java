package bigPack.Year_2020.Day_4;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day4Logic {
    private ArrayList<String> rawPassportList = new ArrayList<>();
    private ArrayList<String> PassportList = new ArrayList<>();

    public ArrayList<String> getRawPassportList() {
        return rawPassportList;
    }
    public void setRawPassportList(ArrayList<String> rawPassportList) {
        this.rawPassportList = rawPassportList;
    }

    public ArrayList<String> getPassportList() { return PassportList; }
    public void setPassportList(ArrayList<String> passportList) {
        PassportList = passportList;
    }

    public Day4Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_4\\PuzzleInput.txt");
        setRawPassportList(tal.getArray());
        setPassportList(rawPassportList_PassportList());
    }

    public ArrayList<String> rawPassportList_PassportList(){
        ArrayList<String> PassportList = new ArrayList<>();
        String passportLine = "";

        for(String Line : rawPassportList){
            if(Line.isEmpty() && passportLine != ""){
                passportLine.trim();
                PassportList.add(passportLine);
                passportLine = "";
                continue;
            }

            if(passportLine != "")
                passportLine += " ";
            passportLine += Line;
        }

        if(!passportLine.isEmpty())
            PassportList.add(passportLine);

        return PassportList;
    }

    public int numValidPassportsP1(){
        int validPassports = 0;

        for(String passportFields : getPassportList()){
            Passport passport = new Passport(passportFields);
            if(passport.hasAllFields())
                validPassports++;
        }

        return validPassports;
    }
    public int numValidPassportsP2(){
        int validPassports = 0;

        for(String passportFields : getPassportList()){
            Passport passport = new Passport(passportFields);
            if(passport.isValid())
                validPassports++;
        }

        return validPassports;
    }

    public void printPassports(){
        for(String passportFields : getPassportList()){
            Passport passport = new Passport(passportFields);
            passport.printPassport();
        }
    }
}
