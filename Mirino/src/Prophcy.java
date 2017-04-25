import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

public class Prophcy {
	private ArrayList<Card> cards;
	private boolean[] open = {false,false,false,false,false};
	private ArrayList<Rectangle> slots = new ArrayList <Rectangle>();
	public Prophcy() 
	{

	}
	public void swapCards(int i, int j)
	{
		Collections.swap(cards, i, j);
	}
	public Card discard(int i)
	{
		Card toRet = new Card(cards.get(i));
		cards.remove(i);
		return toRet;
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public boolean[] getOpen() {
		return open;
	}
	public ArrayList<Rectangle> getRect()
	{
		return slots;
	}
}
