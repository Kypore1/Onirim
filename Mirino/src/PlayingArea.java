import java.awt.Rectangle;
import java.util.ArrayList;

public class PlayingArea 
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int doorCounter=0;
	private Rectangle slot = new Rectangle(10,300,1000,500);
	public int getDoorCounter() {
		return doorCounter;
	}
	public void setDoorCounter(int doorCounter) {
		this.doorCounter = doorCounter;
	}
	public void addDoorCounter() {
		doorCounter++;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public Rectangle getRect()
	{
		return slot;
	}
	public boolean addCard(Card card)
	{
		if(cards.size()>0&&card.getColour().equals(cards.get(cards.size()-1).getColour())&&!card.getType().equals(cards.get(cards.size()-1).getType()))
		{
			addDoorCounter();
			cards.add(card);
			System.out.println(getDoorCounter());
			if(doorCounter>1)
			{
				doorCounter = 0;
				return true;
			}
		}
		else
		{
			setDoorCounter(0);
			cards.add(card);
			return false;
		}
		return false;
	}
	public PlayingArea() 
	{

	}
}
