package TESTER;
import PO.*;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class CustomerTester {
    private static SessionFactory sessionFactory; 
    
  public static void main(String[] args) {
    // TODO Auto-generated method stub

       Customer c = new Customer();
       Address a = new Address();
       c.setFirstName("Lynn");
       //c.setCustID(1);
       c.setAddress(a);
       
       Session session = null;
       Transaction transaction= null;
       
       //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
       try
       {
       sessionFactory = HibernateUtil.getSessionFactory();
       session = sessionFactory.openSession();
       transaction = session.beginTransaction();
       
       session.save(c);
       c.setLastName("ML");
       c.setUserName("LynnML");
       //a.setStreetName("Tehama");
     
       c.setPassword("mickeymouse");
       
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
