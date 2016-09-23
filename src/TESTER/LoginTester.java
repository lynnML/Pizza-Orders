package TESTER;
import DAO.ConcretePizzaShopDAO;
import DAO.PizzaShopDAO;
import PO.Customer;
import PO.ServiceLayer;


public class LoginTester {

  public static void main(String[] args){
    
    Customer testCust = new Customer();

    testCust.setUserName("dozer");
    testCust.setPassword("spytek");
    
    PizzaShopDAO login = new ConcretePizzaShopDAO();
    
    testCust = login.retrieveCust(testCust);
    
    System.out.println(testCust.getLastName());
    
    if(testCust.getLastName() == null){
      System.out.println("it was null");
    }
  }
  
  
}
