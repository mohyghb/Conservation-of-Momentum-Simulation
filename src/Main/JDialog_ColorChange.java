package Main;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JDialog_ColorChange {
	
	private JDialog jd;
	private JPanel jp;
	
	private JSlider hue;
	private JSlider saturation;
	private JSlider brightness;
	private JButton showColor;
	
	private JSlider hue1;
	private JSlider saturation1;
	private JSlider brightness1;
	private JButton showColor1;
	
//	private JPanel paint;
//	private JDialog paint_Panel;
	
	
	
	private JCheckBox same;
	private JButton save;
	//private JButton drawObject;
	
	private float h,s,b;
	private float h1,s1,b1;
	
	
	JDialog_ColorChange(int x,int y)
	{
		initJObjects(x,y);
//		initPaint();
//		initDrawObject();
	}
	public void initJObjects(int x,int y)
	{
		
		//jpanel
		this.jp = new JPanel();
		this.jp.setBackground(Color.white);
		this.jp.setLayout(null);
		this.jp.setSize(Support.Width,Support.Height);
		this.jp.setVisible(false);
		
		
		
		//jdialog
		this.jd = new JDialog();
		this.jd.setSize(Support.Width, Support.Height);
		this.jd.setLocationRelativeTo(null);
		this.jd.setTitle("Colors");
		this.jd.setAlwaysOnTop(true);
		this.jd.setResizable(false);
		this.jd.setUndecorated(false);
		this.jd.add(this.jp);
		this.jd.setVisible(false);
		
		initSliders();
		initSliders1();
		
	}
	public void initSliders()
	{
		this.s =0;
		this.h =0;
		this.b =0;
		this.hue = new JSlider(JSlider.VERTICAL);
		hue.setMaximum(10);
		hue.setMinimum(0);
		hue.setPaintLabels(true);
		hue.setMajorTickSpacing(1);
		hue.setPaintTicks(true);
		hue.setBounds(Support.Width/2+5,50,50,200);
		hue.setBackground(Color.white);
		hue.setToolTipText("hue");
		hue.setValue((int)h);
		hue.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				h = (float)(hue.getValue())/10;
				showColor.setBackground(Color.getHSBColor(h, s, b));
			}
			
		});
		
		
		
		
		this.saturation = new JSlider(JSlider.VERTICAL);
		saturation.setMaximum(10);
		saturation.setMinimum(0);
		saturation.setPaintLabels(true);
		saturation.setMajorTickSpacing(1);
		saturation.setPaintTicks(true);
		saturation.setBounds(Support.Width-110,50,50,200);
		saturation.setBackground(Color.white);
		saturation.setToolTipText("saturation");
		saturation.setValue((int)s);
		saturation.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				s = (float)(saturation.getValue())/10;
				showColor.setBackground(Color.getHSBColor(h, s, b));
			}
			
		});
		
		this.brightness = new JSlider(JSlider.VERTICAL);
		brightness.setMaximum(10);
		brightness.setMinimum(0);
		brightness.setPaintLabels(true);
		brightness.setMajorTickSpacing(1);
		brightness.setPaintTicks(true);
		brightness.setBounds(Support.Width/2+125,50,50,200);
		brightness.setBackground(Color.white);
		brightness.setToolTipText("brightness");
		brightness.setValue((int)b);
		brightness.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				b = (float)(brightness.getValue())/10;
				showColor.setBackground(Color.getHSBColor(h, s, b));
			}
			
		});
		
		
		showColor = new JButton();
		showColor.setBorderPainted(false);
//		showColor.setContentAreaFilled(false);
		showColor.setFocusPainted(false);
		showColor.setBounds(120,100,100,100);
		showColor.setBackground(Color.getHSBColor(h, s, b));
		
		
		
		
		save = new JButton("Save");
		save.setBounds(Support.Width/2-45, Support.Height-78, 90, 45);
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		
		
		
		
		same = new JCheckBox("same for trace line");
		same.setBounds(Support.Width/2-60,Support.Height/2-30,140,20);
		same.setBackground(Color.white);
		same.setSelected(true);
		same.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				if(same.isSelected())
				{
					 hue1.setEnabled(false);
					 saturation1.setEnabled(false);
					 brightness1.setEnabled(false);
					 showColor1.setEnabled(false);
				}
				else {
					 hue1.setEnabled(true);
					 saturation1.setEnabled(true);
					 brightness1.setEnabled(true);
					 showColor1.setEnabled(true);
				}
			}
		});
		
		this.jp.add(this.hue);
		this.jp.add(this.saturation);
		this.jp.add(this.brightness);
		this.jp.add(this.showColor);
		this.jp.add(this.save);
		this.jp.add(this.same);
	}
	
	
	public void initSliders1()
	{
		this.s1 =0;
		this.h1 =0;
		this.b1 =0;
		this.hue1 = new JSlider(JSlider.VERTICAL);
		hue1.setMaximum(10);
		hue1.setMinimum(0);
		hue1.setPaintLabels(true);
		hue1.setMajorTickSpacing(1);
		hue1.setPaintTicks(true);
		hue1.setBounds(Support.Width/2+5,400,50,200);
		hue1.setBackground(Color.white);
		hue1.setToolTipText("hue");
		hue1.setValue((int)h1);
		hue1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				h1 = (float)(hue1.getValue())/10;
				showColor1.setBackground(Color.getHSBColor(h1, s1, b1));
			}
			
		});
		
		
		
		
		this.saturation1 = new JSlider(JSlider.VERTICAL);
		saturation1.setMaximum(10);
		saturation1.setMinimum(0);
		saturation1.setPaintLabels(true);
		saturation1.setMajorTickSpacing(1);
		saturation1.setPaintTicks(true);
		saturation1.setBounds(Support.Width-110,400,50,200);
		saturation1.setBackground(Color.white);
		saturation1.setToolTipText("saturation");
		saturation1.setValue((int)s1);
		saturation1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				s1= (float)(saturation1.getValue())/10;
				showColor1.setBackground(Color.getHSBColor(h1, s1, b1));
			}
			
		});
		
		this.brightness1 = new JSlider(JSlider.VERTICAL);
		brightness1.setMaximum(10);
		brightness1.setMinimum(0);
		brightness1.setPaintLabels(true);
		brightness1.setMajorTickSpacing(1);
		brightness1.setPaintTicks(true);
		brightness1.setBounds(Support.Width/2+125,400,50,200);
		brightness1.setBackground(Color.white);
		brightness1.setToolTipText("brightness");
		brightness1.setValue((int)b1);
		brightness1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				b1 = (float)(brightness1.getValue())/10;
				showColor1.setBackground(Color.getHSBColor(h1, s1, b1));
			}
			
		});
		
		
		showColor1 = new JButton();
		showColor1.setBorderPainted(false);
//		showColor.setContentAreaFilled(false);
		showColor1.setFocusPainted(false);
		showColor1.setBounds(120,450,100,100);
		showColor1.setBackground(Color.getHSBColor(h1, s1, b1));
		
		
		
		
		
		
		this.jp.add(this.hue1);
		this.jp.add(this.saturation1);
		this.jp.add(this.brightness1);
		this.jp.add(this.showColor1);
	}
	public JButton getSave()
	{
		return this.save;
	}
	public void setVisible(boolean b)
	{
		this.jd.setVisible(b);
		this.jp.setVisible(b);
		this.brightness.setVisible(b);
		this.saturation.setVisible(b);
		this.hue.setVisible(b);
	}
	public Color getColorObject()
	{
		return Color.getHSBColor(h, s, b);
	}
	public Color getColorTrace()
	{
		if(same.isSelected())
		{
			return Color.getHSBColor(h, s, b);
		}
		return Color.getHSBColor(h1, s1, b1);
	}
	
	public void setObjectColor(Color oc,Color tc)
	{
		this.showColor.setBackground(oc);
		this.showColor1.setBackground(tc);
	}
//	public void initPaint()
//	{
//		this.paint = new JPanel();
//	}
//	public void initDrawObject()
//	{
//		this.drawObject = new JButton();
//		drawObject = new JButton("Draw");
//		drawObject.setBounds(Support.Width/2+45, Support.Height-78, 90, 45);
//		drawObject.setBackground(Color.black);
//		drawObject.setForeground(Color.white);
//		drawObject.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		this.jp.add(drawObject);
//	}
	
	//create a jdialog that changes the colors of the fields as well as the object and the trace lines 

}
