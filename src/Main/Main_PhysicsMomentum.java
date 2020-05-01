package Main;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main_PhysicsMomentum extends JFrame  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Momentum m = new Momentum();
	Main_PhysicsMomentum()
	{
		setSize(Support.Width,Support.Height);
		setLocationRelativeTo(null);
		setResizable(false);
		super.setTitle("Conservation of momentum (By Moh Yaghoub)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		add(m);
		
		
		
		addActionListenerForQuitButton();
		setVisible(true);
	}
	public void addActionListenerForQuitButton()
	{
		m.getQuit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Main_PhysicsMomentum.this.dispatchEvent(new WindowEvent(Main_PhysicsMomentum.this, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main_PhysicsMomentum();

	}


	
}
