import java.util.Formatter;
import java.util.Scanner;

public class TripLeg implements MyFileIO {
    private int legNumber;
    private String departure;
    private String destination;

    public TripLeg() {
    }

    public TripLeg(int legNumber, String departure, String destination) {
        this.legNumber = legNumber;
        this.departure = departure;
        this.destination = destination;
    }

    public void inputData(Scanner scanner) {
        String inpString = scanner.nextLine();
        String attributes[] = inpString.split(",");

        this.legNumber = Integer.parseInt(attributes[0].trim());
        this.departure = attributes[1].trim();
        this.destination = attributes[2].trim();
    }

    public void outputData(Formatter formatter) {
        formatter.format("%d, %s, %s\n", legNumber, departure, destination);
    }

    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("Leg number: %d, Departure: %s, Destination: %s", legNumber, departure, destination);

        String returnStr = formatter.toString();
        formatter.close();
        return returnStr;
    }
}
