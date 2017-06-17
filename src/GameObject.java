import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Observable;

/**
 * @author Juan Bensadon
 *La clase GameObject determina las propiedades que deben cumplir todos los objetos del juego.
 */
public abstract class GameObject extends Observable {
    private int positionX, positionY;
    private int collisionWidth, collisionHeight;
    private float rotation = 0;
    private Area collisionBox;
    private float speedFactor;
    private int state;
    public static final int STATE_TRAVELING= 0, STATE_EXPLODING = 1;

    /**
      *Constructor de la clase.
      *@param collisionWidth es el ancho colisionable del objeto.
      *@param collisionHeight es el alto colisionable del objeto.
      *@param speedFactor es la velocidad base del objeto al moverse en la pantalla.
      *Contínuamente se updatea la colisión de objetos para verificar si ocurre alguna.
    */
    public GameObject(int collisionWidth, int collisionHeight, float speedFactor){
        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;
        this.speedFactor= speedFactor;
        updateCollisionBox();
    }

    /**
      *@return Devuelve la posición en X del objeto.
    */
    protected int getPositionX() {return positionX;}

    /**
      *@param positionX es la posición actual en X del objeto.
    */
    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
      *@return Devuelve la posición en Y del objeto.
    */
    protected int getPositionY() {return positionY;}
    
    /**
      *@param positionY es la posición actual en Y del objeto.
    */
    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
      *@return Devuelve el ancho colisionable del objeto.
    */
    protected int getCollisionWidth() {return collisionWidth;}

    /**
      *@return Devuelve el alto colisionable del objeto.
    */
    protected int getCollisionHeight() {return collisionHeight;}

    /**
      *@return Devuelve la rotación del objeto.
    */
    protected float getRotation(){return rotation;}

    /**
      *@param rotation es la rotación determinada del objeto a ser guardada.
    */    
    protected void setRotation(float rotation) {this.rotation = rotation;}

    /**
      *@return Devuelve el área colisonable del objeto.
    */
    protected Area getCollisionBox() {
        return collisionBox;
    }

    /**
      *@return Devuelve la velocidad del objeto.
    */
    protected float getSpeedFactor(){return speedFactor;}
    
    /**
      *@param speedFactor es la nueva velocidad del objeto.
    */    
    protected void setSpeedFactor(float speedFactor) {this.speedFactor = speedFactor;}

    /**
      *@return Devuelve el estado en el que se encuentra el objeto.
    */
    public int getState() {return state;}

    /**
      *Setea el nuevo estado del objeto y notifica a los Observers.
      *@param state es el nuevo estado
    */
    public void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers();
    }

    /**
      *Se encarga de verificar si el objeto actual y el objeto pasado como parámetro colisionan.
      *@param object es el otro objeto a verificar.
      *@return Devuelve verdadero si colisionan, y falso en caso contrario.
    */
    public  boolean collidesWith(GameObject object){
        if (getState() != STATE_EXPLODING && object.getState() != STATE_EXPLODING && object.getCollisionBox().intersects(getCollisionBox().getBounds()))
            return true;
        return false;
    };

    public abstract void impact();

    /**
      *Updatea la área colisionable del objeto y notifica al resto de los Observers. 
    */
    public void update(){
        updateCollisionBox();
        setChanged();
        notifyObservers();
    }

    /**
      *@return Devuelve verdaderosi el objeto se encuentra fuera de la pantalla, y falso si no.
    */
    public boolean isOffScreen(){
        if (getPositionX() < -getCollisionWidth() || getPositionX() > SpaceJoust.GAME_WIDTH ||
                getPositionY() < -getCollisionHeight() || getPositionY() > SpaceJoust.GAME_HEIGHT)
            return  true;
        return false;
    }

    /**
      *Updatea el área de colisión del objeto.
    */
    private void updateCollisionBox(){
        Rectangle boundaries = new Rectangle(getPositionX() - getCollisionWidth()/2, getPositionY() - getCollisionHeight()/2, getCollisionWidth(), getCollisionHeight());
        AffineTransform tx = new AffineTransform();
        tx.rotate(rotation, getPositionX(), getPositionY());
        collisionBox = new Area(tx.createTransformedShape(boundaries));
    }
}
