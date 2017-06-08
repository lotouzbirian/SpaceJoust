import java.awt.*;
import java.util.Observable;

/**
 * Created by Bensas on 5/28/17.
 */
public class RocketView extends GameObjectView {
    private static final int STATE_TRAVELING= 0, STATE_EXPLODING= 1;


    public RocketView(){
        Image[] frames = new Image[]{
                loadTexture("rocket1.png"),
                loadTexture("rocket2.png"),
                loadTexture("rocket3.png"),
                loadTexture("rocket4.png"),
                loadTexture("rocket5.png"),
                loadTexture("rocket6.png"),
                loadTexture("rocket7.png"),
                loadTexture("rocket8.png")
        };
        animation = new Animation(frames, 20);
    }

    @Override
    public void switchAnimation(int state) {
        switch (state){
            case STATE_EXPLODING:
                setAnimation(explodeAnimation);
                break;
        }
    }
}
