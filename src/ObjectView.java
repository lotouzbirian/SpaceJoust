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
    protected Animation animation;

    protected Image loadTexture(String textureName){
        ImageIcon i = new ImageIcon(textureName);
        return i.getImage();
    }

    public void draw(Graphics2D g){
        //We rotate the whole canvas before drawing our object
        //and then rotate it back to its original position
        g.rotate(getRotation());
        g.drawImage(animation.getFrame(), getPositionX(), getPositionY(), animation.getFrame().getWidth(null), animation.getFrame().getHeight(null), null);
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
