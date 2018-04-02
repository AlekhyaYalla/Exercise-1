import java.util.HashMap;

class Rover {
    protected int x_coordinate;
    protected int y_coordinate;
    protected Character direction;

}

public class RoverPlateau {


    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.x_coordinate = 3;
        rover.y_coordinate = 3;
        rover.direction = 'E';
        setDirectionOrientation();
        rover = getRoverFinalCoordinates(rover, "MMRMMRMRRM");
        System.out.println("Output is:" + rover.x_coordinate + " " + rover.y_coordinate + " " + rover.direction);


    }

    static HashMap<String, Character> directionOrientation = new HashMap<>();

    public static void setDirectionOrientation() {
        directionOrientation.put("RN", 'E');
        directionOrientation.put("LN", 'W');
        directionOrientation.put("RE", 'S');
        directionOrientation.put("LE", 'N');
        directionOrientation.put("RS", 'W');
        directionOrientation.put("LS", 'E');
        directionOrientation.put("RW", 'N');
        directionOrientation.put("LW", 'S');

    }

    public static Rover getRoverFinalCoordinates(Rover rover, String instructions) {


        int len = instructions.length();
        for (int i = 0; i < len; i++) {
            switch (instructions.charAt(i)) {
                case 'M':
                    rover = changeDimension(rover);
                    break;
                case 'L':
                    rover = changeDirection(rover, "L");
                    break;
                case 'R':
                    rover = changeDirection(rover, "R");
                    break;

            }
        }
        return rover;

    }

    private static Rover changeDirection(Rover rover, String direction) {
//        System.out.println("in changeDirectione direction letter  "+direction+rover.direction);
        rover.direction = directionOrientation.get( direction+rover.direction );
        return rover;
    }

    private static Rover changeDimension(Rover rover) {
//        System.out.println("in change Dimension"+rover.direction);
        if (rover.direction.equals('N')) (rover.y_coordinate)++;
        if (rover.direction.equals('S')) (rover.y_coordinate)--;
        if (rover.direction.equals('E')) (rover.x_coordinate)++;
        if (rover.direction.equals('W')) (rover.x_coordinate)--;
        return rover;
    }

}
