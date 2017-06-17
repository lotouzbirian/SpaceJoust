public class Button{
	private String nameButton;
	private int positionX;
	private int positionY;
	private Font fnt0 = new Font("arial", Font.BOLD, 30);
	public Rectangle rectangle;

	
	public Button (String nameButton, int positionX, int positionY){
		this.nameButton=nameButton;
		this.positionX=positionX;
		this.positionY=positionY;
	}

	public void draw (Graphics2D g){
		rectangle = new Rectangle (positionX, positionY, 120, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.draw(newButton);
		g.drawString( nameButton, newButton.x +30, newButton.y + 20);
	}
}