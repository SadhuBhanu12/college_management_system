
import java.util.ArrayList;
import java.util.Scanner;

class User {

    String id;
    String pass;

    User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public String getid() {
        return id;
    }

    public boolean passvalidate(String inp_pass) {
        return pass.equals(inp_pass);
    }
}

class Student extends User {

    String name;

    String department;
    String email;

    public Student(String name, String pass, String id, String department, String email) {
        super(id, pass);
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public String getname() {
        return name;
    }

    public String getid() {
        return id;
    }

    public String getdepartment() {
        return department;
    }

    public String email() {
        return email;
    }

    public String toString() {
        return "Name: " + name + ", id: " + id + ", Department: " + department + ", Email: " + email;
    }

}

class Faculty extends User {

    String name;

    Faculty(String id, String pass, String name) {
        super(id, pass);
        this.name = name;
    }

    public String GetFacultyName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}

class Studentservices {

    ArrayList<Student> a = new ArrayList<>();
    ArrayList<Faculty> b = new ArrayList<>();

    public void addStudent(Student name) {
        a.add(name);
        System.out.println("Student " + name + " is successfully added");
    }

    public void addFaculty(Faculty a) {
        b.add(a);
        System.out.println("The added faculty is " + a);

    }

    public void viewfaculty() {
        if (b.isEmpty()) {
            System.out.println("There are no faculties");
        } else {
            for (Faculty a1 : b) {
                System.out.println(a1);
            }
        }

    }

    public Faculty getFacultyByid(String a) {
        for (Faculty a1 : b) {
            if (a1.getid().equals(a)) {
                return a1;
            }

        }
        return null;
    }

    public void removeFaculty(String a) {
        if (getFacultyByid(a) != null) {
            b.remove(a);
            System.out.println("removed faculty" + a);
        } else {
            System.out.println("there is no faculty");
        }

    }

    public void viewStudents() {
        if (a.isEmpty()) {
            System.out.println("there are no students to print");
        }
        for (Student a1 : a) {
            System.out.println(a1);
        }
    }

    public Student findStudentById(String id) {
        for (Student a1 : a) {
            if (a1.getid().equals( id)) {
                return a1;
            }

        }
        return null;
    }

    public void removeStudent(String id) {
        Student student = findStudentById(id);
        if (student != null) {
            a.remove(student);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}

class sms {

    public static void main(String[] args) {
        Studentservices a = new Studentservices();
        a.addFaculty(new Faculty("0001", "12345678", "DR.Sachin"));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- College Management System ---");
            System.out.println("1. Faculty");
            System.out.println("2.Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice");
            int bh = sc.nextInt();
            sc.nextLine();
            if (bh == 3) {
                break;
            }
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();
            if (bh == 1) {
                Faculty a1 = a.getFacultyByid(id);
                if (a1 != null && a1.passvalidate(pass)) {

                    int choice;
                    do {
                        System.out.println("1. Add Student");
                        System.out.println("2. View Students");
                        System.out.println("3. Remove Student");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("enter the name of student you want to Register");
                                String name = sc.nextLine();
                                System.out.println("enter the id of student you want to Regiter");
                                String id1 = sc.nextLine();
                                System.out.println("enter the department of student you want to Register");
                                String department = sc.nextLine();
                                System.out.println("enter the email of student you want to Register");
                                String email = sc.nextLine();
                                System.out.println("enter the password t of student you want to Rgister");
                                String pass1 = sc.nextLine();
                                Student abh1 = new Student(name, pass1, id1, department, email);

                                a.addStudent(abh1);
                                break;
                            case 2:
                                System.out.println("List of studnets");
                                a.viewStudents();
                                break;
                            case 3:
                                System.out.println("enter the student id you want to remove");
                                String ab = sc.nextLine();

                                a.removeStudent(ab);
                                break;
                            case 4:
                                System.out.println("Exiting... Goodbye!");
                                break;

                            default:
                                System.out.println("Invalid choice! Please try again.");
                        }
                    } while (choice != 4);

                } else if (a1 == null) {
                    System.out.println("there are no faculty");
                } else {
                    System.out.println("password incorrect");
                }
            }
            if (bh == 2) {
                Student abh = a.findStudentById(id);
                if (abh != null && abh.passvalidate(pass)) {

                    System.out.println("Your name is" + abh.getname());
                    System.out.println("Your id is" + abh.getid());
                    System.out.println("Your department is" + abh.getdepartment());
                    System.out.println("your email is" + abh.email);

                } else if (abh == null) {
                    System.out.println("Student not found");
                } else {
                    System.out.println("Password incorrect");
                }

            }
        }
    }
}
