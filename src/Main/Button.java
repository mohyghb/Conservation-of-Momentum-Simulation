package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Button  {

	private int x;
	private int y;
	private int w;
	private int h;
	private Color c;
	private boolean is;
	private boolean play;
	private JButton jb;
	
	Button()
	{
		
	
		w = 100;
		h = w;
		x = Support.Width/2-(this.w/2);
		y = (Support.Height/2)-(this.h/2);
		
		is = true;
		
		c = Color.blue;
		
		
		this.play = true;
		
		this.jb = new JButton();
		jb.setBorderPainted(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		jb.setBounds(x+20, y+20, w-50, h-50);
		jb.setVisible(true);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(play==true)
				{
					play = false;
					Animation.play();
				}
				else {
					Animation.stop();
					play = true;
				}
			}
		});
		jb.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(true);
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
	public void draw(Graphics2D g)
	{
		if(this.is)
		{
			g.setColor(c);
			g.setStroke(new BasicStroke(12));
			g.drawOval(x, y, w, h);
		}
		if(play&&is)
		{
			g.setColor(Color.cyan);
			g.setFont(new Font("Serfi",Font.PLAIN,30));
			g.drawString("PLAY",this.x+(this.w/2)-35, this.y+(this.h/2)+15);
//			g.setFont(new Font("Serfi",Font.BOLD,50));
//			g.drawString("|", this.x+(this.w/2)-40, this.y+(this.h/2)+40);
//			g.setFont(new Font("Serfi",Font.PLAIN,100));
//			g.drawString(">", this.x+(this.w/2)-25, this.y+(this.h/2)+40);
		}
		else if(!play&&is)
		{
			g.setStroke(new BasicStroke(15));
			g.setColor(Color.cyan);
			g.drawRect(x+30, y+30, w-60,h-60 );
		}
		
	}
	public void setVisible(boolean b)
	{
		
			this.is = b;
			this.jb.setVisible(b);

			
	
	}
	public int getW()
	{
		return this.w;
	}
	public int getH()
	{
		return this.h;
	}
	public void setW(int nw)
	{
		this.w = nw;
	}
	public void setH(int nh)
	{
		this.h = nh;
	}
	public void setPlay(boolean s)
	{
		this.play = s;
	}
	public JButton getButton()
	{
		return this.jb;
	}


}
