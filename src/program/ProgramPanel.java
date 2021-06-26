package program;

import java.awt.*;
import javax.swing.*;
import types.*;

public class ProgramPanel extends JPanel{

	
	public World world;

	public ProgramPanel(World map){
		this.world = map;
		this.setPreferredSize(new Dimension(C.CANVAS_WIDTH, C.CANVAS_HEIGHT));
		this.setBackground(Color.white);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(int y = 0; y < C.HEIGHT; y++) {
			for(int x = 0; x < C.WIDTH; x++) {
				
				Tile tile = world.map[y][x];
				
				int predatorsNumber = tile.predators.size();
				int praysNumber = tile.prays.size();
				
				if(tile.isOverpopulated()) {
					
					g.setColor(C.OVERPOPULATED_TILE);
					
				}else if(predatorsNumber > praysNumber) {
					
					g.setColor(C.HUNGRY_TILE);
					
				} else if(predatorsNumber == praysNumber) {
					
					g.setColor(C.NEUTRAL);
					
				} else {
					
					g.setColor(C.OK_TILE);
					
				}
				
				g.fillRect(x * C.TILE_SIZE, y * C.TILE_SIZE,
						C.TILE_SIZE, C.TILE_SIZE);
				g.setColor(Color.black);
				g.drawRect(x * C.TILE_SIZE, y * C.TILE_SIZE,
							C.TILE_SIZE, C.TILE_SIZE);
				g.drawString(world.getTile(x, y),
							x * C.TILE_SIZE, (1+y) * C.TILE_SIZE);
			}
		}
	}
}
