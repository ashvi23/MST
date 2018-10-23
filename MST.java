package apps;

import structures.*;
import java.util.ArrayList;

public class MST {
	
	/**
	 * Initializes the algorithm by building single-vertex partial trees
	 * 
	 * @param graph Graph for which the MST is to be found
	 * @return The initial partial tree list
	 */

	public static PartialTreeList initialize(Graph graph) {
	
		PartialTreeList treeList = new PartialTreeList(); // step 1
		
		for (int i = 0 ; i< graph.vertices.length; i++) { //trav through graph
			
			PartialTree single = new PartialTree(graph.vertices[i]); // 2.1 create new single partial tree per vertex
			Vertex.Neighbor nextNeigh = graph.vertices[i].neighbors; // add the neighbors
			MinHeap<PartialTree.Arc> archeap = single.getArcs(); // 2.3 create priority queue
				
			while (nextNeigh != null) { // 2.4
				
				PartialTree.Arc homie = new PartialTree.Arc(graph.vertices[i], nextNeigh.vertex, nextNeigh.weight);
				archeap.insert(homie);
				
				if (nextNeigh.next == null) {
					break;
				}
				
				else {
					nextNeigh = nextNeigh.next;
				}
			}
		
			treeList.append(single); //2.5
			//System.out.println();
		}
	
		return treeList;
	}

	/**
	 * Executes the algorithm on a graph, starting with the initial partial tree list
	 * 
	 * @param ptlist Initial partial tree list
	 * @return Array list of all arcs that are in the MST - sequence of arcs is irrelevant
	 */
	
	public static ArrayList<PartialTree.Arc> execute(PartialTreeList ptlist) {
		
		ArrayList<PartialTree.Arc> arcList = new ArrayList<>(); //combined  partial tree
		
		while (ptlist.size()>1) {
			
			PartialTree ptx = ptlist.remove();
			if (ptx == null) {
				return null;
			}
			if(ptx.getArcs()== null) {
				return null;
			}
			MinHeap<PartialTree.Arc> pqx = ptx.getArcs();
			if(pqx.getMin() == null) {
				return null;
			}
			PartialTree.Arc min = pqx.deleteMin();
			
			//Vertex v1 = min.v1;
			Vertex v2 = min.v2;
			boolean check = vCheck(ptx,v2);
			while (check == true && !(ptx.getArcs().isEmpty())) {
				check = vCheck(ptx,v2);
				if (check == false) {
					break;
				}
				
				min = ptx.getArcs().deleteMin();
			//	v1= min.v1;
				v2= min.v2;	
			}
			//System.out.println(min +" "+"is a component of the MST");
			PartialTree pty = ptlist.removeTreeContaining(min.v2);
			ptx.merge(pty);
			arcList.add(min);
			ptlist.append(ptx);
			
		}
		return arcList;
	}
	private static boolean vCheck(PartialTree ptx, Vertex v2) {
		boolean same = false;
		if (ptx.getRoot()==v2.getRoot()) {
			same = true;
		}
		return same;
	}
	/*private static boolean vCheck(PartialTree ptx, Vertex v2) {
		boolean same = false;
		Vertex v1tree = v1.getRoot();
		Vertex v2tree = v2.getRoot();
		if (v1tree == v2tree) {
			same = true;
		}
		return same;
	}
 */
	
	
}