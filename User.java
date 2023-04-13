public class User {
  private String name;
  private int age;
  private String gender;
  private String email;
  private String phone;
  private String password;
  private static int idCounter = 0;
  private string userId;

  // Constructor
  public User(String name, int age, String gender, String email, String phone, String password, int userId) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.userId = "U" + idCounter++;
  }

  // Getter methods
  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassword() {
    return password;
  }

  // Setter methods
  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // Method to authenticate user login
  public boolean authenticateUserLogin(String username, String password) {
    return (this.email.equals(username) && this.password.equals(password));
  }

  // Method to get user role
  public String getUserRole() {
    return "customer";
  }

  // Method to update user profile information
  public void updateUserProfile(String name, int age, String gender, String email, String phone, String password) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }
}