import java.util.*;
/**
 * 
 * @author Ramiro Oliva
 * Habria que ver que pasa con los asteroides que se crean aleatoriamente en las esquinas porque
 * a veces ni aparecerian por como se mueven. lo que yo pense es restringir mas los bordes como para
 * que no puedan salir de las esquinas ya que si se crea alguno que no se ve, si ponemos buffs
 * estariamos alterando el balanceo y tambien creo que faltaria como un timer para decir que 
 * despues de cierto tiempo si esta "out of bounds" elimine el asteroide.
 * Donde dice set speed me frene por no querer hacer cagadas.
 * 
 */

public class Asteroid extends GameObject{
	private static final float DEFAULT_SPEED_FACTOR= 0.005f;

	Random rnd=new Random();

	private float speedX, speedY;

	public Asteroid(int collisionWidth, int collisionHeight){
		super(collisionWidth, collisionHeight, DEFAULT_SPEED_FACTOR);
		setRandomPropierties();
	}

	public float getSpeedX() {return speedX;}
	public void setSpeedX(float speedX) {this.speedX = speedX;}

	public float getSpeedY() {return speedY;}
	public void setSpeedY(float speedY) {this.speedY = speedY;}

	public void impact(){
        setState(STATE_EXPLODING);
    }

    public void update(){
        setPositionX(getPositionX() + (int)getSpeedX());
        setPositionY(getPositionY() + (int)getSpeedY());
        setRotation(getRotation() + 0.001f);
        super.update();
    }
	
	public void setRandomPropierties(){
		if(rnd.nextBoolean()){//si es verdadero, entra por la derecha o izquierda
			if(rnd.nextBoolean()){//si es verdadero, entra por la derecha
				setPositionX(SpaceJoust.GAME_WIDTH + getCollisionWidth());
				setPositionY((int)(rnd.nextFloat()*SpaceJoust.GAME_HEIGHT)); //El int tiene que ser entre
				setSpeedX(-1);
				setSpeedY(1);
			}
			else{//sale por la izquierda
				setPositionX(-getCollisionWidth());
				setPositionY((int)(rnd.nextFloat()*SpaceJoust.GAME_HEIGHT));
				setSpeedX(1);
				setSpeedY(-1);
			}
		}
		else{//entra por arriba o abajo
			if(rnd.nextBoolean()){//entra por abajo
				setPositionX((int)(rnd.nextFloat() * SpaceJoust.GAME_WIDTH)); //El int tiene que ser entre
				setPositionY(SpaceJoust.GAME_HEIGHT + getCollisionHeight());
				setSpeedX(1);
				setSpeedY(-1);
			}
			else{//entra por arriba
				setPositionX((int)(rnd.nextFloat() * SpaceJoust.GAME_WIDTH)); //El int tiene que ser entre
				setPositionY(-getCollisionHeight());
				setSpeedX(-1);
				setSpeedY(1);
			}
		}
		
	}
}
