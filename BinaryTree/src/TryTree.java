import java.util.LinkedList;
import java.util.Queue;

public class TryTree {
	static class Node{
		int value;
		Node left,right;
		
		public Node(int val) {
			this.value=val;
			left=null;
			right=null;
		}

	}
	
	public static void main(String[] args) {
		Node root=new Node(1);
		
		insert(root,10);
		insert(root,2);
		insert(root,3);
		insert(root,4);
		insert(root,6);
		
		System.out.println("Inorder Traversal..");
		inorderTraversal(root);
		
		System.out.println();
		System.out.println("Preorder Traversal..");
		preOrder(root);
		
		System.out.println();
		System.out.println("Post Order Traversal..");
		postOrder(root);
		System.out.println();
		
		if(search(root,20)==null) {
			System.out.println("Not found..");
		}else {
			System.out.println("found..");
		}
		
		levelOrder(root);
	}

	private static void levelOrder(Node root) {
			Queue<Node> queue=new LinkedList<>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node tempNode=queue.poll();
				System.out.print(tempNode.value+" ");
				
				if(tempNode.left !=null) {
					queue.add(tempNode.left);
				}
				
				if(tempNode.right !=null) {
					queue.add(tempNode.right);
				}
			}
	}

	private static Node search(Node root, int i) {
		if(root ==null || root.value==i) {
			return root;
		}
		
		if(root.value<i) {
			search(root.right,i);
		}
		if(root.value > i) {
			search(root.left,i);
		}
		return root;
	}

	private static void postOrder(Node root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value+" ");
		}
	}

	private static void preOrder(Node root) {
		if(root!=null) {
			System.out.print(root.value+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}

	private static void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal( root.left);
			System.out.print(root.value+" ");
			inorderTraversal( root.right);
		}
	}

	private static void insert(Node root, int val) {
		if(val < root.value) {
			if(root.left!=null) {
				insert(root.left,val);
			}else {
				System.out.println("Inserted the val "+val+ " to left of "+root.value);
				root.left=new Node(val);
			}
		}else if(val > root.value) {
			if(root.right !=null) {
				insert(root.right,val);
			}else {
				System.out.println("Inserted the val "+val+ " to right of "+root.value);
				root.right=new Node(val);
			}
		}
		
	}

}
