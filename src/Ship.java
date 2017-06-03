/**
 * Created by Bensas on 5/27/17.
 */
public class Ship extends GameObject{
    private float radialPosition;

    private boolean isAlive = true;

    public Ship(int collisionWidth, int collisionHeight){
        super(collisionWidth, collisionHeight);

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
