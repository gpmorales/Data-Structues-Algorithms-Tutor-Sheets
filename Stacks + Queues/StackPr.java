class StackPr{
	// Implementing two Stacks in ONE Array by having each Stack being at opposing corners
	// The stacks will grow/shrink in the opposite direction***
	
	int Top1; //Stack 1's Pointer starts at the LEFTMOST corner
	int Top2; //Stacks 2's Pointer starts at RIGHTMOST corner
	int[] array;
	int size;

	StackPr(int N){ //Constructor of our Stack Object
		size = N;
		Top1 = -1; //Stack 1's Pointer starts at the LEFTMOST corner
		Top2 = size; //Stacks 2's Pointer starts at RIGHTMOST corner
		array = new int[size];
	}

	boolean isEmpty(){
		return (Top1 < 0 && Top2 > size - 1);
	}
	
	boolean OverFlow(){
		return ( Top2 == Top1); //If the Pointer s are equal after the increments, then there will be an overflow
	}

	public static void main(String[] args){
		StackPr st = new StackPr(8);

		st.push1(2);
		st.push1(3);
		st.push1(4);
		st.push1(5);

		st.push2(11);
		st.push2(12);
		st.push2(13);
		st.push2(14);

		st.push2(15); //Stack Overflow error
		st.push1(6); //Stack Overflow error

		st.pop1(); //removes and returns 5
		st.pop2();//removes and returns 14

		st.printStack();

	}


	public void push1(int data){ //function inserts element at Top of Stack1 : 2 3 4 5 <- TOP1
		Top1++;
		if( OverFlow() ){
			System.out.println("STACK OVERFLOW ERROR");
			Top1--;
			return;
		}

		else{
			array[Top1] = data;
		}
	}

	public int pop1(){ //function removes Top element of Stack1 and returns it
		if ( isEmpty() ){
			System.out.println("STACK1 IS EMPTY");
			return -1;
		}
		else{
			return array[Top1--];
		}
	}

	public void push2(int data){ //function inserts element at Top of Stack2 : TOP2 -> 14 13 12 11
		Top2--;
		if( OverFlow() ){
			System.out.println("STACK OVERFLOW ERROR");
			Top2++;
			return;
		}

		else{
			array[Top2] = data;
		}
	}

	public int pop2(){
		if ( isEmpty() ){
			System.out.println("STACK2 IS EMPTY");
			return -1;
		}
		else{
			return array[Top2++];
		}
	}

	public void printStack(){
		if( Top1 == -1){
			System.out.println("STACK1 IS EMPTY");
			return;
		}

		else{
			for(int i = 0; i <= Top1; i++){
				System.out.print(array[i] + " ");
			}

			System.out.println();

			if( Top2 != size){
				for(int i = size-1; i >= Top2; i--){
					System.out.print(array[i] + " ");
				}
			}
			else{
				System.out.println("STACK2 IS EMPTY");
			}
		}

	}

}
