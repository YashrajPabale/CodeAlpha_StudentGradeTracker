import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {
1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No data available.");
                        break;
                    }

                    int total = 0;
                    int highest = Integer.MIN_VALUE;
                    int lowest = Integer.MAX_VALUE;

                    System.out.println("\n--- Student Report ---");

                    for (Student s : students) {
                        System.out.println(s.name + " - " + s.marks);
                        total += s.marks;

                        if (s.marks > highest) highest = s.marks;
                        if (s.marks < lowest) lowest = s.marks;
                    }

                    double average = (double) total / students.size();

                    System.out.println("\nAverage Marks: " + average);
                    System.out.println("Highest Marks: " + highest);
                    System.out.println("Lowest Marks: " + lowest);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}