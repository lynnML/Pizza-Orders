package PO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Topping {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="topping_id")
  private int topId;

  

  
  private int toppingPrice;

  private String toppingName;
  
  

  //@Transient
  
  //@OneToOne(fetch=FetchType.EAGER)
  //@JoinColumn(name="order_id")
  
  
  //@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  //@JoinColumn(name="topping_id")
 
 // @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  //@JoinColumn(name="order_id")
  //private PlaceOrder placeorder;
  
  
  
  @ManyToMany(cascade=CascadeType.ALL)
  @JoinTable(name = "top_order",
  joinColumns = {@JoinColumn(name="topping_id")},
  inverseJoinColumns = {@JoinColumn(name = "order_id")})
  //private PlaceOrder placeorder;
  
  private List<PlaceOrder> placeorder;
  //@ManyToOne(fetch = FetchType.EAGER)
  //@JoinColumn(name= "order_id")
  //private PlaceOrder placeorder;
  
  public int getTopId() {
    return topId;
  }


  public void setTopId(int topId) {
    this.topId = topId;
  }
  
  public String getToppingName(){
    return this.toppingName;
  }
  
  public int getToppingPrice(){
    return this.toppingPrice;
  }
  
  public void setToppingName(int num){
    
    switch(num){
    case 0: this.toppingName = "null";
            break;
    case 1: this.toppingName = "Pepperoni"; 
            break;
    case 2: this.toppingName = "Mushroom"; 
            break;
    case 3: this.toppingName = "Sasusage"; 
            break;
    case 4: this.toppingName = "Bacon"; 
            break;
    case 5: this.toppingName = "Extra Cheese"; 
            break;
    case 6: this.toppingName = "Black Olives"; 
            break;
    case 7: this.toppingName = "Green Peppers"; 
            break;
    case 8: this.toppingName = "Pineapple"; 
            break;
    case 9: this.toppingName = "Spinach"; 
            break;
    }    
 
  }
  
  public void setToppingPrice(int num){
    

    switch(num){
    case 0: this.toppingPrice = 0;
          break;
    case 1: this.toppingPrice = 1;
          break;
    case 2: this.toppingPrice = 2;
          break;
    case 3: this.toppingPrice = 3;
          break;
    case 4: this.toppingPrice = 4;
          break;
    case 5: this.toppingPrice = 5;
          break;
    case 6: this.toppingPrice = 6;
          break;
    case 7: this.toppingPrice = 7;
          break;
    case 8: this.toppingPrice = 8;
          break;
    case 9: this.toppingPrice = 9;
          break;
          
    }        
 
  }




  public List<PlaceOrder> getPlaceorder() {
    return placeorder;
  }


  public void setPlaceorder(List<PlaceOrder> placeorder) {
    this.placeorder = placeorder;
  }


  public void setToppingName(String toppingName) {
    this.toppingName = toppingName;
  }

  

  
 

  
  
  
}
