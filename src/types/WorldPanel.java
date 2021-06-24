package types;

import java.awt.*;
import javax.swing.*;

import program.C;

public class WorldPanel extends JPanel{

	
	public World world;

	public WorldPanel(World map){
		this.world = map;
		this.setPreferredSize(new Dimension(C.CANVAS_WIDTH, C.CANVAS_HEIGHT));
		this.setBackground(Color.white);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(int y = 0; y < C.HEIGHT; y++) {
			for(int x = 0; x < C.WIDTH; x++) {
				if(world.map[y][x].predators.size() > world.map[y][x].prays.size()) {
					g.setColor(Color.red);
				} else if(world.map[y][x].predators.size() == world.map[y][x].prays.size()) {
					g.setColor(Color.yellow);
				} else {
					g.setColor(Color.green);
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
