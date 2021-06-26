package types;

import javax.swing.*;

import program.ProgramPanel;

public class MyFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8515733548072536480L;
	
	public ProgramPanel worldPanel;
	
	public MyFrame(ProgramPanel panel){
		
		this.worldPanel = panel;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.worldPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
