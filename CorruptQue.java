import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class CorruptQue<Item> implements Iterable<Item>
{
    // Helpful Linked List for storing the queue
    private class Node {
        public Node next, prev;
        public Item item;

        public Node(Item it) {
            this.prev = null;
            this.next = null;
            this.item = it;
        }

        // Instantiate a node while setting both its prev and next pointers
        public Node(Item it, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.item = it;
        }
    }

    private int N; // Number of items in the queue
    private Node head, tail; // Back and front of the corrupt queue, respectively

    public CorruptQue() {
        this.N = 0;
        this.head = null;
        this.tail = null;
    }


    public void PrintQue()
    {
        if(tail == null)
        {
            System.out.println("empty");
        }

        Node temp = head;
        while( temp != null)
        {
            System.out.println(temp.item + " ");
            temp = temp.prev;
        }
    }

    // return the number of items
    public int size() {
        return N;
    }

    // true if empty, false otherwise
    public boolean isEmpty() 
    {
        return size() == 0;
    }

    // add Item x to the back of this queue
    public void enqueue(Item x)
    {
        // FILL ME IN
        Node input = new Node(x);
        if( tail == null && head == null)//If que is empty
        {
            tail = input;
            input.prev = null;
            input.next = head;
        }

        else if( tail != null && head == null)
        {
            head = tail;
            input.next = head;
            head.prev = input;
            tail = input;
        }

        else
        {
            input.next = tail;
            tail.prev = input;
            input.prev = null;
            tail = input;
        }
        N++;
    }

    // barge into the line, adding Item x to the second place from the front (or the front if they're alone)
    public void cut(Item x) {
        Node insert = new Node(x);
        if( isEmpty() )
        {
            tail = insert;
            insert.prev = null;
            insert.next = head;
        }

        else
        {
            insert.prev = head.prev;
            head.prev.next = insert;
            insert.next = head;
            head.prev = insert;
        }
        N++;
    }

    // return item removed from the front (end) of the queue
    public Item dequeue() throws NoSuchElementException {
        if (isEmpty() == true)
            throw new NoSuchElementException();

        Node temp = head;
        head = head.prev;

        // FILL ME IN
        return temp.item; //change!
    }

    // internal iterator implementation
    public class Iter implements Iterator<Item> {
        private Node where;

        public Iter() {
            where = tail; // Assumes tail has the front of the queue. You can turn this around if you desire.
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item it = where.item;
            where = where.prev;
            return it;
        }

        public boolean hasNext() {
            return (where != null);
        }

    }

    // teturn Iterator as required by Iterable (from front to back).
    public Iterator<Item> iterator() {
        return new Iter();
    }

    // print contents of queue from front to back
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item it : this) {
            s.append (it.toString() + " ");
        }
        s.append ("\n"); // newline
        return s.toString();
    }

    // this method is used by HackerRank to read in operations
    public void process(char op, Item val) {
        if (op == 'e') // enqueue
           enqueue(val);
        else if (op == 'c') // cut
           cut(val);
        else if (op == 'd') // dequeue
           System.out.println (dequeue()); // ignore val
    }

    public static void main(String[] args)
    {
        CorruptQue<Integer> cq = new CorruptQue<>();
        cq.enqueue(2);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.enqueue(6);

        cq.dequeue();
        cq.PrintQue();


    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CorruptQue<Integer> cq = new CorruptQue<>();

        cq.enqueue(6);


        cq.PrintQue();

        /*
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, n).forEach(nItr -> {
            try {
                char o = (char)bufferedReader.read();
                int k = 0;
                if (o != 'd') { // the enqueue operations 'e' and 'c' both take an argument
                    bufferedReader.skip(1); // eat the space
                    k = Integer.parseInt(bufferedReader.readLine().trim());
                } else {
                    bufferedReader.readLine();
                }
                cq.process(o, k);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        */
    }
}
