package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ShowWork extends JPanel {
	
	/**
	 * this class shows the calculations for the conservation of the momentum class
	 */
	private static final long serialVersionUID = 1L;
	
	//Dialog
	private JDialog jd;
	
	//work area
	private JTextPane jtp;
	private JScrollPane jsp;
	
	
	
	ShowWork()
	{
		initDesign();
		initClass();
	}
	
	//init
	private void initDesign()
	{
		super.setBackground(Color.WHITE);
		super.setLayout(null);
		super.setSize(Support.Width, Support.Height);
	}
	private void initClass()
	{
		initJD();
		initJTP();
		initJSP();	
	}
	private void initJD()
	{
		this.jd = new JDialog();
		this.jd.setSize(Support.Width, Support.Height);
		this.jd.setTitle("Show Work");
		this.jd.setVisible(false);
		this.jd.setResizable(false);
		this.jd.setTitle("Show work");
		this.jd.add(this);
	}
	private void initJTP() 
	{
		//init
		this.jtp = new JTextPane();
		this.jtp.setBounds(0, 0, Support.Width, Support.Height);
		this.jtp.setFont(new Font("Serif",Font.PLAIN,20));
		this.jtp.setEditable(false);
	
		//center it 
		StyledDocument doc = jtp.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		//end center it
		
		add(this.jtp);
	}
	private void initJSP()
	{
		this.jsp = new JScrollPane(this.jtp);
		this.jsp.setBounds(0, 0, Support.Width, Support.Height);
		add(this.jsp);
	}
	
	
	
	//public setters
	public void addText(String str)
	{
		this.jtp.setText(jtp.getText()+str);
	}
	public void setVisibility(boolean tof)
	{
		this.jd.setVisible(tof);
		this.jtp.setVisible(tof);
		super.setVisible(tof);
		this.jsp.setVisible(tof);
	}
	

}
