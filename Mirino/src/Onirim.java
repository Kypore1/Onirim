import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Onirim extends JFrame {
	public Hand hand = new Hand();
	public Deck deck = new Deck();
	public Discard discard = new Discard();
	public Prophcy prophecy = new Prophcy();
	public PlayingArea play = new PlayingArea();
	public Doors doors = new Doors();
	public Limbo limbo;
	public int cardWidth = 100;
	public int cardHeight = 140;
	
	
	Image tanSun = Toolkit.getDefaultToolkit().getImage("Tan sun.png");
	Image tanMoon = Toolkit.getDefaultToolkit().getImage("Tan Moon.png");
	Image tanKey = Toolkit.getDefaultToolkit().getImage("Tan Key.png");
	Image tanDoor = Toolkit.getDefaultToolkit().getImage("tanDoor.png");
	
	Image redSun = Toolkit.getDefaultToolkit().getImage("Red sun.png");
	Image redMoon = Toolkit.getDefaultToolkit().getImage("Red Moon.png");
	Image redKey = Toolkit.getDefaultToolkit().getImage("Red Key.png");
	Image redDoor = Toolkit.getDefaultToolkit().getImage("redDoor.png");
	
	Image blueSun = Toolkit.getDefaultToolkit().getImage("Blue Sun.png");
	Image blueMoon = Toolkit.getDefaultToolkit().getImage("Blue Moon.png");
	Image blueKey= Toolkit.getDefaultToolkit().getImage("Blue Key.png");
	Image blueDoor = Toolkit.getDefaultToolkit().getImage("blueDoor.png");
	
	Image greenSun = Toolkit.getDefaultToolkit().getImage("Green sun.png");
	Image greenMoon = Toolkit.getDefaultToolkit().getImage("Green Moon.png");
	Image greenKey = Toolkit.getDefaultToolkit().getImage("Green Key.png");
	Image greenDoor = Toolkit.getDefaultToolkit().getImage("greenDoor.png");
	
	Image cardBack = Toolkit.getDefaultToolkit().getImage("Zard Back.png");
	Image Nightmare = Toolkit.getDefaultToolkit().getImage("Unknown.png");
	
	
	

	public void makeEnvironment()
	{
		setTitle("Dragging stuff");
		setBounds(0,0,1280,1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyPanel pan = new MyPanel();
		addMouseListener(new Mousey());
		addMouseMotionListener(new Mousey());
		pan.setBackground(Color.DARK_GRAY);
		getContentPane().add(pan);
		setResizable(false);
		setVisible(true);
	}
	
	private class MyPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			drawStuff(g,g2);
		}
		
	}
	public void drawStuff(Graphics g,Graphics2D g2)
	{
		g.drawImage(cardBack, (int)deck.getRect().getX(), (int)deck.getRect().getY(),cardWidth,cardHeight, this);
		g2.setColor(Color.RED);
		for(int i=0;i<hand.getRect().length;i++)
		{
			g2.draw(hand.getRect()[i]);
		}
		for(int i=0;i<doors.getRect().length;i++)
		{
			g2.draw(doors.getRect()[i]);
			if(doors.getShown()[i]==true)
			{
				g.drawImage(doors.getCards().get(i).getImage(),doors.getCards().get(i).getRect().x,doors.getCards().get(i).getRect().y,cardWidth,cardHeight, this);
			}
		}
		for(int i=hand.getCards().size()-1;i>-1;i--)
		{
			g.drawImage(hand.getCards().get(i).getImage(),hand.getCards().get(i).getRect().x,hand.getCards().get(i).getRect().y,cardWidth,cardHeight, this);
		}
		g2.draw(play.getRect());
		g2.draw(discard.getRect());
		for(int i = 0; i<play.getCards().size();i++)
		{
			g.drawImage(play.getCards().get(i).getImage(),play.getCards().get(i).getRect().x,play.getCards().get(i).getRect().y,cardWidth,cardHeight, this);
		}
		
		repaint();
	}
	public void init()
	{
		makeEnvironment();
		for(int i = 0; i < 6;i++)
			deck.getCards().add(new Card("Sun","Tan", new Rectangle(-200,-200,cardWidth,cardHeight),tanSun));
		for(int i = 0; i < 9;i++)
			deck.getCards().add(new Card("Sun","Red", new Rectangle(-200,-200,cardWidth,cardHeight),redSun));
		for(int i = 0; i < 8;i++)
			deck.getCards().add(new Card("Sun","Blue", new Rectangle(-200,-200,cardWidth,cardHeight),blueSun));
		for(int i = 0; i < 7;i++)
			deck.getCards().add(new Card("Sun","Green", new Rectangle(-200,-200,cardWidth,cardHeight),greenSun));
		for(int i = 0; i < 4;i++)
		{
			deck.getCards().add(new Card("Moon","Tan", new Rectangle(-200,-200,cardWidth,cardHeight),tanMoon));
			deck.getCards().add(new Card("Moon","Red", new Rectangle(-200,-200,cardWidth,cardHeight),redMoon));
			deck.getCards().add(new Card("Moon","Blue", new Rectangle(-200,-200,cardWidth,cardHeight),blueMoon));
			deck.getCards().add(new Card("Moon","Green", new Rectangle(-200,-200,cardWidth,cardHeight),greenMoon));
		}
		for(int i = 0; i < 3;i++)
		{
			deck.getCards().add(new Card("Key","Tan", new Rectangle(-200,-200,cardWidth,cardHeight),tanKey));
			deck.getCards().add(new Card("Key","Red", new Rectangle(-200,-200,cardWidth,cardHeight),redKey));
			deck.getCards().add(new Card("Key","Blue", new Rectangle(-200,-200,cardWidth,cardHeight),blueKey));
			deck.getCards().add(new Card("Key","Green", new Rectangle(-200,-200,cardWidth,cardHeight),greenKey));
		}
			doors.getCards().add(new Card("Door","Tan", new Rectangle(-200,-200,cardWidth,cardHeight),tanDoor));
			doors.getCards().add(new Card("Door","Tan", new Rectangle(-200,-200,cardWidth,cardHeight),tanDoor));
			doors.getCards().add(new Card("Door","Red", new Rectangle(-200,-200,cardWidth,cardHeight),redDoor));
			doors.getCards().add(new Card("Door","Red", new Rectangle(-200,-200,cardWidth,cardHeight),redDoor));
			doors.getCards().add(new Card("Door","Blue", new Rectangle(-200,-200,cardWidth,cardHeight),blueDoor));
			doors.getCards().add(new Card("Door","Blue", new Rectangle(-200,-200,cardWidth,cardHeight),blueDoor));
			doors.getCards().add(new Card("Door","Green", new Rectangle(-200,-200,cardWidth,cardHeight),greenDoor));
			doors.getCards().add(new Card("Door","Green", new Rectangle(-200,-200,cardWidth,cardHeight),greenDoor));
		for(int i=0;i<8;i++)
		{
			doors.getCards().get(i).getRect().setLocation(doors.getRect()[i].getLocation());
		}
		for(int i = 0; i < 10;i++)
			deck.getCards().add(new Card("Nightmare","Null", new Rectangle(-200,-200,cardWidth,cardHeight),Nightmare));
		deck.shuffle();
	//	limbo = new Limbo(deck, discard, hand, doors);
		
	}
	public void drawCard()
	{
		System.out.println(Arrays.toString(hand.getOpen()));
		for(int i = 0; i<hand.getOpen().length;i++)
		{
			if(hand.getOpen()[i]==true)
			{
//				System.out.println(deck.getCards().size());
				hand.getCards().add(new Card(deck.getCards().get(0)));
				deck.getCards().remove(0);
				hand.getCards().get(hand.getCards().size()-1).getRect().setBounds(hand.getRect()[i].getBounds());
				hand.setOpen(i, false);
				hand.Organize();
			}
		}
	}
	public void printCards(ArrayList<Card> a)
	{
		for(int i = 0; i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
	}
	public void playGame()
	{
		init();
		{
		//	drawCard();
		}
		for(int i = 0; i<hand.getCards().size();i++)
		{
			if(hand.getCards().get(i).getType().equals("Nightmare"))
			{
			//	limbo.getCards().add(hand.getCards().get(i));
			//	hand.getCards().remove(i);
			}
		}
//		limbo.discardNightmare();
	}
	public static void main(String[]args)
	{
		Onirim obj = new Onirim();
		obj.playGame();
		obj.printCards(obj.hand.getCards());
		System.out.println(Arrays.toString(obj.hand.getOpen()));

		
	}
	private class Mousey implements MouseListener, MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) 
		{

				if(hand.getCards().get(0).isSelected())
				{	
					hand.getCards().get(0).getRect().setLocation(e.getX()-50, e.getY()-70);
				}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(deck.getRect().contains(e.getPoint()))
			{
				drawCard();
			}
			if(!(hand.getCards().size()<5))
			{
				for(int i=0;i<hand.getCards().size();i++)
				{
					if(hand.getCards().get(i).getRect().contains(e.getPoint()))//checks to see if the mouse if over a card and if so selects it
					{
						hand.getOpen()[i]=true;
						hand.getCards().add(0,new Card(hand.getCards().get(i)));
						hand.getCards().remove(i+1);
						hand.getCards().get(0).setSelected(true);
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) 
		{
			for(int i=0;i<hand.getCards().size();i++)
			{
				if(hand.getCards().get(i).isSelected()&&hand.getCards().get(i).getRect().intersects(play.getRect()))//places the card into the playing area
				{
					if(play.addCard(hand.getCards().get(i)))
					{
						
						for(int j =0;j<8;j++)
						{
							
							//System.out.println(play.getCards().get(play.getCards().size()-1).getColour()+" "+doors.getCards().get(i).getColour());
							if(play.getCards().get(play.getCards().size()-1).getColour().equals(doors.getCards().get(j).getColour()))
							{
								System.out.println("here");
								doors.setShown(j, true);
								break;
							}
						}
					}
					hand.getCards().get(i).setSelected(false);
					hand.getCards().remove(i);
					play.getCards().get(play.getCards().size()-1).getRect().setLocation(play.getRect().x+(80*((play.getCards().size()-1)%12)), play.getRect().y+(140*((play.getCards().size()-1)/12)));
				}
				else if(hand.getCards().get(i).isSelected()&&hand.getCards().get(i).getRect().intersects(discard.getRect()))//TODO change position of cards and deal with keys
				{
					hand.getCards().get(i).setSelected(false);
					discard.addCard(hand.getCards().get(i));
					hand.getCards().remove(i);
				}
				if(!hand.getCards().isEmpty())//sets cards to not be selected
				{
					hand.getCards().get(i).setSelected(false);
				}
			}
			
		}
		
	}
}
