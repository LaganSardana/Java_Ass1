import java.util.ArrayList;
import java.util.Scanner;

public class mainManagement {
    private final static int MAXNUM = 100;
    private ArrayList <Student> students = new ArrayList<>();
    private int cntStudents;
    private ArrayList <Subject> subjects = new ArrayList<>();
    private int cntSubjects;
    private ArrayList <Assignment> assignments = new ArrayList<>();
    private int cntAssignments;


    mainManagement(int cntStudents, int cntSubjects, int cntAssignments){
        this.cntStudents = cntStudents;
        this.cntSubjects = cntSubjects;
        this.cntAssignments = cntAssignments;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*** Management System Menu ***");
            System.out.println("1. Add a student");
            System.out.println("2. Add a subject");
            System.out.println("3. Add an assignment");
            System.out.println("4. Find a student");
            System.out.println("5. Find a subject");
            System.out.println("6. Find all assignments of a subject");
            System.out.println("7. Find all assignments of a student");
            System.out.println("0. Quit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter degree: ");
                    String degree = scanner.nextLine();
                    System.out.print("Enrolled subjects (Separated by whitespace): ");
                    
                    break;
                case 2:
                    // Add a subject
                    // Assuming the method to create and add a subject is implemented
                    break;
                case 3:
                    // Add an assignment
                    // Assuming the method to create and add an assignment is implemented
                    break;
                case 4:
                    // Find a student
                    // Assuming the method to find a student is implemented
                    break;
                case 5:
                    // Find a subject
                    // Assuming the method to find a subject is implemented
                    break;
                case 6:
                    // Find all assignments of a subject
                    // Assuming the method to find all assignments of a subject is implemented
                    break;
                case 7:
                    // Find all assignments of a student
                    // Assuming the method to find all assignments of a student is implemented
                    break;
                case 0:
                    System.out.println("Quitting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 7.");
            }
        } while (choice != 0);

        scanner.close();
    }
    


}
