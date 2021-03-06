import java.awt.*;
import java.util.Observable;

/**
 * @author Juan Bensadon
 * Clase encargada de mostrar la nave en la view.
 */
public class ShipView extends GameObjectView {
    protected static final int STATE_DAMAGED= 3, STATE_CRITICAL= 4;
    protected SwingProgressBar healthBar, energyBar;

    /**
      *Constructor de la nave que crea la barra de vida y energía de la nave.
    */
    public ShipView(){
        healthBar = new SwingProgressBar(3, 3, Color.GREEN);
        energyBar = new SwingProgressBar(10, 5, Color.YELLOW);
    }

    /**
      *Cambia la animación que debe ocurrir
      *@param state determina como se mostrará a la nave.
    */
    @Override
    protected void switchAnimation(int state) {
        switch (state){
            case STATE_DAMAGED:
                setAnimation(animations.get("DAMAGED"));
                break;
            case STATE_CRITICAL:
                setAnimation(animations.get("CRITICAL"));
                break;
        }
        super.switchAnimation(state);
    }

    /**
      *Updatea la vida y energía de la nave.
    */
    @Override
    public void update(Observable o, Object arg) {
        healthBar.setCurrentValue(((Ship)o).getHealth());
        energyBar.setCurrentValue(((Ship)o).getEnergy());
        super.update(o, arg);
    }

    /**
      *Dibuja a la nave en la pantalla y la barra de vida y energía.
    */
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (getState() != STATE_EXPLODING && getState() != STATE_INACTIVE){
            healthBar.draw(g, getPositionX(), getPositionY() - 20);
            energyBar.draw(g, getPositionX(), getPositionY() - 40);
        }
    }
}
