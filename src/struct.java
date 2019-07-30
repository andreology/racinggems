import java.math.BigDecimal;

public class struct 
{
	private boolean taken;
	private Integer value;
	private BigDecimal bigD;
	private int index;
	private int why;
	public struct(int x)
	{
		taken = false;
		value = x;
	}
	public Integer getValue() 
	{
		return value;
	}
	public void setValue(Integer value)
	{
		this.value = value;
	}
	public boolean isTaken()
	{
		return taken;
	}
	public void setTaken(boolean taken)
	{
		this.taken = taken;
	}
	public BigDecimal getBigD() {
		return bigD;
	}
	public void setBigD(BigDecimal bigD) {
		this.bigD = bigD;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getWhy() {
		return why;
	}
	public void setWhy(int why) {
		this.why = why;
	}
	
}
