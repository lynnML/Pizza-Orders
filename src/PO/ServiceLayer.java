package PO;
import DAO.ConcretePizzaShopDAO;
import DAO.PizzaShopDAO;

import java.util.Calendar;
import java.util.Scanner;


public class ServiceLayer {
  
 
  public ServiceLayer(){
       
  }
  
  public void createCustomer(Customer acct){
    
    PizzaShopDAO cust = new ConcretePizzaShopDAO();
    cust.createCust(acct);
  }
  
  /**
   * Login checks customer exists in pizza database
   */
  public Customer login(){
    
    Customer currentUser = new Customer();
    PizzaShopDAO cust = new ConcretePizzaShopDAO();
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Please login in with existing account.");
    System.out.println("(If you do not have an account, you will have to signup)");
    
    
    System.out.print("Username: ");
    String loginInput = scan.nextLine();
    currentUser.setUserName(loginInput);
    
    System.out.print("Password: ");
    String passInput = scan.nextLine();
    currentUser.setPassword(passInput);
    
    
    currentUser = cust.retrieveCust(currentUser);
    
    if(currentUser.getFirstName() == null){
      PresentationLayer p = new PresentationLayer();
      p.signUp();
    }
  
    
    return currentUser;
    
  }
  

  /**
   * 
   */
  public void makeOrder(PlaceOrder placeOrder){
    
    Calendar calendar = Calendar.getInstance();
    java.util.Date now = calendar.getTime();
    java.sql.Timestamp deliveryTime = new java.sql.Timestamp(now.getTime());
    
    PizzaShopDAO customerOrder = new ConcretePizzaShopDAO();
    PlaceOrder order = placeOrder;
    
    order.setSizeOfPizza();
    order.setDeliveryTime(deliveryTime);
    
    order.setPizzaToppings();
    
  
    order.setPayment();
    
    customerOrder.createOrder(order);
    
    
  }
  public void discountedOrder(){
    
  }
  
  public void viewAllOrder(){
    
  }
  
  public void changeOrder(){
    
  }
  
  public void cancelOrder(){
    
  }
  
}
