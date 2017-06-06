/**
 * Created by Bensas on 5/27/17.
 */
public class Ship extends GameObject{
    private static final float RADIUS= 0;
    private static final int STARTING_HEALTH= 5;
    private static final int STARTING_ENERGY= 5;
    private static final int ROCKET_COST= 2;
    private static final int SHIELD_COST= 2;
    private static final int ACCELERATION_COST= 2;
    private static final float ACCELERATION_FACTOR= 2f;
    private static final float DECELERATION_FACTOR= 0.1f;
    private static final int DEFAULT_SPEED_FACTOR= 2;
    private int speedFactor= DEFAULT_SPEED_FACTOR;
    private float radialPosition;    
    private boolean isAlive= true;
    private int health= STARTING_HEALTH;
    private int energy= STARTING_ENERGY;
    private boolean shielded= false;

    public Ship(int collisionWidth, int collisionHeight){
        super(collisionWidth, collisionHeight, DEFAULT_SPEED_FACTOR);
    }

    //cambia la posición de la nave en base al coseno y al seno
    //de su posición radial
    @Override
    public void update(){
        setRadialPosition(getRadialPosition() + getSpeedFactor());
        setPositionX((int)(RADIUS * Math.cos(getRadialPosition())));
        setPositionY((int)(RADIUS * Math.sin(getRadialPosition())));
        if (getSpeedFactor() > DEFAULT_SPEED_FACTOR){
            setSpeedFactor(getSpeedFactor() - DECELERATION_FACTOR);
        }
        super.update();
    }

    //getter y setters
    public float getRadialPosition(){return radialPosition;}
    public void setRadialPosition(float radialPosition) { this.radialPosition= radialPosition; }
    public int getHealth(){return health;}
    public void setHealth(int health){
        this.health= health;
    }
    public int getEnergy(){return energy;}
    public void setEnergy(int energy){
        this.energy= energy;
    }
    public int getSpeedFactor(){ return speedFactor;}
    public void setSpeedFactor(int speedFactor){this.speedFactor=speedFactor;}
	
    //El objetivo de los siguientes métodos es llevar acabo
    //las acciones acelerar, escudo y disparar cohete.
    //Retornan boolean con el fin de que el modelo sepa si el jugador tenia
    //la energia suficiente para llevar acabo la acción
    public boolean accelerate(){
        if(getEnergy()< ACCELERATION_COST)
            return false;
        setEnergy(getEnergy() - ACCELERATION_COST);
        setSpeedFactor(getSpeedFactor() * ACCELERATION_FACTOR);
        return true;
    }
    public void decelerate(){
        setSpeedFactor(getSpeedFactor() / ACCELERATION_FACTOR);
    }
    public boolean shield(){
        if (getEnergy() < SHIELD_COST)
            return false;
        setEnergy(getEnergy() - SHIELD_COST);
        shielded=true;
        return true;
    }
    public void unshield(){
        shielded=false;
    }
    public void fireRocket(){
        if(getEnergy() < ROCKET_COST)
            return false;
        setEnergy(getEnergy() - ROCKET_COST);
        return true;
    }

    public boolean isBehindShip(Ship otherShip){
        if (otherShip.getRadialPosition() > getRadialPosition() ||
                getRadialPosition() - otherShip.getRadialPosition() > Math.PI)
            return true;
        return false;
    }

    public boolean isAlive(){
        return isAlive;
    }
    public void setIsAlive(){
        isAlive = false;
    }

}
