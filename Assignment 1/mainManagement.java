import java.util.Scanner;

public class mainManagement {
    private final static int MAXNUM = 100;
    private Student students[];
    private int cntStudents;
    private Subject subjects[];
    private int cntSubjects;
    private Assignment assignments[];
    private int cntAssignments;

    public mainManagement() {
        this.students = new Student[MAXNUM];
        this.subjects = new Subject[MAXNUM];
        this.assignments = new Assignment[MAXNUM];

        this.cntStudents = 0;
        this.cntSubjects = 0;
        this.cntAssignments = 0;
    }

    public boolean checkStudentDuplicate(int studentNumber) {
        for (int itr = 0; itr < cntStudents; itr++) {
            if (students[itr].getNumber() == studentNumber) {
                return true; // Duplicate entry
            }
        }

        return false; // Not a duplicate
    }

    public void addStudent(Scanner scanner) {
        int number;
        String name;
        String dob;
        String degree;
        String codes;

        System.out.print("\nStudent number: ");
        number = scanner.nextInt();
        scanner.nextLine();

        if (checkStudentDuplicate(number)) {
            System.out.println("The student " + number + " exists. Cannot add a student");
            return;
        }

        System.out.print("\nStudent name: ");
        name = scanner.nextLine();

        System.out.print("\nDate of birth: ");
        dob = scanner.nextLine();

        System.out.print("\nDegree: ");
        degree = scanner.nextLine();

        System.out.print("\nEnrolled subjects (Separated by whitespace): ");
        codes = scanner.nextLine();

        Student newStudent = new Student(number, name, dob, degree);
        String codes_arr[] = codes.split(" ");

        for (String code : codes_arr) {
            newStudent.addCode(code);
        }

        this.students[this.cntStudents] = newStudent;
        this.cntStudents++;
    }

    public boolean checkSubjectDuplicate(String subjectCode) {
        for (int itr = 0; itr < cntSubjects; itr++) {
            if (subjects[itr].getCode().equals(subjectCode)) {
                return true; // Duplicate entry
            }
        }

        return false; // Not a duplicate
    }

    public void addSubject(Scanner scanner) {
        String code;
        String title;
        int credits;
        String school;

        System.out.print("\nSubject code: ");
        code = scanner.nextLine();

        if (checkSubjectDuplicate(code)) {
            System.out.println("The subject " + code + " exists. Cannot add a subject.");
            return;
        }

        System.out.print("\nSubject title: ");
        title = scanner.nextLine();

        System.out.print("\nCredits: ");
        credits = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nOffered by: ");
        school = scanner.nextLine();

        this.subjects[this.cntSubjects] = new Subject(code, title, credits, school);
    }

    public boolean checkAssignmentDuplicacy(String subjectCode, int assignmentNumber) {
        for (int itr = 0; itr < cntAssignments; itr++) {
            Assignment currAssignment = assignments[itr];

            if (currAssignment.getCode().equals(subjectCode) && currAssignment.getNumber() == assignmentNumber) {
                return true;
            }
        }

        return false;
    }

    public void addAssignment(Scanner scanner) {
        String code;
        int number;
        String dueDate;
        int totalWorth;

        System.out.print("\nSubject code: ");
        code = scanner.nextLine();

        System.out.print("\nAssignment number: ");
        number = scanner.nextInt();
        scanner.nextLine();

        if (checkAssignmentDuplicacy(code, number)) {
            System.out.println(
                    "The assignment " + number + " of the subject " + code + " exists. Cannot add an assignment.");
            return;
        }

        System.out.print("\nDue date: ");
        dueDate = scanner.nextLine();

        System.out.print("\nTotal worth: ");
        totalWorth = scanner.nextInt();
        scanner.nextLine();

        this.assignments[cntAssignments] = new Assignment(code, number, dueDate, totalWorth);
        cntAssignments++;

    }

    public void findStudent(int number) {
        for (int itr = 0; itr < cntStudents; itr++) {
            if (students[itr].getNumber() == number) {
                System.out.print(students[itr].toString());
                return;
            }
        }

        System.out.println("Student " + number + " does not exist");
        return;
    }

    public void findSubject(String code) {
        for (int itr = 0; itr < cntSubjects; itr++) {
            if (subjects[itr].getCode().equals(code)) {
                System.out.print(subjects[itr].toString());
                return;
            }
        }

        System.out.println("Subject " + code + " does not exist");
        return;
    }

    public void findAssignmentsSubject(String code) {
        boolean assignmentExists = false;
        for (int itr = 0; itr < cntAssignments; itr++) {
            if (assignments[itr].getCode().equals(code)) {
                assignmentExists = true;
                System.out.println(assignments[itr]);
            }
        }

        if (!assignmentExists) {
            System.out.println("No assignment for the subject " + code);
        }

    }

    public void findAssignmentsStudent(int studentNumber) {
        boolean assignmentExists = false;
        for (int itr = 0; itr < cntAssignments; itr++) {
            if (assignments[itr].getNumber() == studentNumber) {
                if(!assignmentExists){ //Will be false for the first time
                    findStudent(studentNumber);
                }
                assignmentExists = true;
                System.out.println(assignments[itr]);
            }
        }

        if (!assignmentExists) {
            System.out.println("No assignment for the student " + studentNumber);
        }

    }

    public static void main(String[] args) {
        mainManagement mainObj = new mainManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add a student");
            System.out.println("2. Add a subject");
            System.out.println("3. Add an assignment");
            System.out.println("4. Find a student");
            System.out.println("5. Find a subject");
            System.out.println("6. Find all assignments of a subject");
            System.out.println("7. Find all assignments of a student");
            System.out.println("0. Quit");
            System.out.print("Input a choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    mainObj.addStudent(scanner);
                    break;
                case 2:
                    // Add a subject
                    mainObj.addSubject(scanner);
                    break;
                case 3:
                    // Add an assignment
                    mainObj.addAssignment(scanner);
                    break;
                case 4:
                    // Find a student
                    System.out.print("\nStudent number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    mainObj.findStudent(number);
                    break;
                case 5:
                    // Find a subject
                    System.out.print("\nSubject code: ");
                    String code = scanner.nextLine();
                    mainObj.findSubject(code);
                    break;
                case 6:
                    // Find all assignments of a subject
                    System.out.print("\nSubject code: ");
                    code = scanner.nextLine();
                    mainObj.findAssignmentsSubject(code);
                    break;
                case 7:
                    // Find all assignments of a student
                    System.out.print("\nStudent number: ");
                    number = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        } while (choice != 0);

        scanner.close();
    }
}
