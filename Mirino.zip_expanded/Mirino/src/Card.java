import java.awt.Image;
import java.awt.Rectangle;

public class Card 
{
	private String type,colour;
	private boolean locked,selected;
	private Rectangle slot = new Rectangle();
	private Rectangle oldSlot = new Rectangle();

	private Image image;
	public Card(String t, String c,Rectangle r,Image img)
	{
		type = t;
		colour = c;
		locked = false;
		slot = r;
		image = img;
	}
	public Card(Card card) 
	{
		type = card.getType();
		colour = card.getColour();
		locked = card.isLocked();
		image=card.image;
		slot = card.getRect();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String toString()
	{
		return(type +" "+colour);
	}
	public Rectangle getRect()
	{
		return slot;
	}
	public Rectangle getOldRect() {
		return oldSlot;
	}
	public void setOldRect(Rectangle oldSlot) {
		this.oldSlot = oldSlot;
	}
	public Image getImage()
	{
		return image;
	}
}
