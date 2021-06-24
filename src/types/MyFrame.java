package types;

import javax.swing.*;

public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8515733548072536480L;
	
	public WorldPanel worldPanel;
	
	public MyFrame(WorldPanel panel){
		
		this.worldPanel = panel;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.worldPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
