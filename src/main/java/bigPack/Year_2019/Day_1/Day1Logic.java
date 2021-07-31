package bigPack.Year_2019.Day_1;

import bigPack.txt_ArrayList;

import java.util.ArrayList;

public class Day1Logic {
    public ArrayList<Integer> generateModuleList(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2019\\Day_1\\puzzleInput.txt");
        ArrayList<String> stringModuleList = tal.getArray();
        ArrayList<Integer> moduleList = new ArrayList<Integer>();

        for(String module : stringModuleList){
            moduleList.add(Integer.parseInt(module));
        }

        return moduleList;
    }

    public int calculateFuelForModulesP1(){
        int fuelSum = 0;
        ArrayList<Integer> moduleList = generateModuleList();

        for(int module : moduleList){
            fuelSum += calculateFuelForModule(module);
        }

        return fuelSum;
    }

    public int calculateFuelForModule(int module){
        return (int)Math.floor(module/3) - 2;
    }

    public int calculateFuelForModulesP2(){
        int fuelSum = 0;
        ArrayList<Integer> moduleList = generateModuleList();

        for(int module : moduleList){
            fuelSum += calculateFuelForMass(module);
        }

        return fuelSum;
    }

    public int calculateFuelForMass(int mass){
        int fuel =  (int)Math.floor(mass/3) - 2;

        if(fuel < 0)
            return 0;

        if(fuel > 0)
            fuel += calculateFuelForMass(fuel);

        return fuel;
    }
}
