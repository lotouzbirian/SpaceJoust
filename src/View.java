 import java.awt.*;
 import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyAdapter;
        import java.awt.event.KeyEvent;
 import java.util.ArrayList;

 import javax.swing.*;

 /**
 * Created by Bensas on 5/27/17.
 */

public class View extends JPanel implements ActionListener{
    Model model;
    Controller controller;

    ViewThread thread;

    Image circleImage;
    Image backgroundImage;

    private ArrayList<GameObjectView> gameObjectViews;

    public View() {
        setFocusable(true);
        addKeyListener(new TAdapter());

        circleImage = new ImageIcon("circle.jpg").getImage();
        backgroundImage = new ImageIcon("background1.jpg").getImage();

        gameObjectViews = new ArrayList<>();
        thread = new ViewThread(this);
        thread.setIsRunning(true);
        thread.start();
    }

    public void onThreadClosed(){

    }

    public void setModel(Model model){
        this.model = model;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

     public void addView(GameObjectView view){
         gameObjectViews.add(view);
     }

    private void draw(Graphics g){
        g.drawImage(backgroundImage, 0, 0, backgroundImage.getWidth(null), backgroundImage.getHeight(null), null);
        g.drawImage(circleImage, SpaceJoust.GAME_WIDTH/2 - 200 - 9, SpaceJoust.GAME_HEIGHT / 2 - 200 - 9, 400 + 19, 400 + 19, null);

        for (GameObjectView gameObjectView : gameObjectViews){
            gameObjectView.draw((Graphics2D)g);
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