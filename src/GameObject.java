import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Observable;

/**
 * Created by Bensas on 5/27/17.
 */
public abstract class GameObject extends Observable {
    private int positionX = 100, positionY = 100;
    private int collisionWidth, collisionHeight;
    private float rotation = 0;
    private Rectangle boundaries;
    private Shape collisionBox;
    private float speedFactor;

    public GameObject(int collisionWidth, int collisionHeight, float speedFactor){
        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;
        this.speedFactor= speedFactor;
        updateCollisionBox();
    }

    public int getPositionX() {return positionX;}

    public int getPositionY() {return positionY;}

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getCollisionWidth() {return collisionWidth;}

    public int getCollisionHeight() {return collisionHeight;}

    public float getRotation(){return rotation;}

    public Shape getCollisionBox() {
        return collisionBox;
    }

    public float getSpeedFactor(){return speedFactor;}

    public void setSpeedFactor(float speedFactor) {this.speedFactor = speedFactor;}

    public  boolean collidesWith(GameObject object){
        if (object.getCollisionBox().getBounds2D().intersects(getCollisionBox().getBounds2D()))
            return true;
        return false;
    };

    public void update(){
        updateCollisionBox();
        setChanged();
        notifyObservers();
    }

    private void updateCollisionBox(){
        boundaries = new Rectangle(getPositionX() - getCollisionWidth()/2, getPositionY() - getCollisionHeight()/2, getCollisionWidth(), getCollisionHeight()  );
        AffineTransform tx = new AffineTransform();
        tx.rotate(rotation);
        collisionBox = tx.createTransformedShape(boundaries);
        System.out.println((getPositionX() - getCollisionWidth()/2) + " - " + (getPositionY() - getCollisionHeight()/2) + " --- " + getCollisionWidth() + " - " + getCollisionHeight());
    }
}
