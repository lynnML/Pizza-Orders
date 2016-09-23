package TESTER;

import PO.PaymentType;
import PO.PaymentType.PaymentMethod;

public class PaymentTypeTester {

public static void main(String[] args){
  
  PaymentType cash = new PaymentType(PaymentType.PaymentMethod.CASH);
  PaymentType visa = new PaymentType(PaymentType.PaymentMethod.VISA);
  PaymentType master = new PaymentType(PaymentType.PaymentMethod.MASTER);
  
  
  PaymentType[] pay2 = new PaymentType[]{cash, visa, master};

  cash.printPay();
}
  
}
