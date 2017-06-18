/**
 * @author Ramiro Oliva
 */

import java.awt.*;

public class Button extends GameObject{
	private String nameButton;
	private int positionX;
	private int positionY;S
	public Rectangle rectangle;

	
	public Button (String nameButton, int positionX, int positionY){
		this.nameButton=nameButton;
		this.positionX=positionX;
		this.positionY=positionY;
	}
}