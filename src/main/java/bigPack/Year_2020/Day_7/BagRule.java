package bigPack.Year_2020.Day_7;

import java.util.ArrayList;

public class BagRule {
    private String parentBag;
    private ArrayList<String> childBagList;

    public String getParentBag() {
        return parentBag;
    }
    public void setParentBag(String parentBag) {
        this.parentBag = parentBag;
    }

    public ArrayList<String> getChildBagList() {
        return childBagList;
    }
    public void setChildBagList(ArrayList<String> childBagList) {
        this.childBagList = childBagList;
    }
}
