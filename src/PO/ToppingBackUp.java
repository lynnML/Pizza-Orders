package PO;

public class ToppingBackUp {

  private String[] toppings; 
  private int[] pricing;
  private int price;
  private String topping;
  
  
  public ToppingBackUp(){
    
    this.toppings = new String[]{"null", "Pepperoni","Mushroom","Onions", "Sasuage","Bacon",
                                        "Extra Cheese","Black Olives", "Green Peppers", "Pineapple","spinach"};
  
    this.pricing = new int[]{0, 4, 2, 2, 5, 6,
                                1, 2, 2, 3, 2};
  }


  public void setTopping(int topping){
    
    this.topping = this.toppings[topping];
  
  }
 
  public void setPrice(int topping){
    this.price = this.pricing[topping];
  }
  
  public int getPrice(){
    return this.price;
  }
  
  public String getTopping(){
    return this.topping;
  }
  
  
  
  
  
}
