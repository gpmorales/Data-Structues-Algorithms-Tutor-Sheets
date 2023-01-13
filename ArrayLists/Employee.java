public class Employee
{
    // Employee has one private member variable: name
    private String name;

    // Employee constructors
    public Employee (String n) {
      System.out.println("Inside Employee(String n)");
      name = n;
    }
    public Employee () {
      System.out.println("Inside Employee()");
      name = "Unknown";
    }

    public String getName() { return name; }
    public double earnings () { return 0; }

    // Overriding toString() method which is
    // inherited from Object
    public String toString() { return name; }

    // Overriding equals() which is inherited from Object
    public boolean equals(Object obj){
      if( !(obj instanceof Employee) ) return false;
      Employee temp = (Employee) obj;
      return(name.equals(temp.getName()) );
    }
    
    public static void main(String[] args){}

}
