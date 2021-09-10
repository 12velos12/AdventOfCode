package bigPack.Year_2020.Day_12;

public class Ship {
    private int currLatitude = 0;
    private int currLongitude = 0;
    private char currFacing = 'E';

    public int getCurrLatitude() {
        return currLatitude;
    }
    public int getCurrLongitude() {
        return currLongitude;
    }
    public char getCurrFacing() {
        return currFacing;
    }

    public void move(Direction direction){
        switch(direction.heading){
            case 'N':
                moveNorth(direction.units);
                break;
            case 'S':
                moveSouth(direction.units);
                break;
            case 'E':
                moveEast(direction.units);
                break;
            case 'W':
                moveWest(direction.units);
                break;
            case 'L':
                turnLeft(direction);
                break;
            case 'R':
                turnRight(direction);
                break;
            case 'F':
                moveForward(direction.units);
                break;
            default:
                System.out.println("Error - move(): direction.heading value not recognized: " + direction.heading);
                break;
        }

    }

    private void moveNorth(int units){
        currLongitude += units;
    }

    private void moveSouth(int units){
        currLongitude -= units;
    }

    private void moveEast(int units){
        currLatitude += units;
    }

    private void moveWest(int units){
        currLatitude -= units;
    }

    private void turnLeft(Direction direction){
        if(direction.units == 0){
            return;
        }
        switch(currFacing){
            case 'N':
                currFacing = 'W';
                direction.setUnits(direction.getUnits() - 90);
                turnLeft(direction);
                break;
            case 'S':
                currFacing = 'E';
                direction.setUnits(direction.getUnits() - 90);
                turnLeft(direction);
                break;
            case 'E':
                currFacing = 'N';
                direction.setUnits(direction.getUnits() - 90);
                turnLeft(direction);
                break;
            case 'W':
                currFacing = 'S';
                direction.setUnits(direction.getUnits() - 90);
                turnLeft(direction);
                break;
            default:
                System.out.println("Error - moveLeft(): currFacing value not recognized: " + currFacing);
                break;
        }
    }

    private void turnRight(Direction direction){
        if(direction.units == 0){
            return;
        }
        switch(currFacing){
            case 'N':
                currFacing = 'E';
                direction.setUnits(direction.getUnits() - 90);
                turnRight(direction);
                break;
            case 'S':
                currFacing = 'W';
                direction.setUnits(direction.getUnits() - 90);
                turnRight(direction);
                break;
            case 'E':
                currFacing = 'S';
                direction.setUnits(direction.getUnits() - 90);
                turnRight(direction);
                break;
            case 'W':
                currFacing = 'N';
                direction.setUnits(direction.getUnits() - 90);
                turnRight(direction);
                break;
            default:
                System.out.println("Error - moveRight(): currFacing value not recognized: " + currFacing);
                break;
        }
    }

    private void moveForward(int units){
        switch(currFacing){
            case 'N':
                moveNorth(units);
                break;
            case 'S':
                moveSouth(units);
                break;
            case 'E':
                moveEast(units);
                break;
            case 'W':
                moveWest(units);
                break;
            default:
                System.out.println("Error - moveForward(): currfacing value not recognized: " + currFacing);
                break;
        }
    }

}
