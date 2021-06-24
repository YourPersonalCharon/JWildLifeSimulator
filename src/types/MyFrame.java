package types;

import javax.swing.*;

public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8515733548072536480L;
	
	public MyPanel panel;
	
	public MyFrame(MyPanel panel){
		
		this.panel = panel;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
