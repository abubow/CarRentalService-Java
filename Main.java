
// importing the basic java system libraries
import java.util.Scanner;
import java.util.ArrayList;

// system out print
import java.io.*;

class Main {
  // CarRentalSystem object
  private static CarRentalSystem carRentalSystem = new CarRentalSystem();

  // main method
  public static void main(String[] args) {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // main menu
    while (true) {
      System.out.println("Welcome to the Car Rental System");
      System.out.println("1. Login");
      System.out.println("2. Register");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          login();
          break;
        case 2:
          register();
          break;
        case 3:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  // login method
  public static void login() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // login menu
    while (true) {
      System.out.println("1. Login as Customer");
      System.out.println("2. Login as Admin");
      System.out.println("3. Back");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          loginCustomer();
          break;
        case 2:
          loginAdmin();
          break;
        case 3:
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  // login customer method
  public static void loginCustomer() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // login customer menu
    while (true) {
      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      Customer customer = carRentalSystem.loginCustomer(email, password);
      if (customer != null) {
        customerMenu(customer);
      } else {
        System.out.println("Invalid email or password");
      }
    }
  }

  // login admin method
  public static void loginAdmin() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // login admin menu
    while (true) {
      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      Admin admin = carRentalSystem.loginAdmin(email, password);
      if (admin != null) {
        adminMenu(admin);
      } else {
        System.out.println("Invalid email or password");
      }
    }
  }

  // register method
  public static void register() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // register menu
    while (true) {
      System.out.println("1. Register as Customer");
      System.out.println("2. Register as Admin");
      System.out.println("3. Back");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          registerCustomer();
          break;
        case 2:
          registerAdmin();
          break;
        case 3:
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  // register customer method
  public static void registerCustomer() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // register customer menu
    while (true) {
      System.out.println("Enter your name: ");
      String name = scanner.nextLine();
      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      System.out.println("Enter your phone number: ");
      String phoneNumber = scanner.nextLine();
      System.out.println("Enter your address: ");
      String address = scanner.nextLine();
      System.out.println("Enter your license number: ");
      String licenseNumber = scanner.nextLine();
      Customer customer = new Customer(name, email, password, phoneNumber, address, licenseNumber);
      if (carRentalSystem.addCustomer(customer)) {
        System.out.println("Customer registered successfully");
      } else {
        System.out.println("Customer already exists");
      }
    }
  }

  // register admin method
  public static void registerAdmin() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // register admin menu
    while (true) {
      System.out.println("Enter your name: ");
      String name = scanner.nextLine();
      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      System.out.println("Enter your phone number: ");
      String phoneNumber = scanner.nextLine();
      System.out.println("Enter your address: ");
      String address = scanner.nextLine();
      Admin admin = new Admin(name, email, password, phoneNumber, address);
      if (carRentalSystem.addAdmin(admin)) {
        System.out.println("Admin registered successfully");
      } else {
        System.out.println("Admin already exists");
      }
    }
  }
}