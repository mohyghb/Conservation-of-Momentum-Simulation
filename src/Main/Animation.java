package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Animation extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image dbImage;
	private Graphics dbg;
	
	
	
	private Timer timer;
	private static boolean play;
	private static Color backColor;
	private static ArrayList<Object> objects;
	private Button playButton;
	static State state;
	
	
	static Object object1;
	static Object object2;
	
	static boolean isTheFirstTime;
	
	
	
	Animation()
	{
		
		initClass();
	}
	public void initClass()
	{
		super.setLayout(null);
		initTimer();
		initPlay();
		initBackColor();
		initObjects();
		initButtons();
		addMouseListener();
		initEnums();
		initBooleans();
		
	}
	@Override
	
	//listeners
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(play)
		{
			if(!areOut())
			{
				moveObjects();
				detectCollision();
				createDirectionLines();
			}
			else if(areOut())
			{
				resetAnimation();
			}
			
		}
		
		repaint();
	}
	
	
	public void addMouseListener()
	{
		super.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(state==State.ANIMATION)
				{
					playButton.setVisible(true);
				}
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(state==State.ANIMATION)
				{
					playButton.setVisible(false);
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
	//paint
	public void paint(Graphics g)
	{
		dbImage = createImage(Support.Width,Support.Height);
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	public void paintComponent(Graphics g)
	{
		g.setColor(backColor);
		g.fillRect(0, 0, Support.Width, Support.Height);
		g.setColor(Color.white);
		drawObjects((Graphics2D)g);
		playButton.draw((Graphics2D)g);
	}
	
	public void drawObjects(Graphics2D g)
	{
		for(Object o:objects)
		{
			o.fill(g);
		}
	}
			
	
	
	//init
	public void initTimer()
	{
		this.timer = new Timer(Support.DELAY,this);
		this.timer.start();
	}
	public void initPlay()
	{
		Animation.play =false;
	}
	public void initBackColor()
	{
		backColor = Color.white;
	}
	public void initObjects()
	{
		objects = new ArrayList<Object>();
	}
	public void initButtons()
	{
		this.playButton = new Button();
		add(this.playButton.getButton());
		
	}
	
	//set
	public static void setColor(Color c) {
		backColor = c;
	}
	public static void play()
	{
		Animation.play = true;
	}
	public static void stop()
	{
		Animation.play = false;
	}
	public void initEnums()
	{
		state = State.BEFORE_ANIMATION;
	}
	public void initBooleans()
	{
		isTheFirstTime = true;
	}
	
	
	//Actions
	public void moveObjects()
	{
		for(Object o:objects)
		{
			o.move();
		}
	}
	public void detectCollision()
	{
		if(new Rectangle(object1.getX(),object1.getY(),object1.getW(),object1.getH()).intersects(new Rectangle(object2.getX(),object2.getY(),object2.getW(),object2.getH())))
		{
			object1.addFinals();
			object2.addFinals();
		}
		else if(object1.isAtCenter()&&isTheFirstTime)
		{
			object1.addFinals();
			object2.addFinals();
			object2.setLocation(object1.getX(), object1.getY());
			
			isTheFirstTime = false;
		}
	}
	public void createDirectionLines()
	{
		for(Object o:Animation.objects)
		{
			o.createDirectionLine();
		}
	}
	
	//get
	public static ArrayList<Object> getObjects()
	{
		return Animation.objects;
	}
	
	public static boolean areOut()
	{
		if(Animation.object1.isOut()&&Animation.object2.isOut())
		{
			return true;
		}
		else {
			return false;
		}
			
	}
	public static void resetAnimation()
	{
		for(Object o :Animation.getObjects())
		{
			o.restart();
		}
	}

}
