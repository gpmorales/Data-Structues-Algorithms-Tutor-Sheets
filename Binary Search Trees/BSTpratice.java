import java.util.*;
class BSTpratice extends BinarySearchTree{

	public static void BFS(Node in) //Breadth First Search
	{
		ArrayList<ArrayList<Comparable>> Super = new ArrayList<ArrayList<Comparable>>();
		Queue<Node> q = new LinkedList<>();
		q.offer(in); //insert root

		while( !q.isEmpty() )
		{
			ArrayList<Comparable> sub = new ArrayList<>();
			int size = q.size(); //keep track of original queue size before we traverse level

			for(int i = 0; i < size; i++){
				Node out = q.poll(); //pop root
				sub.add(out.key); //add this to the level
				if(out.left != null){
					q.offer(out.left); //add left child
				}

				if(out.right != null){
					q.offer(out.right); //add right child
				}
			}

			Super.add(sub);

		}

		System.out.println(Super);

	}

	public static void DFS()
	{

	}

	public static void main(String[] args)
	{
		
		BinarySearchTree<Integer, String> A = new BinarySearchTree<Integer, String>();

		A.put(30, "A");
		A.insert(50, "C", A.root);
		A.insert(20, "B", A.root);
		A.insert(40, "F", A.root);
		A.insert(60, "H", A.root);

		A.InOrderTraverse(A.root);

		Node root = A.root;

		System.out.println();

		BFS(root);

	}






}
