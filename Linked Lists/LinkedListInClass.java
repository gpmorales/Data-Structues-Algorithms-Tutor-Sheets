class LinkedListInClass implements SimpleList{

	class Node{ //Node object class
		String data;
		Node next;

		Node(){  //Constructor v1
			data = "empty";
			next = null;
		}

    Node(String data, Node next){ //Constructor overload
        this.data = data;
        this.next = next;
    }
	}
    

  Node head; //declare head of list

  LinkedListInClass()
  {
      head = null; //instantiate our head of list Node
  }


    public boolean isEmpty()
    {
        return head == null; 
    }


    public void addFirst(String item)
    {
        Node newFirst = new Node(item, head);
        //OR
        Node oldhead = head;
        newFirst.next = oldhead;
        head = newFirst;
    }


    public void addLast(String item)
    {

    }

    public String getFirst()
    {
        return head.data;
    }

    public String getLast()
    {
        return null;
    }

    public String get(int pos)
    {
        return null;
    }

    public String removeFirst()
    {

        return null;
    }

    public void remove(String key)
    {

    }


    public static void main(String[] args)
    {


        LinkedListInClass list = new LinkedListInClass();

        list.addFirst("hello");
        list.addFirst("world");

        Node temp = list.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }



}
