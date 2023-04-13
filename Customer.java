import java.util.ArrayList;
public class Customer extends User {
  private ArrayList<Booking> bookings;
  private String id;
  private static int idCounter = 0;
  // Constructor
  public Customer(String name, int age, String gender, String email, String phone, String password) {
    super(name, age, gender, email, phone, password);
    bookings = new ArrayList<>();
    id = "C" + idCounter++;
  }

  // Method to register with the system
  public void register(String name, int age, String gender, String email, String phone, String password) {
    setName(name);
    setAge(age);
    setGender(gender);
    setEmail(email);
    setPhone(phone);
    setPassword(password);
  }

  // Method to update customer profile information
  public void updateCustomerProfile(String name, int age, String gender, String email, String phone, String password) {
    setName(name);
    setAge(age);
    setGender(gender);
    setEmail(email);
    setPhone(phone);
    setPassword(password);
  }

  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  // Method to check individual bookings
  public ArrayList<Booking> checkBookings() {
    return bookings;
  }

  // Method to create a new booking
  public boolean createBooking(int bookingId, Car car, String bookingDate, String pickupLocation,
      String dropoffLocation) {
    Booking newBooking = new Booking(bookingId, this, car, bookingDate, pickupLocation, dropoffLocation);
    if (car.getStatus().equals("available")) {
      car.setStatus("booked");
      bookings.add(newBooking);
      return true;
    } else {
      return false;
    }
  }

  // Method to cancel a booking
  public boolean cancelBooking(int bookingId) {
    for (Booking booking : bookings) {
      if (booking.getBookingId() == bookingId) {
        bookings.remove(booking);
        booking.getCar().setStatus("available");
        return true;
      }
    }
    return false;
  }

}