
import java.util.Arrays;
import java.util.LinkedList;

import graph.unused.Path;

class Parent {     
    // A method which prints the data of the parent class  
	String message = "I am a parent ! \n";
    void showMessage()   
    {   
        System.out.println(message());   
    } 
    
    String message() {
    	return message;
    }
}   
    
// Child class   
class Child extends Parent {  
	
	int message = 22232323;

    @Override
    void showMessage() {
    	// TODO Auto-generated method stub
    	super.showMessage();
    	System.out.println("and I want to grow up!\n");
    }
 
}   
    
public class SeeWooPersonalUse{  
	
	public static void print(String s) {
		System.out.print(s);
	}
    
    public static void main(String[] args)   
    {   
        Parent p = new Parent();
        Child c = new Child();
        
        p.showMessage();
        c.showMessage();
    }   
}  