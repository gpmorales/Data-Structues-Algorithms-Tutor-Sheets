import java.util.ArrayList;
import java.util.Iterator;

// This class will be used to test "Employee" stuff.

// Class "Employee" is defined inside Employee.java, therefore the file
// Employee.java must be located in the same folder as EmployeeTesterArrayList.java
public class EmployeeTesterArrayList{

    public static void main(String[] args){

      /*** Object-Oriented Programming ***/
      Employee e1 = new Employee();
      Employee e2 = new Employee("Kevin");
      Employee e3 = new Employee("Kate");
      Employee e4 = new Employee("Janiel");
      Employee e5 = new Employee("Danuary");
	  

      /*** ArrayList ***/
      // Now let's create a dynamic (flexible) list of employees
      // using Java.util.ArrayList
      // Doc: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
      ArrayList<Employee> empList = new ArrayList<Employee>();
      // We can have the Object class

      // Add employees to the arraylist
      empList.add(e1);
      empList.add(e2);
      empList.add(e3);
      empList.add(1,e4);
      empList.add(e5);
	  
	    //empList.add(1000); // try removing <Employee> ERROR -> primitive int but list takes in Employee Objects only
      // from empList declaration -- what happens?

      // Print the employees list
      // Expected order of employees in the ArrayList?
      // BTW: What happens if you pass object "empList"
      // to System.out.println()...? ;-)
      
      //System.out.println("\nPrinting the list the basic way:\n" + empList);

      /*
      System.out.println();

      // USING A REGULAR FOR LOOP
      for (int i=0; i < empList.size(); i++)
      {
        Employee tmp = empList.get(i);
        System.out.println( "Employee name: " + tmp );
        
        if(tmp.getName().equals("Kevin") )
        {
          empList.remove(i); //Skips next item when we delete
          System.out.println("\t...who just now quit.");
          i--;
        }
      }
      */
	  
	  
	  
    /*
	  //USING AN ITERATOR
      // Q1) Create a new "Iterator" object named itr
      // and get a proper reference to the arraylist's iterator:
      Iterator<Employee> itr = empList.iterator();

      // Hint: Object "itr" gives you two important methods: hasNext() and next()
      // Q2) Use "itr" to traverse all employees and print their information!
      System.out.println("\nPrinting using the Iterator approach:");  // print new line (for clarity)
      while( itr.hasNext() ){
          Employee tmp = itr.next();
		  
          System.out.println( "Employee name: " + tmp );

          // Kevin resigned, remove them from empList:
          if(tmp.getName().equals("Kevin") )
        //if( tmp == e3 )			  
          {
            itr.remove();
            System.out.println("\t...who just now quit.");
          }
      }
      */
	  

    System.out.println();

    /*
	  // If you forget to reset your iterator:
    itr = empList.iterator();
	  while( itr.hasNext() ){
          Employee tmp = itr.next();
          System.out.println( "Employee name: " + tmp );
	  }
	  
      */



	 /* 
	  // --------------------------------------------------------- //
      // --------- Note: ConcurrentModificationException  ------- //
      // Uncomment this code to test the exception:
	  
      System.out.println("\nPrinting using foreach:");
      for( Employee tmp : empList ){
        System.out.println( "Employee name: " + tmp );
          // Kate resigned, remove them from empList:
          if(tmp.getName().equals("Kevin") )
          {
            System.out.println("\t...who just now quit.");
            //empList.remove(tmp);// raises an exception: java.util.ConcurrentModificationException
          }		  
       }
	   
      // Lesson learned: don't attempt to concurrently traverse/modify
      // an ArrayList using two different controllers (in this case,
      // a foreach loop is traversing while empList is attempting to remove an item at index 2)
      // --------------------------------------------------------- //
      */
	  
	  
	  
      System.out.println();
      System.out.println("Updated employee list:\n" + empList);
      System.out.println();

      // Q3) What is the expected output of the following code?
      System.out.println( "List size before get(2) = " + empList.size() );  // 4
      System.out.println("Getting (2): " + empList.get(2)); // Kate
      System.out.println( "List size after get(2) = " + empList.size() );  // 4
      System.out.println("Removing (2)...");
      empList.remove(2);
      System.out.println( "List size after remove(2) = " + empList.size() );  // 3

      // Test more ArrayList features here!!
      // TODO .....
      // itr = empList.iterator(); // restart the iterator if needed!


    }

}
