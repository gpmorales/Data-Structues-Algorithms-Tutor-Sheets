public class ArraysBasic {/*
    Write a method named avgLength which takes an array of Strings as an input parameter and returns a double.
    The method should calculate and return the average length of all the strings in the array.
    Examples:
    avgLength(new String[]{"Hello", "Q"}) returns 3.0 
    avgLength(new String[]{}) returns 0.0
    avgLength(new String[]{"Hello", "Goodbye"}) returns 6.0 
    */
    
    public static void main(String[] args){  //TEST CASES
        System.out.println(avgLength(new String[]{}));  //prints 0.0
        System.out.println(avgLength(new String[]{"Hello", "Q"})); //prints 3.0
        System.out.println(avgLength(new String[]{"hello" , "goodbye"})); //prints 6.0
        System.out.println(avgLength(new String[]{"hello" , "goodbye" , "yo!"})); //prints 5.0
        
    }
    
    public static double avgLength(String[] WordInput){
    double result = 0; //IC, assume average is zero intially

    if(WordInput.length == 0){//if we have empty string, return 0.0, averag of 0 is 0
        return result = 0.0;//return final result as 0.0
    }
    else{//other wise run this for loop which parses through each column of this 1 x N matrix/array, and updates 'result' to equal the total length of each element/String
       for(int j = 0; j < WordInput.length; j++){ // the outer for loop runs as many times as there are elements
        for(int i = 0; i < WordInput[j].length() ; i++){//inner for loop updates result to equal the length of the String within 
            result = result + 1;
        }
    }
        result = result/WordInput.length;//Avg is total/number of elements (.length is the property that tells us how many elements our 1D array has)
    }
        return result; //return result
    }
    
}
