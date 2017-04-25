import java.awt.Rectangle;
import java.util.ArrayList;

public class Hand
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private boolean[] open = {true,true,true,true,true};
	private Rectangle[] slots = new Rectangle[5];
	private Deck deck;
	public Hand(Deck d)
	{
		deck = d;
		for(int i = 0;i<slots.length;i++)
		{
			slots[i]= new Rectangle(120+110*i,810,100,140);
		}
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public boolean[] getOpen() {
		return open;
	}
	public void setOpen(int pos,boolean set) {
		open[pos] = set;
	}
	public Rectangle[] getRect()
	{
		return slots;
	}
	public void Organize()
	{
	    for(int i = 0; i<cards.size();i++)
	    {
	    	if(i>4)
	    	{
	    		deck.getCards().add(new Card(cards.remove(i)));
	    	}
	    	if(!cards.get(i).getRect().intersects(slots[i]))
	    	{
	    		cards.get(i).getRect().setLocation(slots[i].getLocation());
	    		cards.get(i).getOldRect().setLocation(slots[i].getLocation());
	    	}
	    }
	}
	
}
