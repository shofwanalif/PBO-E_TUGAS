package data;

import java.util.*;

import books.*;
import util.iMenu;

import com.main.LibrarySystem;


public class Student extends User implements iMenu {


    Scanner Input = new Scanner(System.in);
    Book[] borrowedBooks = new Book[100];
    LibrarySystem main = new LibrarySystem();

    public Student(String nama, String NIM, String fakultas, String prodi) {
        super(nama, NIM, fakultas, prodi);
    }

    public void displayInfo() {
        System.out.println("===== Data Diri Mahasiswa =====");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNIM());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Prodi: " + getProdi());
    }

    public void showBorrowedBooks() {
        boolean anyBooksBorrowed = false;
    
        System.out.println("===== Daftar Buku Dipinjam =====");
        for (int i = 0; i < borrowedBooks.length; i++) {
            Book book = borrowedBooks[i];
            if (book != null) {
                anyBooksBorrowed = true;
                System.out.println("ID Buku    : " + book.getId_buku());
                System.out.println("Judul Buku : " + book.getJudul());
                System.out.println("Author     : " + book.getAuthor());
                System.out.println("Category   : " + book.getCategory());
                System.out.println("Durasi     : " + book.getDuration() + " hari");
                System.out.println("---------------------------------");
            }
        }
    
        if (!anyBooksBorrowed) {
            System.out.println("Tidak ada buku yang dipinjam.");
        }
    }    

    public void logOut() {
        boolean hasBorrowedBooks = false;
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] != null) {
                hasBorrowedBooks = true;
                break;
            }
        }
    
        if (!hasBorrowedBooks) {
            System.out.println("Anda telah berhasil logout.");
        } else {
            System.out.println("Apakah kamu yakin untuk meminjam semua buku tersebut?");
            System.out.println("Input Y (iya) atau T (tidak):");
    
            String choice = Input.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Peminjaman buku berhasil dilakukan.");
            } else {
                System.out.println("Logout dibatalkan.");
                main.menuStudent(); 
            }
        }
    }
    
    


    public void choiceBook() {
        Book[] bookList = LibrarySystem.getBookList();
        displayBooks();
        System.out.println("99. Kembali ke Menu");
        System.out.print("Pilih buku yang ingin dipinjam (input ID buku atau 99 untuk kembali): ");
        String bookId = Input.next();
        if (bookId.equals("99")) {
            return;
        }

        Book bookToBorrow = null;
        for (Book buku : bookList) {
            if (buku.getId_buku().equals(bookId)) {
                bookToBorrow = buku;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Buku tidak ditemukan.");
        } else if (bookToBorrow.getStockBuku() <= 0) {
            System.out.println("Stok buku habis!");
        } else {
            System.out.print("Masukkan durasi peminjaman (maksimal 14 hari): ");
            int duration = Input.nextInt();
            Input.nextLine();
            if (duration > 14) {
                System.out.println("Anda hanya dapat meminjam buku maksimal selama 14 hari.");
            } else {
                bookToBorrow.setStockBuku(bookToBorrow.getStockBuku() - 1);
                bookToBorrow.setDuration(duration);
                for (int i = 0; i < borrowedBooks.length; i++) {
                    if (borrowedBooks[i] == null) {
                        borrowedBooks[i] = bookToBorrow;
                        System.out.println("Peminjaman buku berhasil dilakukan."); 
                        break;
                    }
                }
            }
        }
    }
    
    public void returnBooks() {
        boolean anyBooksBorrowed = false;
  
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] != null) {
                anyBooksBorrowed = true;
                break;
            }
        }
    
        if (!anyBooksBorrowed) {
            System.out.println("Anda belum meminjam buku apapun.");
            return;
        }
    
        System.out.println("===== Buku yang Dipinjam =====");
        for (int i = 0; i < borrowedBooks.length; i++) {
            Book book = borrowedBooks[i];
            if (book != null) {
                System.out.println("ID Buku    : " + book.getId_buku());
                System.out.println("Judul Buku : " + book.getJudul());
                System.out.println("Author     : " + book.getAuthor());
                System.out.println("Category   : " + book.getCategory());
                System.out.println("Durasi     : " + book.getDuration() + " hari");
                System.out.println("---------------------------------");
            }
        }
        System.out.print("Apakah kamu yakin untuk mengembalikan semua buku tersebut? (Y/T): ");
        String choice = Input.next();
        if (choice.equalsIgnoreCase("Y")) {
            for (int i = 0; i < borrowedBooks.length; i++) {
                Book book = borrowedBooks[i];
                if (book != null) {
                    book.setStockBuku(book.getStockBuku() + 1);
                    borrowedBooks[i] = null;
                }
            }
            System.out.println("Pengembalian buku berhasil dilakukan.");
        } else {
            System.out.println("Pengembalian buku dibatalkan.");
        }
    }
    

    @Override
    public void menu() {
        System.out.println("==== Student Menu ====");
        System.out.println("1. Tampilkan Buku yang Dipinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Pinjam Buku atau Keluar");
    }

}






