import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
  * Created by Bensas on 5/27/17.
  * Es la View encargada de graficar a los objetos de juego.
 */
public abstract class GameObjectView implements Observer{
    private int positionX, positionY;
    private float rotation;

    private int state;
    protected static final int STATE_TRAVELING= 0, STATE_EXPLODING= 1, STATE_INACTIVE = 2;

    protected HashMap<String, Animation> animations = new HashMap<>();
    protected Animation currentAnimation;

    /**
      *Grafica al objeto g en la pantalla.
      *@param g es el objeto a graficar
    */
    public void draw(Graphics2D g){
        getAnimation().update();
        AffineTransform trans = new AffineTransform();
        trans.translate(getPositionX() - getAnimation().getFrame().getWidth(null)/2, getPositionY() - getAnimation().getFrame().getHeight(null)/2);
        trans.rotate(getRotation(), getAnimation().getFrame().getWidth(null)/2, getAnimation().getFrame().getHeight(null)/2);
        g.drawImage(getAnimation().getFrame(), trans, null);
        if (getState() == STATE_EXPLODING && getAnimation().getState() == Animation.STATE_FINISHED)
            setState(STATE_INACTIVE);
    }

    /**
      *Updatea las propiedades gráficas del objeto y genera alguna animación de ser necesario.
      *@param o es el objeto a obervar para su update.
    */
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

    /**
      *Agrega una animación determinada al mapa de animaciones.
      *@param name es el nombre de la animación.
      *@param animation es la animación dicha. 
    */
    public void addAnimation(String name, Animation animation){
        animations.put(name, animation);
    }

    /**
     * @author Juan Bensadon
     * Cambiar la animación en la que se enceuntra el objeto.
     * @param state es el estado para cambiar la animación.
     */
    protected void switchAnimation(int state){
        switch (state){
            case STATE_TRAVELING:
                setAnimation(animations.get("TRAVEL"));
            case STATE_EXPLODING:
                setAnimation(animations.get("EXPLOSION"));
                break;
        }
    };

    /**
      *@return Devuelve la posición x del Observer.
    */
    protected int getPositionX() {return positionX;}

    /**
      *@param positionX es la nueva posición en x del Obsever.
    */
    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
      *@return Devuelve la posición en y del Observer.
    */
    protected int getPositionY() {return positionY;}
    
    /**
      *@param positionY es la nueva posición en Y del Observer.
    */    
    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
      *@return Devuelve la rotación del Observer.
    */
    protected float getRotation() {return rotation;}

    /**
      *@param rotation setea la rotación del Observer.
    */    
    protected void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
      *@return Devuelve el estado en el que se encuentra el Observer.
    */
    protected int getState(){return state;}

    /**
      *@param state setea el estado del Observer.
    */    
    protected void setState(int state){this.state = state;}

    /**
      *@return Devuelve la animación actual del Observer.
    */
    protected Animation getAnimation(){return currentAnimation;}

    /**
      *@param currentAnimation setea la animación del Observer.
    */    
    protected void setAnimation(Animation currentAnimation){this.currentAnimation = currentAnimation;}

}
