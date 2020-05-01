package Main;

import java.awt.Color;
import java.awt.Graphics2D;


public class DirectionLine {
	
	private int x,y,w,h;
	private Color color;
	DirectionLine(int xc,int yc,int wc,int hc,Color c)
	{
		this.x = xc;
		this.y = yc;
		this.w = wc;
		this.h = hc;
		this.color = c;
	}
	public void drawLine(Graphics2D g)
	{
		g.setColor(this.color);
		g.fillOval(x, y, w, h);
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}

}
