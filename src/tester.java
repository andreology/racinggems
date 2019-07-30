import java.math.BigDecimal;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
public class tester
{
	public static int amtGem = 0;
	public static  double courseWidth, courseHeight,courseRatio; 
	public static Graph graph;
	public static void main(String args[]) throws FileNotFoundException
	{
		
		Scanner input = new Scanner(new File("gems.txt"));
		input.useDelimiter(",");
		processFile(input);
		input.close();
		
		sortGraph();
		graph.findPath(courseHeight);
		
	}
	
	public static void sortGraph()
	{
		LinkedList<Entry<Integer, Vertex>> list = new LinkedList<Entry<Integer, Vertex>>(graph.getMap().entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Vertex>>()
		{
			@Override
			public int compare(Entry<Integer, Vertex> arg0, Entry<Integer, Vertex> arg1) 
			{
				if(arg0.getValue().getY().compareTo(arg1.getValue().getY()) == 1 )
					return 1;
				else if (arg0.getValue().getY().compareTo(arg1.getValue().getY())==-1 )
					return -1;
				return 0;
			}
		});
		int i = 0;
		ArrayList<Vertex> array = new ArrayList<>();
		for(int q = 0; q < amtGem;q++)
		{
			array.add(new Vertex());
		}
		for (Entry<Integer, Vertex> item: list) 
		{
			array.get(i).setX(item.getValue().getX());
			array.get(i).setWieght(item.getValue().getWieght());
			array.get(i++).setY(item.getValue().getY());
		}
		i = 1;
		for(int q = 0; q < amtGem;q++)
		{
			((Vertex) graph.getMap().get(i)).setX(array.get(q).getX());
			((Vertex) graph.getMap().get(i)).setY(array.get(q).getY());
			((Vertex) graph.getMap().get(i)).setWieght(array.get(q).getWieght());
			i++;
		}
		
	}
	
	public  static void  processFile(Scanner in) 
	{
		boolean fLine = true;
		 graph = new Graph();
		 BigDecimal xcor, ycor;
		while(in.hasNextLine())
		{
			Scanner in0 = new Scanner(in.nextLine());
			in0.useDelimiter(",");
			xcor = new BigDecimal(0);
			ycor = new BigDecimal(0);
			if(fLine)
			{
				 amtGem =  in0.nextInt();
				 graph.setSize(amtGem);
				 courseRatio = in0.nextDouble();
				courseWidth = in0.nextDouble();
				 String l = in0.next();
				courseHeight = Double.parseDouble(l);
				graph.setRatio(courseRatio);
				graph.setH(Math.ceil(courseHeight));
				 fLine = false;
			}else
			{
				//7.,9.,1
				
				if(in0.hasNextDouble()) { xcor = new BigDecimal(in0.next());}
				if(in0.hasNextDouble()) { ycor = new BigDecimal(in0.next());}
				int value = in0.nextInt();
				if (ycor.compareTo(new BigDecimal(graph.getMh())) == 1) {graph.setMh(Math.ceil(Double.parseDouble(ycor.toString())));}
				graph.createVertex( xcor, ycor, value);
			}
			in0.close();
		}
		
	}
}
