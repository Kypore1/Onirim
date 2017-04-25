import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;

public class Limbo
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Rectangle slot = new Rectangle();
	private Deck deck;
	private Discard discard;
	private Hand hand;
	private Doors doors;
	//Maybe add a tracker for the number of cards and types discarded

	public Limbo(Deck d, Discard dis,Hand h, Doors door) 
	{
		deck = d;
		discard = dis;
		hand = h;
		doors = door;
	}
	public boolean validKey(Card key)
	{
		if(cards.get(0).getType().equals("Nightmare"))
		{
			return true;
		}
		if(cards.get(0).getType().equals("Door")&&key.getColour().equals(cards.get(0).getColour()))
		{
			return true;
		}
		return false;
	}
//	public void discardNightmare()//must replace text input with mouse later on
//	{
//		int remove = -1;
//		int temp = -1;
//		if(s.equals("k"))
//		{
//			for (int i = 0; i <5; i++) 
//			{
//				System.out.println(hand.getCards().get(i) + " "+i+1);
//			}
//			temp = s.nextInt();
//			if(validKey(hand.getCards().get(temp)))
//			{
//				discard.getCards().add(new Card(cards.get(0)));
//				cards.remove(0);
//				while(cards.size()>0)
//				{
//					deck.getCards().add(new Card(cards.get(0)));
//					cards.remove(0);
//				}
//				deck.shuffle();
//			}
//		}
//		if(s.equals("d"))
//		{
//			for (int i = 0; i <5; i++) 
//			{
//				discard.getCards().add(new Card(deck.getCards().get(0)));
//				hand.getCards().remove(0);
//			}
//			deck.shuffle();
//		}
//		if(s.equals("h"))
//		{
//			for (int i = 0; i <5; i++) 
//			{
//				discard.getCards().add(new Card(hand.getCards().get(0)));
//				deck.getCards().remove(0);
//			}
//			deck.shuffle();
//		}
//		if(s.equals("door"))
//		{
//			for (int i = 0; i <5; i++) 
//			{
//				System.out.println(doors.getCards().get(i) + " "+i+1);
//			}
//			remove = s.nextInt();
//			while(remove <-1)
//			{
//				remove = s.nextInt();
//			}
//			discard.getCards().add(doors.getCards().get(remove));
//			doors.getCards().remove(remove);
//			deck.shuffle();
//		}
//	}
//	public ArrayList<Card> getCards() 
//	{
//		return cards;
//	}
//	public Rectangle getRect()
//	{
//		return slot;
//	}
}
