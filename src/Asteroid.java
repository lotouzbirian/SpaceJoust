import java.util.*;
/**
  * @author Ramiro Oliva
  * Clase Asteroid que representa a un objeto no manejable por el usuario,
  * generado de manera random, y el cual puede impactar con las naves y provocarles daño.
*/
public class Asteroid extends GameObject{
	private static final float DEFAULT_SPEED_FACTOR= 0.005f;

	Random rnd=new Random();

	private float speedX, speedY;

	/**
	  *Constructor de la clase. Aquí se establecen las propiedades aleatorias del asteroide.
	  *@param collisionWidth es el ancho colisionable del asteroide.
	  *@param collisionHeight es el alto colisionable del asteroide.
	*/
	public Asteroid(int collisionWidth, int collisionHeight){
		super(collisionWidth, collisionHeight, DEFAULT_SPEED_FACTOR);
		setRandomPropierties();
	}

	/**
	  *@return devuelve la velocidad izquierda/derecha(en x) del asteroide.
	*/
	public float getSpeedX() {return speedX;}

	/**
	  *@param speedX es la nueva velocidad en x del asteroide.
	*/
	public void setSpeedX(float speedX) {this.speedX = speedX;}

	/**
	  *@return devuelve la velocidad arriba/abajo(en y) del asteroide.
	*/
	public float getSpeedY() {return speedY;}

	/**
	  *@param speedY es la nueva velocidad en y del asteroide.
	*/
	public void setSpeedY(float speedY) {this.speedY = speedY;}
	
	/**
	  *Cambia el estado del asteroide al impactar contra una nave.
	*/
	public void impact(){
        setState(STATE_EXPLODING);
    }

	/**
	  *Actualiza la posición del mismo con respecto a su anterior posición.
	*/
    public void update(){
        setPositionX(getPositionX() + (int)getSpeedX());
        setPositionY(getPositionY() + (int)getSpeedY());
        setRotation(getRotation() + 0.001f);
        super.update();
    }
	
	/**
     * Se encarga de determinar la posición en la que aparecerá el asteroide en la pantalla
     * y determinar su velocidad acorde a ella.
	*/
	public void setRandomPropierties(){
        switch (rnd.nextInt(4)){
            case 0:
                setPositionX(SpaceJoust.GAME_WIDTH + getCollisionWidth());
                setPositionY((int)(SpaceJoust.GAME_HEIGHT/2 + rnd.nextFloat()*SpaceJoust.GAME_HEIGHT / 2));
                setSpeedX(-1);
                setSpeedY(-1);
                break;
            case 1:
                setPositionX(-getCollisionWidth());
                setPositionY((int)(rnd.nextFloat()*SpaceJoust.GAME_HEIGHT/2));
                setSpeedX(1);
                setSpeedY(1);
                break;
            case 2:
                setPositionX((int)(rnd.nextFloat() * SpaceJoust.GAME_WIDTH/2));
                setPositionY(SpaceJoust.GAME_HEIGHT + getCollisionHeight());
                setSpeedX(1);
                setSpeedY(-1);
                break;
            case 3:
                setPositionX((int)(SpaceJoust.GAME_WIDTH/2 + rnd.nextFloat() * SpaceJoust.GAME_WIDTH/2));
                setPositionY(-getCollisionHeight());
                setSpeedX(-1);
                setSpeedY(1);
                break;

        }
	}
}
