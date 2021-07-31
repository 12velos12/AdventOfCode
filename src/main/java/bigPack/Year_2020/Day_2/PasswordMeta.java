package bigPack.Year_2020.Day_2;

public class PasswordMeta {
    int minLetter;
    int maxLetter;
    char letter;
    String password;

    public PasswordMeta(String passwordMetaString){
        setMinLetter(Integer.parseInt(passwordMetaString.substring(0,passwordMetaString.indexOf('-'))));
        setMaxLetter(Integer.parseInt(passwordMetaString.substring(passwordMetaString.indexOf('-')+1,passwordMetaString.indexOf(' '))));
        setLetter(passwordMetaString.substring(passwordMetaString.indexOf(' ')+1,passwordMetaString.indexOf(':')).charAt(0));
        setPassword(passwordMetaString.substring(passwordMetaString.lastIndexOf(' ') + 1));
    }

    public int getMinLetter() {
        return minLetter;
    }
    public void setMinLetter(int minLetter) {
        this.minLetter = minLetter;
    }

    public int getMaxLetter() {
        return maxLetter;
    }
    public void setMaxLetter(int maxLetter) {
        this.maxLetter = maxLetter;
    }

    public char getLetter() {
        return letter;
    }
    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidPasswordP1(){
        char[] passwordArray = password.toCharArray();
        int letterAmount = 0;

        for(char passwordLetter : passwordArray){
            if(passwordLetter == getLetter())
                letterAmount++;
        }

        if (minLetter <= letterAmount && letterAmount <= maxLetter)
            return true;
        return false;
    }

    public boolean isValidPasswordP2(){
        boolean minHasLetter = (getPassword().charAt(getMinLetter()-1) == getLetter());
        boolean maxHasLetter = (getPassword().charAt(getMaxLetter()-1) == getLetter());

        return ( ( minHasLetter || maxHasLetter ) && ! ( minHasLetter && maxHasLetter ) );
    }

    public void printPasswordMeta(){
        System.out.println("MinLetter: " + getMinLetter());
        System.out.println("MaxLetter: " + getMaxLetter());
        System.out.println("Letter: " + getLetter());
        System.out.println("Password: " + getPassword());
    }
}
