import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Observable;

/**
 * Created by Bensas on 5/27/17.
 */
public abstract class GameObject extends Observable {
    private int positionX = 100, positionY = 100;
    private int collisionWidth, collisionHeight;
    private float rotation = 0;
    private Rectangle boundaries;
    private Area collisionBox;
    private float speedFactor;

    public GameObject(int collisionWidth, int collisionHeight, float speedFactor){
        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;
        this.speedFactor= speedFactor;
        updateCollisionBox();
    }

    protected int getPositionX() {return positionX;}

    protected int getPositionY() {return positionY;}

    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    protected int getCollisionWidth() {return collisionWidth;}

    protected int getCollisionHeight() {return collisionHeight;}

    protected float getRotation(){return rotation;}

    protected void setRotation(float rotation) {this.rotation = rotation;}

    private Shape getCollisionBox() {
        return collisionBox;
    }

    protected float getSpeedFactor(){return speedFactor;}

    protected void setSpeedFactor(float speedFactor) {this.speedFactor = speedFactor;}

    public  boolean collidesWith(GameObject object){
        if (object.getCollisionBox().intersects(getCollisionBox().getBounds()) && getCollisionBox().intersects(object.getCollisionBox().getBounds()))
            return true;
        return false;
    };

    public abstract void impact();

    public void update(){
        updateCollisionBox();
        setChanged();
        notifyObservers();
    }

    private void updateCollisionBox(){
        boundaries = new Rectangle(getPositionX() - getCollisionWidth()/2, getPositionY() - getCollisionHeight()/2, getCollisionWidth(), getCollisionHeight()  );
        AffineTransform tx = new AffineTransform();
        tx.rotate(rotation);
        collisionBox = new Area(tx.createTransformedShape(boundaries));
        //System.out.println(collisionBox.getBounds());
    }
}
