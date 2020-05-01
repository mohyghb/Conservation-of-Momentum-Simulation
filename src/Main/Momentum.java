package Main;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Momentum extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Initials test;
	Initials test1;
	
	Initials finals;
	Initials finals1;
	
	ArrayList<Initials> tfinals;
	ArrayList<Initials> tinitials;
	
	private JLabel initialsL;
	private JLabel finalsL;
	
	
	
	private JButton cal;
	
	
	private JButton ip;
	private JButton im;
	private JButton fp;
	private JButton fm;
	
//	private JTextArea TA;
	
	//options
	private JButton reset;
	private JButton animation;
	//SUB ANIMATION 
    private JDialog animDialog;
	
	//show Work
    private ShowWork showwork;
	
	
	private JButton about;
	
	private boolean possible;
	private boolean moreInfo;
	
	private JButton quit;
	private JButton showWork;
	
	
	private JButton syncColors;
	
	Animation animClass;
	
	
	public Momentum()
	{
		super.setLayout(null);
		super.setFocusable(true);
		super.setBackground(Color.WHITE);
		initClass();
		initQuit();
	}
	
	public void initClass()
	{
		initConditions();
		initAnimDialog();
		test = new Initials(0,0,0,1,150,140,90,30,"Object-1",Color.black);
		add(test.getAngleTF());
		add(test.getMassTF());
		add(test.getField());
		add(test.getJCB());
		add(test.getJ1());
		add(test.getJ2());
		add(test.getJ3());
		add(test.getJ4());
		add(test.getName());
		add(test.getColorChangeButton());
		
		test1 = new Initials(0,0,0,1,150,390,90,30,"Object-2",Color.black);
		add(test1.getAngleTF());
		add(test1.getMassTF());
		add(test1.getField());
		add(test1.getJCB());
		add(test1.getJ1());
		add(test1.getJ2());
		add(test1.getJ3());
		add(test1.getJ4());
		add(test1.getName());
		add(test1.getColorChangeButton());
		
		
		
		finals = new Initials(0,0,0,1,500,140,90,30,"Object-1",Color.black);
		add(finals.getAngleTF());
		add(finals.getMassTF());
		add(finals.getField());
		add(finals.getJCB());
		add(finals.getJ1());
		add(finals.getJ2());
		add(finals.getJ3());
		add(finals.getJ4());
		add(finals.getName());
		add(finals.getColorChangeButton());
		
		finals1 = new Initials(0,0,0,1,500,390,90,30,"Object-2",Color.black);
		add(finals1.getAngleTF());
		add(finals1.getMassTF());
		add(finals1.getField());
		add(finals1.getJCB());
		add(finals1.getJ1());
		add(finals1.getJ2());
		add(finals1.getJ3());
		add(finals1.getJ4());
		add(finals1.getName());
		add(finals1.getColorChangeButton());
		
		tfinals = new ArrayList<Initials>();
		tfinals.add(finals);
		tfinals.add(finals1);
		
		tinitials = new ArrayList<Initials>();
		tinitials.add(test);
		tinitials.add(test1);
		
		
		this.cal = new JButton("Calculate");
		this.cal.setBounds(300,590,90,45);
		this.cal.setBackground(Color.black);
		this.cal.setForeground(Color.WHITE);
		
		this.cal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditions();
//				TA.setText("");
				checkMass();
				setVelocities();
				whichVelocity();
				createObjects();
				enableAnimation();
				
			}
		});
		
		add(cal);
		
		this.initialsL = new JLabel();
		this.initialsL.setText("INITIALS");
		this.initialsL.setBounds(135, 0, 200, 100);
		this.initialsL.setFont(new Font("Serfi",Font.BOLD,30));
		this.initialsL.setForeground(Color.RED);
		
		add(this.initialsL);
		
		
		this.finalsL = new JLabel();
		this.finalsL.setText("FINALS");
		this.finalsL.setBounds(490, 0, 200, 100);
		this.finalsL.setFont(new Font("Serfi",Font.BOLD,30));
		this.finalsL.setForeground(Color.RED);
		
		add(this.finalsL);
		
		this.ip = new JButton();
		this.ip.setText("+");
		this.ip.setBounds(200,70,50,20);
		this.ip.setBackground(Color.black);
		this.ip.setForeground(Color.white);
		this.ip.setFont(new Font("Serfi",Font.ITALIC,20));
		
		this.ip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!finals1.getField().isVisible())
				{
					finals.setName("Object-1,2");
				}
				else if(finals1.getField().isVisible())
				{
					finals.setName("Object-1");
					finals1.setName("Object-2");
				}
				test1.setVisible(true);
				test.setBounds(150,140,90,30);
			}
		});
		
		add(this.ip);
		
		
		this.im = new JButton();
		this.im.setText("-");
		this.im.setBounds(140,70,50,20);
		this.im.setBackground(Color.black);
		this.im.setForeground(Color.white);
		this.im.setFont(new Font("Serfi",Font.ITALIC,20));
		this.im.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!finals1.getField().isVisible())
				{
					finals.setName("Object-1");
				}
				else if(finals1.getField().isVisible())
				{
					finals.setName("Object-2");
					finals1.setName("Object-3");
				}
				test1.setVisible(false);
				test.setBounds(150 ,265,90,30);
			}
		});
		add(this.im);
		
		this.fm = new JButton();
		this.fm.setText("-");
		this.fm.setBounds(490,70,50,20);
		this.fm.setBackground(Color.black);
		this.fm.setForeground(Color.white);
		this.fm.setFont(new Font("Serfi",Font.ITALIC,20));
		
		this.fm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(test1.getField().isVisible())
				{
					finals.setName("Object-1,2");
				}
				else if(e.getSource()==fm)
				{
					finals.setName("Object-1");
				}
					
				
				
				finals1.setVisible(false);
				finals.setBounds(500,265,90,30);
			}
		});
		
		this.fp = new JButton();
		this.fp.setText("+");
		this.fp.setBounds(550,70,50,20);
		this.fp.setBackground(Color.black);
		this.fp.setForeground(Color.white);
		this.fp.setFont(new Font("Serfi",Font.ITALIC,20));
		this.fp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!test1.getField().isVisible())
				{
					finals.setName("Object-2");
					finals1.setName("Object-3");
				}
				else {
					finals.setName("Object-1");
					finals1.setName("Object-2");
				}
				finals1.setVisible(true);
				finals.setBounds(500,140,90,30);
			}
		});
		
		add(this.fp);
		add(this.fm);
		
		
//		TA = new JTextArea();
//		TA.setBounds(0,0,625,720);
//		TA.setBackground(Color.black);
//		TA.setFont(new Font("Serfi",Font.PLAIN,18));
//		TA.setForeground(Color.white);
//		TA.setText("");
//		TA.setEditable(false);
		
		
		
//		add(TA);
		
		reset = new JButton();
		reset.setText("Reset");
		reset.setBackground(Color.black);
		reset.setForeground(Color.white);
		reset.setBounds(300,640,90,45);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetClass();
				animation.setEnabled(false);
//				showWork.setEnabled(false);
			}
		});

		
		add(reset);
		
		
		animation = new JButton();
		animation.setText("Animation");
		animation.setBackground(Color.black);
		animation.setForeground(Color.white);
		animation.setBounds(186,640,110,45);
		animation.setEnabled(false);
		animation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				animDialog.setVisible(true);
			}
		});

		
		add(animation);
		
		
		
		
		about = new JButton("?");
		about.setBounds(645,710,50,20);
		about.setBackground(Color.red);
		about.setForeground(Color.WHITE);
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "               Created by Moh Yaghoub", "", JOptionPane.PLAIN_MESSAGE);
			} 
		});
		add(about);
//		initShowWork();
//		initshowwork();
		initSyncColors();
	}
	public void checkMass()
	{
		if(possible&&!moreInfo)
		{
		setMasses();
		double initialMass = 0.0;
		double finalMass = 0.0;
		int cordin = -1;
		int cordinf = -1;
		int currentmass = 0;
		int hom = 0;
		double maxmass = 0;
		for(Initials i:tinitials) {
			if(i.getMassTF().isVisible())
			{
				if(i.getMassTF().getText().isEmpty())
				{
					cordin = currentmass;
					hom++;
				}
				else {
					initialMass+=i.getMass();
					
					
					if(i.getMass()>maxmass)
					{
						maxmass = i.getMass();
					}
				}
			}
			
			currentmass++;
						
			
		}
		currentmass = 0;
		for(Initials i:tfinals) {
			if(i.getMassTF().isVisible())
			{
				if(i.getMassTF().getText().isEmpty())
				{
					cordinf = currentmass;
					hom++;
				}
				else {
					finalMass+=i.getMass();
				}
			}
			currentmass++;
						
			
		}
		if(cordin==-1&&hom==2&&test1.getAngleTF().isVisible())
		{
			
			
			try {
				finals.getMassTF().setText(test.getMassTF().getText());
				finals.setMass(Double.parseDouble(test.getMassTF().getText()));
				finals.getMassTF().setBackground(Color.YELLOW);
				finals.getMassTF().setForeground(Color.BLACK);
				finals.adjustFont();
				
				finals1.getMassTF().setText(test1.getMassTF().getText());
				finals1.getMassTF().setBackground(Color.YELLOW);
				finals1.getMassTF().setForeground(Color.black);
				finals1.setMass(Double.parseDouble(test1.getMassTF().getText()));
				finals1.adjustFont();
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "           Need more information", "More info plz!", JOptionPane.WARNING_MESSAGE);
				this.moreInfo = true;
			}
				
			
			
		}
		else if(cordin==-1&&hom==2&&!test1.getAngleTF().isVisible())
		{
			try {
				
				finals.setMass(Double.parseDouble(test.getMassTF().getText())/2);
				finals.getMassTF().setText(String.format("%.1f", finals.getMass()));
				finals.getMassTF().setBackground(Color.YELLOW);
				finals.adjustFont();
				
				finals1.setMass(Double.parseDouble(test.getMassTF().getText())/2);
				finals1.getMassTF().setText(String.format("%.1f", finals1.getMass()));
				finals1.getMassTF().setBackground(Color.YELLOW);
				finals1.adjustFont();
			}catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "           Need more information", "More info plz!", JOptionPane.WARNING_MESSAGE);
				this.moreInfo = true;
			}
		}
		else if(hom<2)
		{
			if(cordin>=0)
			{
				int curr = 0;
				if(finalMass - initialMass>=0) {
					for(Initials i:tinitials) {
						if(i.getMassTF().isVisible())
						{
							if(curr==cordin)
							{
								i.setMass(finalMass-initialMass);
								i.getMassTF().setText(String.format("%.1f", (finalMass-initialMass)));
								i.getMassTF().setBackground(Color.YELLOW);
								i.getMassTF().setForeground(Color.black);
								i.adjustFont();
								
							}
						}
						
						
							curr++;
						
					}
				}
				else {
					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "                 Not possible", "Eror 501", JOptionPane.ERROR_MESSAGE);
					this.possible = false;
				}
				
			}
			else if(cordinf>=0)
			{
				int curr = 0;
				if(initialMass-finalMass>=0)
				{
					for(Initials i:tfinals) {
						if(i.getMassTF().isVisible())
						{
							if(curr==cordinf)
							{
								i.setMass(initialMass-finalMass);
								i.getMassTF().setText(String.format("%.1f", (initialMass - finalMass)));
								i.getMassTF().setBackground(Color.yellow);
								i.getMassTF().setForeground(Color.black);
								i.adjustFont();
								
							}
						}
						
						
							curr++;
						
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "                 Not possible", "Eror 501", JOptionPane.ERROR_MESSAGE);
//					System.out.println("not possible");
					this.possible = false;
				}
				
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "           Need more information", "More info plz!", JOptionPane.WARNING_MESSAGE);
//			System.out.print("need more information");
			this.moreInfo = true;
		}
		Support.currMaxMass = maxmass;
		}
	
		
		
		
	}
	public void setMasses()
	{
		
			for(Initials i:tinitials)
			{
				if(i.getMassTF().isVisible())
				{
					try {
						i.setMass(Double.parseDouble(i.getMassTF().getText()));
					}catch(NumberFormatException e)
					{
						
						
					}
				}
				
			}
		
	
		for(Initials f:tfinals)
		{
			if(f.getMassTF().isVisible())
			{
				try {
					f.setMass(Double.parseDouble(f.getMassTF().getText()));
				}catch(NumberFormatException e)
				{
					
					
				}
			}
			
			
		}
	}
	
	public void setVelocities()
	{
		
			for(Initials i:tinitials)
			{
				if(i.getField().isVisible())
				{
					try {
						i.setTheVelocity(Double.parseDouble(i.getField().getText()), i.getJCB().getSelectedIndex()+1, Double.parseDouble(i.getAngleTF().getText()));
					}catch(NumberFormatException e)
					{
						
						
					}
				}
				
			}
		
	
			for(Initials i:tfinals)
			{
				if(i.getField().isVisible())
				{
					try {
						i.setTheVelocity(Double.parseDouble(i.getField().getText()), i.getJCB().getSelectedIndex()+1, Double.parseDouble(i.getAngleTF().getText()));
					}catch(NumberFormatException e)
					{
						
						
					}
				}
				
			}
	}
	public void whichVelocity() {
		if(this.possible&&!this.moreInfo)
		{
		double initialXmomentum = 0.0;
		double initialYmomentum = 0.0;
		double finalXmomentum = 0.0;
		double finalYmomentum = 0.0;
		int placei = -1;
		int placef = -1;
		int allinfo = 0;
		int currVel = 0;
		double maxVel = 0;
		
		
		for(Initials i:tinitials) {
			if(i.getField().isVisible())
			{
				if(i.getField().getText().isEmpty())
				{
					placei = currVel;
					allinfo++;
				}
				else {
					if(Math.abs(i.getXvel())>maxVel)
					{
						maxVel = Math.abs(i.getXvel());
					}
					else if(Math.abs(i.getYvel())>maxVel)
					{
						maxVel = Math.abs(i.getYvel());
					}
					
					initialXmomentum += i.getXMomentum();
//					TA.setText(TA.getText()+String.format(" InitialXMomentum of %s = %.1f * %.1f = %.1f\n",i.getName1(),i.getMass(),i.getXvel(),i.getXMomentum()));
					initialYmomentum += i.getYMomentum();
					//TA.setText(TA.getText()+String.format(" InitialYMomentum of %s = %.1f * %.1f = %.2f\n",i.getName1(),i.getMass(),i.getYvel(),i.getYMomentum()));
				}
				currVel++;
			}
		}
	//	TA.setText(TA.getText()+String.format(" Total initial x momentum = %.2f\n",initialXmomentum));
		//TA.setText(TA.getText()+String.format(" Total initial y momentum = %.2f\n\n",initialYmomentum));
		currVel = 0;
		for(Initials f:tfinals) {
			if(f.getField().isVisible())
			{
				if(f.getField().getText().isEmpty())
				{
					placef = currVel;
					allinfo++;
				}
				else {
					if(Math.abs(f.getXvel())>maxVel)
					{
						maxVel = Math.abs(f.getXvel());
					}
					else if(Math.abs(f.getYvel())>maxVel)
					{
						maxVel = Math.abs(f.getYvel());
					}
					finalXmomentum += f.getXMomentum();
					//TA.setText(TA.getText()+String.format(" InitialXMomentum of %s = %.1f * %.1f = %.2f\n",f.getName1(),f.getMass(),f.getXvel(),f.getXMomentum()));
					finalYmomentum += f.getYMomentum();
					//TA.setText(TA.getText()+String.format(" InitialYMomentum of %s = %.1f * %.1f = %.2f\n",f.getName1(),f.getMass(),f.getYvel(),f.getYMomentum()));
				}
				currVel++;
			}
		}
		
		//TA.setText(TA.getText()+String.format(" Total final x momentum = %.2f\n",finalXmomentum));
		//TA.setText(TA.getText()+String.format(" Total final y momentum = %.2f\n\n",finalYmomentum));
		
		if(allinfo<2)
		{
			if(placei>=0)
			{
				int curr = 0;
				for(Initials i:tinitials)
				{
					if(i.getField().isVisible())
					{
						if(curr==placei) {
							if(finalXmomentum> initialXmomentum)
							{
								i.setXmomentum(finalXmomentum+initialXmomentum);
							}
							else if(finalXmomentum<=initialXmomentum)
							{
								i.setXmomentum(initialXmomentum-finalXmomentum);
							}
							
							if(finalYmomentum> initialYmomentum)
							{
								i.setYmomentum(finalYmomentum+initialYmomentum);
							}
							else if(finalYmomentum<=initialYmomentum)
							{
								i.setYmomentum(initialYmomentum-finalYmomentum);
							}
							
							
							i.calFinalMomentum(i.getXMomentum1(), i.getYMomentum1());
							i.setV();
							i.getField().setBackground(Color.yellow);
							i.getField().setForeground(Color.black);
							i.calXvel();
							i.calYvel();
							i.calAngle();
							i.adjustFont();
							if(Math.abs(i.getXvel())>maxVel)
							{
								maxVel = Math.abs(i.getXvel());
							}
							else if(Math.abs(i.getYvel())>maxVel)
							{
								maxVel = Math.abs(i.getYvel());
							}
							//TA.setText(TA.getText()+String.format(" Final momentum of %s\n",i.getName1()));
							//TA.setText(TA.getText()+String.format(" = sqrt((%.1f)^2+(%.1f)^2) = %.2fN.s\n",i.getYMomentum1(),i.getXMomentum1(),i.getFinalMomentum()));
							//TA.setText(TA.getText()+String.format(" Final velocity of %s = %.1f/%.1f = %.2fm/s\n",i.getName1(),i.getFinalMomentum(),i.getMass(),i.getVelocity()));
							//TA.setText(TA.getText()+String.format(" Angle of %s = tan^-1(%.1f/%.1f) = %.2f %s\n",i.getName1(),i.getYvel(),i.getXvel(),i.getAngle(),i.names[i.getJCB().getSelectedIndex()]));
							
						}
					}
					
					curr++;
				}
			}
			
			else if(placef>=0)
			{
				int curr = 0;
				for(Initials i:tfinals)
				{
					if(i.getField().isVisible())
					{
						if(curr==placef) {
							if(finalXmomentum> initialXmomentum)
							{
								i.setXmomentum(finalXmomentum+initialXmomentum);
							}
							else if(finalXmomentum<=initialXmomentum)
							{
								i.setXmomentum(initialXmomentum-finalXmomentum);
							}
							
							if(finalYmomentum> initialYmomentum)
							{
								i.setYmomentum(finalYmomentum+initialYmomentum);
							}
							else if(finalYmomentum<=initialYmomentum)
							{
								i.setYmomentum(initialYmomentum-finalYmomentum);
							}
							i.calFinalMomentum(i.getXMomentum1(), i.getYMomentum1());
							i.setV();
							i.getField().setBackground(Color.yellow);
							i.getField().setForeground(Color.black);
							i.calXvel();
							i.calYvel();
							i.calAngle();
							i.adjustFont();
							
							if(Math.abs(i.getXvel())>maxVel)
							{
								maxVel = Math.abs(i.getXvel());
							}
							else if(Math.abs(i.getYvel())>maxVel)
							{
								maxVel = Math.abs(i.getYvel());
							}
						//	TA.setText(TA.getText()+String.format(" Final momentum of %s\n",i.getName1()));
						//	TA.setText(TA.getText()+String.format(" = sqrt((%.1f)^2+(%.1f)^2) = %.2fN.s\n",i.getYMomentum1(),i.getXMomentum1(),i.getFinalMomentum()));
						//	TA.setText(TA.getText()+String.format(" Final velocity of %s = %.1f/%.1f = %.2fm/s\n",i.getName1(),i.getFinalMomentum(),i.getMass(),i.getVelocity()));
						//	TA.setText(TA.getText()+String.format(" Angle of %s = tan^-1(%.1f/%.1f) = %.2f %s\n",i.getName1(),i.getYvel(),i.getXvel(),i.getAngle(),i.names[i.getJCB().getSelectedIndex()]));
						}
					}
					
					curr++;
				}
			}
		}
		Support.currMaxVelocity = maxVel;
	}
		
}
	public void createObjects()
	{
		if(possible&&!moreInfo)
		{
			int situation = 0;
			if(test.getAngleTF().isVisible()&&test1.getAngleTF().isVisible()&&finals.getAngleTF().isVisible()&&finals1.getAngleTF().isVisible())
			{
				Animation.object1 = new Object(test.getDirection1(),test.getMass(),test.getAngle(),test.getXvel(),test.getYvel(),true,test.getObjectColor(),finals.getDirection1(),finals.getMass(),finals.getAngle(),finals.getXvel(),finals.getYvel(),false,finals.getObjectColor(),true,1,test.getName1(),test.getTraceColor(),finals.getTraceColor());
				Animation.object2 = new Object(test1.getDirection1(),test1.getMass(),test1.getAngle(),test1.getXvel(),test1.getYvel(),true,test1.getObjectColor(),finals1.getDirection1(),finals1.getMass(),finals1.getAngle(),finals1.getXvel(),finals1.getYvel(),false,finals1.getObjectColor(),true,1,test1.getName1(),test1.getTraceColor(),finals1.getTraceColor());
				situation = 1;
			}
			else if(test.getAngleTF().isVisible()&&test1.getAngleTF().isVisible()&&finals.getAngleTF().isVisible()&&!finals1.getAngleTF().isVisible())
			{
				Animation.object1 = new Object(test.getDirection1(),test.getMass(),test.getAngle(),test.getXvel(),test.getYvel(),true,test.getObjectColor(),finals.getDirection1(),test.getMass(),finals.getAngle(),finals.getXvel(),finals.getYvel(),false,finals.getObjectColor(),true,2,test.getName1(),test.getTraceColor(),finals.getTraceColor());
				Animation.object2 = new Object(test1.getDirection1(),test1.getMass(),test1.getAngle(),test1.getXvel(),test1.getYvel(),true,test1.getObjectColor(),finals.getDirection1(),test1.getMass(),finals.getAngle(),finals.getXvel(),finals.getYvel(),false,finals.getObjectColor(),true,2,test1.getName1(),test1.getTraceColor(),finals.getTraceColor());
				situation = 2;
			}
			else if(test.getAngleTF().isVisible()&&!test1.getAngleTF().isVisible()&&finals.getAngleTF().isVisible()&&finals1.getAngleTF().isVisible())
			{
				Animation.object1 = new Object(test.getDirection1(),test.getMass(),test.getAngle(),test.getXvel(),test.getYvel(),true,test.getObjectColor(),finals.getDirection1(),finals.getMass(),finals.getAngle(),finals.getXvel(),finals.getYvel(),false,finals.getObjectColor(),true,3,test.getName1(),test.getTraceColor(),finals.getTraceColor());
				Animation.object2 = new Object(0,0,0,0,0,false,Color.green,finals1.getDirection1(),finals1.getMass(),finals1.getAngle(),finals1.getXvel(),finals1.getYvel(),false,finals1.getObjectColor(),false,3,finals1.getName1(),finals1.getTraceColor(),finals1.getTraceColor());
				situation =3;
			}
//			System.out.println();
//			System.out.print(Support.currMaxVelocity);
			removeAllObjects();
			Animation.getObjects().add(Animation.object1);
			Animation.getObjects().add(Animation.object2);
			
			setSizesForObjects();
			setSizesForObjectsFinal();
			
			setVelocitiesForObjects();
			setVelocitiesForObjectsFinal();
			makeSureTheyCollide();
//			timeItTakes();
			if(situation==1||situation==2)
			{
//				equalDistance();
				Animation.isTheFirstTime = false;
			}
			else if(situation==3)
			{
				Animation.isTheFirstTime = true;
			}
				
			
			Animation.state = State.ANIMATION;
		
		
		}
	}
	
	public void resetClass()
	{
		test.reset();
		test.adjustFont();
		test1.reset();
		test1.adjustFont();
		finals.reset();
		finals.adjustFont();
		finals1.reset();
		finals1.adjustFont();
		removeAllObjects();
		//TA.setText("");
	}
	public void initConditions()
	{
		this.possible = true;
		this.moreInfo = false;
	}
	public void initAnimDialog()
	{
		this.animDialog = new JDialog();
		initAnimClass();
		animDialog.setTitle("Animation");
		animDialog.setSize(Support.Width,Support.Height);
		animDialog.add(animClass);
		animDialog.setResizable(false);
		animDialog.setVisible(false);
		
	}
	public void initAnimClass()
	{
		this.animClass  =new Animation();
	}
	public void conditions()
	{
		this.possible = true;
		this.moreInfo =false;
	}
	public void setSizesForObjects()
	{
		for(Object o:Animation.getObjects())
		{
			o.setSize((o.getMass()/Support.currMaxMass)*(Support.MAX_MASS),true); 
		}
	}
	public void setSizesForObjectsFinal()
	{
		for(Object o:Animation.getObjects())
		{
			o.setSize1(((o.getMass1()/Support.currMaxMass)*(Support.MAX_MASS))); 
		}
	}
	public void setVelocitiesForObjects()
	{
		for(Object o:Animation.getObjects())
		{
			o.setVel((o.getXV()/Support.currMaxVelocity)*Support.MAX_VELOCITY, (o.getYV()/Support.currMaxVelocity)*Support.MAX_VELOCITY);
		}
	}
	public void setVelocitiesForObjectsFinal()
	{
		for(Object o:Animation.getObjects())
		{
			o.setVel1((o.getXV1()/Support.currMaxVelocity)*Support.MAX_VELOCITY, (o.getYV1()/Support.currMaxVelocity)*Support.MAX_VELOCITY);
		}
	}
//	public void equalDistance()
//	{
//		double lowestTime = 999999999;
//		double position = 0;
//		int p = 0;
//		for(Object o:Animation.getObjects())
//		{
//			if(o.getTime()<lowestTime)
//			{
//				lowestTime = o.getTime();
//				position = p;
//			}
//			p++;
//		}
//		p = 0;
//		
//		for(Object o:Animation.getObjects())
//		{
//			if(p!=position)
//			{
//				o.positionBTime(lowestTime);
//			}
//			p++;
//		}
//		
//		
//		
//	}
	public void timeItTakes()
	{
		for(Object o:Animation.getObjects())
		{
			o.timeItTakes();
		}
	}
	public void makeSureTheyCollide()
	{
		boolean control = true;
		
		setXY();
		
		
		while(control)
		{
			for(Object o:Animation.getObjects())
			{
				o.moveInverse();
				if(o.hitsBorders())
				{
					control = false;
					break;
				}
			}
		}
		savePositions();
	}
	public void savePositions()
	{
		for(Object o:Animation.getObjects())
		{
			o.savePositions();
		}
	}
	public void setXY()
	
	{
		
		for(Object o:Animation.getObjects())
		{
			o.centerLocation();
		}
		
	}
	public void removeAllObjects()
	{
		for(Object o:Animation.getObjects())
		{
			o.remove();
		}
	}
	public void enableAnimation()
	{
		if(possible&&!moreInfo)
		{
			this.animation.setEnabled(true);
			this.showWork.setEnabled(true);
		}
		else 
		{
			this.animation.setEnabled(false);
			this.showWork.setEnabled(false);
		}
	}
	public void initQuit()
	{
		this.quit = new JButton("Quit");
		this.quit.setBackground(Color.black);
		this.quit.setForeground(Color.white);
		this.quit.setBounds(394,640,90,45);
		this.quit.setFont(new Font("Serfi",Font.PLAIN,15));
		add(this.quit);
	}
	public JButton getQuit()
	{
		return this.quit;
	}
//	public void initShowWork()
//	{
//		this.showWork = new JButton("Show work");
//		this.showWork.setBounds(Support.Width/2-60,Support.Height-60,110,45);
//		this.showWork.setBackground(Color.black);
//		this.showWork.setForeground(Color.white);
//		this.showWork.setEnabled(false);
//		this.showWork.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//			{
//				showwork.setVisibility(true);
//			}
//		});
//		add(showWork);
//	}
//	public void initshowwork()
//	{
//		this.showwork = new ShowWork();
//	}
	public void initSyncColors()
	{
		this.syncColors = new JButton("Sync Colors");
		this.syncColors.setBackground(Color.BLACK);
		this.syncColors.setForeground(Color.white);
		this.syncColors.setToolTipText("This button syncs the colors for both objects based on the color of first object");
//		this.syncColors.setBounds((Support.Width/2)-20,20,70,30);
		this.syncColors.setBounds(Support.Width/2-60,Support.Height-60,110,45);
		this.syncColors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				finals.setObjectColor(test.getObjectColor());
				finals.setTraceColor(test.getTraceColor());
				finals.setDialogColor(finals.getObjectColor(), finals.getTraceColor());
				finals.sameColor();
				
				finals1.setObjectColor(test1.getObjectColor());
				finals1.setTraceColor(test1.getTraceColor());
				finals1.setDialogColor(finals1.getObjectColor(), finals1.getTraceColor());
				finals.sameColor();
			}
		});
		add(this.syncColors);
	}
	
	

}
