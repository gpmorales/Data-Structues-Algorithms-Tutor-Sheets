// This class represents the application code that tests BST.java functions
public class BSTTester{

    public static void main(String[] args) {
      BST tree = new BST();

      // inserting the first () node:
      tree.insert(8);

      // inserting remaining nodes:
      tree.insert(4);
      tree.insert(12);
      tree.insert(2);
      tree.insert(6);
      tree.insert(10);
      tree.insert(14);

      // testing the traversal functions:
      // System.out.println("Preorder traversal of binary tree is ");
      // tree.printPreorder();
      System.out.println("Inorder traversal of binary tree is ");
      tree.printInorder();
      System.out.println();

      // test the getMinValue function
      System.out.println("\nThe minimum value of this BST is " + tree.getMinValue());

      // test the getMaxValue function
      System.out.println("The maximum value of this BST is " + tree.getMaxValue());

      // test the search function
      int item = 10;  // exists
      System.out.println("\nSearching for item [" + item + "] in the BST: " + tree.search(item).key);
      item = 5;  // does not exist
      System.out.println("Searching for item [" + item + "] in the BST: " + tree.search(item));

      //test deleting a node
      int del = 8;
      tree.delete(del);
      System.out.println();
      System.out.println("Deleting item [" + del + "]...");
      tree.printInorder();
      System.out.println();


      // Uncomment below when implementation is complete:
      /*
      //test Ceil function
      System.out.println("\nTesting the ceil function for different values: ");
      for (int i = 0; i < 16; i++) {
        System.out.println(i + " " + tree.findCeil(i));
      }
      //test Floor function
      System.out.println("\nPrinting tree again [Inorder]: ");
      tree.printInorder();
      System.out.println("\nTesting the floor function for different values: ");
      for (int i = 0; i < 16; i++) {
        System.out.println(i + " " + tree.findFloor(i));
      }
      */

    }
}
