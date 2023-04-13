import java.util.ArrayList;

public class CarRentalSystem {
  private ArrayList<User> users;
  private ArrayList<Car> cars;
  private ArrayList<Booking> bookings;
  private User currentUser;

  // Constructor
  public CarRentalSystem() {
    users = new ArrayList<>();
    cars = new ArrayList<>();
    bookings = new ArrayList<>();
  }

  // Method to login to the system
  public Customer loginCustomer(String email, String password) {
    for (User user : users) {
      if (user.getEmail().equals(email) && user.getPassword().equals(password) && user instanceof Customer) {
        currentUser = user;
        return (Customer) user;
      }
    }
    return null;
  }

  public Admin loginAdmin(String email, String password) {
    for (User user : users) {
      if (user.getEmail().equals(email) && user.getPassword().equals(password) && user instanceof Admin) {
        currentUser = user;
        return (Admin) user;
      }
    }
    return null;
  }

  // Method to add a new customer to the system
  public boolean addCustomer(String name, int age, String gender, String email, String phone, String password) {
    for (User user : users) {
      if (user.getEmail().equals(email)) {
        return false;
      }
    }
    Customer newCustomer = new Customer(name, age, gender, email, phone, password);
    users.add(newCustomer);
    return true;
  }

  // overload method to add a new customer to the system
  public boolean addCustomer(Customer customer) {
    for (User user : users) {
      if (user.getEmail().equals(customer.getEmail())) {
        return false;
      }
    }
    users.add(customer);
    return true;
  }

  // Method to add a new admin to the system
  public boolean addAdmin(String name, int age, String gender, String email, String phone, String password) {
    for (User user : users) {
      if (user.getEmail().equals(email)) {
        return false;
      }
    }
    Admin newAdmin = new Admin(name, age, gender, email, phone, password);

    users.add(newAdmin);
    return true;
  }

  // overload method to add a new admin to the system
  public boolean addAdmin(Admin admin) {
    for (User user : users) {
      if (user.getEmail().equals(admin.getEmail())) {
        return false;
      }
    }
    users.add(admin);
    return true;
  }

  // Method to add a new car to the system
  public boolean addCar(String make, String model, int year, String color, String plateNumber) {
    for (Car car : cars) {
      if (car.getPlateNumber().equals(plateNumber)) {
        return false;
      }
    }
    Car newCar = new Car(make, model, year, color, plateNumber);
    newCar.setStatus("available");
    cars.add(newCar);
    return true;
  }

  // Method to search for a car by plate number
  public Car searchCar(String plateNumber) {
    for (Car car : cars) {
      if (car.getPlateNumber().equals(plateNumber)) {
        return car;
      }
    }
    return null;
  }

  // Method to delete a car
  public boolean deleteCar(String carId) {
    for (Car car : cars) {
      if (car.getCarId() == carId) {
        if (car.getStatus().equals("booked")) {
          return false;
        }
        cars.remove(car);
        return true;
      }
    }
    return false;
  }

  // Method to update a car's information
  public boolean updateCarInformation(String carId, String make, String model, int year, String color,
      String plateNumber) {
    for (Car car : cars) {
      if (car.getCarId() == carId) {
        if (car.getStatus().equals("booked")) {
          return false;
        }
        car.editCarInformation(make, model, year, color, plateNumber);
        return true;
      }
    }
    return false;
  }

  // Method to delete a user
  public boolean deleteUser(String userId) {
    for (User user : users) {
      if (user.getUserId() == userId) {
        users.remove(user);
        return true;
      }
    }
    return false;
  }

  // Method to view all users
  public ArrayList<User> viewAllUsers() {
    return users;
  }

  // Method to view all cars
  public ArrayList<Car> viewAllCars() {
    return cars;
  }

  // Method to create a new booking
  public boolean createBooking(String bookingId, Car car, String bookingDate, String pickupLocation,
      String dropoffLocation) {
    if (currentUser == null) {
      return false;
    }
    // public Booking(String bookingId, User user, Car car, String bookingDate,
    // String
    // pickupLocation, String dropoffLocation) {

    Booking newBooking = new Booking(bookingId, currentUser, car, bookingDate, pickupLocation, dropoffLocation);
    if (car.getStatus().equals("available")) {
      car.setStatus("booked");
      bookings.add(newBooking);
      return true;
    } else {
      return false;
    }
  }

  // Method to cancel a booking
  public boolean cancelBooking(String bookingId) {
    for (Booking booking : bookings) {
      if (booking.getBookingId() == bookingId) {
        bookings.remove(booking);
        booking.getCar().setStatus("available");
        return true;
      }
    }
    return false;
  }

  // Method to view all bookings
  public ArrayList<Booking> viewAllBookings() {
    return bookings;
  }
}