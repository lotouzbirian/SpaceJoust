import java.awt.*;
import java.util.Observable;

/**
 * Created by Bensas on 6/15/17.
 */
public class ShieldView extends GameObjectView {
    boolean isActive = false;

    public void setActive(boolean active) {isActive = active;}

    @Override
    public void update(Observable o, Object arg) {
        setActive(((Ship)o).isShielded());
        super.update(o, arg);
    }

    @Override
    public void draw(Graphics2D g) {
        if (isActive)
            super.draw(g);
    }
}
