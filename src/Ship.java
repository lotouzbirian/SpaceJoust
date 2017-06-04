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
    private float radialPosition;    
    private boolean isAlive= true;
    private int health= STARTING_HEALTH;
    private int energy= STARTING_ENERGY;
    private boolean shielded= false;

    public Ship(int collisionWidth, int collisionHeight){
        super(collisionWidth, collisionHeight, DEFAULT_SPEED_FACTOR);
    }

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
    
    public float getRadialPosition(){return radialPosition;}
    public void setRadialPosition(float radialPosition){
        this.radialPosition= radialPosition;
    }

    public int getHealth(){return health;}
    public void setHealth(int health){
        this.health= health;
    }

    public int getEnergy(){return energy;}
    public void setEnergy(){
        this.energy= energy;
    }

    public void accelerate(){
        setSpeedFactor(getSpeedFactor() * ACCELERATION_FACTOR);
    }

    public void shield(){
        shielded=true;
    }
    public void unshield(){
        shielded=false;
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
