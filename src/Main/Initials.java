package Main;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Initials {
	
	//momentum class
	private double mass;
	private double velocity;
	private double Xvel;
	private double Yvel;
	private double angle;
	
	@SuppressWarnings("unused")
	private int dangle;
	private double Xmomentum;
	private double Ymomentum;
	private double finalMomentum;
	
	//velocity textField
	private JTextField jtf;
	private int x;
	private int y;
	private int w;
	private int h;
	
	//mass textField
	private JTextField massjtf;
	private int xm;
	private int ym;
	private int wm;
	private int hm;
	
	//angle textField
	private JTextField ajtf;
	private int xa;
	private int ya;
	private int wa;
	private int ha;
	
	//direction angle
	
	@SuppressWarnings("rawtypes")
	private JComboBox jcb;
	private int xd;
	private int yd;
	private int wd;
	private int hd;
	
//	private JButton b;
//	private int xb;
//	private int yb;
//	private int wb;
//	private int hb;
	
	private JLabel j1;
	private JLabel j2;
	private JLabel j3;
	private JLabel j4;
	
	
	private JLabel nameJ;
	private String name;
	

	
	
	private int change = 40;
	
	public final String[]names = {"         N","     E O N","     N O E","         E","     S O E","     E O S","         S","     W O S","     S O W","         W","     N O W","     W O N"};
	
	
	//Color options 
	private Color objectColor;
	private Color traceColor;
	private JButton colorChangeButton;
	private JDialog_ColorChange cjd;
	
	
	public Initials(double m,double v, double a,int da,int x1,int y1,int w1,int h1,String n,Color c)
	{
		 this.mass = m;
		 setTheVelocity(v,da,a);
		 this.angle = a;
		 this.dangle = da;
		 
		 this.x = x1;
		 this.y = y1;
		 this.w = w1;
		 this.h = h1;
		 
		 
		 this.xm = x1;
		 this.ym = y1+h1+5;
		 this.wm = w1;
		 this.hm = h1;
		 
		 this.xa = x1;
		 this.ya = ym+h1+5;
		 this.wa = w1;
		 this.ha = h1;
		 
		 this.xd = x1;
		 this.yd = ya+h1+5;
		 this.wd = w1;
		 this.hd = h1;
		 
//		 this.xb = x1+100;
//		 this.yb = ym+h1;
//		 this.wb = w1;
//		 this.hb = h1;
		 
//		 initJB();
		 this.name = n;
		 initJName();
		 initJL();
		 initJCB();
		 initAngleJTF();
		 initmassJTF();
		 initJTF(x1,y1,w1,h1);
		 initColorChangeButton();
		 initObjectColor(c);
		 initcjd();
		 addActionListenerForSave();
	}
	public double getXMomentum()
	{
		return (this.Xvel*this.mass);
	}
	public double getYMomentum()
	{
		return (this.Yvel*this.mass);
	}
	public double getMass()
	{
		return this.mass;
	}
//	public void initJB() {
//		this.b = new JButton("OK");
//		this.b.setBounds(this.xb,this.yb,this.wb,this.hb);
//		this.b.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					mass = Double.parseDouble(massjtf.getText());
//				}catch(NumberFormatException ex) {
//					
//				}
//			}
//		});
//		
//	}
//	public JButton getJB()
//	{
//		return this.b;
//	}
	public void initJL()
	{
		j1 = new JLabel();
		j1.setText("Velocity");
		j1.setBounds(this.x-change-10,this.y,this.w,this.h);
		
		j2 = new JLabel();
		j2.setText("Mass");
		j2.setBounds(this.xm-change,this.ym,this.wm,this.hm);
		
		j3 = new JLabel();
		j3.setText("Angle");
		j3.setBounds(this.xa-change,this.ya,this.wa,this.ha);
		
		j4 = new JLabel();
		j4.setText("Direction");
		j4.setBounds(this.xd-change-20,this.yd,this.wd,this.hd);
	}
	public JLabel getJ1()
	{
		return this.j1;
	}
	public JLabel getJ2()
	{
		return this.j2;
	}
	public JLabel getJ3()
	{
		return this.j3;
	}
	public JLabel getJ4()
	{
		return this.j4;
	}
	public void setTheVelocity(double v,int da,double angle)
	{
		if(da==1||da==4)
		{
			this.velocity = v;
			if(da==1) {
				this.Yvel = v;
				this.Xvel = 0;
			}
			else 
			{
				this.Yvel = 0;
				this.Xvel = v;
			}
		}
		else if(da==7||da==10)
		{
			this.velocity = -v;
			if(da==7) {
				this.Yvel = -v;
				this.Xvel = 0;
			}
			else 
			{
				this.Yvel = 0;
				this.Xvel = -v;
			}
		}
		else if(da==2||da==3)
		{
			if(da==2)
			{
				this.Xvel = Math.sin(Math.toRadians(angle))*v;
				this.Yvel = Math.cos(Math.toRadians(angle))*v;
			}
			else if(da==3)
			{
				this.Yvel = Math.sin(Math.toRadians(angle))*v;
				this.Xvel = Math.cos(Math.toRadians(angle))*v;
			}
		}
		else if(da==5||da==6)
		{
			if(da==5)
			{
				this.Yvel = Math.sin(Math.toRadians(angle))*-v;
				this.Xvel = Math.cos(Math.toRadians(angle))*v;
			}
			else if(da==6)
			{
				this.Xvel = Math.sin(Math.toRadians(angle))*v;
				this.Yvel = Math.cos(Math.toRadians(angle))*-v;
			}
		}
		else if(da==8||da==9)
		{
			if(da==8)
			{
				this.Xvel = Math.sin(Math.toRadians(angle))*-v;
				this.Yvel = Math.cos(Math.toRadians(angle))*-v;
			}
			else if(da==9)
			{
				this.Yvel = Math.sin(Math.toRadians(angle))*-v;
				this.Xvel = Math.cos(Math.toRadians(angle))*-v;
			}
		}
		else if(da==11||da==12)
		{
			if(da==11)
			{
				this.Yvel = Math.sin(Math.toRadians(angle))*v;
				this.Xvel = Math.cos(Math.toRadians(angle))*-v;
			}
			else if(da==12)
			{
				this.Xvel = Math.sin(Math.toRadians(angle))*-v;
				this.Yvel = Math.cos(Math.toRadians(angle))*v;
			}
		}
	}
	public void initJTF(int xpos,int ypos,int width,int height)
	{
		this.jtf = new JTextField();
		this.jtf.setBounds(this.x, this.y, this.w, this.h);
		this.jtf.setForeground(Color.black);
		this.jtf.setHorizontalAlignment(JTextField.CENTER);
		this.jtf.setFont(new Font("Serfi",Font.PLAIN,15));
	
		this.jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if (jtf.getText().length()>=10)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,12));
				}
				else if(jtf.getText().length()>=5)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,15));
				}
				else if(jtf.getText().length()<5)
				{
					jtf.setFont(new Font("Serfi",Font.PLAIN,20));
				}
			}
		});
	}
	public double getXvel()
	{
		return this.Xvel;
	}
	public double getYvel()
	{
		return this.Yvel;
	}
	public JTextField getField()
	{
		return this.jtf;
	}
	public void initmassJTF() {
		this.massjtf = new JTextField();
		this.massjtf.setBounds(this.xm, this.ym, this.wm, this.hm);
		this.massjtf.setForeground(Color.black);
		this.massjtf.setHorizontalAlignment(JTextField.CENTER);
		this.massjtf.setFont(new Font("Serfi",Font.PLAIN,15));
		this.massjtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if (massjtf.getText().length()>=10)
				{
					massjtf.setFont(new Font("Serfi",Font.PLAIN,12));
				}
				else if(massjtf.getText().length()>=5)
				{
					massjtf.setFont(new Font("Serfi",Font.PLAIN,15));
				}
				else if(massjtf.getText().length()<5)
				{
					massjtf.setFont(new Font("Serfi",Font.PLAIN,20));
				}
			}
		});
		
	}
	public void initAngleJTF() {
		this.ajtf = new JTextField();
		this.ajtf.setBounds(this.xa, this.ya, this.wa, this.ha);
		this.ajtf.setForeground(Color.black);
		this.ajtf.setHorizontalAlignment(JTextField.CENTER);
		this.ajtf.setFont(new Font("Serfi",Font.PLAIN,20));
		this.ajtf.setText("90");
		this.ajtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if(jcb.getSelectedIndex()==0||jcb.getSelectedIndex()==3||jcb.getSelectedIndex()==6||jcb.getSelectedIndex()==9)
				{
					e.consume();
				}
				if (ajtf.getText().length()>=10)
				{
					ajtf.setFont(new Font("Serfi",Font.PLAIN,12));
				}
				else if(ajtf.getText().length()>=5)
				{
					ajtf.setFont(new Font("Serfi",Font.PLAIN,15));
				}
				else if(ajtf.getText().length()<5)
				{
					ajtf.setFont(new Font("Serfi",Font.PLAIN,20));
				}
				
			}
			public void keyTyped(KeyEvent e)
			{
				if(jcb.getSelectedIndex()==0||jcb.getSelectedIndex()==3||jcb.getSelectedIndex()==6||jcb.getSelectedIndex()==9)
				{
					e.consume();
				}
			}
			public void keyReleased(KeyEvent e)
			{
				if(jcb.getSelectedIndex()==0||jcb.getSelectedIndex()==3||jcb.getSelectedIndex()==6||jcb.getSelectedIndex()==9)
				{
					e.consume();
				}
			}
		});
	}
	public JTextField getMassTF()
	{
		return this.massjtf;
	}
	public JTextField getAngleTF()
	{
		return this.ajtf;
	}
	
	public void initJCB()
	{
		this.jcb = new JComboBox<String>(names);
		this.jcb.setBounds(this.xd, this.yd, this.wd, this.hd);
		this.jcb.setMaximumRowCount(11);
		this.jcb.setBackground(Color.white);
		this.jcb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(jcb.hasFocus())
				{
					if(jcb.getSelectedIndex()==0||jcb.getSelectedIndex()==3||jcb.getSelectedIndex()==6||jcb.getSelectedIndex()==9)
					{
						getAngleTF().setText("90");
						adjustFont();
					}
					else {
						getAngleTF().setText("1<angle<90");
						adjustFont();
					}
				}
				
				
			}
			
		});
		
	
		
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getJCB()
	{
		return this.jcb;
	}
	public void setMass(double mass)
	{
		this.mass = mass;
	}
	public void setXmomentum(double xm)
	{
		this.Xmomentum = xm;
	}
	public void setYmomentum(double ym)
	{
		this.Ymomentum = ym;
	}
	public void calFinalMomentum(double xm,double ym)
	{
		this.finalMomentum = Math.sqrt((Math.pow(Math.abs(xm), 2))+(Math.pow(Math.abs(ym), 2)));
	}
	public void setV()
	{
		double vel = this.finalMomentum/this.mass;
		this.velocity = vel;
		this.jtf.setText(String.format("%.1f",vel));
		System.out.print(vel);
	}
	public double getXMomentum1()
	{
		return this.Xmomentum;
	}
	public double getYMomentum1()
	{
		return this.Ymomentum;
	}
	public void calYvel()
	{
		this.Yvel = this.Ymomentum/this.mass;
	}
	public void calXvel()
	{
		this.Xvel = this.Xmomentum/this.mass;
	}
	public void calAngle()
	{
		this.angle = (Math.atan(this.Yvel/this.Xvel))/Math.PI*180;
		this.ajtf.setText(String.format("%.1f", Math.abs(angle)));
		this.ajtf.setBackground(Color.YELLOW);
		this.ajtf.setForeground(Color.black);
		getDirection();
	}
	public void getDirection()
	{
		if(this.Xvel==0&&this.Yvel>0)
		{
			this.jcb.setSelectedIndex(0);
		}
		else if(this.Xvel==0&&this.Yvel<0)
		{
			this.jcb.setSelectedIndex(6);
		}
		else if(this.Xvel>0&&this.Yvel==0)
		{
			this.jcb.setSelectedIndex(3);
		}
		else if(this.Xvel<0&&this.Yvel==0)
		{
			this.jcb.setSelectedIndex(9);
		}
		else if(this.Xvel>0&&this.Yvel>0)
		{
			this.jcb.setSelectedIndex(2);
		}
		else if(this.Xvel<0&&this.Yvel<0)
		{
			this.jcb.setSelectedIndex(8);
		}
		else if(this.Xvel>0&&this.Yvel<0)
		{
			this.jcb.setSelectedIndex(4);
		}
		else {
			this.jcb.setSelectedIndex(10);
		}
		this.jcb.setBackground(Color.yellow);
		this.jcb.setForeground(Color.black);
	}
	public int getDirection1()
	{
		return this.jcb.getSelectedIndex()+1;
	}
	public void setVisible(boolean bo)
	{
		this.ajtf.setVisible(bo);
		this.massjtf.setVisible(bo);
		this.jcb.setVisible(bo);
		this.j1.setVisible(bo);
		this.j2.setVisible(bo);
		this.j3.setVisible(bo);
		this.j4.setVisible(bo);
		this.jtf.setVisible(bo);
		this.nameJ.setVisible(bo);
		this.colorChangeButton.setVisible(bo);
	}
	public void setBounds(int x1,int y1,int w1,int h1)
	{
		 this.x = x1;
		 this.y = y1;
		 this.w = w1;
		 this.h = h1;
		 
		 
		 this.xm = x1;
		 this.ym = y1+h1+5;
		 this.wm = w1;
		 this.hm = h1;
		 
		 this.xa = x1;
		 this.ya = ym+h1+5;
		 this.wa = w1;
		 this.ha = h1;
		 
		 this.xd = x1;
		 this.yd = ya+h1+5;
		 this.wd = w1;
		 this.hd = h1;
		 
		j1.setBounds(this.x-change-10,this.y,this.w,this.h);
		j2.setBounds(this.xm-change,this.ym,this.wm,this.hm);
		j3.setBounds(this.xa-change,this.ya,this.wa,this.ha);
		j4.setBounds(this.xd-change-20,this.yd,this.wd,this.hd);
		this.jcb.setBounds(this.xd, this.yd, this.wd, this.hd);
		this.ajtf.setBounds(this.xa, this.ya, this.wa, this.ha);
		this.jtf.setBounds(this.x, this.y, this.w, this.h);
		this.massjtf.setBounds(this.xm, this.ym, this.wm, this.hm);
		this.nameJ.setBounds(x+5, y-h, w, h);
		this.colorChangeButton.setBounds(this.x+65,this.y-this.h+7,20,20);
	}
	public void initJName()
	{
		this.nameJ = new JLabel(this.name);
		this.nameJ.setForeground(Color.blue);
		this.nameJ.setBounds(x+5, y-h, w, h);
	}
	public void setName(String name)
	{
		this.name = name;
		this.nameJ.setText(this.name);
	}
	public JLabel getName()
	{
		return this.nameJ;
	}
	public String getName1()
	{
		return this.name;
	}
	public double getFinalMomentum()
	{
		return this.finalMomentum;
	}
	public double getVelocity()
	{
		return this.velocity;
	}
	public double getAngle()
	{
		return this.angle;
	}
	public void reset()
	{
		 mass = 0;
		 velocity = 0;
		 Xvel = 0;
		 Yvel= 0;
		 angle= 0;
		 dangle= 0;
		 Xmomentum =0;
		 Ymomentum =0;
		 finalMomentum =0;
		 this.jtf.setText("");
		 this.massjtf.setText("");
		 this.ajtf.setText("90");
		 this.jcb.setSelectedIndex(0);
		 this.jtf.setBackground(Color.white);
		 this.massjtf.setBackground(Color.white);
		 this.ajtf.setBackground(Color.white);
		 this.jcb.setBackground(Color.white);	 
	}
	public void adjustFont()
	{
		//angle
		if (ajtf.getText().length()>=10)
		{
			ajtf.setFont(new Font("Serfi",Font.PLAIN,12));
		}
		else if(ajtf.getText().length()>=5)
		{
			ajtf.setFont(new Font("Serfi",Font.PLAIN,15));
		}
		else if(ajtf.getText().length()<5)
		{
			ajtf.setFont(new Font("Serfi",Font.PLAIN,20));
		}
		
		//mass
		if (massjtf.getText().length()>=10)
		{
			massjtf.setFont(new Font("Serfi",Font.PLAIN,12));
		}
		else if(massjtf.getText().length()>=5)
		{
			massjtf.setFont(new Font("Serfi",Font.PLAIN,15));
		}
		else if(massjtf.getText().length()<5)
		{
			massjtf.setFont(new Font("Serfi",Font.PLAIN,20));
		}
		
		//velocity
		if (jtf.getText().length()>=10)
		{
			jtf.setFont(new Font("Serfi",Font.PLAIN,12));
		}
		else if(jtf.getText().length()>=5)
		{
			jtf.setFont(new Font("Serfi",Font.PLAIN,15));
		}
		else if(jtf.getText().length()<5)
		{
			jtf.setFont(new Font("Serfi",Font.PLAIN,20));
		}
		
	}
	
	//color change
	public void initObjectColor(Color c)
	{
		this.objectColor = c;
		this.traceColor = c;
		sameColor();
	}
	public void initcjd()
	{
		this.cjd = new JDialog_ColorChange(this.x+285,this.y-15);
	}
	public void initColorChangeButton()
	{
		this.colorChangeButton = new JButton();
		this.colorChangeButton.setBounds(this.x+65,this.y-this.h+7,20,20);
		this.colorChangeButton.setBackground(this.objectColor);
		this.colorChangeButton.setToolTipText("Change Color");
		this.colorChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				 cjd.setVisible(true);
			}
		});
	}
	public JButton getColorChangeButton()
	{
		return this.colorChangeButton;
	}
	public void sameColor()
	{
		this.ajtf.setForeground(this.objectColor);
		this.j1.setForeground(this.objectColor);
		this.j2.setForeground(this.objectColor);
		this.j3.setForeground(this.objectColor);
		this.j4.setForeground(this.objectColor);
		this.jcb.setForeground(this.objectColor);
		this.jtf.setForeground(this.objectColor);
		this.massjtf.setForeground(this.objectColor);
		this.nameJ.setForeground(this.objectColor);
		this.colorChangeButton.setBackground(this.objectColor);
	}
	public void addActionListenerForSave()
	{
		cjd.getSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				cjd.setVisible(false);
				objectColor = cjd.getColorObject();
				traceColor = cjd.getColorTrace();
				sameColor();
			}
		});
	}
	
	public void setDialogColor(Color oc,Color tc)
	{
		this.cjd.setObjectColor(oc, tc);
	}
	public void setObjectColor(Color c)
	{
		this.objectColor = c;
	}
	public void setTraceColor(Color c)
	{
		this.traceColor = c;
	}
	public Color getObjectColor()
	{
		return this.objectColor;
	}
	public Color getTraceColor()
	{
		return this.traceColor;
	}

}
