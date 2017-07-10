package PO;

import java.util.ArrayList;

public class Pizza {

  private PizzaSize size;
  private ArrayList<Topping> topping;
  private double price;
  
  public Pizza(ArrayList<Topping> topping, PizzaSize size){
    
    this.topping = topping;
    this.size = size;
    this.price = 0;
 
  }
  
  public void calc_price(){
    
    for(Topping x: topping){
      
      this.price += x.getToppingPrice();
      
    }
    
  }
  
  
  
  
  
  
}
