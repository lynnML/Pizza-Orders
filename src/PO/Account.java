package PO;

public class Account {

  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private Address address;
	
  
  public Account(){
    
  }
  
  public Account(String firstName, String lastName, String userName){
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
  
	
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
	
  
	
  
}
