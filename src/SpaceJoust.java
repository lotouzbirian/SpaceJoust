import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Juan Bensadon
 * Clase principal del juego, inicializa las otras clases y crea el Frame.
 */
public class SpaceJoust{
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public static void main(String[] args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();

        model.setView(view);
        view.setModel(model);
        view.setController(controller);
        controller.setModel(model);
        controller.setView(view);

        JFrame frame = new JFrame();
        frame.setBounds(1, 1, GAME_WIDTH, GAME_HEIGHT);
        frame.add(view);
        frame.setVisible(true);
    }
}
