import java.util.Arrays;
import java.util.LinkedList;

import graph.unused.Path;

class Parent {   
    String name;   
    
    // A method which prints the data of the parent class   
    void showMessage()   
    {   
        System.out.println("Parent method is called");   
    }   
}   
    
// Child class   
class Child extends Parent {   
    int age;   
    
    // Performing overriding  
    @Override  
    void showMessage()   
    {   
        System.out.println("Child method is called");   
    }   
}   
    
public class Downcasting{  
	
	public static void print(String s) {
		System.out.print(s);
	}
    
    public static void main(String[] args)   
    {   
        LinkedList<Integer> lol = new LinkedList<>();
        lol.addAll(Arrays.asList(new Integer[] {1,2,3,4,5}));
        LinkedList<Integer> hmm = (LinkedList<Integer>)lol.clone();
        hmm.add(7);
        
        Path<Integer> kek;
        
        print(lol.toString());
        print(hmm.toString());
        
        Integer a = 55;
        Integer b = a + 1;
        a = 3;
        System.out.println(a);
        System.out.println(b);
    }   
}  