import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TripManagement {
    private ArrayList<Employee> employees;
    private ArrayList<Truck> trucks;
    private ArrayList<Trip> trips;

    private Scanner consoleScanner;

    public TripManagement() {
        employees = new ArrayList<>();
        this.loadEmployees();

        trucks = new ArrayList<>();
        this.loadTrucks();

        trips = new ArrayList<>();
        this.loadTrips();

        consoleScanner = new Scanner(System.in);
    }

    public Scanner getConsoleScanner() {
        return consoleScanner;
    }

    public void closeScanner() {
        consoleScanner.close();
    }

    public void loadEmployees() {
        try (Scanner fileScanner = new Scanner(new File("employees.txt"))) {
            fileScanner.useDelimiter(",");

            while (fileScanner.hasNextLine()) {
                Employee newEmployee = null;

                String type = fileScanner.next().trim();

                if (type.equals("A")) {
                    newEmployee = new Admin();
                } else if (type.equals("D")) {
                    newEmployee = new Driver();
                }

                newEmployee.inputData(fileScanner);
                employees.add(newEmployee);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public Employee fetchEmployee(int employeeNum) {
        for (Employee employee : employees) {
            if (employee.getNumber() == employeeNum) {
                return employee;
            }
        }

        return null;
    }

    public Employee addEmployee() {
        Scanner consoleScanner = getConsoleScanner();
        Employee newEmployee = null;

        int number;
        String name;
        String dob;
        String address;

        System.out.print("Employee number: ");
        number = consoleScanner.nextInt();
        consoleScanner.nextLine();

        if (fetchEmployee(number) != null) {
            System.out.println("The employee " + number + " exists.");
            return null;
        }

        System.out.print("Employee name: ");
        name = consoleScanner.nextLine();

        System.out.print("Data of birth (dd-mm-yyyy): ");
        dob = consoleScanner.nextLine();

        System.out.print("Address: ");
        address = consoleScanner.nextLine();

        System.out.print("Admin or Driver (A or D): ");
        String choice = consoleScanner.nextLine().trim();

        if (choice.equals("A")) {
            System.out.print("Position: ");
            String position = consoleScanner.nextLine();

            newEmployee = new Admin(number, name, dob, address, position);

        } else if (choice.equals("D")) {
            int license;
            String status;

            System.out.print("License: ");
            license = consoleScanner.nextInt();
            consoleScanner.nextLine();

            System.out.print("Status: ");
            status = consoleScanner.nextLine();

            newEmployee = new Driver(number, name, dob, address, license, status);
        }

        return newEmployee;

    }

    public void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public void loadTrucks() {
        try (Scanner fileScanner = new Scanner(new File("trucks.txt"))) {
            fileScanner.useDelimiter(",");
            while (fileScanner.hasNextLine()) {
                Truck newTruck = new Truck();
                newTruck.inputData(fileScanner);
                trucks.add(newTruck);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public Truck fetchTruck(String rego) {
        for (Truck truck : trucks) {
            if (truck.getRego().equals(rego)) {
                return truck;
            }
        }

        return null;
    }

    public Truck addTruck() {
        Scanner consoleScanner = getConsoleScanner();
        Truck newTruck = null;

        String rego;
        double capacity;
        double weight;
        String status;

        System.out.print("Truck rego: ");
        rego = consoleScanner.nextLine();

        if (fetchTruck(rego) != null) {
            System.out.println("The truck " + rego + " exists.");
            return null;
        }

        System.out.print("Capacity: ");
        capacity = consoleScanner.nextDouble();
        consoleScanner.nextLine();

        System.out.print("Weight: ");
        weight = consoleScanner.nextDouble();
        consoleScanner.nextLine();

        System.out.print("Status: ");
        status = consoleScanner.nextLine();

        newTruck = new Truck(rego, capacity, weight, status);

        return newTruck;
    }

    public void displayTrucks() {
        for (Truck truck : trucks) {
            System.out.println(truck);
        }
        System.out.println();
    }

    public void loadTrips() {
        try (Scanner fileScanner = new Scanner(new File("trips.txt"))) {
            fileScanner.useDelimiter(",");
            while (fileScanner.hasNextLine()) {
                Trip newTrip = new Trip();
                newTrip.inputData(fileScanner);
                trips.add(newTrip);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public Trip fetchTrip(int tripNumber) {
        for (Trip trip : trips) {
            if (trip.getNumber() == tripNumber) {
                return trip;
            }
        }

        return null;
    }

    public Trip addTrip() {
        Scanner consoleScanner = getConsoleScanner();

        int tripNumber;
        int license;
        String rego;
        String tripDate;

        System.out.print("Trip number: ");
        tripNumber = consoleScanner.nextInt();
        consoleScanner.nextLine();

        if (fetchTrip(tripNumber) != null) {
            System.out.println("The trip " + tripNumber + " exists.");
            return null;
        }

        System.out.print("License: ");
        license = consoleScanner.nextInt();
        consoleScanner.nextLine();

        System.out.print("Rego: ");
        rego = consoleScanner.nextLine();

        System.out.print("Trip date (dd-mm-yyyy): ");
        tripDate = consoleScanner.nextLine();

        System.out.print("Total legs: ");
        int legsCount = consoleScanner.nextInt();
        consoleScanner.nextLine();

        Trip newTrip = new Trip(tripNumber, license, rego, tripDate);

        for (int itr = 0; itr < legsCount; itr++) {
            int legNumber;
            String departure;
            String destination;

            System.out.print("Leg number: ");
            legNumber = consoleScanner.nextInt();
            consoleScanner.nextLine();

            System.out.print("Departure: ");
            departure = consoleScanner.nextLine();

            System.out.print("Destination: ");
            destination = consoleScanner.nextLine();

            newTrip.addLeg(new TripLeg(legNumber, departure, destination));
        }

        return newTrip;
    }

    public void displayTrips() {
        for (Trip trip : trips) {
            System.out.println(trip);
            System.out.println();
        }
    }

    public void saveEmployees() {
        try (Formatter fileFormatter = new Formatter(new File("employees.txt"))) {
            for (Employee employee : employees) {
                employee.outputData(fileFormatter);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void saveTrucks() {
        try (Formatter fileFormatter = new Formatter(new File("trucks.txt"))) {
            for (Truck truck : trucks) {
                truck.outputData(fileFormatter);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void saveTrips() {
        try (Formatter fileFormatter = new Formatter(new File("trips.txt"))) {
            for (Trip trip : trips) {
                trip.outputData(fileFormatter);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        TripManagement tms = new TripManagement();

        Scanner scanner = tms.getConsoleScanner();
        int choice;

        do {
            System.out.println("1. Display all employees.");
            System.out.println("2. Display all trucks.");
            System.out.println("3. Display all trips.");
            System.out.println("4. Find an employee.");
            System.out.println("5. Find a truck.");
            System.out.println("6. Find a trip.");
            System.out.println("7. Add a new employee.");
            System.out.println("8. Add a new truck.");
            System.out.println("9. Add a new trip.");
            System.out.println("10. Save all data into files.");
            System.out.println("0. Exit.");
            System.out.print("Input a choice (0-10): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    tms.displayEmployees();
                    System.out.println("");
                    break;
                case 2:
                    tms.displayTrucks();
                    System.out.println("");
                    break;
                case 3:
                    tms.displayTrips();
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Employee number: ");
                    int employeeNum = scanner.nextInt();
                    scanner.nextLine();

                    Employee employee = tms.fetchEmployee(employeeNum);
                    if (employee == null) {
                        System.out.println("Employee " + employeeNum + " does not exist");
                    } else {
                        System.out.println(employee);
                    }
                    System.out.println("");
                    break;
                case 5:
                    System.out.print("Truck rego: ");
                    String rego = scanner.nextLine();

                    Truck truck = tms.fetchTruck(rego);
                    if (truck == null) {
                        System.out.println("Truck " + rego + " does not exist");
                    } else {
                        System.out.println(truck);
                    }
                    System.out.println("");
                    break;
                case 6:
                    System.out.print("Trip number: ");
                    int tripNumber = scanner.nextInt();
                    scanner.nextLine();

                    Trip trip = tms.fetchTrip(tripNumber);
                    if (trip == null) {
                        System.out.println("Trip " + tripNumber + " does not exist");
                    } else {
                        System.out.println(trip);
                    }
                    System.out.println("");
                    break;
                case 7:
                    employee = tms.addEmployee();
                    if (employee != null) {
                        tms.employees.add(employee);
                    }
                    System.out.println("");
                    break;
                case 8:
                    truck = tms.addTruck();
                    if (truck != null) {
                        tms.trucks.add(truck);
                    }
                    System.out.println("");
                    break;
                case 9:
                    trip = tms.addTrip();
                    if (trip != null) {
                        tms.trips.add(trip);
                    }
                    System.out.println("");
                    break;
                case 10:
                    tms.saveEmployees();
                    tms.saveTrips();
                    tms.saveTrucks();
                    System.out.println("Data saved.");
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Bye-bye");
                    return;
            }
        } while (choice != 0);
        tms.closeScanner();
    }
}

/*
 * Load [X]
 * 1,2,3 - Display [X]
 * 4,5,6 - Find [X]
 * 7,8,9 - Add [X]
 * 10 - Save [X]
 * Menu
 * 0
 */
