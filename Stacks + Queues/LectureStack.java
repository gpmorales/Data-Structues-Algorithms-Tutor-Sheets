class LectureStack{
    // Fixed-Capacity Stack using an Array
    // Push() - Add a new item at S[N]
    // Pop() - Remove item from top of Stack
    
    private int N; //Pointer to current top of Stack

    protected int Capacity; // Max capacity, size of array

    private String[] StackArray;

    LectureStack(int Capacity){ //Constructor
        this.Capacity = Capacity;
        this.N = 0;
        StackArray = new String[Capacity];
    }

    public void CopyArr(String[] oldArr, String[] newArr){
        for(int i = 0; i < oldArr.length; i++){
            newArr[i] = oldArr[i];
        }
    }

    public boolean isEmpty() // Method checks if Stack is empty
    {
        return N == 0;
    }

    public boolean isFull() //Method for checking if Stack is full
    {
        return N == Capacity;
    }


    public void DynamicPush(String item) //Push function DYNAMIC
    {
        if( isFull() ){
            String[] newArr = new String[2 * StackArray.length];
            CopyArr(StackArray, newArr);
            StackArray = newArr;
            Capacity = 2 * Capacity;
        }

        StackArray[N++] = item; //Move ptr to first item
    }


    public String Pop()
    {
        if( !isEmpty() ){
            String ret = StackArray[N];
            StackArray[N--] = null;
            return ret;
        }

        System.out.println("STACK IS EMPTY");
        return null;
    }


    public void Print(){ //Print Stack
        for(int i = 0; i < N; i++){
            System.out.println(StackArray[i]);
        }
        System.out.println();
    }


    public static void main(String[] args){
        LectureStack myStack = new LectureStack(4);

        myStack.DynamicPush("Hello");
        myStack.DynamicPush("World");
        myStack.DynamicPush("Java");
        myStack.DynamicPush("C");
        myStack.DynamicPush("C++");
        myStack.DynamicPush("R");

        //myStack.Pop();
        //myStack.Pop();

        myStack.Print();
        System.out.println("Stack capacity is " + myStack.Capacity);

    }

    // DYNAMIC RESIZING -> When STACK is FULL, Create New Stack with TWICE the number of elements
    // [ ] 0
    //
    // [ | ] 1
    //
    // [ | | | | ] 2
    //
    // [ | | | | | | | | ] 4
    //
    // [ | | | | | | | | | | | | | | | ] 8
    //
    // When we have a stack of size 1, we then double it to size 2, then when it reaches size 2, COPY it into a stack of size 4
    //
    //  0 + 1 + 2 + 4 + 8 + 16 + 32...
    //
    //  Hence for N items -> lets say 7 items
    //  When we insert the first item, our stack has size 1, it becomes full so we double it to size 2
    //  We insert the second item, out stack is full again, we double our stack size to 4
    //  Now, when we insert our 3rd itme, our stack is not full, so we then insert our 4th item, and double our stack size to 8
    //
    //  So if we have 7 items, we need to spend time copying 1 element + 2 elements + 4 elements + 8 elements = 15 
    //  So when we push N items, it takes O(2*N) time
    //
    //  10 items < 16 , greater than 8, so it will take 1 + 2 + 4 + 8 + 16 = 31



}
