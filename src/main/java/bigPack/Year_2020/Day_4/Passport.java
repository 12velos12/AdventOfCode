package bigPack.Year_2020.Day_4;

public class Passport {
    String byr;
    String iyr;
    String eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;

    public String getByr() {
        return byr;
    }
    public void setByr(String byr) {
        this.byr = byr;
    }

    public String getIyr() {
        return iyr;
    }
    public void setIyr(String iyr) {
        this.iyr = iyr;
    }

    public String getEyr() {
        return eyr;
    }
    public void setEyr(String eyr) {
        this.eyr = eyr;
    }

    public String getHgt() {
        return hgt;
    }
    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getHcl() {
        return hcl;
    }
    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public String getEcl() {
        return ecl;
    }
    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }

    public Passport(String passportFields){
        String[] fieldsArray = passportFields.split(" ");

        for(String field : fieldsArray){
            switch(field.substring(0, field.indexOf(':'))){
                case "byr":
                    setByr(field.substring(field.indexOf(':') + 1));
                    break;
                case "cid":
                    setCid(field.substring(field.indexOf(':') + 1));
                    break;
                case "ecl":
                    setEcl(field.substring(field.indexOf(':') + 1));
                    break;
                case "eyr":
                    setEyr(field.substring(field.indexOf(':') + 1));
                    break;
                case "hcl":
                    setHcl(field.substring(field.indexOf(':') + 1));
                    break;
                case "hgt":
                    setHgt(field.substring(field.indexOf(':') + 1));
                    break;
                case "iyr":
                    setIyr(field.substring(field.indexOf(':') + 1));
                    break;
                case "pid":
                    setPid(field.substring(field.indexOf(':') + 1));
                    break;
                default:
                    System.out.println("Error: Passport.java - Passport Field not recognized: " + field.substring(0, field.indexOf(':')));
                    break;
            }
        }
    }

    public boolean hasAllFields(){
        return  getByr() != null &&
//                getCid() != null &&
                getEcl() != null &&
                getEyr() != null &&
                getHcl() != null &&
                getHgt() != null &&
                getIyr() != null &&
                getPid() != null;
    }

    public boolean isValid(){
        if(!hasAllFields())
            return false;
        return allFieldsAreValid();
    }

    public boolean byrIsValid(){
        int byrNum;

        try{
            byrNum = Integer.parseInt(getByr());
        }
        catch (Exception e){
            return false;
        }

        return byrNum >= 1920 &&
                byrNum <= 2002;
    }
    public boolean eclIsValid(){
        String ecl = getEcl();

        return ecl.equals("amb") ||
                ecl.equals("blu") ||
                ecl.equals("brn") ||
                ecl.equals("gry") ||
                ecl.equals("grn") ||
                ecl.equals("hzl") ||
                ecl.equals("oth");
    }
    public boolean eyrIsValid(){
        int eyrNum;

        try{
            eyrNum = Integer.parseInt(getEyr());
        }
        catch (Exception e){
            return false;
        }

        return eyrNum >= 2020 &&
                eyrNum <= 2030;
    }
    public boolean hclIsValid(){
        return getHcl().matches("^#([0-9]|[a-f]){6}$");
    }
    public boolean hgtIsValid(){
        String hgt = getHgt();
        int hgtNum;

        if(!hgt.endsWith("in") && !hgt.endsWith("cm"))
            return false;
        try{
            hgtNum = Integer.parseInt(hgt.substring(0,hgt.length()-2));
        }
        catch (Exception e){
            return false;
        }

        if(hgt.endsWith("cm")){
            return hgtNum >= 150 &&
                    hgtNum <= 193;
        }
        else{
            return hgtNum >= 59 &&
                    hgtNum <= 76;
        }
    }
    public boolean iyrIsValid(){
        int iyrNum;

        try{
            iyrNum = Integer.parseInt(getIyr());
        }
        catch (Exception e){
            return false;
        }

        return iyrNum >= 2010 &&
                iyrNum <= 2020;
    }
    public boolean pidIsValid(){
        String pid = getPid();

        if(pid.length() != 9)
            return false;

        try{
            int pidNum = Integer.parseInt(pid);
        }
        catch (Exception e){
            return false;
        }

        return true;
    }

    public boolean allFieldsAreValid(){
        return byrIsValid() &&
               eclIsValid() &&
               eyrIsValid() &&
               hclIsValid() &&
               hgtIsValid() &&
               iyrIsValid() &&
               pidIsValid();
    }

    public void printPassport(){
        System.out.println("byr: " + getByr());
        System.out.println("cid: " + getCid());
        System.out.println("ecl: " + getEcl());
        System.out.println("eyr: " + getEyr());
        System.out.println("hcl: " + getHcl());
        System.out.println("hgt: " + getHgt());
        System.out.println("iyr: " + getIyr());
        System.out.println("pid: " + getPid());
    }
}
