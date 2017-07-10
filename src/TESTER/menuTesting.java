package TESTER;
import PO.PresentationLayer;

import static org.junit.Assert.*;

import org.junit.Test;

public class menuTesting {

  @Test
  public void test() {
    PresentationLayer menuTest = new PresentationLayer();
    
    int num = menuTest.menu();
    assertEquals(0, num);
  
    int num2 = menuTest.menu();
    assertEquals(2, num2);
    
  
  }
  

}
