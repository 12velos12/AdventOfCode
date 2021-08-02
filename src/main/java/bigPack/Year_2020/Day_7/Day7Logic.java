package bigPack.Year_2020.Day_7;

import bigPack.txt_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day7Logic {
    private HashMap<String, ArrayList<String>> bagRules = new HashMap<>();

    public HashMap<String, ArrayList<String>> getBagRules() {
        return bagRules;
    }
    public void setBagRules(HashMap<String, ArrayList<String>> bagRules) {
        this.bagRules = bagRules;
    }
    public void setBagRules(ArrayList<String> rawBagRules){
        HashMap<String, ArrayList<String>> bagRules = new HashMap();

        for(String rawBagRule : rawBagRules){
            BagRule bagRule = generateBagRule(rawBagRule);
            bagRules.put(bagRule.getParentBag(), bagRule.getChildBagList());
        }

        setBagRules(bagRules);
    }

    public Day7Logic(){
        txt_ArrayList tal = new txt_ArrayList("C:\\Users\\Ryan\\IdeaProjects\\AdventOfCode\\src\\main\\java\\bigPack\\Year_2020\\Day_7\\PuzzleInput.txt");
        ArrayList<String> rawBagRules = tal.getArray();
        setBagRules(rawBagRules);
//        System.out.println(bagRules.keySet());
    }

    public BagRule generateBagRule(String rawBagRule){
        BagRule bagRule = new BagRule();
        bagRule.setParentBag(generateRawBagRuleParent(rawBagRule));
        bagRule.setChildBagList(generateRawBagRuleChildList(rawBagRule));

        return bagRule;
    }

    public String generateRawBagRuleParent(String rawBagRule){
        String[] rawBagArray = rawBagRule.split(" bags contain ");
        return rawBagArray[0];
    }

    public ArrayList<String> generateRawBagRuleChildList(String rawBagRule){
        ArrayList<String> rawBagRuleChildList = new ArrayList<>();
        String[] rawBagRuleArray = rawBagRule.split(" bags contain ");
        rawBagRuleArray = rawBagRuleArray[1].split(", ");
        rawBagRuleArray[rawBagRuleArray.length - 1] = rawBagRuleArray[rawBagRuleArray.length - 1].substring(0, rawBagRuleArray[rawBagRuleArray.length - 1].length()-1);
        for(int i = 0; i < rawBagRuleArray.length; i++){
            rawBagRuleArray[i] = rawBagRuleArray[i].replace(" bags", "");
            rawBagRuleArray[i] = rawBagRuleArray[i].replace(" bag", "");
        }
        for(String rawChildBag : rawBagRuleArray)
            rawBagRuleChildList.add(rawChildBag);

        return rawBagRuleChildList;
    }

    public int validOuterBagsAmount(String inputBag){
        String[] bagKeySet = getBagRules().keySet().toArray(new String[0]);
        int validOuterBagsAmount = 0;

        for(String bagKey : bagKeySet){
            if(validOuterBag(bagKey, inputBag))
                validOuterBagsAmount++;
        }

        return validOuterBagsAmount;
    }

    public boolean validOuterBag(String outerBag, String innerBag){
        ArrayList<String> childrenBags = getChildrenBags(outerBag);
        ArrayList<String> childrenBagsNames = getChildrenBagsNames(childrenBags);
        for(String childBagName : childrenBagsNames){
            if(childBagName.equals(innerBag))
                return true;
            else if(childBagName.equals("no other")){
                continue;
            }
            else if(validOuterBag(childBagName, innerBag))
                return true;
        }

        return false;
    }

    public ArrayList<String> getChildrenBags(String parentBag){
        return bagRules.get(parentBag);
    }

    public ArrayList<String> getChildrenBagsNames(ArrayList<String> childrenBags){
        ArrayList<String> childrenBagsNames = new ArrayList<>();

        for(String childBag : childrenBags){
            childrenBagsNames.add(getChildBagName(childBag));
        }

        return childrenBagsNames;
    }

    public String getChildBagName(String childBag){
        if(childBag.equals("no other"))
            return childBag;
        String[] childBagWords = childBag.split(" ");
        return childBagWords[1] + " " + childBagWords[2];
    }

    public int getChildBagAmount(String childBag){
        String[] childBagWords = childBag.split(" ");
        return Integer.parseInt(childBagWords[0]);
    }

    public int bagAmountInParentBag(String parentBag){
        int bagsWithin = 0;
        ArrayList<String> childrenBags = getChildrenBags(parentBag);

        for(String childBag : childrenBags){
            if(childBag.equals("no other"))
                break;
            bagsWithin += getChildBagAmount(childBag);
            bagsWithin += getChildBagAmount(childBag) * bagAmountInParentBag(getChildBagName(childBag));
        }

        return bagsWithin;
    }
}
