package data;

import books.Book;
import data.Admin;
import data.Student;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Book> bookList = new ArrayList<>();
    static ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as data.Student");
            System.out.println("2. Login as data.Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    inputNim(scanner);
                    break;
                case "2":
                    Admin admin = new Admin();
                    admin.menuAdmin(scanner);
                    break;
                case "3":
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void inputNim(Scanner scanner) {
        System.out.print("Enter your NIM (input 99 for back): ");
        String nim = scanner.nextLine();
        if (nim.equals("99")) {
            return;
        } else if (checkNim(nim)) {
            Student student = new Student(nim);
            student.menuStudent(scanner); // Panggil menuStudent dari objek student yang sudah dibuat
        } else {
            System.out.println("Invalid NIM. Please try again.");
            inputNim(scanner);
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }

    public static void initializeData() {
        // Inisialisasi data buku
        bookList.add(new Book("388c-e681-9152", "title1", "author1", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "title2", "author2", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "title3", "author3", "Sejarah", 3));

        // Inisialisasi data user
        userStudent.add(new Student("Taufiq Ramadhan", "202210370311288", "Teknik", "Informatika"));
        userStudent.add(new Student("Who", "202310370311135", "Teknik", "Informatika"));
        userStudent.add(new Student("Sutrisno Adit Pratama", "202210370311203", "Teknik", "Informatika"));
    }

}





