package PO;

import DAO.ConcretePizzaShopDAO;
import DAO.PizzaShopDAO;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * PresentationLayer with MAIN
 * @author LYNN
 *
 */
public class PresentationLayer {
  
  private static final int MAXCOUNTER = 3;
  private Scanner scan = new Scanner(System.in);
  private ServiceLayer s = new ServiceLayer();
  private Customer currentCustomer;
  PlaceOrder currentOrder = new PlaceOrder();
  private PizzaSize size;
  private PaymentType type;
  private Topping topping1, topping2, topping3;
  
  
  
  /**
   * Main
   * @param args
   */
  public static void main(String[] args){
    
  PresentationLayer p = new PresentationLayer();
  
  System.out.println("Welcome to Pizza 3.14 Ordering Company");
 

  int num = p.menu();
  while( num != 0){
      p.menuChoice(num);
    num = p.menu();
  }

  System.out.println("\nThank you for choosing Pizza 3.14" );
  

  }//Main

  /**
   * MENU
   * @param num
   * @param p
   * @return
   */
  public int menuChoice(int num){
    if(num == 1){
      signUp();
      
    }
    
    if(num == 2){
      currentCustomer = s.login();
      //menu();
    }
    
    if(num == 3){
      
      sizeMenu();
      
      
      topMenu(topping1);
      topMenu(topping2);
      //topMenu(topping3);
      payMenu();
      
      s.makeOrder(this.currentOrder);
      
      currentOrder.reset();
    
  
      
    }
    
    if(num == 0){
      num = 0;
    }
    
    return num;
    
    
  }
  
  
  public void topMenu(Topping t){
      int num = 0;
      t = new Topping();
      
      System.out.println("What toppings would you like to have on your pizza?\n");
      System.out.println("  (1) PEPPERONI ");
      System.out.println("  (2) MUSHROOM ");
      System.out.println("  (3) ONIONS ");
      System.out.println("  (4) SASUAGE ");
      System.out.println("  (5) BACON ");
      System.out.println("  (6) EXTRA CHEESE ");
      System.out.println("  (7) BLACK OLIVES");
      System.out.println("  (8) GREEN PEPPERS");
      System.out.println("  (9) PINEAPPLE");
      System.out.println("  (10) SPINACH ");
      System.out.println("\n(0) Menu\n");
      System.out.println("\n  NOTE: MAXIMUM of 3 toppings per pizza. \n");
      System.out.print("Select payment type: ");
      String choice = readInput();
      num = stringToNum(choice);
    

      
      t.setToppingName(num);
      t.setToppingPrice(num);
      
      this.currentOrder.addTopping(t);
     // System.out.println(t.getToppingName());
   

   
    
 
    
  }
  
  
  public void payMenu(){
   int num = 0;
    
    System.out.println("How would you like to pay for the pizza.\n");
    System.out.println("  (1) CASH ");
    System.out.println("  (2) VISA ");
    System.out.println("  (3) MASTER ");
    System.out.println("\n(0) Menu\n");
    System.out.print("Select payment type: ");
    String choice = readInput();
    num = stringToNum(choice);
    
    if (num == 1){
      this.type = new PaymentType(Type.CASH);
      this.type.setType();
      currentOrder.setPaymentMethod(this.type);
    }
    if (num == 2){
      this.type = new PaymentType(Type.VISA);
      this.type.setType();
      currentOrder.setPaymentMethod(this.type);
    }
    if (num == 3){
      this.type = new PaymentType(Type.MASTER);
      this.type.setType();
      currentOrder.setPaymentMethod(this.type);
      
    }
    
   
    
    
  }
  
  
  /**
   * Sign in accout with username and password
   * @param username
   * @param password
   */
  public void signUp(){
    
    Customer acct = new Customer();
    Address add = new Address();

    System.out.println("Please enter the following request to become a user.");
    System.out.print("Enter your FIRST name: ");
    String firstName = readInput();
    acct.setFirstName(firstName);
    
    System.out.print("Enter LAST Name: ");
    String lastName = readInput();
    acct.setLastName(lastName);

    System.out.print("Email: ");
    String eMail = readInput();
    add.setStreetNum(eMail);
    
    
    System.out.print("Choose a USER name: ");
    String userName = readInput();
    acct.setUserName(userName);
    
    System.out.print("Choose a password: ");
    String password = readInput();
    acct.setPassword(password);
    
    //clearScreen();
    //Address info
    
    
    System.out.println("Please enter your current address.");
    System.out.print("Street number: ");
    String streetNum = readInput();
    add.setStreetNum(streetNum);
    
    System.out.print("Street name: ");
    String streetName = readInput();
    add.setStreetName(streetName);
    
    System.out.print("City: ");
    String city = readInput();
    add.setCity(city);
    
    System.out.print("State: ");
    String state = readInput();
    add.setState(state);
    
    System.out.print("Zipcode: ");
    String zipcode = readInput();
    add.setZipcode(zipcode);
    
    acct.setAddress(add);
    
    s.createCustomer(acct);
    
    
    s.login();
    
  }
  
  public String readInput(){
    String input = scan.nextLine();
    return input;
    
  }
  
  
  /**
   * Menu Listing
   */
  public int menu(){
    
    int menuNum = 0;
    
    System.out.println("Menu");
    System.out.println("  (1) To Sign in.");
    System.out.println("  (2) To log in");
    System.out.println("  (3) Make a regular order");
    System.out.println("  (4) Make a discounted order");
    System.out.println("  (5) View all orders");
    System.out.println("  (6) Change an order");
    System.out.println("  (7) Cancel an order");
    System.out.println("\n(0) Exit");
    
    
    
    System.out.print("\nSelect from the following: ");
    String num = readInput();
    menuNum = stringToNum(num);
    
    return menuNum;
    
  }
  
  /**
   * 
   */
  public void sizeMenu(){
    int num = 0;
    
    System.out.println("Select any size Pizza.\n");
    System.out.println("  (1) SMALL - $3");
    System.out.println("  (2) MEDIUM - $5");
    System.out.println("  (3) LARGE - $7");
    System.out.println("\n(0) Menu\n");
    System.out.print("Select size: ");
    String choice = readInput();
    num = stringToNum(choice);
    
    if (num == 1){
      this.size = new PizzaSize(Size.SMALL);
      size.setSizePrice();
      currentOrder.setSize(size);
    }
    if (num == 2){
      this.size = new PizzaSize(Size.MEDIUM);
      this.size.setSizePrice();
      currentOrder.setSize(size);
    }
    if (num == 3){
      this.size= new PizzaSize(Size.LARGE);
      size.setSizePrice();
      currentOrder.setSize(size);
      
    }

    currentOrder.setCustomer(currentCustomer);
      
  }
  
 
  
  
  /**
   * 
   */
  public void clearScreen(){
    for(int i = 0; i < 25; ++i) { 
      System.out.println(); 

      }
  }
  
  public int stringToNum(String input){
    int x = Integer.parseInt(input);
    
    return x;
    
  }
	
}
