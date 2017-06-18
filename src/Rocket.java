/**
 * @author Guido Princ
 * Clase Misil usado para la jugabilidad del juego, creado y controlado por el usuario.
*/
public class Rocket extends GameObject{
    private static final float ROCKET_SPEED_FACTOR= 3;

    private GameObject target;
    private GameObject origin;
    private float speedX;
    private float speedY;


    /**
      *Constructor de la clase que setea las propiedades iniciales del misil.
      *@param collisionWidth es el ancho colisionable del misil.
      *@param collisionHeight es el alto colisionable del misil.
      *@param target es el GameObject al que va dirigido el misil.
      *@param origin es el GameObject del que fue creado el misil.
    */
    public Rocket(int collisionWidth, int collisionHeight, GameObject target, GameObject origin){
        super(collisionWidth, collisionHeight, ROCKET_SPEED_FACTOR);
        setPositionX(origin.getPositionX());
        setPositionY(origin.getPositionY());
        setTarget(target);
        setOrigin(origin);
        setState(STATE_TRAVELING);
    }

 
    /**
      *Se encarga de cambiar el estado del misil al impactar.
    */
    @Override
    public void impact(){
        setState(STATE_EXPLODING);
    }


    /**
      *@return Devuelve la velocidad en x del misil.
    */
    private float getSpeedX() {return speedX;}

 
    /**
      *@param speedX es la nueva velocidad en x del misil.
    */    
    private void setSpeedX(float speedX) {this.speedX = speedX;}


    /**
      *@return Devuelve la velocidad en y del misil.
    */
    private float getSpeedY() {return speedY;}


    /**
      *@param speedY es la nueva velocidad en y del misil.
    */    
    private void setSpeedY(float speedY) {this.speedY = speedY;}

  
    /**
      *@return Devuelve el GameObject origen del misil.
    */
    public GameObject getOrigin() {return origin;}

   
    /**
      *@param origin el origen del misil.
    */    
    public void setOrigin(GameObject origin) {this.origin = origin;}

  
    /**
      *@return Devuelve el GameObject al que se dirige el misil.
    */ 
    public GameObject getTarget(){ return target;}
    
    
    /**
      *@param target es el objetivo del misil.
    */
    public void setTarget (GameObject target){
        this.target=target;
    }


    /**
      *Updatea la posición del misil en la pantalla y modifica su velocidad X, Y, y su rotación.
    */
    @Override
    public void update(){
        if (getState() == STATE_TRAVELING){
            float distanceX= target.getPositionX() - getPositionX();
            float distanceY= target.getPositionY() - getPositionY();
            setSpeedX(setMovement(distanceX, distanceY));
            setSpeedY(setMovement(distanceY, distanceX));
            setPositionX(getPositionX() + (int)getSpeedX());
            setPositionY(getPositionY() + (int)getSpeedY());
            setRotation((float)Math.tan(speedX/speedY));
        }
        super.update();
    }


    /**
      *Método auxiliar para calcular la nueva velocidad del misil.
    */    
    public float setMovement(float a, float b){
        float cuenta= (a/(float)Math.sqrt((a * a) + (b * b))) * getSpeedFactor();
        return cuenta;
    }


    /**
      *Verifica si el misil colisiona con su objetivo.
      *@return Devuelve falso si colisiona con su origen, y, de no serlo, devuelve el valor del collidesWith de GameObject.
    */
    @Override
    public boolean collidesWith(GameObject object){
        if(object.getClass().equals(Rocket.class) || object.equals(origin) )
            return false;
        return super.collidesWith(object);
    }
}
