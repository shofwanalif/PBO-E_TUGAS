package org.example;

import java.util.Scanner;
public class tugas1md1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Library System ====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Chose option (1-3): ");

            int pilUser = userInput.nextInt();
            switch (pilUser) {
                case 1:
                    Scanner nim = new Scanner(System.in);
                    System.out.print("Enter your NIM: ");
                    String NIM = nim.nextLine();
                    if (NIM.length() == 15) {
                        System.out.println("Successfull Login as Student");
                    } else {
                        System.out.println("user not found");
                    }
                    break;
                case 2:
                    Scanner username = new Scanner(System.in);
                    Scanner password = new Scanner(System.in);
                    System.out.print("Enter your username: ");
                    String UserName = username.nextLine();
                    System.out.print("Enter your password: ");
                    String Password = password.nextLine();

                    if(UserName.equals("Admin") && Password.equals("Admin")){
                        System.out.println("Successfull Login as Admin");
                    } else {
                        System.out.println("Admin User not found!");
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.print("Adios!");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        }

    }
}