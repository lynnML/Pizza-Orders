package TESTER;
import org.hibernate.HibernateException;

import PO.*;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class OrderTester {
  private static SessionFactory sessionFactory; 
  public static void main(String[] args){
    
    Customer c = new Customer();
    Address a = new Address();
    c.setFirstName("Lynn");
    
    PlaceOrder po = new PlaceOrder();
    PizzaSize s = new PizzaSize(Size.MEDIUM);
    
    
    c.setLastName("ML");
    c.setUserName("LynnML");
    a.setStreetName("Tehama");
    c.setAddress(a);
    c.setPassword("mickeymouse");
    
    
    Session session = null;
    Transaction transaction = null;
    
    try
    {
    sessionFactory = HibernateUtil.getSessionFactory();
    session = sessionFactory.openSession();
    transaction = session.beginTransaction();
    
    session.save(po);
    po.setCustomer(c);
    po.setSize(s);
    
    transaction.commit();
    }
    catch (HibernateException he)
    {
      transaction.rollback();
        System.out.println("Transaction is rolled back.");
    }
    finally
    {
      session.close();
      sessionFactory.close();
    }


    
    
    
  }
  
  
}
