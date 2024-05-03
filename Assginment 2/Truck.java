import java.util.Formatter;
import java.util.Scanner;

public class Truck implements MyFileIO {
    private String rego;
    private double capacity;
    private double weight;
    private String status;

    public Truck() {

    }

    public Truck(String rego, double capacity, double weight, String status) {
        this.rego = rego;
        this.capacity = capacity;
        this.weight = weight;
        this.status = status;
    }

    public String getRego() {
        return this.rego;
    }

    public void inputData(Scanner scanner) {
        this.rego = scanner.next().trim();
        this.capacity = Double.parseDouble(scanner.next().trim());
        this.weight = Double.parseDouble(scanner.next().trim());
        this.status = scanner.nextLine().split(",")[1].trim();
    }

    public void outputData(Formatter formatter) {
        formatter.format("%s, %.2f, %.2f, %s\n", this.rego, this.capacity, this.weight, this.status);
    }

    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format("Rego: %s, Capacity: %.2f, Weight: %.2f, Status: %s", rego, capacity, weight, status);

        String returnStr = formatter.toString();
        formatter.close();
        return returnStr;
    }
}
