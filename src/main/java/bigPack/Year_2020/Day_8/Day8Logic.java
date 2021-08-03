package bigPack.Year_2020.Day_8;

import bigPack.txt_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Day8Logic {
    private int acc = 0;
    private int programCounter = 0;
    private ArrayList<String> instructionSet;

    public int getAcc() {
        return acc;
    }
    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getProgramCounter() {
        return programCounter;
    }
    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    public ArrayList<String> getRawInstructionSet() {
        return instructionSet;
    }
    public void setRawInstructionSet(ArrayList<String> rawInstructionSet) {
        this.instructionSet = rawInstructionSet;
    }

    public Day8Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_8\\PuzzleInput.txt");
        setRawInstructionSet(tal.getArray());
    }

    public int findLoopInInstructionSet(){
        ArrayList<Integer> programCounterList = new ArrayList<>();

        programCounterList.add(getProgramCounter());
        while (!listHasDuplicates(programCounterList)){
            performInstruction();
            programCounterList.add(getProgramCounter());
        }

        return getAcc();
    }

    public boolean instructionSetLoops(){
        ArrayList<Integer> programCounterList = new ArrayList<>();

        programCounterList.add(getProgramCounter());
        while (!listHasDuplicates(programCounterList)){
            performInstruction();
            programCounterList.add(getProgramCounter());
            if(getProgramCounter() >= getRawInstructionSet().size())
                return false;
        }

        return true;
    }

    public boolean listHasDuplicates(ArrayList<Integer> inputList){
        Collections.sort(inputList);

        if (inputList.size() < 2)
            return false;

        for(int i = 0; i < inputList.size()-1; i++){
            if(inputList.get(i).equals(inputList.get(i+1)))
                return true;
        }

        return false;
    }

    public void performInstruction(){
        String[] readableInstruction = generateReadableInstruction();

        switch(readableInstruction[0]){
            case "acc":
                accOp(Integer.parseInt(readableInstruction[1]));
                break;
            case "jmp":
                jmpOp(Integer.parseInt(readableInstruction[1]));
                break;
            case "nop":
                nopOp();
                break;
            default:
                System.out.println("Error: performInstruction() - Operation not recognized.");
        }
    }

    public String[] generateReadableInstruction(){
        return instructionSet.get(getProgramCounter()).split(" ");
    }

    public String[] generateReadableInstruction(int instructionNumber){
        return instructionSet.get(instructionNumber).split(" ");
    }

    public void accOp(int increment){
        setAcc(getAcc() + increment);
        setProgramCounter(getProgramCounter() + 1);
    }

    public void jmpOp(int offset){
        setProgramCounter(getProgramCounter() + offset);
    }

    public void nopOp(){
        setProgramCounter(getProgramCounter() + 1);
    }

    public int generateFixedInstructionSetAcc(){
        fixInstructionSet();
        return getAcc();
    }

    public void fixInstructionSet(){
        ArrayList<String> defaultInstructionSet = (ArrayList<String>)getRawInstructionSet().clone();

        if(!instructionSetLoops())
            return;

        for(int i = 0; i < defaultInstructionSet.size(); i++){
            resetProgram();
            if(!jmpORnop(i))
                continue;
            else{
                switchJmpANDNop(i);
                if(!instructionSetLoops())
                    return;
            }
            setRawInstructionSet((ArrayList<String>)defaultInstructionSet.clone());
        }
    }

    public boolean jmpORnop(int instructionNumber){
        String[] readableInstruction = generateReadableInstruction(instructionNumber);
        return readableInstruction[0].equals("jmp") || readableInstruction[0].equals("nop");
    }

    public void switchJmpANDNop(int instructionNumber){
        String[] readableInstruction = generateReadableInstruction(instructionNumber);
        String instruction = getRawInstructionSet().get(instructionNumber);

        if(readableInstruction[0].equals("jmp")){
            instruction = instruction.replace("jmp", "nop");
            instructionSet.set(instructionNumber, instruction);
        } else if (readableInstruction[0].equals("nop")) {
            instruction = instruction.replace("nop", "jmp");
            instructionSet.set(instructionNumber, instruction);
        }
    }

    public void resetProgram(){
        setAcc(0);
        setProgramCounter(0);
    }
}
