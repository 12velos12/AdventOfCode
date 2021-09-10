package bigPack.Year_2020.Day_12;

public class Waypoint {
    private int currLatitude = 10;
    private int currLongitude = 1;

    public int getCurrLatitude() {
        return currLatitude;
    }
    public int getCurrLongitude() {
        return currLongitude;
    }


    public void move(Direction direction, Ship ship){
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
                rotateLeft(direction);
                break;
            case 'R':
                rotateRight(direction);
                break;
            case 'F':
                moveForward(direction.units, ship);
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

    private void rotateLeft(Direction direction){
        if(direction.getUnits() == 0) {return;}

        int newRelLatitude = -1 * currLongitude;
        int newRelLongitude = currLatitude;
        currLatitude = newRelLatitude;
        currLongitude = newRelLongitude;

        direction.setUnits(direction.getUnits() - 90);
        rotateLeft(direction);
    }

    private void rotateRight(Direction direction){
        if(direction.getUnits() == 0) {return;}

        int newRelLatitude = currLongitude;
        int newRelLongitude = -1 * currLatitude;
        currLatitude = newRelLatitude;
        currLongitude = newRelLongitude;

        direction.setUnits(direction.getUnits() - 90);
        rotateRight(direction);
    }

    private void moveForward(int units, Ship ship){
        Direction waypointNorth = new Direction("N" + currLongitude);
        Direction waypointEast = new Direction("E" + currLatitude);

        for(int i = 0; i < units; i++){
            ship.move(waypointNorth);
            ship.move(waypointEast);
        }
    }
}
