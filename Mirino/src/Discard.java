import java.awt.Rectangle;
import java.util.ArrayList;

public class Discard 
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Rectangle slot = new Rectangle();
	//Maybe add a tracker for the number of cards and types discarded
	public Discard() 
	{
		slot.setBounds(1050, 10, 180, 840);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	public void addCard(Card card)
	{
		cards.add(new Card(card));
	}
	public Rectangle getRect()
	{
		return slot;
	}
}
