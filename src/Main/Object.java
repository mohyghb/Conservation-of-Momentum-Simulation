package Main;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Object  {
	
	private double initialX;
	private double initialY;
	
	private double x;
	private double y;
	private double w;
	private double h;
	@SuppressWarnings("unused")
	private double angle;
	private double YVelocity;
	private double XVelocity;
	private double mass;
	private boolean is;
	private int direction;
	private Color color;
	
	
	@SuppressWarnings("unused")
	private double angle1;
	private double YVelocity1;
	private double XVelocity1;
	private double mass1;
	private boolean is1;
	@SuppressWarnings("unused")
	private int direction1;
	private Color color1;
	private double w1;
	private double h1;
	
	private double TotalTime;
	private boolean shouldBeMoving;
	private boolean delete;
	
	private int situation;
	@SuppressWarnings("unused")
	private String name;
	
	private Color traceLine;
	private Color traceLine1;
	
	
	//drawing trace lines
	private ArrayList<DirectionLine> lines;
	
	
	
	Object(int d,
			double m,
			double a,
			double xv,
			double yv,
			boolean i,
			Color c,
			int d1,
			double m1,
			double a1,
			double xv1,
			double yv1,
			boolean i1,
			Color c1,
			boolean sbm,
			int sit,
			String n,
			Color trace,
			Color trace1)
	{
		this.direction = d;
		this.mass = m;
		this.angle = a;
		this.XVelocity = xv;
		this.YVelocity = yv;
		this.is = i;
		this.color = c;
		
		this.direction1 = d1;
		this.mass1 = m1;
		this.angle1 = a1;
		this.XVelocity1 = xv1;
		this.YVelocity1 = yv1;
		this.is1 = i1;
		this.color1 = c1;
		
		this.TotalTime = 0;
		this.shouldBeMoving = sbm;
		this.delete = false;
		
		this.situation = sit;
		this.name = n;  
		
		this.traceLine = trace;
		this.traceLine1 = trace1;
		initLines();
		
	}
	
	public void move()
	{
		if(is&&this.shouldBeMoving&&delete==false)
		{
		this.x+=this.XVelocity;
		this.y-=this.YVelocity;
		}
		else if(is1&&this.shouldBeMoving&&delete==false)
		{
			this.x+=this.XVelocity1;
			this.y-=this.YVelocity1;
		}
		
	}
	public void moveInverse()
	{
		if(delete==false)
		{
			this.x+=(-this.XVelocity);
			this.y-=(-this.YVelocity);
		}
		
	}
	public void fill(Graphics2D g)
	{
		if(delete==false&&is)
		{
			g.setColor(this.color);
			g.fillOval((int)x,(int)y,(int)w,(int)h);
			this.drawDirectionLines(g);
		}
		else if(delete==false&&is1)
		{
			g.setColor(this.color1);
			g.fillOval((int)x, (int)y, (int)w1, (int)h1);
			this.drawDirectionLines(g);
		}
	
	}
	public void setColor(Color c)
	{
		this.color = c;
	}
	public double getMass()
	{
		return this.mass;
	}
	public void setSize(double s,boolean b)
	{
		
		this.w = s;
		this.h = s;
//		if(b)
//		{
//			calPosition();
//		}
		
	}
	public void setSize1(double s)
	{
		this.w1 = s;
		this.h1 = s;
	}
	public double getMass1()
	{
		return this.mass1;
	}
	public void setVel(double xv,double yv)
	{
		this.XVelocity = xv;
		this.YVelocity = yv;
	}
	public void setVel1(double xv,double yv)
	{
		this.YVelocity1 = yv;
		this.XVelocity1 = xv;
	}
	public void setPosition(int ix,int iy)
	{
		this.x = ix;
		this.y = iy;
	}
//	public void calPosition()
//	{
//		switch(this.direction)
//		{
//		default:
//			this.x = 0;
//			this.y = 0;
//			break;
//		case 1:
//			//north
//			this.x = (Support.Width/2)-(this.w/2);
//			this.y = Support.Height-(this.h+Support.UNCERTAINTY);
//			break;
//		case 2:
//			//NOE
//			this.x  =0;
//			this.y = Support.Height-(this.h+Support.UNCERTAINTY);
//			break;
//		case 3:
//			//ENO
//			this.x  =0;
//			this.y = Support.Height-(this.h+Support.UNCERTAINTY);
//			break;
//		case 4:
//			//East
//			this.x  =0;
//			this.y = (Support.Height/2)-(this.h/2);
//			
//			break;
//		case 5:
//			//SOE
//			this.x  =0;
//			this.y = 0;
//			
//			
//			break;
//		case 6:
//			//EOS
//			this.x  =0;
//			this.y = 0;
//			break;
//		case 7:
//			//south
//			this.x = (Support.Width/2)-(this.w/2);
//			this.y = 0;
//			
//			
//			
//			break;
//		case 8:
//			//WOS
//			this.x = (Support.Width)-(this.w+Support.standardBorder);
//			this.y = 0;
//			break;
//		case 9:
//			this.x = (Support.Width)-(this.w+Support.standardBorder);
//			this.y = 0;
//			//SOW
//			break;
//			
//		case 10:
//			//w
//			this.x = Support.Width-(this.w+Support.standardBorder);
//			this.y = (Support.Height/2)-(this.h/2);
//			break;
//			
//		case 11:
//			this.x = Support.Width-(this.w+Support.standardBorder);
//			this.y = Support.Height-  (this.h+Support.UNCERTAINTY);
//			//now
//			break;
//		case 12:
//			//won
//			this.x = Support.Width-(this.w+Support.standardBorder);
//			this.y = Support.Height-  (this.h+Support.UNCERTAINTY);
//			break;
//				
//		}
//		if(this.XVelocity==0&&this.YVelocity==0)
//		{
//			this.x = (Support.Width/2)-(this.w/2);
//			this.y = (Support.Height/2)-(this.h/2);
//		}
//		
//		
//		
//	}
	public void centerLocation()
	{
		double xm = (Support.Width/2)-(this.w/2);
		double ym = (Support.Height/2)-(this.h/2);
		
		this.x = xm;
		this.y = ym;
	}
	public boolean hitsBorders()
	{
		if(delete==false)
		{
			double endX = Support.Width-(this.w+Support.standardBorder);
			double endY =  Support.Height-  (this.h+Support.UNCERTAINTY);
			if(this.x<=0||this.y<=0||this.x>=endX||this.y>=endY)
			{
				return true;
			}
		}
		return false;
	}
	public int getDirection()
	{
		return this.direction;
	}
	public int getX()
	{
		return (int)this.x;
	}
	public int getY()
	{
		return (int)this.y;
	}
	public int getW()
	{
		if(situation==2)
		{
			return (int)(this.w-Support.circleToSqr);
		}
		return (int)this.w;
	}
	public int getH()
	{
		if(situation==2)
		{
			return (int)(this.h-Support.circleToSqr);
		}
		return (int)this.h;
	}
	public void addFinals()
	{
		if(delete==false)
		{
			this.is = false;
			this.is1 = true;
			this.shouldBeMoving = true;
		}
		
	}
	public double getXV()
	{
		return this.XVelocity;
	}
	public double getXV1()
	{
		return this.XVelocity1;
	}
	public double getYV()
	{
		return this.YVelocity;
	}
	public double getYV1()
	{
		return this.YVelocity1;
	}
	public void timeItTakes()
	{
		double xm = ((Support.Width/2) - (this.w/2));
		double ym = ((Support.Height/2) - (this.h/2));
		 
		double xd = Math.abs(xm-this.x);
		double yd = Math.abs(ym-this.y);
		double rd = Math.sqrt((Math.pow(xd, 2)+Math.pow(yd, 2)));
		double rs = Math.sqrt(Math.pow(this.XVelocity, 2)+Math.pow(this.YVelocity, 2));
		this.TotalTime = rd/rs;		
	}
//	public void positionBTime(double tt)
//	{
//		while(tt<this.TotalTime)
//		{
//			switch(this.direction)
//			{
//			
//			case 1 :
//				//north
//				this.y--;
//				break;
//			case 2:
//				//NOE
//				this.x++;
//				this.y--;
//				break;
//			case 3:
//				//ENO
//				this.x++;
//				this.y--;
//				break;
//			case 4:
//				//East
//				this.x++;
//				
//				break;
//			case 5:
//				//SOE
//				this.x++;
//				this.y++;
//				
//				
//				break;
//			case 6:
//				//EOS
//				this.x++;
//				this.y++;
//				break;
//			case 7:
//				//south
//				this.y++;	
//				break;
//			case 8:
//				//WOS
//				this.x--;
//				this.y++;
//			
//				break;
//			case 9:
//				this.x--;
//				this.y++;
//				//SOW
//				break;
//				
//			case 10:
//				//w
//				this.x--;
//				break;
//				
//			case 11:
//				this.x--;
//				this.y--;
//				//now
//				break;
//			case 12:
//				//won
//				this.x--;
//				this.y--;
//				break;
//			
//			}
//			this.timeItTakes();
//		}
//	}
	public double getTime()
	{
		return this.TotalTime;
	}
	public boolean isAtCenter()
	{
		if(this.isAtXCenter()&&this.isAtYCenter())
		{
			return true;
		}
		return false;
	}
	public boolean isAtXCenter() {
		double xm = Support.Width/2;
		if(this.x<=xm+(this.w)&&this.x>=xm-(this.w)){
			return true;
		}
		return false;
	}
	public boolean isAtYCenter()
	{
		double ym = Support.Height/2;
		if(this.y>=ym-(this.h)&&this.y<=ym+(this.h)) {
			return true;
		}
		return false;
	}
	public void setLocation(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public void remove()
	{
		this.delete = true;
		this.is  = false;
		this.is1 = false;
		this.shouldBeMoving = false;
	}
	
	//DirectionLine
	public void initLines()
	{
		this.lines = new ArrayList<DirectionLine>();
	}
	public boolean createOne()
	{
		if(this.is)
		{
			if(Math.abs(this.lastDirectionX()+this.XVelocity)>=this.x&&Math.abs(this.lastDirectionY()+this.YVelocity)>=this.y)
			{
				return true;
			}
		}
		else if(this.is1)
		{
			if(Math.abs(this.lastDirectionX1()+this.XVelocity1)>=this.x&&Math.abs(this.lastDirectionY1()+this.YVelocity1)>=this.y)
			{
				return true;
			}
		}
		return false;
	}
	public int lastDirectionX()
	{
		int sz = 0;
		for(DirectionLine l:lines) 
		{
			if(sz==lines.size())
			{
				return l.getX();
			}
			sz++;
		}
		return (int) ((this.x)+(this.w/2));
	}
	public int lastDirectionY()
	{
		int sz = 0;
		for(DirectionLine l:lines)
		{
			if(sz==lines.size())
			{
				return l.getY();
			}
			sz++;
		}
		return (int)((this.y)+(this.h/2));
	}
	
	public int lastDirectionX1()
	{
		int sz = 0;
		for(DirectionLine l:lines) 
		{
			if(sz==lines.size())
			{
				return l.getX();
			}
			sz++;
		}
		return (int) ((this.x)+(this.w1/2));
	}
	public int lastDirectionY1()
	{
		int sz = 0;
		for(DirectionLine l:lines)
		{
			if(sz==lines.size())
			{
				return l.getY();
			}
			sz++;
		}
		return (int)((this.y)+(this.h1/2));
	}
	
	
	
	public void createDirectionLine()
	{
		if(this.createOne())
		{
			if(this.is)
			{
				DirectionLine l = new DirectionLine((int) (this.x+(this.w/2)),(int)(this.y+(this.h/2)),10,10,this.traceLine);
				this.lines.add(l);
			}
			else if(this.is1)
			{
				DirectionLine l = new DirectionLine((int) (this.x+(this.w1/2)),(int)(this.y+(this.h1/2)),10,10,this.traceLine1);
				this.lines.add(l);
			}
			
		}
	}
	public void drawDirectionLines(Graphics2D g)
	{
		for(DirectionLine l:lines)
		{
			l.drawLine(g);
		}
	}
	
	public boolean isOut()
	{
		if(this.x<-10||this.x>=Support.Width)
		{
			return true;
		}
		else if(this.y<=-10||this.y>=Support.Height)
		{
			return true;
		}
		else {
			return false;
		}
	}
	public void savePositions()
	{
		this.initialX = this.x;
		this.initialY = this.y;
	}
	public void restart()
	{
		this.lines = new ArrayList<DirectionLine>();
		this.x = this.initialX;
		this.y = this.initialY;
		this.is = true;
		this.is1 = false;
	}
	
	
	
	
	
	
	
	
	

}
