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
	
	BSTNode insert(BSTNode root, int data)
	{
		if(root == null)
		{
			root = new BSTNode(data);
			return root;
		}
		if(data < root.data)
		{
			root.left = insert(root.left, data);
		}
		else if( data > root.data)
		{
			root.right = insert(root.right, data);
		}
		return root;
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
			return null;
		}
		else
		{
			if(value < node.data)
			{
				node.left = deleteNode(node.right, value);
			}
			else if(value > node.data)
			{
				node.right = deleteNode(node.left, value);
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
		if(root == null)
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
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BSTImplementation bst = new BSTImplementation();
		System.out.println("Enter the size of the tree : ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++)
		{
			int value = sc.nextInt();
//			if(i==0)
//			{
//				bst.root = bst.insert(bst.root,value);
//			}
//			else
//			{
				bst.root = bst.insert(bst.root,value);
			//}
		}
		bst.deleteNode(bst.root, 10);
		bst.inorderTraversal(bst.root);
	}
}
