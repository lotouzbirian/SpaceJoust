import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Bensas on 5/27/17.
 */
public class Controller {
    Model model;
    View view;

    /**
      *Setea el model al controller.
    */
    public void setModel(Model model){
        this.model = model;
    }

    /**
     *Setea la view al controller.
     */
    public void setView(View view){
        this.view = view;
    }

    /**
      *Se encarga de manejar la presión de teclas para la jugabilidad del juego.
      *@param e es el evento que genera presionar la tecla, y con un switch se verifica que realizar. 
    */
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
                model.cycleShipTarget(2);
                break;
        }
    }

    public void handleMouseInput(MouseEvent e){
        switch (view.getState()){
            case View.STATE_MAIN_MENU:
                for (Button button: view.mainMenuButtons){
                    if (button.getBoundaries().contains(e.getX(), e.getY()))
                        view.setState(button.getStatePointer());
                }
                break;
            case View.STATE_NEW_GAME:
                for (Button button: view.newGameButtons){
                    if (button.getBoundaries().contains(e.getX(), e.getY()))
                        view.setState(button.getStatePointer());
                }
                break;
            case View.STATE_GAME_OVER:
                for (Button button: view.gameOverButtons){
                    if (button.getBoundaries().contains(e.getX(), e.getY()))
                        view.setState(button.getStatePointer());
                }
                break;
        }
    }
}
