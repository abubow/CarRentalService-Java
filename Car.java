public class Car {
  private String make;
  private String model;
  private int year;
  private String color;
  private String plateNumber;
  private String status;
  private static int idCounter = 0;
  private String carId;

  // Constructor
  public Car(String make, String model, int year, String color, String plateNumber) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.plateNumber = plateNumber;
    this.status = "available";
    this.carId = "C" + idCounter++;
  }

  // Getter methods
  public String getCarId() {
    return carId;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public String getColor() {
    return color;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public String getStatus() {
    return status;
  }

  // Setter methods
  public void setStatus(String status) {
    this.status = status;
  }

  // Method to edit car information
  public void editCarInformation(String make, String model, int year, String color, String plateNumber) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.plateNumber = plateNumber;
  }
}