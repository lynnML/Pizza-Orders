package PO;

public enum PaymentMethod {

  CASH("cash"), 
  VISA("visa"), 
  MASTER("master");
  
  private String payType;
  
  PaymentMethod(String payment){
    this.payType = payment;
  }
  
  public String getPaymentType(){
    return this.payType;
  }
  
}
