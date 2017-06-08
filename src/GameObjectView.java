import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bensas on 5/27/17.
 */
public abstract class GameObjectView implements Observer{
    private int positionX, positionY;
    private float rotation;
    private int state;
    protected Animation[] animations;
    protected Animation currentAnimation, travelAnimation, explodeAnimation;
    AffineTransform identity = new AffineTransform();

    /***
     *
     * @param textureName
     * @return
     */
    protected Image loadTexture(String textureName){
        ImageIcon i = new ImageIcon(textureName);
        return i.getImage();
    }

    /***
     *
     * @param g
     */
    public void draw(Graphics2D g){
        getAnimation().update();
        AffineTransform trans = new AffineTransform();
        trans.setTransform(identity);
        trans.translate(getPositionX() - getAnimation().getFrame().getWidth(null)/2, getPositionY() - getAnimation().getFrame().getHeight(null) / 2);
        trans.rotate(getRotation(), getAnimation().getFrame().getWidth(null)/2, getAnimation().getFrame().getHeight(null)/2);
        g.drawImage(getAnimation().getFrame(), trans, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setPositionX(((GameObject)o).getPositionX());
        setPositionY(((GameObject)o).getPositionY());
        setRotation(((GameObject)o).getRotation());
        if (((GameObject)o).getState() != getState()){
            switchAnimation(((GameObject)o).getState());
            setState(((GameObject)o).getState());
        }
    }

    protected Animation getAnimation(){return currentAnimation;}

    protected void setAnimation(Animation currentAnimation){this.currentAnimation = currentAnimation;}

    protected abstract void switchAnimation(int nextState);


    protected int getPositionX() {return positionX;}

    protected int getPositionY() {return positionY;}

    protected float getRotation() {return rotation;}

    protected void setRotation(float rotation) {
        this.rotation = rotation;
    }

    protected int getState(){return state;}

    protected void setState(int state){this.state = state;}

    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
