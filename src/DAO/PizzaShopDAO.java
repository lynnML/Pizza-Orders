package DAO;

import java.util.List;



import PO.*;

public interface PizzaShopDAO 
{
  void createCust(Customer user);
  Customer findCustPrimaryKey(Integer primaryKey);
  List findCustExample(Customer cust, boolean fuzzy);
  boolean deleteCust(Customer cust);
  Customer retrieveCust(Customer cust);
  
  PlaceOrder createOrder(PlaceOrder pizzaOrder);
  boolean update(Pizza pizza);
  boolean delete (Pizza pizza);
  Pizza findByPrimaryKey(Integer PrimaryKey);
  List findByExample(Pizza pizza, boolean fuzzy);
  List findAll();
  
  
}
