/**
 * Created by Bensas on 5/27/17.
 */
public class Ship extends GameObject{
    private float radialPosition;    
    private static final float SHIP_SPEED_FACTOR= 2;
    private static final float RADIUS=0;
    private boolean isAlive = true;

    public Ship(int collisionWidth, int collisionHeight){
        super(collisionWidth, collisionHeight, SHIP_SPEED_FACTOR);

    }
    
    public float getRadialPosition(){return radialPosition;}

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
