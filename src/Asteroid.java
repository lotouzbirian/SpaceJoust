import java.util.*;
/**
 * 
 * @author ramonga
 * Habria que ver que pasa con los asteroides que se crean aleatoriamente en las esquinas porque
 * a veces ni aparecerian por como se mueven. lo que yo pense es restringir mas los bordes como para
 * que no puedan salir de las esquinas ya que si se crea alguno que no se ve, si ponemos buffs
 * estariamos alterando el balanceo y tambien creo que faltaria como un timer para decir que 
 * despues de cierto tiempo si esta "out of bounds" elimine el asteroide.
 * Donde dice set speed me frene por no querer hacer cagadas.
 * 
 */

public class Asteroid extends GameObject{
	Random rnd=new Random();
	float randomFloat=rnd.nextFloat();
	
	public Asteroid(int collisionWidth, int collisionHeight, float speedFactor){
		super(collisionWidth, collisionHeight, speedFactor);
		setRandomPropierties();
	}

	public void explode(){
        
    }
	
	public void setRandomPropierties(){
		if(rnd.nextBoolean()){//si es verdadero, entra por la derecha o izquierda
			if(rnd.nextBoolean()){//si es verdadero, entra por la derecha
				setPositionX(SpaceJoust.GAME_WIDTH + getCollisionWidth());
				setPositionY((int)rnd.nextFloat()*SpaceJoust.GAME_HEIGHT); //El int tiene que ser entre
				//setSpeed();
			}
			else{//sale por la izquierda
				setPositionX(-getCollisionWidth());
				setPositionY((int)rnd.nextFloat()*SpaceJoust.GAME_HEIGHT);
				//setSpeed();
			}
		}
		else{//entra por arriba o abajo
			if(rnd.nextBoolean()){//entra por arriba
				setPositionX((int)rnd.nextFloat()*SpaceJoust.GAME_WIDTH); //El int tiene que ser entre
				setPositionY(SpaceJoust.GAME_HEIGHT + getCollisionHeight());
				//setSpeed();
			}
			else{//entra por abajo
				setPositionX((int)rnd.nextFloat()*SpaceJoust.GAME_WIDTH); //El int tiene que ser entre
				setPositionY(-getCollisionHeight());
				//setSpeed();
			}
		}
		
	}
}
