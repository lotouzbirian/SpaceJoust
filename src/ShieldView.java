import java.awt.*;
import java.util.Observable;

/**
 * @author Juan Bensadon
 * Clase encargada de mostrar el escudo de la nave en la view.
 */
public class ShieldView extends GameObjectView {
    boolean isActive = false;

    /**
      *@param active setea si el escudo es activado o no.
    */
    public void setActive(boolean active) {isActive = active;}

    /**
      *Updatea a la nave que activo el escudo, de haberlo hecho.
    */
    @Override
    public void update(Observable o, Object arg) {
        setActive(((Ship)o).isShielded());
        super.update(o, arg);
    }

    /**
      *Dibuja al escudo.
    */
    @Override
    public void draw(Graphics2D g) {
        if (isActive)
            super.draw(g);
    }
}
