package PO;
public class PizzaSize{

private final int SMALL = 3;
private final int MEDIUM = 5;
private final int LARGE = 7;

private Size size;
private int price;
private String nameOfSize;

  public PizzaSize(Size size){
    this.size = size;
    
  }
 
  /**
   * 
   */
  public void setSizePrice(){

   switch (this.size){
     case SMALL:
       this.price = this.SMALL;
       this.nameOfSize = "SMALL";
       break;
     case MEDIUM:
       this.price = this.MEDIUM;
       this.nameOfSize = "MEDIUM";
       break;
     case LARGE:
       this.price = this.LARGE;
       this.nameOfSize = "LARGE";
       break;
   }//switch
 }//setSizePrice
  
  
  
  /**
   * 
   * @return
   */
  public int getPrice(){
   
    return this.price;
  }
  
  public String getPizzaSize(){
    return this.nameOfSize;
  }
  

}//PizzaSize
 
