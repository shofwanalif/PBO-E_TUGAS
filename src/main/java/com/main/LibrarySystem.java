package com.main;

import java.util.*;

import books.*;
import data.*;

public class LibrarySystem {

        Scanner Input = new Scanner(System.in);
        private static final Student[] userStudent = new Student[100];
        private static final Book[] bookList = new Book[100];
        public static Student[] getUserStudent(){
            return userStudent;
        }
        public static Book[] getBookList() {
            return bookList;
        }

        public static void addBook(Book book) {
            for (int i = 0; i < bookList.length; i++) {
                if (bookList[i] == null) {
                    bookList[i] = book;
                    break;
                }
            }
        }

        public static Admin admin = new Admin(null, null, null, null);
        
        static LibrarySystem main = new LibrarySystem();
        
        public static void main(String[] args){
           
            
            userStudent[0] = new Student("Shofwan Alif Alfani", "202310370311238", "Teknik","Informatika");

            bookList[0] = new Book("388c-e681-9152", "Pemograman Java OOP", "max", "Novel", 10,5);
            
            Book historyBook = new HistoryBook("14567", "bulan bintang", "lewis", "Sejarah", 8, 8);
            addBook(historyBook);

            Book storyBook = new StoryBook("5678", "Pencari Surga", "Agus", "Cerita", 11, 9); 
            addBook(storyBook);

            Book textBook = new TextBook("91011", "Si Kancil","Andre","Novel", 20, 10);
            addBook(textBook);

            main.Menu();
            admin.addStudent();
            admin.inputBook();
    }
    
    public void Menu(){
        int pilihan;
        do {
            System.out.println("====== Library System ======");
            System.out.println("1. Login Sebagai Mahasiswa");
            System.out.println("2. Login Sebagai Admin");
            System.out.println("3. Exit");
            System.out.print("Pilih Opsi (1-3): ");
            pilihan= Input.nextInt();

            switch (pilihan) {
                case 1:
                    loginStudent();
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    exit();
                default:
                    System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
            }
        }while (pilihan !=3);

    }


    void loginStudent() {
        System.out.print("Masukan NIM : ");
        String NIM = Input.next();
    
        while (NIM.length() != 15) {
            System.out.println("NIM harus 15 digit angka.");
            System.out.print("Masukan NIM : ");
            NIM = Input.next();
        }
    
        if (checkNim(NIM)) {
            menuStudent();
        } else {
            System.out.println("User Not Found!! ");
        }
    }
    
 
    boolean checkNim(String NIM) {
        for (Student student : userStudent) {
            if (student != null && student.getNIM().equals(NIM)) {
                return true;
            }
        }
        return false;
    }
    

    public void menuStudent(){
        Student student = new Student(null, null, null, null);
        int pilihan;

        do {
            System.out.println("==== Student Menu ====");
            System.out.println("1. Tampilkan Buku yang Dipinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Pinjam Buku atau Keluar");
            System.out.print("Pilih opsi (1-4): ");
            pilihan = Input.nextInt();

            switch (pilihan) {
                case 1:
                    student.showBorrowedBooks();
                    break;
                case 2:
                    student.choiceBook();
                    break;
                case 3:
                    student.returnBooks();
                    break;
                case 4:
                    student.logOut();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (true);
    }
    

    void loginAdmin() {

        System.out.print("Masukan Username (admin) : ");
        String username = Input.next();
        Input.nextLine();
        System.out.print("Masukan Password (admin) : ");
        String pw = Input.next();

        if (username.equals("admin") && pw.equals("admin")){
            menuAdmin();
        }else {
            System.out.println("Admin User Not Found!!");
        }

    }

    public void menuAdmin(){
        
        int pilihan;
        do {
            System.out.println("===== Dashboard Admin =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Tampilkan Daftar Mahasiswa");
            System.out.println("4. Daftar Buku Tersedia");
            System.out.println("5. Logout");
            System.out.print("Pilih Opsi (1-5): ");
            pilihan = Input.nextInt();

            switch (pilihan) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.inputBook();
                    break;
                case 3:
                    admin.displayStudent();
                    break;
                case 4:
                    admin.displayBooks();
                    break;
                case 5:
                    System.out.println("System Logout...");
                    Menu();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
            }
        } while (pilihan != 3);
        System.out.println();
     }

    static void exit(){
        System.out.println("Terima Kasih!!!");
        System.exit(0);
    }

}
