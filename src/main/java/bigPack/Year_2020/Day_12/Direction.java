package bigPack.Year_2020.Day_12;

public class Direction {
    char heading;
    int units;

    public Direction(String directionString){
        heading = directionString.charAt(0);
        units = Integer.parseInt(directionString.substring(1));
    }

    public char getHeading() {
        return heading;
    }
    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
