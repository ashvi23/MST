

/*package apps;

import structures.*;

import java.io.IOException;

public class MSTDriver {

	public static void main(String[] args) throws IOException{
		Graph test1 = new Graph("graph1.txt");
		System.out.println("initialize 1");
		PartialTreeList list1 = MST.initialize(test1);
		
		
		Graph test2 = new Graph("graph2.txt");
		System.out.println("initialize 2");
		PartialTreeList list2 = MST.initialize(test2);

		Vertex v1 = list1.remove().getArcs().getMin().v2;
		list1.removeTreeContaining(v1);
		System.out.println("removed v1: "+ list1.removeTreeContaining(v1) + "v1 is: "+ v1);
		//while(list1.size() != 0){
			//System.out.println(list1.remove());
	//	}
		
		Vertex v2 = list1.remove().getArcs().getMin().v2;
		System.out.println(list1.removeTreeContaining(v2));
		System.out.println("removed 2");
		while(list1.size() != 0){
			System.out.println(list1.remove());
		}
	
	
		Vertex v3 = list2.remove().getArcs().getMin().v2;
		list2.removeTreeContaining(v3);
		
		
		System.out.println();
		Vertex v4 = list2.remove().getArcs().getMin().v2;
		System.out.println(list2.removeTreeContaining(v4));
		System.out.println("v4");
		while(list2.size() != 0){
			System.out.println("hell: "+list2.remove());
		}
		
	}
	

}
package apps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import structures.Graph;

public class MSTDriver
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name:");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		PartialTreeList ptl = MST.initialize(graph);
		System.out.println("are you being initialized?");
		Vertex vertex = b;
		ptl.removeTreeContaining(vertex);
		
		ArrayList<PartialTree.Arc> a = MST.execute(ptl);
		System.out.println("are you being executed?");
		graph.print();
		for (int i=0; i< a.size(); i++) {
			PartialTree.Arc b = a.get(i);
            System.out.println(b);
		}
		ptl.remove();
		
	} */


package apps;

import java.io.IOException;
import java.util.ArrayList;

import structures.Graph;

public class MSTDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MST test = new MST();
		try {
			Graph test2 = new Graph("graph10.txt");
			PartialTreeList test3 = new PartialTreeList();
			test3 = MST.initialize(test2);
			ArrayList<PartialTree.Arc> test4 = new ArrayList<PartialTree.Arc>();
			test4 = MST.execute(test3);
			for (int i = 0;i<=test4.size()-1;i++){
				System.out.println(test4.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}



