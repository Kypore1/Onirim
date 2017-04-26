import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Limbo
{
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Rectangle slot = new Rectangle(800, 810, 100, 140);
	private Deck deck;
	private Discard discard;
	private Hand hand;
	private Doors doors;
	private boolean playable = true;
	//Maybe add a tracker for the number of cards and types discarded

	public boolean isPlayable() {
		return playable;
	}
	public void setPlayable(boolean playable) {
		this.playable = playable;
	}
	public Limbo(Deck d, Discard dis,Hand h, Doors door) 
	{
		deck = d;
		discard = dis;
		hand = h;
		doors = door;
	}
	public Rectangle getRect()
	{
		return slot;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void Door(MouseEvent e)
	{
		for (int i = 0; i < hand.getRect().length; i++)
		{
			if(hand.getRect()[i].contains(e.getPoint())&&hand.getCards().get(i).getType().equals("Key")&&hand.getCards().get(i).getColour().equals(cards.get(cards.size()-1).getColour()))// if discarding key
			{
				discard.addCard(hand.getCards().remove(i));
				discard.getCards().get(discard.getCards().size()-1).getRect().setLocation(discard.getRect().x+(80*((discard.getCards().size()-1)%2)), discard.getRect().y+(140*((discard.getCards().size()-1)/2)));
				for (int j = 0; j < doors.getShown().length; j++) {
					if (!cards.isEmpty()&&!doors.getShown()[j]) 
					{
						cards.get(cards.size()-1).getRect().setBounds(doors.getRect()[j]);
						doors.getCards().add(cards.remove(cards.size()-1));
						doors.setShown(j, true);
					}
				}
				
				doors.Organize();
				break;
			}
		}
	}

	public void Nightmare(MouseEvent e)
	{
		boolean found = false;
		if(deck.getRect().contains(e.getPoint()))//if discarding deck cards
		{
			for(int i=0;i<4;i++)
			{
				discard.addCard(deck.getCards().remove(i));
				discard.getCards().get(discard.getCards().size()-1).getRect().setLocation(discard.getRect().x+(80*((discard.getCards().size()-1)%2)), discard.getRect().y+(140*((discard.getCards().size()-1)/2)));
				playable=true;
			}
		}
		for (int i = 0; i < hand.getRect().length; i++) //if discarding hand or keys
		{
			if(hand.getRect()[i].contains(e.getPoint())&&hand.getCards().get(i).getType().equals("Key"))// if discarding key
			{
				discard.addCard(hand.getCards().remove(i));
				discard.getCards().get(discard.getCards().size()-1).getRect().setLocation(discard.getRect().x+(80*((discard.getCards().size()-1)%2)), discard.getRect().y+(140*((discard.getCards().size()-1)/2)));
				playable=true;
				for (int j = 0; j < hand.getOpen().length; j++)
				{
					hand.getOpen()[i]=true;
				}
				break;
			}
			else if(hand.getRect()[i].contains(e.getPoint())||found)// if discarding everything
			{
				for (int j = 0; j < hand.getCards().size() ;j++) 
				{
					found = true;
					j=0;
					discard.addCard(hand.getCards().remove(j));
					discard.getCards().get(discard.getCards().size()-1).getRect().setLocation(discard.getRect().x+(80*((discard.getCards().size()-1)%2)), discard.getRect().y+(140*((discard.getCards().size()-1)/2)));
				}
				for(int j = 0; j < 5; j++)
				{
					hand.getCards().add(deck.getCards().remove(j));
					if(hand.getCards().get(hand.getCards().size()-1).getType().equals("Nightmare")||hand.getCards().get(hand.getCards().size()-1).getType().equals("Door"))
					{
						deck.getCards().add(hand.getCards().remove(j));
						j--;
					}
				}
				playable=true;
			}
		}
		for (int i = 0; i < doors.getRect().length; i++)//if readding a door
		{
			if(doors.getRect()[i].contains(e.getPoint()))
			{
				doors.getCards().get(i).getRect().setLocation(deck.getRect().getLocation());
				doors.setShown(i, false);
				deck.getCards().add(doors.getCards().remove(i));
				deck.shuffle();
				doors.Organize();
				playable=true;
				break;
			}
		}
		if(playable)
		{
			discard.addCard(cards.get(cards.size()-1));
			discard.getCards().get(discard.getCards().size()-1).getRect().setLocation(discard.getRect().x+(80*((discard.getCards().size()-1)%2)), discard.getRect().y+(140*((discard.getCards().size()-1)/2)));
		}
	}
	
}
