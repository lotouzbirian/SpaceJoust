import java.awt.*;
import java.util.Observable;

/**
 * Created by Bensas on 5/28/17.
 */
public class ShipView extends GameObjectView {
    protected static final int STATE_DAMAGED= 3, STATE_CRITICAL= 4;
    protected SwingProgressBar healthBar, energyBar;


    public ShipView(){
        healthBar = new SwingProgressBar(3, 3, Color.GREEN);
        energyBar = new SwingProgressBar(10, 5, Color.YELLOW);
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

    @Override
    public void update(Observable o, Object arg) {
        healthBar.setCurrentValue(((Ship)o).getHealth());
        energyBar.setCurrentValue(((Ship)o).getEnergy());
        super.update(o, arg);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (getState() != STATE_EXPLODING && getState() != STATE_INACTIVE){
            healthBar.draw(g, getPositionX(), getPositionY() - 20);
            energyBar.draw(g, getPositionX(), getPositionY() - 40);
        }
    }
}
