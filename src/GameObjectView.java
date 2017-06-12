import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bensas on 5/27/17.
 */
public abstract class GameObjectView implements Observer{
    private int positionX, positionY;
    private float rotation;
    AffineTransform identity = new AffineTransform();

    private int state;
    protected static final int STATE_TRAVELING= 0, STATE_EXPLODING= 1;

    protected HashMap<String, Animation> animations = new HashMap<>();
    protected Animation currentAnimation;

    /***
     *
     * @param g
     */
    public void draw(Graphics2D g){
        getAnimation().update();
        AffineTransform trans = new AffineTransform();
        trans.setTransform(identity);
        trans.translate(getPositionX() - getAnimation().getFrame().getWidth(null)/2, getPositionY() - getAnimation().getFrame().getHeight(null) / 2);
        trans.rotate(getRotation(), getAnimation().getFrame().getWidth(null)/2, getAnimation().getFrame().getHeight(null)/2);
        g.drawImage(getAnimation().getFrame(), trans, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setPositionX(((GameObject)o).getPositionX());
        setPositionY(((GameObject)o).getPositionY());
        setRotation(((GameObject)o).getRotation());
        if (((GameObject)o).getState() != getState()){
            switchAnimation(((GameObject)o).getState());
            setState(((GameObject)o).getState());
        }
    }

    public void addAnimation(String name, Animation animation){
        animations.put(name, animation);
    }

    protected Animation getAnimation(){return currentAnimation;}
    protected void setAnimation(Animation currentAnimation){this.currentAnimation = currentAnimation;}

    protected void switchAnimation(int state){
        switch (state){
            case STATE_TRAVELING:
                setAnimation(animations.get("TRAVEL"));
            case STATE_EXPLODING:
                setAnimation(animations.get("EXPLOSION"));
                break;
        }
    };


    protected int getPositionX() {return positionX;}

    protected int getPositionY() {return positionY;}

    protected float getRotation() {return rotation;}

    protected void setRotation(float rotation) {
        this.rotation = rotation;
    }

    protected int getState(){return state;}

    protected void setState(int state){this.state = state;}

    protected void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    protected void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
