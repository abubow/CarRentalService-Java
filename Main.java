
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
      System.out.print("\033[H\033[2J");
      System.out.flush();
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
      // Clear the screen
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Welcome to the Car Rental System");
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
          System.out.println("\033[H\033[2J");
          return;
        case 0:
          System.out.print("\033[H\033[2J");
          System.out.println("Thank you for using our program");
          System.exit(0);
          break;
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
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      Customer customer = carRentalSystem.loginCustomer(email, password);
      if (customer != null) {
        customerMenu(customer);
        // System.out.println("Login successful");
        // return;
      } else {
        System.out.println("Invalid email or password");
      }
    }
  }

  // customer menu method
  public static void customerMenu(Customer customer) {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // customer menu
    while (true) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Welcome " + customer.getName());
      System.out.println("1. View Cars");
      System.out.println("2. Book a Car");
      System.out.println("3. Search a Car");
      System.out.println("4. View Bookings");
      System.out.println("5. Logout");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          viewCars();
          break;
        case 2:
          bookCar();
          break;
        case 3:
          searchCar();
          break;
        case 4:
          viewBookings();
          break;
        case 5:
          return;
        case 0:
          System.out.print("\033[H\033[2J");
          System.out.println("Thank you for using our program");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  // view cars method
  public static void viewCars() {
    // Printing the cars
    ArrayList<Car> cars = carRentalSystem.viewAllCars();
    for (Car car : cars) {
      // public Car(String make, String model, int year, String color, String
      // plateNumber) {
      printCar(car);
    }
  }

  // view bookings method
  public static void viewBookings() {
    // Printing the bookings
    ArrayList<Booking> bookings = carRentalSystem.viewAllBookings();
    for (Booking booking : bookings) {
      System.out.println("Booking ID: " + booking.getBookingId());
      System.out.println("Booking Date: " + booking.getBookingDate());
      System.out.println("Pickup Location: " + booking.getPickupLocation());
      System.out.println("Dropoff Location: " + booking.getDropoffLocation());
      System.out.println("Car Details: ");
      printCar(booking.getCar());
    }
  }

  // book car method
  public static void bookCar() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);

    // Cars
    ArrayList<Car> cars = carRentalSystem.viewAllCars();

    // book car menu
    while (true) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("Following are the cars available for booking");
      for (Car car : cars) {
        System.out.println("Car ID: " + car.getCarId());
        System.out.println("Car Name: " + car.getMake() + " " + car.getModel());
        System.out.println("Car Year: " + car.getYear());
        System.out.println("Car Color: " + car.getColor());
        System.out.println("");
      }
      System.out.println("Enter the car ID you want to book: ");
      String carId = scanner.nextLine();
      Car car = carRentalSystem.searchCar(carId);
      System.out.println("Enter the booking date: ");
      String bookingDate = scanner.nextLine();
      System.out.println("Enter the pickup location: ");
      String pickupLocation = scanner.nextLine();
      System.out.println("Enter the dropoff location: ");
      String dropoffLocation = scanner.nextLine();
      boolean isBooked = carRentalSystem.createBooking(carId, car, bookingDate, pickupLocation, dropoffLocation);
      if (isBooked) {
        System.out.println("Car booked successfully");
        return;
      } else {
        System.out.println("Car booking failed");
      }
    }
  }

  // print car method
  public static void printCar(Car car) {
    System.out.println("Car ID: " + car.getCarId());
    System.out.println("Car Name: " + car.getMake() + " " + car.getModel());
    System.out.println("Car Year: " + car.getYear());
    System.out.println("Car Color: " + car.getColor());
    System.out.println("Car Plate Number: " + car.getPlateNumber());
    System.out.println();
  }

  // search car method
  public static void searchCar() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // cars
    ArrayList<Car> cars = carRentalSystem.viewAllCars();
    // search car menu
    while (true) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println("1. Search by Make");
      System.out.println("2. Search by Model");
      System.out.println("3. Search by Year");
      System.out.println("4. Search by Color");
      System.out.println("5. Search by Plate Number");
      System.out.println("6. Back");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          System.out.println("Enter the make: ");
          String make = scanner.nextLine();
          for (Car car : cars) {
            if (car.getMake().equals(make)) {
              printCar(car);
            }
          }
          break;
        case 2:
          System.out.println("Enter the model: ");
          String model = scanner.nextLine();
          for (Car car : cars) {
            if (car.getModel().equals(model)) {
              printCar(car);
            }
          }
          break;
        case 3:
          System.out.println("Enter the year: ");
          int year = scanner.nextInt();
          scanner.nextLine();
          for (Car car : cars) {
            if (car.getYear() == year) {
              printCar(car);
            }
          }
          break;
        case 4:
          System.out.println("Enter the color: ");
          String color = scanner.nextLine();
          for (Car car : cars) {
            if (car.getColor().equals(color)) {
              printCar(car);
            }
          }
          break;
        case 5:
          System.out.println("Enter the plate number: ");
          String plateNumber = scanner.nextLine();
          for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
              printCar(car);
            }
          }
          break;
        case 6:
          // clear the screen
          System.out.print("\033[H\033[2J");
          return;
        case 0:
          // clear the screen
          System.out.print("\033[H\033[2J");
          System.out.println("Thank you for using our program");
          System.exit(0);
        default:
          System.out.println("Invalid choice");
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
        System.out.println("Thank you for using our program");
        return;
      } else {
        System.out.println("Invalid email or password");
      }
    }
  }

  // Admin Menu Method
  public static void adminMenu(Admin admin) {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // admin menu
    while (true) {
      System.out.println("1. Add Car");
      System.out.println("2. Remove Car");
      System.out.println("3. View All Cars");
      System.out.println("4. View All Bookings");
      System.out.println("5. View All Customers");
      System.out.println("6. Update Car Info");
      System.out.println("7. Delete Customer");
      System.out.println("8. Cancel Booking");
      System.out.println("9. Logout");
      System.out.print("0. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 0:
          System.out.print("\033[H\033[2J");
          System.out.println("Thank you for using our program");
          System.exit(0);
        case 1:
          addCar();
          break;
        case 2:
          removeCar();
          break;
        case 3:
          viewCars();
          break;
        case 4:
          viewBookings();
          break;
        case 5:
          viewCustomers();
          break;
        case 6:
          updateCarInfo();
          break;
        case 7:
          deleteCustomer();
          break;
        case 8:
          cancelBooking();
          break;
        case 9:
          // clear screen
          System.out.print("\033[H\033[2J");
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  // cancel booking method
  public static void cancelBooking() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // all bookings
    ArrayList<Booking> bookings = carRentalSystem.viewAllBookings();
    while (true) {
      // booking id
      System.out.println("Enter the booking id: ");
      String bookingId = scanner.nextLine();
      // check if booking id exists
      for (Booking booking : bookings) {
        if (booking.getBookingId().equals(bookingId)) {
          // cancel booking
          carRentalSystem.cancelBooking(bookingId);
          System.out.println("Booking cancelled");
          return;
        }
      }
      System.out.println("Invalid booking id");
    }
    // // cancel booking
    // carRentalSystem.cancelBooking(bookingId);
  }

  // view customers method
  public static void viewCustomers() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // customers
    ArrayList<Customer> customers = carRentalSystem.viewAllCustomers();
    // print customers
    for (Customer customer : customers) {
      printCustomer(customer);
    }
    System.out.println("Press enter to continue");
    scanner.nextLine();
  }

  // print customer method
  // Customer(String name, int age, String gender, String email, String phone,
  // String password)
  public static void printCustomer(Customer customer) {
    System.out.println("User id: " + customer.getUserId());
    System.out.println("Customer id: " + customer.getId());
    System.out.println("Name: " + customer.getName());
    System.out.println("Age: " + customer.getAge());
    System.out.println("Gender: " + customer.getGender());
    System.out.println("Email: " + customer.getEmail());
    System.out.println("Phone: " + customer.getPhone());
  }

  // delete customer method
  public static void deleteCustomer() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // Customer objects
    ArrayList<Customer> customers = carRentalSystem.viewAllCustomers();
    // select customer
    while (true) {
      System.out.println("Enter the User Id of the customer you want to delete: ");
      String userID = scanner.nextLine();
      Boolean found = false;
      for (Customer customer : customers) {
        if (customer.getUserId().equals(userID)) {
          found = true;
          break;
        }
      }
      if (!found) {
        System.out.println("Customer not found");
      } else {
        break;
      }
    }
    // delete customer
    carRentalSystem.deleteCustomer(userID);
  }

  // Update Car Info Method
  public static void updateCarInfo() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // select car
    while (true) {
      System.out.println("Enter the plate number of the car you want to update: ");
      String plateNumber = scanner.nextLine();
      Car car = carRentalSystem.searchCar(plateNumber);
      if (car == null) {
        System.out.println("Car not found");
      } else {
        break;
      }
    }
    while (true) {
      // print previous car info
      System.out.println("Previous Car Info");
      printCar(car);

      // ask for new car info
      // updateCarInformation(String carId, String make, String model, int year,
      // String color,
      System.out.println("Enter the new car info");
      System.out.println("Enter the make: ");
      String make = scanner.nextLine();
      System.out.println("Enter the model: ");
      String model = scanner.nextLine();
      System.out.println("Enter the year: ");
      int year = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Enter the color: ");
      String color = scanner.nextLine();
      // update car info
      Boolean done = carRentalSystem.updateCarInformation(car.getCarId(), make, model, year, color);
      if (done) {
        System.out.println("Car info updated successfully");
        return;
      }
      // clear screen
      System.out.print("\033[H\033[2J");
      System.out.println("Car info not updated due to an error");
    }
  }

  // update car info menu

  // View All Cars Method
  public static void viewAllCars() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // cars
    ArrayList<Car> cars = carRentalSystem.viewAllCars();
    // view all cars menu
    while (true) {
      System.out.print("\033[H\033[2J");
      System.out.flush();
      for (Car car : cars) {
        printCar(car);
      }
      System.out.println("1. Back");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 0:
          System.out.print("\033[H\033[2J");
          System.out.println("Thank you for using our program");
          System.exit(0);
        case 1:
          // clear screen
          System.out.print("\033[H\033[2J");
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }

  // remove car method
  public static void removeCar() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // remove car menu
    while (true) {
      System.out.println("Enter the Car Id: ");
      String carId = scanner.nextLine();
      Boolean car = carRentalSystem.removeCar(carId);
      if (!car) {
        System.out.println("Car not found or is booked");
      } else {
        System.out.println("Car removed successfully");
        return;
      }
    }
  }

  // add car method
  public static void addCar() {
    // Scanner object
    Scanner scanner = new Scanner(System.in);
    // add car menu
    while (true) {
      // addCar(String make, String model, int year, String color, String plateNumber)
      // {
      System.out.println("Enter the make: ");
      String make = scanner.nextLine();
      System.out.println("Enter the model: ");
      String model = scanner.nextLine();
      System.out.println("Enter the year: ");
      int year = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Enter the color: ");
      String color = scanner.nextLine();
      System.out.println("Enter the plate number: ");
      String plateNumber = scanner.nextLine();
      Boolean car = carRentalSystem.addCar(make, model, year, color, plateNumber);
      if (!car) {
        System.out.println("Car already exists");
      } else {
        System.out.println("Car added successfully");
        return;
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
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 0:
          // clear screen
          System.out.print("\033[H\033[2J");
          System.out.println("Thank you for using our program");
          System.exit(0);
        case 1:
          registerCustomer();
          break;
        case 2:
          registerAdmin();
          break;
        case 3:
          // clear screen
          System.out.print("\033[H\033[2J");
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
      // public Customer(String name, int age, String gender, String email, String
      // phone, String password) {
      System.out.println("Enter your name: ");
      String name = scanner.nextLine();
      System.out.println("Enter your age: ");
      int age = scanner.nextInt();
      scanner.nextLine();
      String gender = "";
      do {
        System.out.println("Enter your gender (M/F): ");
        gender = scanner.nextLine();
      } while (!(gender.toLowerCase().equals("m") || gender.toLowerCase().equals("f")));

      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      System.out.println("Enter your phone number: ");
      String phoneNumber = scanner.nextLine();
      Customer customer = new Customer(name, age, gender, email, phoneNumber, password);
      if (carRentalSystem.addCustomer(customer)) {
        System.out.println("Customer registered successfully");
        return;
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
      // public Admin(String name, int age, String gender, String email, String phone,
      // String password) {
      System.out.println("Enter your name: ");
      String name = scanner.nextLine();
      System.out.println("Enter your age: ");
      int age = scanner.nextInt();
      scanner.nextLine();
      String gender = "";
      do {
        System.out.println("Enter your gender (M/F): ");
        gender = scanner.nextLine();
        //
      } while (!(gender.toLowerCase().equals("m") || gender.toLowerCase().equals("f")));

      System.out.println("Enter your email: ");
      String email = scanner.nextLine();
      System.out.println("Enter your phone number: ");
      String phoneNumber = scanner.nextLine();
      System.out.println("Enter your password: ");
      String password = scanner.nextLine();
      Admin admin = new Admin(name, age, gender, email, phoneNumber, password);
      if (carRentalSystem.addAdmin(admin)) {
        System.out.println("Admin registered successfully");
        return;
      } else {
        System.out.println("Admin already exists");
      }
    }
  }
}