import java.awt.Rectangle;
import java.util.ArrayList;

public class Doors 
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private boolean[] shown = /*{true,true,true,true,true,true,true,true};*/new boolean[8];
	private Rectangle[] slots = new Rectangle[8];
	//Maybe add a tracker for the number of cards and types discarded
	public Doors() 
	{
		for(int i = 0; i<8;i++)
		{
			slots[i]= new Rectangle(10+110*i, 10+((i%2)*100), 100, 140);
		}
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public Rectangle[] getRect()
	{
		return slots;
	}
	public boolean[] getShown() {
		return shown;
	}
	public void setShown(int pos,boolean set) {
		shown[pos] = set;
	}
}
