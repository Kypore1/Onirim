import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Random rand = new Random();
	private Rectangle slot = new Rectangle();
	//Maybe add a tracker for the number of cards and types discarded

	public Deck() 
	{
		slot.setBounds(10, 810, 100, 140);
	}

	public ArrayList<Card> getCards() 
	{
		return cards;
	}
	public void shuffle()
	{
		int rando = 0;
		rando = rand.nextInt(cards.size());
		Card temp = null;
		for(int i = 0; i <cards.size(); i++)
		{
			temp = cards.get(i);
			cards.set(i, cards.get(rando));
			cards.set(rando, temp);
			rando = rand.nextInt(cards.size());
		}
	}
	public Rectangle getRect()
	{
		return slot;
	}
}
