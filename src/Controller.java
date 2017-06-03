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
                break;
                //model.
        }

    }
}
