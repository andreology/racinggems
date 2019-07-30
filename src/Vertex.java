//Andre Barajas
import java.math.BigDecimal;

public class Vertex 
{
	
	  
	private char label;        // label (e.g. 'A')
	   private boolean wasVisited;
	   private  double wieghtValue; 
	   private BigDecimal x;
	   private BigDecimal y;
	   //private HashSet<Integer> k1;
	   
	   public Vertex()   // constructor
	   {
	      //label = lab;
	      wasVisited = false;
	    //  k1 =  new HashSet<>();
	   }
	  // public void addKnown(int x)
	   //{
		//	k1.add(x);
	   //}
	   //public HashSet<Integer> returnKnown()
	  // {
		//	return k1;
	  // }
	 //  public void removeKey(int i)
	  // {
			//Iterator<Integer> it = k1.iterator();
			//int ww = 0;
			//while(it.hasNext())
			//	{
			//		int w = it.next();
			//		if (w == i)
			//			ww = w;
			//	}
			//if (ww != 0)
			//	k1.remove(ww);
		//}
	   //public void print()
	   //{
		//   System.out.println("(" + x + ", " + y + ")"+ " Value= " + wieghtValue);
	  // }
		//Setters and Getters 
		public char getLabel() {return label;}
		public void setLabel(char label) {this.label = label;}
		public boolean isWasVisited() {	return wasVisited;}
		public void setWasVisited(boolean wasVisited) {this.wasVisited = wasVisited;}
		public double getWieght() {	return wieghtValue;}
		public void setWieght(double wieght) {this.wieghtValue = wieght;}
		public BigDecimal getX() {return x;	}
		public void setX(BigDecimal x) {this.x = x;}
		public BigDecimal getY() {return y;}
		public void setY(BigDecimal y) {this.y = y;}
}// end class Vertex
