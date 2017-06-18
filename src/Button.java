/**
 * @author Ramiro Oliva
 */

import java.awt.*;

public class Button {
	private Font font = new Font("arial", Font.BOLD, 20);
	private String text;
	private int posX, posY, width = 200, height = 40;
	private Rectangle boundaries;
	private int statePointer;
	
	public Button (String text, int posX, int posY, int statePointer){
		super();
		this.text=text;
		this.posX = posX;
		this.posY = posY;
		boundaries = new Rectangle(posX - width/2, posY - height/2, width, height);
		this.statePointer = statePointer;
	}

	public void draw(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fillRect(posX - width/2, posY - height/2, width, height);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString(text, posX - width/2 + 20, posY+ 10);
	}

	public Rectangle getBoundaries(){return boundaries;}

	public int getStatePointer() {return statePointer;}
}