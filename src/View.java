 import java.awt.*;
 import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyAdapter;
        import java.awt.event.KeyEvent;
 import java.util.ArrayList;

 import javax.swing.JPanel;

 /**
 * Created by Bensas on 5/27/17.
 */

public class View extends JPanel implements ActionListener{

    Model model;
    Controller controller;

    private ArrayList<ObjectView> objectViews;

    public View() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        //setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        objectViews = new ArrayList<>();
    }

    public void setModel(Model model){
        this.model = model;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

     public void addView(ObjectView view){
         objectViews.add(view);
     }

    private void draw(Graphics g){
        for (ObjectView objectView : objectViews){
            objectView.draw((Graphics2D)g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

     @Override
     public void actionPerformed(ActionEvent e) {

     }

     private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            controller.handleInput(e);
        }
    }

}