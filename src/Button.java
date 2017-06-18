/**
 * @author Ramiro Oliva
 */

import java.awt.*;

/**
 * Clase para los botones del menú.
 */
public class Button {
	private Font font = new Font("arial", Font.BOLD, 20);
	private String text;
	private int posX, posY, width = 200, height = 40;
	private Rectangle boundaries;
	private int statePointer;

	
	/**
 	  * Constructor de la clase que inicializa las propiedades básicas del botón.
	  * @param text es el texto que debe decir el botón.
	  * @param posX es la posición en X del botón.
	  * @param posY es la posición en Y del botón.
	  * @param statePointer es el estado del botón.
 	*/
	public Button (String text, int posX, int posY, int statePointer){
		super();
		this.text=text;
		this.posX = posX;
		this.posY = posY;
		boundaries = new Rectangle(posX - width/2, posY - height/2, width, height);
		this.statePointer = statePointer;
	}

	
	/**
 	  * Grafica el botón según sus propiedades.
 	*/
	public void draw(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fillRect(posX - width/2, posY - height/2, width, height);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString(text, posX - width/2 + 20, posY+ 10);
	}

	
	
	/**
 	  * @return Devuelve las limitaciones del botón.
 	*/
	public Rectangle getBoundaries(){return boundaries;}

	
	/**
 	  * @return Devuelve el estado del botón.
 	*/
	public int getStatePointer() {return statePointer;}
}
