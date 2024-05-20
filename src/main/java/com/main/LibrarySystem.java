package com.main;

import books.*;
import data.Admin;
import data.Student;
import exception.custom.illegalAdminAccess;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    public static ArrayList<Book> bookList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        bookList.add(new TextBook("TB164", "Manusia Baru", 4, "Text", "Eudora"));
        bookList.add(new HistoryBook("HB03F", "Budaya Pancasila", 2, "History", "Moskov"));
        bookList.add(new StoryBook("SB413", "Cina Timor", 17, "Story", "Martis"));
        bookList.add(new HistoryBook("HB09P", "Dilema Bansos", 2, "History", "Moskov"));

        // Mengisi daftar mahasiswa
        studentList.add(new Student("202310370311238", "Shofawn Alif Aflani", "Teknik", "Mesin"));
        studentList.add(new Student("202310370311239", "Ahmad Sultan", "Teknik", "Informatika"));
        studentList.add(new Student("202310370311240", "Tio Putra", "Teknik", "Elektro"));
        menu();

    }

    public static void menu() {
        boolean isRunning = true;
        while (isRunning) {

            try {
                System.out.println("===== Library System =====");
                System.out.println("1. Login sebagai Mahasiswa");
                System.out.println("2. Login sebagai Admin");
                System.out.println("3. Keluar");
                System.out.print("Pilih antara (1-3): ");


                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan NIM : ");
                        String nimStudent = scanner.next();
                        scanner.nextLine();
                        while (true) {
                            if (nimStudent.length() != 15) {
                                System.out.print("Nim Harus 15 Digit!!!\n");
                                System.out.print("Masukkan NIM : ");
                                nimStudent = scanner.nextLine();
                            } else if (checkNim(nimStudent)) {
                                Student student = new Student(nimStudent);
                                student.login();
                                break;
                            } else {
                                System.out.println("Nim tidak terdaftar!");
                                break;
                            }
                        }
                        break;
                    case 2:
                        Admin admin = new Admin();
                        admin.login();
                        break;
                    case 3:
                        System.out.println("Terima kasih semoga puas dengan pelayanan kami");
                        isRunning = false;
                        break;
                    default:
                        throw new illegalAdminAccess("Invalid credentials");
                }
            } catch (illegalAdminAccess e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan inputan agar tidak terjadi loop
            }
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
