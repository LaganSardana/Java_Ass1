import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Trip implements MyFileIO {
    private int tripNumber;
    private int license;
    private String rego;
    private String tripDate;
    private ArrayList<TripLeg> legs;

    public Trip() {
        this.legs = new ArrayList<>();
    }

    public Trip(int tripNumber, int license, String rego, String tripDate) {
        this.tripNumber = tripNumber;
        this.license = license;
        this.rego = rego;
        this.tripDate = tripDate;

        this.legs = new ArrayList<>();
    }

    public int getNumber() {
        return tripNumber;
    }

    public void inputData(Scanner scanner) {
        this.tripNumber = Integer.parseInt(scanner.next().trim());
        this.license = Integer.parseInt(scanner.next().trim());
        this.rego = scanner.next().trim();
        this.tripDate = scanner.nextLine().split(",")[1].trim();

        int totalTrips = Integer.parseInt(scanner.nextLine());
        for (int itr = 0; itr < totalTrips; itr++) {
            TripLeg newLeg = new TripLeg();
            newLeg.inputData(scanner);
            this.addLeg(newLeg);
        }
    }

    public void outputData(Formatter formatter) {
        formatter.format("%d, %d, %s, %s\n%d\n", this.tripNumber, this.license, this.rego, this.tripDate,
                this.legs.size());
        for (TripLeg leg : legs) {
            leg.outputData(formatter);
        }
    }

    public void addLeg(TripLeg leg) {
        this.legs.add(leg);
    }

    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("Trip number: %d, license: %d, Rego: %s, Trip date: %s", tripNumber, license, rego, tripDate);

        String returnStr = formatter.toString();
        formatter.close();

        StringBuilder builder = new StringBuilder();

        builder.append(returnStr);

        for (TripLeg leg : this.legs) {
            builder.append("\n");
            builder.append(leg);
        }

        returnStr = builder.toString();
        return returnStr;
    }
}
