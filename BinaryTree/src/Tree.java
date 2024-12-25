
public class Tree {
	static class Node{
		int val;
		Node left,right;
		
		Node(int val){
			this.val=val;
			left=null;
			right=null;
		}
	}
	public static void main(String[] args) {
		
		Node root=new Node(10);
		
		insert(root,5);
		insert(root, 15);
		insert(root, 3);
		insert(root, 8);
		insert(root, 12);
		
		System.out.println("Preorder Traversal");
		preorder(root);
		
		System.out.println(" ");
		System.out.println("Iorder Traversal");
		inorder(root);
		
		System.out.println(" ");
		System.out.println("postorder");
		postorder(root);
		
		System.out.println();
		delete(root,3);
		inorder(root);
		
		if(search(root,15)==null) {
			System.out.println("not found");
		}else {
			System.out.println("found");
		}
	}
	private static Node search(Node root, int i) {
		if(root ==null || root.val==i) {
			return root;
		}
		
		if(root.val>i) {
			return search(root.left,i);
		}else if(root.val<i) {
			return search(root.right,i);
		}
		return root;
		
		
	}
	private static Node delete(Node root, int key) {
		if(root==null) {
			return root;
		}
		
		if(root.val>key) 
		{
			root.left=delete(root.left,key);
		}else if(root.val<key){
			root.right=delete(root.right,key);
		}else {
			if(root.left==null) {
				return root.right;
			}else if(root.right==null){
				return root.left;
			}else{
				root.val=min(root.right);
				root.right=delete(root.right,root.val);
			}
		}
		return root;
	}
	private static int min(Node root) {
		int min1=root.val;
		
		while(root.left!=null) {
			min1=root.left.val;
			root=root.left;
			
		}
		return min1;
	}
	private static void postorder(Node root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val+" ");
		}
		
	}
	private static void inorder(Node root) {
		
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.val+" ");
			inorder(root.right);
			
		}
		
	}
	private static void preorder(Node node) {
		if(node!=null) {
			System.out.print(node.val+" ");
			preorder(node.left);
			preorder(node.right);
		}
		
	}
	private static void insert(Node node, int val) {
		
		if(val<node.val) {
			if(node.left!=null) {
				insert(node.left,val);
			}else {
				System.out.println("Inserted "+val+" to left of"+node.val);
				node.left=new Node(val);
			}
			
		}else if(val>node.val) {
			if(node.right!=null) {
				insert(node.right,val);
			}else {
				System.out.println("Inserted "+val+" to right of "+node.val);
				node.right=new Node(val);
			}
		}
	}

}
