public class Admin extends User {
  // Constructor
  public Admin(String name, int age, String gender, String email, String phone, String password) {
    super(name, age, gender, email, phone, password);
  }

  // Method to authenticate admin login
  public boolean authenticateAdminLogin(String username, String password) {
    return (this.getEmail().equals(username) && this.getPassword().equals(password));
  }

  // Method to get admin role
  public String getAdminRole() {
    return "admin";
  }
}