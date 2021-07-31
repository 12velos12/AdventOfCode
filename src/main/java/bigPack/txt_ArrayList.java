package bigPack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class txt_ArrayList {
    private ArrayList<String> fileArray;

    public ArrayList<String> getArray(){
        return fileArray;
    }

    private void setArray(ArrayList<String> fileArray){
        this.fileArray = fileArray;
    }

    public txt_ArrayList(String filePath){
        try {
            File file = new File(filePath);
            Scanner reader = new Scanner(file);
            ArrayList<String> fileArray = new ArrayList<>();

            while(reader.hasNext()){
                fileArray.add(reader.nextLine());
            }
            setArray(fileArray);
        }
        catch(FileNotFoundException e){
            System.out.println("Error: txt_Array - Input file was not found");
        }
        catch (Exception e){
            System.out.println("Error: txt_Array - " + e);
        }
    }
}
