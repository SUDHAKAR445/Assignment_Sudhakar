package dataStructure;

import java.util.*;

class TreeNode {
    int data;
    List<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}

public class NarrayTreeImp {
    private TreeNode root;

    public NarrayTreeImp(int data) {
        root = new TreeNode(data);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int parentData, int data) {
        insert(root, parentData, data);
    }

    private void insert(TreeNode node, int parentData, int data) {
        if (node == null) {
            return;
        }

        if (node.data == parentData) {
            node.addChild(new TreeNode(data));
        } 
        else 
        {
            for (TreeNode child : node.children) 
            {
                insert(child, parentData, data);
            }
        }
    }

    public void display() {
        display(root, 0);
    }

    private void display(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.data);

        for (TreeNode child : node.children) {
            display(child, level + 1);
        }
    }
    
   
    private static void delete(TreeNode root, int val) {
    	  if (root == null) {
              return ;
          }

          // Find the index of the child node with the value to delete
          int indexToDelete = -1;
          for (int i = 0; i < root.children.size(); i++) {
              TreeNode child = root.children.get(i);
              if (child.data == val) {
                  indexToDelete = i;
                  break;
              }
          }

          if (indexToDelete != -1) {
              // Get the node with the specified value
              TreeNode nodeToDelete = root.children.get(indexToDelete);
              
              // Remove the node with the specified value from the children list
              root.children.remove(indexToDelete);

              // Reattach the children of the deleted node to the parent
              for (TreeNode child : nodeToDelete.children) 
              {
                  root.children.add(child);
              }
          } 
          else 
          {
              // Recursively search in the children
              for (TreeNode child : root.children) {
                  delete(child, val);
              }
          }
    }

    public void dfs() {
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        for (TreeNode child : node.children) {
            dfs(child);
        }
    }
    public void bfs() {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");

            for (TreeNode child : node.children) {
                queue.offer(child);
            }
        }
    }
    
    int height(){
        int height = 0;

        Deque<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if(temp == null){
                height++;

                if(!q.isEmpty()){
                    q.add(null);
                }

                continue;
            }

            q.addAll(temp.children);
        }

        return height;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the root value: ");
        int rootValue = scanner.nextInt();
        NarrayTreeImp tree = new NarrayTreeImp(rootValue);

        while (true) {
            System.out.print("Enter the parent value (-1 to exit): ");
            int parentValue = scanner.nextInt();
            if (parentValue == -1) {
                break;
            }
            System.out.print("Enter the new node value: ");
            int newValue = scanner.nextInt();
            tree.insert(parentValue, newValue);
        }

        int choice = -1;
        while(choice != 0)
        {
        	System.out.println(" 1.BFS\n 2.DFS \n 3.Delete \n 4.Height \n 5.Insert \n 6.Print\n 0.Exit");
        	choice = scanner.nextInt();
        	switch(choice)
        	{
        		case 1:
        		{
        			tree.bfs();
        			break;
        		}
        		case 2:
        		{
        			tree.dfs();
        			break;
        		}
        		case 3:
        		{
        			System.out.print("Enter the value to delete: ");
        	        int valueToDelete = scanner.nextInt();
        	        delete(tree.root, valueToDelete);
        	        break;
        		}
        		case 4:
        		{
        			System.out.println("Height of the n-array tree : "+ tree.height());
        			break;
        		}
        		case 5:
        		{
        			System.out.print("Enter the parent value (-1 to exit): ");
                    int parentValue = scanner.nextInt();
                    if (parentValue == -1) 
                    {
                        break;
                    }
                    System.out.print("Enter the new node value: ");
                    int newValue = scanner.nextInt();
                    tree.insert(parentValue, newValue);
        		}
        		case 6:
        		{
        			System.out.println("N-ary Tree:");
        	        tree.display();
        	        break;
        		}
        		default:
        		{
        			System.out.println("Enter the valid choice !...");
        			break;
        		}
        	}
        }
    }
}

