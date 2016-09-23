package TESTER;
import PO.Customer;
import PO.Address;
import DAO.PizzaShopDAO;
import DAO.ConcretePizzaShopDAO;
import org.hibernate.Session;

import PO.HibernateUtil;

public class DAOTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
  
  Address add = new Address();
  Customer user = new Customer();
  user.setFirstName("Lynn");
  user.setLastName("Longboy");
  user.setPassword("spytek");
  user.setUserName("dozer");
  add.setCity("San jose");
  add.setState("CA");
  add.setStreetName("teama");
  add.setStreetNum("123");
  add.setZipcode("95122");
  add.setStreetName("tehama");
  user.setAddress(add);
  
  Address add1 = new Address();
  Customer user1 = new Customer();
  user1.setFirstName("me");
  user1.setLastName("YOU");
  user1.setPassword("stek");
  user1.setUserName("der");
  add1.setCity("San se");
  add1.setState("CA");
  add1.setStreetName("tma");
  add1.setStreetNum("123");
  add1.setZipcode("952");
  add1.setStreetName("tama");
  user1.setAddress(add1);
  
  PizzaShopDAO userDAO = new ConcretePizzaShopDAO();
  userDAO.createCust(user);
  userDAO.createCust(user1);
  
 
  Customer getUser = new Customer();
  getUser =  userDAO.retrieveCust();
  userDAO.deleteCust(getUser);
    
  //userDAO.deleteCust(user);
  
  
  
  }

}
