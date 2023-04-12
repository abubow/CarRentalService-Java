public class Booking {
  private int bookingId;
  private User user;
  private Car car;
  private String bookingDate;
  private String pickupLocation;
  private String dropoffLocation;
  private String status;

  // Constructor
  public Booking(int bookingId, User user, Car car, String bookingDate, String pickupLocation, String dropoffLocation) {
    this.bookingId = bookingId;
    this.user = user;
    this.car = car;
    this.bookingDate = bookingDate;
    this.pickupLocation = pickupLocation;
    this.dropoffLocation = dropoffLocation;
    this.status = "booked";
  }

  // Getter methods
  public int getBookingId() {
    return bookingId;
  }

  public User getUser() {
    return user;
  }

  public Car getCar() {
    return car;
  }

  public String getBookingDate() {
    return bookingDate;
  }

  public String getPickupLocation() {
    return pickupLocation;
  }

  public String getDropoffLocation() {
    return dropoffLocation;
  }

  public String getStatus() {
    return status;
  }
}
