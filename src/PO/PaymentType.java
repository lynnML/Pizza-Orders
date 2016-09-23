package PO;
public class PaymentType{

private Type type;

private String nameOfType;

public PaymentType(){
  
}

  public PaymentType(Type type){
    this.type = type;
    
  }
 
  /**
   * 
   */ 
  public void setType(){

   switch (this.type){
     
     case CASH:
       this.nameOfType = "CASH";
       break;
     
     case VISA:
       this.nameOfType = "VISA";
       break;
     
     case MASTER:
       this.nameOfType = "MASTER";
       break;
   }//switch
 }//setType

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getNameOfType() {
    return nameOfType;
  }

  public void setNameOfType(String nameOfType) {
    this.nameOfType = nameOfType;
  }
  
  



} 
