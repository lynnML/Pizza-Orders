/**
 * Codes from Hibernate Made Easy with little modifications
 */
package DAO;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import PO.Customer;
import PO.HibernateUtil;
import PO.PlaceOrder;

public class ConcretePizzaShopDAO implements PizzaShopDAO
{   private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
 
/**
 * 
 */
public void createCust(Customer acct){
  
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  acct.setRegistrationDate(new GregorianCalendar());
    session.save(acct);
    session.getTransaction().commit();
    session.close();

  //  return acct;
  
}

/**
 * 
 */
public Customer retrieveCust(Customer cust){
  
  Customer getAcct = cust;
  
  String userName = getAcct.getUserName();
  String password = getAcct.getPassword();
  
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  


  Customer prototype = new Customer();  
  prototype.setUserName(userName);
  //prototype.setPassword(password);
  Example example = Example.create(prototype);

  Criteria criteria = session.createCriteria(Customer.class);  
  criteria.add(example);

  List<Customer> results = criteria.list();

  String checkUserName;
  
  for(Customer x: results){
    checkUserName = x.getUserName();

    if(userName.equals(checkUserName)){
      String pw = x.getPassword();
   
      if(password.equals(pw)){
        int id = x.getCustID();
        getAcct = (Customer)session.get(Customer.class, id);
        
        
      }
    }
  }
  
  
    //getAcct = (Customer)session.get(Customer.class, 1);
    //System.out.println("User name retrieved is " + getAcct.getLastName());
  //}
  session.close();
  
  return getAcct;
}



public Customer findCustUniqueKey(String uniqueKey)
{   
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  Object pojo  = session.get(Customer.class, uniqueKey);
  session.getTransaction().commit();
  
  return (Customer)pojo;
}


/*
public Customer findCustPrimaryKey(Integer primaryKey)
{   
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  Object pojo  = session.get(Customer.class, primaryKey);
  session.getTransaction().commit();
  
  return (Customer)pojo;
}
*/
public List findCustExample(Customer cust, boolean fuzzy)
{  
   Session session = sessionFactory.openSession();
   session.beginTransaction();
   
   List users = null;
   Criteria criteria = session.createCriteria(Customer.class);
   Example example = Example.create(cust);
   if (fuzzy)
   {   example.enableLike(MatchMode.ANYWHERE);
       example.ignoreCase();
       example.excludeZeroes();
   }
   criteria.add(example);
   users = criteria.list();
   session.getTransaction().commit();
   return users;    
}

public boolean deleteCust(Customer cust)
{
  Session session = sessionFactory.openSession();
  session.beginTransaction();
  
    session.delete(cust);
    session.getTransaction().commit();
    session.close();
    sessionFactory.close();
  return true;
}

/*
  public Pizza create(Pizza pizza)
  {   Session session = sessionFactory.openSession();
    session.beginTransaction();
    pizza.setRegistrationDate(new GregorianCalendar());
      session.save(pizza);
      
      
      session.getTransaction().commit();
      session.close();
      return pizza;
  }
  */
  public boolean update(Pizza pizza)
  {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    
      session.update(pizza);
      session.getTransaction().commit();
      session.close();
    return true;
  }
  
  public boolean delete(Pizza pizza)
  {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    
      session.delete(pizza);
      session.getTransaction().commit();
      session.close();
    return true;
  }
  
  public Pizza findByPrimaryKey(Integer primaryKey)
  {   
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Object pojo  = session.get(Pizza.class, primaryKey);
    session.getTransaction().commit();
    
    return (Pizza)pojo;
  }
  
  public List findByExample(Pizza pizza, boolean fuzzy)
  {  
     Session session = sessionFactory.openSession();
     session.beginTransaction();
     
     List users = null;
     Criteria criteria = session.createCriteria(Pizza.class);
     Example example = Example.create(pizza);
     if (fuzzy)
     {   example.enableLike(MatchMode.ANYWHERE);
         example.ignoreCase();
         example.excludeZeroes();
     }
     criteria.add(example);
     users = criteria.list();
     session.getTransaction().commit();
     return users;    
  }
  
  public List findAll()
  {   Session session = sessionFactory.openSession();
      session.beginTransaction();
     
    String queryString = "from User";
    Query queryResult = session.createQuery(queryString);
    
    session.getTransaction().commit();
    return queryResult.list();
  }

  public PlaceOrder createOrder(PlaceOrder pizzaOrder) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    //acct.setRegistrationDate(new GregorianCalendar());
      session.save(pizzaOrder);
      
      session.getTransaction().commit();
      session.close();
    
    return null;
  }


  public Customer findCustPrimaryKey(Integer primaryKey) {
    // TODO Auto-generated method stub
    return null;
  }

}
  
  
