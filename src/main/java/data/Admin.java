package data;

import java.util.Scanner;
import java.util.UUID;

import books.*;
import util.iMenu;

import com.main.LibrarySystem;

public class Admin extends User implements iMenu {
    Scanner Input = new Scanner(System.in);
    Student[] userStudent = LibrarySystem.getUserStudent(); 
    Book[] bookList = LibrarySystem.getBookList(); 
    
    LibrarySystem main = new LibrarySystem();

    public Admin(String nama, String NIM, String fakultas, String prodi) {
        super(nama, NIM, fakultas, prodi);
    }

    public void addStudent() {
      System.out.print("Nama     : ");
      String nama = Input.next();
      String NIM;
      do {
          System.out.print("NIM      : ");
          NIM = Input.next();
          if (NIM.length() != 15)
              System.out.println("NIM harus 15 digit !!!");
      } while (NIM.length() != 15);
      System.out.print("Fakultas : ");
      String fakultas = Input.next();
      System.out.print("Prodi    : ");
      String prodi = Input.next();

      Student mahasiswa = new Student(nama, NIM, fakultas, prodi);
      for (int i = 0; i < userStudent.length; i++) {
          if (userStudent[i] == null) {
              userStudent[i] = mahasiswa;
              break;
          }
      }
      System.out.println("Mahasiswa berhasil ditambahkan");
  }
  

    public void displayStudent() {
        System.out.println("===== Daftar Mahasiswa =====");
        if (userStudent[0] == null) {
            System.out.println("Tidak ada mahasiswa yang terdaftar.");
        } else {
            for (Student student : userStudent) {
                if (student != null) {
                    System.out.println("Nama     : " + student.getNama());
                    System.out.println("NIM      : " + student.getNIM());
                    System.out.println("Fakultas : " + student.getFakultas());
                    System.out.println("Prodi    : " + student.getProdi());
                    System.out.println("---------------------------------");
                }
            }
        }
        System.out.println("99. Kembali ke Menu Admin");
        System.out.print("Masukkan angka 99 untuk kembali: ");
        int choice = Input.nextInt();
        if (choice == 99) {
            main.menuAdmin();
        } else {
            System.out.println("Pilihan tidak valid.");
            displayStudent();
        }
    }

    public void inputBook() {
      Book buku = null;

      System.out.println("===== Tambah Buku =====");
      System.out.println("Pilih kategori buku:");
      System.out.println("1. Story Book");
      System.out.println("2. History Book");
      System.out.println("3. Text Book");
      System.out.print("Pilih kategori (1-3): ");
      int pilihan = Input.nextInt();

      Input.nextLine(); // Membersihkan buffer

      System.out.print("Judul Buku: ");
      String judul = Input.nextLine();
      System.out.print("Penulis: ");
      String author = Input.nextLine();
      System.out.print("Stok Buku: ");
      int stok = Input.nextInt();

      switch (pilihan) {
          case 1:
              buku = new StoryBook(generateId(), judul, author, "Cerita", stok, 0);
              break;
          case 2:
              buku = new HistoryBook(generateId(), judul, author, "Sejarah", stok, 0);
              break;
          case 3:
              buku = new TextBook(generateId(), judul, author, "Novel", stok, 0);
              break;
          default:
              System.out.println("Pilihan Tidak Valid!!\nPilih Nomor (1-3) !!!");
              return;
      }

      for (int i = 0; i < bookList.length; i++) {
          if (bookList[i] == null) {
              bookList[i] = buku;
              break;
          }
      }

      System.out.println("Buku berhasil ditambahkan ke perpustakaan.");
  }

    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void displayBooks() {
        super.displayBooks();
        System.out.println("99. Kembali ke Menu Admin");
        System.out.print("Masukkan angka 99 untuk kembali: ");
        int choice = Input.nextInt();
        if (choice == 99) {
            main.menuAdmin();
        } else {
            System.out.println("Pilihan tidak valid.");
            displayBooks();
        }
    }

    @Override
    public void menu() {
        System.out.println("===== Dashboard Admin =====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tambah Buku");
        System.out.println("3. Tampilkan Daftar Mahasiswa");
        System.out.println("4. Daftar Buku Tersedia");
        System.out.println("5. Logout");
    }
}
