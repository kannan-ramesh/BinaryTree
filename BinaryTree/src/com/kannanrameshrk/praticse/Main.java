package com.kannanrameshrk.praticse;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		System.out.println("\t\tTree DataStructue");
		System.out.println("\t\t*****************");
		
		Node root=new Node(10);
		
		insert(root,4);
		insert(root,24);
		insert(root,40);
		insert(root,1);
		
		System.out.println("\t\tPreorder Traversal");
		System.out.println("\t\t******************");
		preorderTraversal(root);
		System.out.println("\t\tInorder Traversal");
		System.out.println("\t\t******************");
		inorderTraversal(root);
		System.out.println("\t\tPostorder Traversal");
		System.out.println("\t\t******************");
		postorderTraversal(root);
		System.out.println("\t\tLevelorder Traversal");
		System.out.println("\t\t******************");
		LevelOrderTraversal(root);
	}

	private static void LevelOrderTraversal(Node root) {
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp=q.poll();
			
			System.out.print(temp.val+" ");
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
	}

	private static void postorderTraversal(Node root) {
		if(root!=null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.val+" ");
		}
	}

	private static void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal(root.left);
			System.out.print(root.val+" ");
			inorderTraversal(root.right);
		}
	}

	private static void preorderTraversal(Node root) {
		if(root!=null) {
			System.out.print(root.val+" ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		
	}

	private static void insert(Node root, int val) {
		if(root.val<val) {
			if(root.right!=null) {
				insert(root.right,val);
			}else {
				System.out.println("Inset the element "+val+" in right Node.");
				root.right=new Node(val);
			}
		}else if(root.val>val) {
			if(root.left!=null) {
				insert(root.left,val);
			}else {
				System.out.println("Inset the element "+ val+" in left Node.");
				root.left=new Node(val);
			}
		}
		
	}

}
