import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prophcy {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private boolean[] open = {false,false,false,false,false};
	private boolean[] shown = {false,false,false,false,false};
	private ArrayList<Rectangle> slots = new ArrayList <Rectangle>();
	private Discard discard;
	private Deck deck;
	public Prophcy(Discard d,Deck dec) 
	{
		discard = d;
		deck = dec;
		for(int i = 0;i<5;i++)
		{
			slots.add(i,new Rectangle(10+110*i,155,100,140));
		}
	}
	public void swapCards(int i, int j)
	{
		Rectangle temp;
		Rectangle temp2;
		temp = new Rectangle( cards.get(i).getRect());
		temp2 = new Rectangle(cards.get(i).getOldRect());
		cards.get(i).getRect().setBounds(cards.get(j).getRect());
		cards.get(i).getOldRect().setBounds(cards.get(j).getOldRect());
		cards.get(j).getRect().setBounds(temp);
		cards.get(j).getOldRect().setBounds(temp2);
		Collections.swap(cards, i, j);
	}
	public Card discard(int i)
	{
		Card toRet = new Card(cards.get(i));
		cards.remove(i);
		return toRet;
	}
	public void startProphecy()
	{
		if(discard.getCards().get(discard.getCards().size()-1).getType().equals("Key"))
		{
			Arrays.fill(shown, true);
			for (int i = 0; i < 5&&i<deck.getCards().size(); i++) 
			{
				cards.add(0,new Card(deck.getCards().remove(0)));
				cards.get(i).getRect().setBounds(slots.get(i));
			}
			Organize();
			cards.get(0).getRect().setBounds(slots.get(0));
		}
	}
	public void endProphecy()
	{
		for (int i = 0; i < cards.size(); i++) 
		{
			cards.get(i).getRect().setLocation(-200,-200);
			cards.get(i).getOldRect().setLocation(-200,-200);
			deck.getCards().add(cards.remove(i));	
			Arrays.fill(shown, false);
		}
	}
	public void Organize()
	{
	    for(int i = 0; i<cards.size();i++)
	    {
	    	if(!cards.get(i).getRect().intersects(slots.get(i)))
	    	{
	    		cards.get(i).getRect().setLocation(slots.get(i).getLocation());
	    		cards.get(i).getOldRect().setLocation(slots.get(i).getLocation());
	    	}
	    }
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public boolean[] getOpen() {
		return open;
	}
	public boolean[] isShown() {
		return shown;
	}
	public ArrayList<Rectangle> getRect()
	{
		return slots;
	}
}
