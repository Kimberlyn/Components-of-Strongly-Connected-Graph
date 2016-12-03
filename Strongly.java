package Project;

import java.io.IOException;
import java.util.ArrayList;

public class Strongly extends DfsGraph {

	static ArrayList<Integer> stack = new ArrayList<Integer>(); 
	public Strongly(String name) throws IOException {
		super(name);
	}

	public static void main(String[] args) throws IOException{
		Strongly g = new Strongly(args[0]);
		DfsGraph h = new DfsGraph(g.getName(), g.getOrder(), g.getSize(), g.isDirected(), g.weighted);

		for (int i = 0; i < g.getOrder(); i++) {
			if (!g.vertexMarked(i)) {
				g.dfs(i);
			}
		}
		
	 	Edge[] edge = g.getEdges();
	    for (Edge e: edge) {
	    	h.addEdge(e.getHead(), e.getTail());
	    }	   
	        
	    while (!stack.isEmpty()) {
	    	if (!h.vertexMarked(stack.get(stack.size()-1))) {
	    		System.out.println("Component");
				h.dfs(stack.get(stack.size()-1));
	   			}
	    	int i = stack.get(stack.size()-1);
	    	System.out.println(i);
	    	stack.remove(i);
	    }
	     	
}	
	public void preVisit(int v) {
		if (!stack.isEmpty() && stack.contains(v))
  		stack.remove(stack.indexOf(v));			
	}
	
	public void postVisit(int v) {
		stack.add(v);
	}
	
	public void doMarked(int v, int w) {
	}
	
	public void doUnmarked(int v, int w) {
	}

}
