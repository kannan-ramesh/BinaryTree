package com.kannanrameshrk;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		System.out.println("Tree data Structure..");
		
		Node root=new Node(10);
		
		insert(root,1);
		insert(root,12);
		insert(root,10);
		insert(root,6);
		insert(root,4);
		
		System.out.println("Pre order Traversal..");
		preorderTraversal(root);
		System.out.println();
		
		System.out.println("inorder traversal...");
		inorderTraversal(root);
		System.out.println();
		
		System.out.println("postorder Traversal..");
		postorderTraversal(root);
		System.out.println();
		
		
		if(search(root,6)==null) {
			System.out.println("Item not found..");
		}else {
			System.out.println("item found..");
		}
		System.out.println("Level Order Traversal...");
		levelOrder(root);
	}

	private static void levelOrder(Node root) {
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node newNode=q.poll();
			System.out.print(newNode.val+" ");
			
			if(newNode.left!=null) {
				q.add(newNode.left);
			}
			if(newNode.right!=null) {
				q.add(newNode.right);
			}
		}
	}

	private static Node search(Node root, int i) {
		if(root ==null || root.val==i) {
			return root;
		}
		if(i>root.val) {
			return search(root.right,i);
		}
		if(i<root.val) {
			return search(root.left,i);
		}
		return root;
	}

	private static void postorderTraversal(Node root) {
		if(root!=null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.val+",");
		}	
	}

	private static void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal(root.left);
			System.out.print(root.val+",");
			inorderTraversal(root.right);
		}
	}

	private static void preorderTraversal(Node root) {
		if(root!=null) {
			System.out.print(root.val+",");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	private static void insert(Node root, int val) {
		if(root.val<val) {
			if(root.right!=null) {
				insert(root.right,val);
			}else {
				System.out.println("Inserted the val "+val+" right of node");
				root.right=new Node(val);
			}
		}else if(root.val>val) {
			if(root.left!=null) {
				insert(root.left,val);
			}else {
				System.out.println("Inserted the val "+val+" left of node");
				root.left=new Node(val);
			}
		}	
	}
}