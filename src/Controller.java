import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Bensas on 5/27/17.
 */
public class Controller {
    Model model;

    /**
      *Setea el model al controller.
    */
    public void setModel(Model model){
        this.model = model;
    }

    /**
      *Se encarga de manejar la presión de teclas para la jugabilidad del juego.
      *@param e es el evento que genera presionar la tecla, y con un switch se verifica que realizar. 
    */
    public void handleInput(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                model.getPlayer(1).accelerate();
                break;
            case KeyEvent.VK_S:
                model.getPlayer(1).shield();
                break;
            case KeyEvent.VK_D:
                if (model.getPlayer(1).fireRocket())
                    model.createRocketWithView(model.getPlayer(1), model.getPlayer(2));
                break;
            case KeyEvent.VK_W:
                break;

            case KeyEvent.VK_J:
                model.getPlayer(2).accelerate();
                break;
            case KeyEvent.VK_K:
                model.getPlayer(2).shield();
                break;
            case KeyEvent.VK_L:
                if (model.getPlayer(2).fireRocket())
                    model.createRocketWithView(model.getPlayer(2), model.getPlayer(1));
                break;
            case KeyEvent.VK_I:
                break;
        }

    }
}
