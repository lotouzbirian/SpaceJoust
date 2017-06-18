import java.awt.*;
import java.util.Observable;

/**
 * Created by Bensas on 6/17/17.
 */
public class CrosshairView  extends GameObjectView{
    @Override
    public void update(Observable o, Object arg) {
        setPositionX(((Ship)o).getTarget().getPositionX());
        setPositionY(((Ship)o).getTarget().getPositionY());
    }
}
