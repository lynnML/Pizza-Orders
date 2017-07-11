package PO;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "customer_info")
public class Customer {
  

  @Id
  @GeneratedValue//(strategy = GenerationType.AUTO)
  @Column(name = "customer_id")
  private int custID;
  private String firstName;
  private String lastName;
  private Address address;
  private String password;
  private java.util.Calendar registrationDate;
  
  /**@OneToMany(mappedBy="customer", targetEntity = PlaceOrder.class, 
           fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  private List<PlaceOrder> placeOrders;
  **/
  @Column(unique = true, name="user_Name")
  private String userName;
  
  
  

  public int getCustID() {
    return custID;
  }

  public void setCustID(int userID) {
    this.custID = userID;
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
  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
  

  //@Temporal(TemporalType.DATE)
  public java.util.Calendar getRegistrationDate() {
    return registrationDate;
  } 
  public void setRegistrationDate(java.util.Calendar registrationDate) {
    this.registrationDate = registrationDate;
  }
   
  public String toString()
    { return userName + " " + registrationDate; }
  
  
  
  
}
