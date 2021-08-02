package bigPack.Year_2020.Day_6;

import bigPack.txt_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Day6Logic {
    private ArrayList<String> rawQuestionsList;

    public ArrayList<String> getRawQuestionsList() {
        return rawQuestionsList;
    }
    public void setRawQuestionsList(ArrayList<String> rawQuestionsList) {
        this.rawQuestionsList = rawQuestionsList;
    }

    public Day6Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_6\\PuzzleInput.txt");
        rawQuestionsList = tal.getArray();
    }

    public ArrayList<String> rawQuestionsList_groupedQuestionsList(){
        ArrayList<String> groupedQuestionsList = new ArrayList<>();
        String questionLine = "";

        for(String Line : getRawQuestionsList()){
            if(Line.isEmpty() && questionLine != ""){
                questionLine.trim();
                groupedQuestionsList.add(questionLine);
                questionLine = "";
                continue;
            }

            questionLine += Line;
        }

        if(!questionLine.isEmpty())
            groupedQuestionsList.add(questionLine);

        return groupedQuestionsList;
    }

    public int totalYesForAllGroups(){
        ArrayList<String> groupedQuestionsList = rawQuestionsList_groupedQuestionsList();
        int totalYes = 0;

        for(String questions : groupedQuestionsList){
            totalYes += totalYesForGroup(questions);
        }

        return totalYes;
    }

    public int totalYesForGroup(String rawQuestionLine){
        char[] questions = rawQuestionLine.toCharArray();
        ArrayList<Character> yesQuestionList = new ArrayList<>();

        for(char question : questions){
            if (!yesQuestionList.contains(question)){
                yesQuestionList.add(question);
            }
        }

        return yesQuestionList.size();
    }

    public ArrayList<String> rawQuestionsList_groupedQuestionsWithGroupSizeList(){
        ArrayList<String> groupedQuestionsWithGroupSizeList = new ArrayList<>();
        String questionLine = "";
        int peopleInGroup = 0;

        for(String Line : getRawQuestionsList()){
            if(Line.isEmpty() && questionLine != ""){
                questionLine.trim();
                groupedQuestionsWithGroupSizeList.add(questionLine + peopleInGroup);
                questionLine = "";
                peopleInGroup = 0;
                continue;
            }

            questionLine += Line;
            peopleInGroup++;
        }

        if(!questionLine.isEmpty())
            groupedQuestionsWithGroupSizeList.add(questionLine + peopleInGroup);

        return groupedQuestionsWithGroupSizeList;
    }

    public int totalUnanimousYesForAllGroups(){
        ArrayList<String> groupedQuestionsWithGroupSizeList = rawQuestionsList_groupedQuestionsWithGroupSizeList();
        int totalYes = 0;

        for(String questions : groupedQuestionsWithGroupSizeList){
            totalYes += totalUnanimousYesForGroup(questions);
        }

        return totalYes;
    }

    public int totalUnanimousYesForGroup(String rawQuestionLine){
        int groupSize = Integer.parseInt(String.valueOf(rawQuestionLine.charAt(rawQuestionLine.length() - 1)));
        rawQuestionLine = rawQuestionLine.substring(0, rawQuestionLine.length() - 1);
        char[] questions = rawQuestionLine.toCharArray();
        Arrays.sort(questions);

        if(groupSize == 1)
            return questions.length;

        int consecutiveQuestions = 0;
        int unanimousQuestions = 0;
        for(int i = 0; i < questions.length - 1; i++){
            if(questions[i] == questions[i+1]){
                consecutiveQuestions++;
                if(consecutiveQuestions + 1 == groupSize){
                    unanimousQuestions++;
                    consecutiveQuestions = 0;
                }
                continue;
            }
            consecutiveQuestions = 0;
        }

        return unanimousQuestions;
    }
}
