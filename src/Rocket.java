/**
 * Created by Bensas on 5/27/17.
 */
public class Rocket extends GameObject{

    private GameObject target;
    private GameObject origin;
    private static final float ROCKET_SPEED_FACTOR= 3;

    public Rocket(int collisionWidth, int collisionHeight, GameObject target, GameObject origin){
        super(collisionWidth, collisionHeight, ROCKET_SPEED_FACTOR);
        this.target=target;
        this.origin= origin;
    }
    
    public void setTarget (GameObject target){
        this.target=target;
    }
    
    public void updateTrayectory (){
        
    }
    
}
