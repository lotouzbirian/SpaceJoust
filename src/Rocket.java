/**
 * Created by Bensas on 5/27/17.
 */
public class Rocket extends GameObject{
    private static final float ROCKET_SPEED_FACTOR= 3;

    private GameObject target;
    private GameObject origin;
    private float speedX;
    private float speedY;

    public Rocket(int collisionWidth, int collisionHeight, GameObject target, GameObject origin){
        super(collisionWidth, collisionHeight, ROCKET_SPEED_FACTOR);
        setPositionX(origin.getPositionX());
        setPositionY(origin.getPositionY());
        setTarget(target);
        setOrigin(origin);
        setState(STATE_TRAVELING);
    }

    public void impact(){
        setState(STATE_EXPLODING);
    }

    private float getSpeedX() {return speedX;}
    private void setSpeedX(float speedX) {this.speedX = speedX;}

    private float getSpeedY() {return speedY;}
    private void setSpeedY(float speedY) {this.speedY = speedY;}


    public GameObject getOrigin() {return origin;}

    public void setOrigin(GameObject origin) {this.origin = origin;}

    public GameObject getTarget(){ return target;}

    public void setTarget (GameObject target){
        this.target=target;
    }
    
    public void update(){
        float distanceX= target.getPositionX() - getPositionX();
        float distanceY= target.getPositionY() - getPositionY();
        speedX= setMovement(distanceX, distanceY);
        speedY= setMovement(distanceY, distanceX);
        setPositionX(getPositionX() + (int)speedX);
        setPositionY(getPositionY() + (int)speedY);
        setRotation((float)Math.atan((getSpeedY()/getSpeedY())));
        super.update();
    }
    
    public float setMovement(float a, float b){
        float cuenta= (a/(float)Math.sqrt((a * a) + (b * b))) * getSpeedFactor();
        return cuenta;
    }
    
    public boolean collidesWith(GameObject object){
        if(object.getClass().equals(Rocket.class) || object.equals(origin) )
            return false;
        return super.collidesWith(object);
    }
}
