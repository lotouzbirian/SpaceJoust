/**
 * Created by Bensas on 5/27/17.
 */
public class Ship extends GameObject{
    private static final int RADIUS= 200;
    private static final int STARTING_HEALTH= 5;
    private static final int STARTING_ENERGY= 5;
    private static final int MAX_ENERGY= 10;
    private static final int ROCKET_COST= 2;
    private static final int SHIELD_COST= 2;
    private static final int ACCELERATION_COST= 2;
    private static final float ACCELERATION_FACTOR= 10f;
    private static final float DECELERATION_FACTOR= 0.002f;
    private static final float DEFAULT_SPEED_FACTOR= 0.005f;

    private float radialPosition;    
    private boolean isAlive= true;
    private int health= STARTING_HEALTH;
    private int energy= STARTING_ENERGY, energyRegenTimer = 0;
    private boolean shielded= false;

    public Ship(int collisionWidth, int collisionHeight){
        super(collisionWidth, collisionHeight, DEFAULT_SPEED_FACTOR);
    }
    
    @Override
    public void update(){
        if (getIsAlive()){
            updatePositionAndRotation();
            updateEnergy();
            if (getSpeedFactor() > DEFAULT_SPEED_FACTOR){
                setSpeedFactor(getSpeedFactor() - DECELERATION_FACTOR);
            } else {
                setSpeedFactor(DEFAULT_SPEED_FACTOR);
            }

            if (getIsAlive() && getHealth() <= 0)
                setIsAlive(false);
        }
        super.update();
    }

    public void updateEnergy(){
        energyRegenTimer++;
        if (energyRegenTimer >= 60 && getEnergy() <= MAX_ENERGY){
            setEnergy(getEnergy() + 1);
            energyRegenTimer = 0;
        }
    }

    public void updatePositionAndRotation(){
        setRadialPosition(getRadialPosition() + getSpeedFactor());
        setPositionX(SpaceJoust.GAME_WIDTH/2 - (int)(RADIUS * Math.cos(getRadialPosition())));
        setPositionY(SpaceJoust.GAME_HEIGHT/2 - (int)(RADIUS * Math.sin(getRadialPosition())));
        setRotation(getRadialPosition());
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
    public void setEnergy(int energy){
        this.energy= energy;
    }

    public boolean accelerate(){
        if (getEnergy() >= ACCELERATION_COST && getSpeedFactor() == DEFAULT_SPEED_FACTOR){
            setEnergy(getEnergy() - ACCELERATION_COST);
            setSpeedFactor(getSpeedFactor() * ACCELERATION_FACTOR);
            return true;
        }
        return false;
    }

    public boolean shield(){
        if (getEnergy() >= SHIELD_COST){
            setEnergy(getEnergy() - SHIELD_COST);
            shielded=true;
            return true;
        }
        return false;
    }
    public void unshield(){
        shielded=false;
    }

    public boolean fireRocket(){
        if (getEnergy() >= ROCKET_COST){
            setEnergy(getEnergy() - ROCKET_COST);
            return  true;
        }
        return false;
    }

    public void impact(){
        setHealth(getHealth() - 1);
    }

    public boolean isBehindShip(Ship otherShip){
        if (otherShip.getRadialPosition() > getRadialPosition() ||
                getRadialPosition() - otherShip.getRadialPosition() > Math.PI)
            return true;
        return false;
    }

    public boolean getIsAlive(){
        return isAlive;
    }
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

}