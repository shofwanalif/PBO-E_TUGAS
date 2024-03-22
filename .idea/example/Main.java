import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<String, String[]> bookList = new HashMap<>();
    static final Map<String, String[]> userStudent = new HashMap<>();

    static {
        bookList.put("1", new String[]{"Title 1", "Author 1", "Category 1", "5"});
        bookList.put("2", new String[]{"Title 2", "Author 2", "Category 2", "7"});
        bookList.put("3", new String[]{"Title 3", "Author 3", "Category 3", "3"});
        bookList.put("4", new String[]{"Title 4", "Author 4", "Category 4", "4"});
        bookList.put("5", new String[]{"Title 5", "Author 5", "Category 5", "0"});
        bookList.put("6", new String[]{"Title 6", "Author 6", "Category 6", "2"});

        userStudent.put("123456789012345", new String[]{"John Doe", "Engineering", "Computer Science"});
    }

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Library System\n1. Login as Student\n2. Login as Admin\n3. Exit\nChoose option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loginAsStudent(scanner);
                    break;
                case 2:
                    loginAsAdmin(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you. Exiting Program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void loginAsStudent(Scanner scanner) {
        Student student = new Student();
        System.out.print("Enter your NIM: ");
        String nim = scanner.next();
        if (student.checkNim(nim)) {
            student.menuStudent(scanner);
        } else {
            System.out.println("Invalid NIM. Please try again.");
        }
    }

    public static void loginAsAdmin(Scanner scanner) {
        admin admin = new admin();
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        if (admin.checkCredentials(username, password)) {
            admin.menuAdmin(scanner);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
}
