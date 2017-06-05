import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Bensas on 5/27/17.
 */
public class Controller {
    Model model;

    public void setModel(Model model){
        this.model = model;
    }

    public void handleInput(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                model.players[0].accelerate();
                break;
            case KeyEvent.VK_S:
                model.players[0].shield();
                break;
            case KeyEvent.VK_D:
                model.players[0].fireRocket();
                break;
            case KeyEvent.VK_W:
                break;

            case KeyEvent.VK_J:
                model.players[1].accelerate();
                break;
            case KeyEvent.VK_K:
                model.players[1].shield();
                break;
            case KeyEvent.VK_L:
                model.players[1].fireRocket();
                break;
            case KeyEvent.VK_I:
                break;
        }

    }
}
