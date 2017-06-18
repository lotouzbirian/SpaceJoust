import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Bensas on 5/27/17.
 */
public class Controller {
    Model model;

    public void setModel(Model model){
        this.model = model;
    }

    public void handleKeyboardInput(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                model.getPlayer(1).accelerate();
                break;
            case KeyEvent.VK_S:
                model.getPlayer(1).shield();
                break;
            case KeyEvent.VK_D:
                if (model.getPlayer(1).fireRocket())
                    model.createRocketWithView(model.getPlayer(1), model.getPlayer(1).getTarget());
                break;
            case KeyEvent.VK_W:
                model.cycleShipTarget(1);
                break;

            case KeyEvent.VK_J:
                model.getPlayer(2).accelerate();
                break;
            case KeyEvent.VK_K:
                model.getPlayer(2).shield();
                break;
            case KeyEvent.VK_L:
                if (model.getPlayer(2).fireRocket())
                    model.createRocketWithView(model.getPlayer(2), model.getPlayer(2).getTarget());
                break;
            case KeyEvent.VK_I:
                model.cycleShipTarget(1);
                break;
        }
    }

    public void handleMouseInput(MouseEvent e){
//        for (e.getX() )
    }
}
