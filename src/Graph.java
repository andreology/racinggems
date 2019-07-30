//Andre Barajas
//Spring 2018
//CECS328
//Racing Gems problem 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.math.BigDecimal;

public class Graph
{
	private Map<Integer, Vertex> graph;
	private int currentMapSize = 0;
	private ArrayList<ArrayList<struct>> dataStruc = new ArrayList<ArrayList<struct>>();
	private double ratio;
	private int lastTaken;
	private double courseH;
	private int maxH=0;
	private HashSet<Integer> list = new HashSet<>();
	private int see;
	//private int phi;
	public Graph()	//constructor 
	{
		
	}
	public void setMh(double x) {maxH = (int)x;}
	public int getMh() {return maxH;}
	public void setRatio(double x) {ratio = x;}
	public double getRatio() {return ratio;}
	public void setH(double x) {courseH = x;}
	public double getH() {return courseH;}
	
	public void setSize(int s)
	{
		graph = new HashMap<>(s);
	}
	public void findPath(double cheight)
	{

		for(int i = 0; i <= currentMapSize; i++)
			dataStruc.add(new ArrayList<struct>());
		 for(int q = 0; q <= currentMapSize;q++)
		{
			for(int j = 0; j <=currentMapSize; j++)
			{	
				if(q == 4 && j ==4)
				{
					int s = 2; 
					s = s +2;
				}
				
				dataStruc.get(q).add(rec(q, j));
				System.out.print( ((dataStruc.get(q).get(j).isTaken() == true)? 1: 0));
			}
			//System.out.println( " | " + dataStruc.get(q).get(currentMapSize).getValue() + (( dataStruc.get(q).get(currentMapSize).isTaken() == true) ? 1: 0) + "|	" + q  + "" );
			if(dataStruc.get(q).get(currentMapSize).isTaken() == true)
			{
				list.add(q);
			}
			System.out.println();
			see = 0;
		}	
		
	 //printV();
		 
		 TreeSet<Integer> mySet = new TreeSet();
		 mySet.addAll(list);
		Iterator<Integer> it = mySet.iterator();
		while(it.hasNext())
		{
			int w = it.next();
			if(w!=0)
			System.out.println(w + " " + graph.get(w).getX() + "," + graph.get(w).getY() + ","+ (int)graph.get(w).getWieght());
		}
		 System.out.println();
		 printMap();
	}
	/*
	public void printPath()
	{
		int el = 5;
		int sig = currentMapSize;
			for(int i = currentMapSize; i >0;i--)
			{
					for(int j = sig; j > 0;j--)
					{
						
						if(dataStruc.get(i).get(j).isTaken())
						{
							list.add(i);
							sig--;
							j =0;
						}else {j = 0; }
								
					}
			}
		
	}
	*/
	public void printMap()
	{
		for(int i = 1; i <= currentMapSize; i++)
		{
			System.out.println(i + "(" + graph.get(i).getX().toString() + ", " + graph.get(i).getY().toString() + "):" + graph.get(i).getWieght() );
		}
	}
	public void printV()
	{
		for(int i =0 ; i <=currentMapSize;i++)
		{
				for(int j = 0; j <= currentMapSize;j++)   //(( dataStruc.get(q).get(currentMapSize).isTaken() == true)
				{
					// dataStruc.get(i).get(j).getValue() + ", " +
						System.out.print( ((dataStruc.get(i).get(j).isTaken() == true)? 1: 0));						
				}
			System.out.println();
		}
		
		
	}
	
	
	public  struct rec(int i, int c)
	{
		 struct temp;
		 double dis=0;
		
		 if(i>c ||i==0 && c==0) {dis = ratio-1;}
		 else
		 {
					 dis = computeDistance(i, c);
				
		 }
				
		
				if (c==0 || i ==c)
				{
					temp = new struct(0);
					temp.setTaken(false);
				   //temp.setBigD(new BigDecimal(Double.parseDouble(graph.get(i).getY().toString())));
				}
				else if(  dis< ratio &&  i>c )//get capacity of from c 
				{
					temp = dataStruc.get(i).get(c-1);
					temp.setTaken(false);
				}
				else if (i == 0)
				{
					
					struct delta = new struct(0);
					
					 delta.setValue( (int)( graph.get(c).getWieght() )) ;
					
						 temp = delta;
						 temp.setTaken(true);
						 temp.setBigD(new BigDecimal(Double.parseDouble(graph.get(c).getY().toString())));
						/// lastTaken = i;
					 
				}
				
				else 
				{
					struct theta =  dataStruc.get(i-1).get(c);
					struct delta = new struct(0);
					//int lawd = see;
					
					int what = (( dataStruc.get(i).get(c-1) )).getValue();
					
					 delta.setValue( (int)( graph.get(c).getWieght() +   what)) ;
					 if(delta.getValue() >= theta.getValue())
					 {
						 temp = delta;
						 temp.setTaken(true);
						 temp.setBigD(new BigDecimal(Double.parseDouble(graph.get(i).getY().toString())));
						 lastTaken = i;
					 }
					 else
					 {
						 temp = theta;
					     temp.setTaken(false);
					 }
				}
				see++;
		
		return temp;
	}
	
	
	
	public void createVertex( BigDecimal x, BigDecimal y, int val)
	{
		
		Vertex vertex = new Vertex();
		//vertex.setLabel(label);
		vertex.setWieght(val);
		vertex.setX(x);
		vertex.setY(y);
		graph.put(++currentMapSize, vertex);
	}
	public Map getMap()
	{
		return graph;
	}
	public double computeDistance(int o1, int o2)
	{
		
		double X;
		
		double Y; 
			
		if(o1==0) 
			{
			X = 1;
			Y= Double.parseDouble(graph.get(02).getY().toString());
			}
		else 
		{
			X= Double.parseDouble((graph.get(o1).getX().subtract(graph.get(o2).getX())).toString());
			Y=Double.parseDouble((graph.get(o1).getY().subtract(graph.get(o2).getY())).toString());
		}
		if(X<0) {X=X*-1;}
		if(Y<0) {Y=Y*-1;}
		double ratio = Y/X;
		return ratio;
		
	}
	//public void displayVertices()
	//{
		//for(int i = 1; i <= currentMapSize; i++)
		//{
		//	System.out.println(i +  " " );;
		//	graph.get(i).print();
		//}
	//}
	public void setGraph(Graph d)
	{
		graph = (Map<Integer, Vertex>) d;
	}
	//public void addEdge(int X, int Y)
	//{
	//	 graph.get(X).addKnown(Y);
	//	 graph.get(Y).addKnown(X);
	//}
	

}
