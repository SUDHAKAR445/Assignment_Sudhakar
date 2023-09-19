package dataStructure;
import java.util.*;

class BSTNode
{
	int data;
	BSTNode left,right;
	
	public BSTNode(int value)
	{
		data = value;
		left = null;
		right = null;
	}
}
public class BSTImplementation 
{
	BSTNode root;
	
	BSTImplementation()
	{
		root = null;
	}
	
	BSTNode insert(BSTNode current, int value)
	{		
		if(current == null)
		{
			BSTNode newNode = new BSTNode(value);
			return newNode;
		}
		else
		{
			if(value < current.data)
				current.left = insert(current.left, value);
			else
				current.right = insert(current.right, value);
		}		
		return current;
	}
	
	void search(BSTNode root, int val)
	{
		if(root == null)
		{
			System.out.println("Search element is not found in BST");
			return;
		}
		else
		{
			if(val < root.data)
			{
				search(root.left, val);
			}
			else if(val > root.data)
			{
				search(root.right, val);
			}
			else
			{
				System.out.println("Search element is found in BST");
			}
		}
	}
	BSTNode minimumNode(BSTNode root)
	{
		if(root.left != null)
		{
			return minimumNode(root.left);
		}
		else
		{
			return root;
		}
	}
	
	BSTNode deleteNode( BSTNode node, int value)
	{
		if(node == null)
		{
			return node;
		}
		else
		{
			if(value < node.data)
			{
				node.left = deleteNode(node.left, value);
			}
			else if(value > node.data)
			{
				node.right = deleteNode(node.right, value);
			}
			else
			{
				if(node.left == null && node.right == null)
				{
					node = null;
				}
				else if(node.left == null)
				{
					node = node.right;
				}
				else if(node.right == null)
				{
					node = node.left;
				}
				else
				{
					BSTNode temp = minimumNode(node.right);
					node.data = temp.data;
					node.right = deleteNode(node.right, temp.data);
				}
			}
		}
		return node;
	}
	void inorderTraversal(BSTNode node)
	{
		if(node == null)
		{
			return;
		}
		else
		{
			if(node.left!=null)
			{
				inorderTraversal(node.left);
			}
			System.out.print(node.data +" ");
			if(node.right!=null)
			{
				inorderTraversal(node.right);
			}
		}
	}
	void preorderTraversal(BSTNode node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.data + " ");
		if(node.left!=null)
		{
			preorderTraversal(node.left);
		}
		if(node.right!=null)
		{
			preorderTraversal(node.right);
		}
	}
	void postorderTraversal(BSTNode node)
	{
		if(root == null)
		{
			return;
		}
		if(node.left!=null)
		{
			preorderTraversal(node.left);
		}
		if(node.right!=null)
		{
			preorderTraversal(node.right);
		}
		System.out.print(node.data + " ");
	}
	
	static List<List<Integer>> levelOrderTraversal(BSTNode root)
	{
		List<List<Integer>> l = new LinkedList<>();
		Deque<BSTNode> q = new LinkedList<BSTNode>();
		
		if(root == null)
		{
			return l;
		}
		
		q.add(root);
		
		while( !q.isEmpty())
		{
			List<Integer> ll = new LinkedList<>();
			int count = q.size();
			while(count!=0)
			{
				BSTNode temp = q.peek();
				ll.add(temp.data);
				q.poll();
				if(temp.left != null)
				{
					q.add(temp.left);
				}
				if(temp.right != null)
				{
					q.add(temp.right);
				}
				count--;
			}
			l.add(ll);
		}
		return l;
	}
	
			
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BSTImplementation bst = new BSTImplementation();
		System.out.println("Enter the size of the tree : ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++)
		{
			int value = sc.nextInt();
			bst.root = bst.insert(bst.root,value);
		}
		bst.root = bst.deleteNode(bst.root, 10);
		bst.search(bst.root, 100);
		System.out.println("Inorder Traversal");
		bst.inorderTraversal(bst.root);
		System.out.println("\nPreorder Traversal");
		bst.preorderTraversal(bst.root);
		System.out.println("\nPostorder Traversal");
		bst.postorderTraversal(bst.root);
		System.out.println();
		List<List<Integer>> l = levelOrderTraversal(bst.root);
		int level = 0;
		for( List e : l)
		{
			System.out.println(level++);
			for(int i=0; i<e.size();i++)
			{
				System.out.print(e.get(i)+" ");
			}
			System.out.println();
		}
	}
}
