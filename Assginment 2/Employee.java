import java.util.Formatter;
import java.util.Scanner;

public abstract class Employee implements MyFileIO {
    private int number;
    private String name;
    private String dob;
    private String address;

    abstract public void inputData(Scanner scanner);

    abstract public void outputData(Formatter formatter);

    public Employee() {
    }

    public Employee(int number, String name, String dob, String address) {
        this.number = number;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public String getDob() {
        return this.dob;
    }

    public String getAddress() {
        return this.address;
    }

}

class Admin extends Employee {
    private String position;

    public Admin() {
        super();
    }

    public Admin(int number, String name, String dob, String address, String position) {
        super(number, name, dob, address);
        this.position = position;
    }

    public void inputData(Scanner scanner) {
        super.setNumber(Integer.parseInt(scanner.next().trim()));
        super.setName(scanner.next().trim());
        super.setDob(scanner.next().trim());
        super.setAddress(scanner.next().trim());

        this.position = scanner.nextLine().trim();
        this.position = (this.position.split(",")[1]).trim();
    }

    public void outputData(Formatter formatter) {
        formatter.format("%s, %d, %s, %s, %s, %s\n", "A", super.getNumber(), super.getName(), super.getDob(),
                super.getAddress(), this.position);
    }

    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format(
                "Admin Employee number: %d, Employee name: %s, Date of birth: %s, Address: %s, Position: %s",
                this.getNumber(), this.getName(), this.getDob(), this.getAddress(), this.position);

        String returnStr = formatter.toString();
        formatter.close();
        return returnStr;
    }
}

class Driver extends Employee {
    private int license;
    private String status;

    public Driver() {
        super();
    }

    public Driver(int number, String name, String dob, String address, int license, String status) {
        super(number, name, dob, address);
        this.license = license;
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        super.setNumber(Integer.parseInt(scanner.next().trim()));
        super.setName(scanner.next().trim());
        super.setDob(scanner.next().trim());
        super.setAddress(scanner.next().trim());

        this.license = Integer.parseInt(scanner.next().trim());
        this.status = scanner.nextLine().trim();
        this.status = (this.status.split(",")[1]).trim();
    }

    public void outputData(Formatter formatter) {
        formatter.format("%s, %d, %s, %s, %s, %d, %s\n", "D", super.getNumber(), super.getName(), super.getDob(),
                super.getAddress(), this.license, this.status);
    }

    public String toString() {
        Formatter formatter = new Formatter();
        formatter.format(
                "Driver Employee number: %d, Employee name: %s, Date of birth: %s, Address: %s, License: %d, Status: %s",
                this.getNumber(), this.getName(), this.getDob(), this.getAddress(), this.license, this.status);

        String returnStr = formatter.toString();
        formatter.close();
        return returnStr;
    }

}
