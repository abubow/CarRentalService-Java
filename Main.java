
// importing the basic java system libraries
import java.util.Scanner;
import java.util.ArrayList;

// system out print
import java.io.*;

class Main {
  private static UserList userList = new UserList();
  private static CarList carList = new CarList();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Create an admin account and add to the user list
    Admin admin = new Admin("admin", "password", "Admin");
    userList.addUser(admin);

    // Display login prompt
    System.out.println("Welcome to the Car Rental System!");
    System.out.println("Please enter your username and password to login.");

    // Prompt user to enter username and password
    System.out.print("Username: ");
    String username = scanner.nextLine();
    System.out.print("Password: ");
    String password = scanner.nextLine();

    // Attempt to log in user
    User currentUser = userList.login(username, password);
    if (currentUser == null) {
      System.out.println("Invalid username or password. Exiting program.");
      return;
    }

    // Display appropriate menu for user type
    if (currentUser instanceof Admin) {
      adminMenu();
    } else if (currentUser instanceof Customer) {
      customerMenu((Customer) currentUser);
    } else {
      System.out.println("Invalid user type. Exiting program.");
      return;
    }
  }

  // Display menu for admin
  private static void adminMenu() {
    while (true) {
      System.out.println("\nPlease select an option:");
      System.out.println("1. Add a new car");
      System.out.println("2. Edit car information");
      System.out.println("3. Approve customer account");
      System.out.println("4. Delete customer account");
      System.out.println("5. View customer information");
      System.out.println("6. Search for customer by name");
      System.out.println("7. Confirm booking");
      System.out.println("8. Delete booking");
      System.out.println("9. View booking information");
      System.out.println("10. Search for booking by car number");
      System.out.println("11. Exit program");

      int option = scanner.nextInt();
      scanner.nextLine(); // consume newline character

      switch (option) {
        case 1:
          addCar();
          break;
        case 2:
          editCar();
          break;
        case 3:
          approveCustomer();
          break;
        case 4:
          deleteCustomer();
          break;
        case 5:
          viewCustomerInfo();
          break;
        case 6:
          searchCustomer();
          break;
        case 7:
          confirmBooking();
          break;
        case 8:
          deleteBooking();
          break;
        case 9:
          viewBookingInfo();
          break;
        case 10:
          searchBooking();
          break;
        case 11:
          System.out.println("Exiting program.");
          return;
        default:
          System.out.println("Invalid option.");
          break;
      }
    }
  }

  // Confirm booking
  private static void confirmBooking() {
    System.out.println("Please enter the booking ID:");
    int bookingId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    Booking booking = carList.getBookingById(bookingId);
    if (booking == null) {
      System.out.println("Booking ID not found.");
      return;
    }
    booking.setStatus("Confirmed");
    System.out.println("Booking confirmed.");
  }

  // Delete booking
  private static void deleteBooking() {
    System.out.println("Please enter the booking ID:");
    int bookingId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    Booking booking = carList.getBookingById(bookingId);
    if (booking == null) {
      System.out.println("Booking ID not found.");
      return;
    }
    carList.deleteBooking(booking);
    System.out.println("Booking deleted.");
  }

  // View booking information
  private static void viewBookingInfo() {
    System.out.println("Please enter the booking ID:");
    int bookingId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    Booking booking = carList.getBookingById(bookingId);
    if (booking == null) {
      System.out.println("Booking ID not found.");
      return;
    }
    System.out.println(booking);
  }

  // Search booking by car number
  private static void searchBooking() {
    System.out.println("Please enter the car number:");
    String carNumber = scanner.nextLine();
    Booking booking = carList.searchBooking(carNumber);
    if (booking == null) {
      System.out.println("Booking not found.");
      return;
    }
    System.out.println(booking);
  }

  // View Customer Information
  private static void viewCustomerInfo() {
    System.out.println("Please enter the customer's username:");
    String username = scanner.nextLine();
    Customer customer = (Customer) userList.getUser(username);
    if (customer == null) {
      System.out.println("Customer not found.");
      return;
    }
    System.out.println(customer);
  }

  // Search Customer by Name
  private static void searchCustomer() {
    System.out.println("Please enter the customer's name:");
    String name = scanner.nextLine();
    Customer customer = (Customer) userList.searchUser(name);
    if (customer == null) {
      System.out.println("Customer not found.");
      return;
    }
    System.out.println(customer);
  }

  // Add a new car to the car inventory
  private static void addCar() {
    System.out.println("Please enter the car number:");
    String carNumber = scanner.nextLine();
    System.out.println("Please enter the car make:");
    String make = scanner.nextLine();
    System.out.println("Please enter the car model:");
    String model = scanner.nextLine();
    System.out.println("Please enter the car year:");
    int year = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    System.out.println("Please enter the car color:");
    String color = scanner.nextLine();
    System.out.println("Please enter the car price per day:");
    double pricePerDay = scanner.nextDouble();
    scanner.nextLine(); // consume newline character
    System.out.println("Please enter the car status:");
    String status = scanner.nextLine();

    Car car = new Car(carNumber, make, model, year, color, pricePerDay, status);
    carList.addCar(car);
  }

  // Edit car information
  private static void editCar() {
    System.out.println("Please enter the car ID:");
    int carId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    Car car = carList.getCarById(carId);
    if (car == null) {
      System.out.println("Car ID not found.");
      return;
    }

    System.out.println("Please enter the car number:");
    String carNumber = scanner.nextLine();
    System.out.println("Please enter the car make:");
    String make = scanner.nextLine();
    System.out.println("Please enter the car model:");
    String model = scanner.nextLine();
    System.out.println("Please enter the car year:");
    int year = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    System.out.println("Please enter the car color:");
    String color = scanner.nextLine();
    System.out.println("Please enter the car price per day:");
    double pricePerDay = scanner.nextDouble();
    scanner.nextLine(); // consume newline character
    System.out.println("Please enter the car status:");
    String status = scanner.nextLine();

    car.setCarNumber(carNumber);
    car.setMake(make);
    car.setModel(model);
    car.setYear(year);
    car.setColor(color);
    car.setPricePerDay(pricePerDay);
    car.setStatus(status);
  }

  // Approve a customer account
  private static void approveCustomer() {
    System.out.println("Please enter the customer ID:");
    int customerId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    Customer customer = userList.getCustomerById(customerId);
    if (customer == null) {
      System.out.println("Customer ID not found.");
      return;
    }
    customer.setApproved(true);
  }

  // Delete a customer account
  private static void deleteCustomer() {
    System.out.println("Please enter the customer ID:");
    int customerId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    Customer customer = userList.getCustomerById(customerId);
    if (customer == null) {
      System.out.println("Customer ID not found.");
      return;
    }
    userList.deleteCustomer(customer);
  }

  // Display menu for customer
  private static void customerMenu(Customer customer) {
    while (true) {
      System.out.println("\nPlease select an option:");
      System.out.println("1. Update profile");
      System.out.println("2. View booking history");
      System.out.println("3. Search for available cars");
      System.out.println("4. Book a car");
      System.out.println("5. Cancel booking");
      System.out.println("6. Exit program");
      int option = scanner.nextInt();
      scanner.nextLine(); // consume newline character

      switch (option) {
        case 1:
          updateProfile(customer);
          break;
        case 2:
          System.out.println("Please enter the car ID:");
          int carId = scanner.nextInt();
          scanner.nextLine(); // consume newline character
          Car car = carInventory.getCarById(carId);
          if (car == null) {
            System.out.println("Car not found.");
          } else {
            System.out.println("Car details:");
            System.out.println(car.toString());
          }
          break;
        case 3:
          System.out.println("Please enter the car ID:");
          carId = scanner.nextInt();
          scanner.nextLine(); // consume newline character
          car = carInventory.getCarById(carId);
          if (car == null) {
            System.out.println("Car not found.");
          } else {
            updateCar(car);
          }
          break;
        case 4:
          System.out.println("Please enter the booking ID:");
          int bookingId = scanner.nextInt();
          scanner.nextLine(); // consume newline character
          Booking booking = bookingManagement.getBookingById(bookingId);
          if (booking == null) {
            System.out.println("Booking not found.");
          } else {
            System.out.println("Booking details:");
            System.out.println(booking.toString());
          }
          break;
        case 5:
          System.out.println("Please enter the booking ID:");
          bookingId = scanner.nextInt();
          scanner.nextLine(); // consume newline character
          booking = bookingManagement.getBookingById(bookingId);
          if (booking == null) {
            System.out.println("Booking not found.");
          } else {
            updateBooking(booking);
          }
          break;
        case 6:
          System.out.println("Thank you for using our car rental system. Goodbye!");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }

      System.out.println();
    }
  }
  // update Booking information
  private static void updateBooking(Booking booking) {
    System.out.println("Update Booking");
    System.out.println("1. Update booking ID");
    System.out.println("2. Update car ID");
    System.out.println("3. Update customer ID");
    System.out.println("4. Update booking start date");
    System.out.println("5. Update booking end date");
    System.out.println("6. Update booking status");
    System.out.println("7. Back to main menu");
    System.out.print("Please enter an option: ");

    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    scanner.nextLine(); // consume newline character

    switch (option) {
      case 1:
        System.out.print("Please enter your new booking ID: ");
        int bookingID = scanner.nextInt();
        booking.setBookingID(bookingID);
        break;
      case 2:
        System.out.print("Please enter your new car ID: ");
        int carID = scanner.nextInt();
        booking.setCarID(carID);
        break;
      case 3:
        System.out.print("Please enter your new customer ID: ");
        int customerID = scanner.nextInt();
        booking.setCustomerID(customerID);
        break;
      case 4:
        System.out.print("Please enter your new booking start date: ");
        String bookingStartDate = scanner.nextLine();
        booking.setBookingStartDate(bookingStartDate);
        break;
      case 5:
        System.out.print("Please enter your new booking end date: ");
        String bookingEndDate = scanner.nextLine();
        booking.setBookingEndDate(bookingEndDate);
        break;
      case 6:
        System.out.print("Please enter your new booking status: ");
        String bookingStatus = scanner.nextLine();
        booking.setBookingStatus(bookingStatus);
        break;
      case 7:
        return;
      default:
        System.out.println("Invalid option. Please try again.");
        break;
    }
  }

  // Update Car information
  private static void updateCar(Car car) {
    System.out.println("Update Car");
    System.out.println("1. Update car number");
    System.out.println("2. Update car make");
    System.out.println("3. Update car model");
    System.out.println("4. Update car year");
    System.out.println("5. Update car color");
    System.out.println("6. Update car price per day");
    System.out.println("7. Update car status");
    System.out.println("8. Back to main menu");
    System.out.print("Please enter an option: ");

    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    scanner.nextLine(); // consume newline character

    switch (option) {
      case 1:
        System.out.print("Please enter your new car number: ");
        String carNumber = scanner.nextLine();
        car.setCarNumber(carNumber);
        break;
      case 2:
        System.out.print("Please enter your new car make: ");
        String make = scanner.nextLine();
        car.setMake(make);
        break;
      case 3:
        System.out.print("Please enter your new car model: ");
        String model = scanner.nextLine();
        car.setModel(model);
        break;
      case 4:
        System.out.print("Please enter your new car year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        car.setYear(year);
        break;
      case 5:
        System.out.print("Please enter your new car color: ");
        String color = scanner.nextLine();
        car.setColor(color);
        break;
      case 6:
        System.out.print("Please enter your new car price per day: ");
        double pricePerDay = scanner.nextDouble();
        scanner.nextLine(); // consume newline character
        car.setPricePerDay(pricePerDay);
        break;
      case 7:
        System.out.print("Please enter your new car status: ");
        String status = scanner.nextLine();
        car.setStatus(status);
        break;
      case 8:
        return;
      default:
        System.out.println("Invalid option. Please try again.");
        break;
    }
  }

  private static void updateProfile(Customer customer) {
    System.out.println("Update Profile");
    System.out.println("1. Update name");
    System.out.println("2. Update gender");
    System.out.println("3. Update age");
    System.out.println("4. Update phone number");
    System.out.println("5. Update email address");
    System.out.println("6. Update home address");
    System.out.println("7. Back to main menu");
    System.out.print("Please enter an option: ");

    Scanner scanner = new Scanner(System.in);
    int option = scanner.nextInt();
    scanner.nextLine(); // consume newline character

    switch (option) {
      case 1:
        System.out.print("Please enter your new name: ");
        String name = scanner.nextLine();
        customer.setName(name);
        break;
      case 2:
        System.out.print("Please enter your new gender (M/F): ");
        char gender = scanner.nextLine().charAt(0);
        customer.setGender(gender);
        break;
      case 3:
        System.out.print("Please enter your new age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        customer.setAge(age);
        break;
      case 4:
        System.out.print("Please enter your new phone number: ");
        String phoneNumber = scanner.nextLine();
        customer.setPhoneNumber(phoneNumber);
        break;
      case 5:
        System.out.print("Please enter your new email address: ");
        String emailAddress = scanner.nextLine();
        customer.setEmailAddress(emailAddress);
        break;
      case 6:
        System.out.print("Please enter your new home address: ");
        String homeAddress = scanner.nextLine();
        customer.setHomeAddress(homeAddress);
        break;
      case 7:
        System.out.println("Your bookings: ");
        List<Booking> bookings = rentalSystem.getBookingsByCustomer(customer);
        if (bookings.isEmpty()) {
          System.out.println("You have no bookings.");
        } else {
          for (Booking booking : bookings) {
            System.out.println(booking);
          }
        }
        break;
      case 8:
        System.out.print("Enter the car ID: ");
        int carId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        Car car = rentalSystem.getCarById(carId);
        if (car == null) {
          System.out.println("Invalid car ID.");
        } else {
          System.out.println("Car details:");
          System.out.println(car);
          System.out.println("Enter 'book' to book this car, or any other key to go back.");
          String input = scanner.nextLine();
          if (input.equalsIgnoreCase("book")) {
            Booking booking = new Booking(customer, car);
            if (rentalSystem.addBooking(booking)) {
              System.out.println("Booking confirmed.");
            } else {
              System.out.println("Booking failed. Please try again later.");
            }
          }
        }
        break;
      case 9:
        System.out.println("Thank you for using the car rental system!");
        exit = true;
        break;
      default:
        System.out.println("Invalid option. Please try again.");
    }
  }

}