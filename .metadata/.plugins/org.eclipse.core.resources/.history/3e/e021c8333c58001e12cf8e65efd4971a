package graphImplementation;

import java.util.*;

class Graph2
{
	private Map<Integer, List<Integer>> adjacentList;
	public Map<Integer, Boolean> track;
	public Graph2()
	{	
		adjacentList = new HashMap<>();	
		track = new HashMap<>();
	}
	void insertVertices(int v)
	{
		adjacentList.put(v, new LinkedList<>());
		track.put(v, false);
	}
	void resetTrack()
	{
		for (Map.Entry<Integer, Boolean> entry : track.entrySet()) {
	          track.put(entry.getKey(), false);
	      }
	}
	public void addEdge( int source, int distination)
	{
		adjacentList.get(source).add(distination);
		adjacentList.get(distination).add(source);
	}
	public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacentList.entrySet()) {
            System.out.print(entry.getKey() + " --> ");
            for (Integer vertex : entry.getValue()) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
	}
	
	public void dfsTraversal(Graph2 g, int start, Map<Integer, Boolean> track)
	{
		track.put(start, true);
        System.out.print(start + " ");

        for (int neighbor : g.adjacentList.get(start)) {
            if (!track.get(neighbor)) {
                dfsTraversal(g, neighbor, track);
            }
        }
	}
	public void dfs(Graph2 g, int start)
	{
		dfsTraversal(g, start, track);
	}
	public void bfs(Graph2 g , int start)
	{	
		Queue<Integer> q = new LinkedList<>();
		track.put(start, true);
		q.offer(start);
		
		while(!q.isEmpty())
		{
			int current = q.poll();
			System.out.print(current+ " ");
			
			for(int neighbourVertices : g.adjacentList.get(current))
			{
				if(!track.get(neighbourVertices))
				{
					track.put(neighbourVertices, true);
					q.offer(neighbourVertices);
				}
			}
		}
		System.out.println();
	}
}
public class UndirectedGraphImp 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of vertices in the graph : ");
		int vertices = sc.nextInt();
		
		Graph2 g = new Graph2();
		
		System.out.println("Enter the vertices present in the graph : ");
		for(int i=0;i<vertices;i++)
		{
			int v = sc.nextInt();
			g.insertVertices(v);
		}
		System.out.println("Enter the soucre and distination of graph vertices : ");
		while(true)
		{
			System.out.print("Enter the source : ");
			int source = sc.nextInt();
			if(source == -1)
			{
				break;
			}
			System.out.print("Enter the distination : ");
			int distination = sc.nextInt();
			g.addEdge(source, distination);
			System.out.println();
		}
		g.printGraph();
		System.out.println("Enter the starting vertex of the graph (bfs) : ");
		int start = sc.nextInt();
		g.bfs(g,start);
		g.resetTrack();
		g.printGraph();
		
		System.out.println("Enter the starting vertex of the graph (dfs) : ");
		start = sc.nextInt();
		g.dfs(g,start);
		g.resetTrack();
		sc.close();
	}
}
