import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bensas on 5/27/17.
 */
public abstract class ObjectView implements Observer{
    private int positionX, positionY;
    private float rotation;
    private Image texture;

    public ObjectView(){

    }

    public void loadAndSetTexture(String textureName){
        ImageIcon i = new ImageIcon(textureName);
        texture = i.getImage();
    }

    public void draw(Graphics2D g){
        //We rotate the whole canvas before drawing our object
        //and then rotate it back to its original position
        g.rotate(getRotation());
        g.drawImage(texture, getPositionX(), getPositionY(), texture.getWidth(null), texture.getHeight(null), null);
        g.rotate(-getRotation());
    }

    @Override
    public void update(Observable o, Object arg) {
        setPositionX(((GameObject)o).getPositionX());
        setPositionY(((GameObject)o).getPositionY());
        setRotation(((GameObject)o).getRotation());
    }

    public int getPositionX() {return positionX;}

    public int getPositionY() {return positionY;}

    public float getRotation() {return rotation;}

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
