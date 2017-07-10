package PO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Place_Order")
public class PlaceOrder {

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "order_id") 
  private int orderID;
  
  @Column(name="size")
  private String size;

  @Transient
  private PaymentType paymentMethod;


  @Column(name="price")
  private double price;
  
  //private double totalPrice;
  @Column(name="delivery_time")
  private Timestamp deliveryTime;

  
  @Column(name="payment_method")
  private String payment;
  
  //@Column(name ="topping_id")
  //private int toppingID;
  //private String pizzaToppings;
  
 
  /* CUSTOMER RELATIONSHIP */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id")
  private Customer customer;
  
  /* TOPPING RELATIONSHIP */

  //@OneToMany(mappedBy = "placeorder", targetEntity = Topping.class, fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  //@JoinColumn(name="topping_id")
  
  //@ManyToMany(mappedBy="placeorder", targetEntity = Topping.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
  
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "top_order",
  joinColumns = {@JoinColumn(name="order_id")},
  inverseJoinColumns = {@JoinColumn(name = "topping_id")})
  
  
  private List<Topping> toppings;

  
  
  
//  private String sizeOfPizza;

  
 

  public PlaceOrder(){
    this.toppings = new ArrayList<Topping>();
  }
  


  public void setSizeOfPizza(){
    //this.sizeOfPizza = this.size.getPizzaSize();
    
  }
  
  public void setPizzaToppings(){
  //  for(Topping x: toppings){
    //  pizzaToppings += x.getToppingName()+ ", ";
     
    //}
    //System.out.println("ajflsdkjs" + this.pizzaToppings);
   
  }

  public void addTopping(Topping topping){
    this.toppings.add(topping);
  }
 

  public void setSize(int num){
    /* Needs to be implemented */
  }

  public PaymentType getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentType paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public void setPayment(){
    this.payment = this.paymentMethod.getNameOfType();
    
  }
  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }



  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  

public List<Topping> getToppings() {
    return toppings;
  }


  public void setToppings(List<Topping> toppings) {
    this.toppings = toppings;
  }

  public void reset(){
    this.orderID = 0;
    this.size = null;
    this.paymentMethod = null;
    this.price = 0;
    this.payment = " ";
    this.toppings.clear();
  }

@Temporal(TemporalType.TIMESTAMP)
  public Timestamp getDeliveryTime() {
    return deliveryTime;
  }



  public void setDeliveryTime(Timestamp deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  
 
  



  
}
