class ObjectOrientedProgramming{
 /* The 4 Pillars of OOP
	*
	* Encapsulation -> packaging of data and functions as attributes and methods for an Object
	*			-
	*			-
	*			-
	* Abstraction -> the presentation of data and code to the user that only exposes the necessary
	*			-
	*			-
	*			-
	*	Inheritance -> the
	*			-
	*			-
	*			-
	*/
	

	public int valueOfRank = 19;  // A Non-Static method or data field (like in this case) can only be called or instantiated when an Object is instantied

	public static String Var = "Hello World"; // Static means we can access this data field / method without instantiating an object

	public static void main(String[] args){
		System.out.println(ObjectOrientedProgramming.Var);

		// System.out.println(ObjectOrientedProgramming.i); // Produces Error as the data field i can not be called without the instantiation of the object class

		System.out.println();
		//However, once we instantiate the class , we can now call on this data field / method
		ObjectOrientedProgramming OOP = new ObjectOrientedProgramming();
		System.out.print(OOP.valueOfRank);



	}








}

