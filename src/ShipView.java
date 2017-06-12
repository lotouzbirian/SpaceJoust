import java.awt.*;

/**
 * Created by Bensas on 5/28/17.
 */
public class ShipView extends GameObjectView {
    protected static final int STATE_DAMAGED= 3, STATE_CRITICAL= 4;


    public ShipView(){
    }

    @Override
    protected void switchAnimation(int state) {
        switch (state){
            case STATE_DAMAGED:
                setAnimation(animations.get("DAMAGED"));
                break;
            case STATE_CRITICAL:
                setAnimation(animations.get("CRITICAL"));
        }
        super.switchAnimation(state);
    }
}
