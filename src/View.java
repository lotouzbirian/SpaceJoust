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
    private Controller controller;

    private ViewThread thread;

    Image circleImage;
    Image backgroundImage;
    protected Animation shipTravelAnimation, shipDamagedAnimation, shipCriticalAnimation, rocketTravelAnimation, asteroidTravelAnimation, explosionAnimation;


     private ArrayList<GameObjectView> gameObjectViews;

    public View() {
        setFocusable(true);
        addKeyListener(new TAdapter());

        loadAnimations();
        circleImage = new ImageIcon("circle.jpg").getImage();
        backgroundImage = new ImageIcon("background1.jpg").getImage();

        gameObjectViews = new ArrayList<>();
        thread = new ViewThread(this);
        thread.setIsRunning(true);
        thread.start();
    }

    public void loadAnimations(){
        Image[] shipTravelFrames = new Image[]{
                loadTexture("ship1.png")
        };
        Image[] shipDamagedFrames = new Image[]{
                loadTexture("ship1.png")
        };
        Image[] shipCriticalFrames = new Image[]{
                loadTexture("ship1.png")
        };
        Image[] rocketTravelFrames = new Image[]{
                loadTexture("rocket1.png"),
                loadTexture("rocket2.png"),
                loadTexture("rocket3.png"),
                loadTexture("rocket4.png"),
                loadTexture("rocket5.png"),
                loadTexture("rocket6.png"),
                loadTexture("rocket7.png"),
                loadTexture("rocket8.png")
        };

        Image[] asteroidTravelFrames = new Image[]{
                loadTexture("asteroid.png")
        };
        Image[] explosionFrames = new Image[]{
                loadTexture("explosion01.png"),
                loadTexture("explosion02.png"),
                loadTexture("explosion03.png"),
                loadTexture("explosion04.png"),
                loadTexture("explosion05.png"),
                loadTexture("explosion06.png"),
                loadTexture("explosion07.png"),
                loadTexture("explosion08.png"),
                loadTexture("explosion09.png"),
                loadTexture("explosion10.png"),
                loadTexture("explosion11.png"),
                loadTexture("explosion12.png"),
                loadTexture("explosion13.png"),
                loadTexture("explosion14.png"),
                loadTexture("explosion15.png"),
                loadTexture("explosion16.png"),
                loadTexture("explosion17.png"),
                loadTexture("explosion18.png"),
                loadTexture("explosion19.png"),
                loadTexture("explosion20.png"),
                loadTexture("explosion21.png"),
                loadTexture("explosion22.png"),
                loadTexture("explosion23.png"),
                loadTexture("explosion24.png"),
                loadTexture("explosion25.png"),
                loadTexture("explosion26.png"),
                loadTexture("explosion27.png"),
                loadTexture("explosion28.png"),
                loadTexture("explosion29.png"),
                loadTexture("explosion30.png"),
                loadTexture("explosion31.png"),
                loadTexture("explosion32.png"),
                loadTexture("explosion33.png"),
                loadTexture("explosion34.png"),
                loadTexture("explosion35.png"),
                loadTexture("explosion36.png"),
                loadTexture("explosion37.png"),
                loadTexture("explosion38.png"),
                loadTexture("explosion39.png"),
                loadTexture("explosion40.png"),
                loadTexture("explosion41.png"),
                loadTexture("explosion42.png"),
                loadTexture("explosion43.png"),
                loadTexture("explosion44.png"),
                loadTexture("explosion45.png"),
                loadTexture("explosion46.png"),
                loadTexture("explosion47.png"),
                loadTexture("explosion48.png"),
                loadTexture("explosion49.png"),
                loadTexture("explosion50.png"),
                loadTexture("explosion51.png"),
                loadTexture("explosion52.png"),
                loadTexture("explosion53.png"),
                loadTexture("explosion54.png"),
                loadTexture("explosion55.png"),
                loadTexture("explosion56.png"),
                loadTexture("explosion57.png"),
                loadTexture("explosion58.png"),
                loadTexture("explosion59.png"),
                loadTexture("explosion60.png"),
                loadTexture("explosion61.png"),
                loadTexture("explosion62.png"),
                loadTexture("explosion63.png"),
                loadTexture("explosion64.png"),
                loadTexture("explosion65.png"),
                loadTexture("explosion66.png"),
                loadTexture("explosion67.png"),
                loadTexture("explosion68.png"),
                loadTexture("explosion69.png"),
                loadTexture("explosion70.png"),
                loadTexture("explosion71.png"),
                loadTexture("explosion72.png"),
                loadTexture("explosion73.png"),
                loadTexture("explosion74.png"),
                loadTexture("explosion75.png"),
                loadTexture("explosion76.png"),
                loadTexture("explosion77.png"),
                loadTexture("explosion78.png"),
                loadTexture("explosion79.png"),
                loadTexture("explosion80.png"),
                loadTexture("explosion81.png"),
                loadTexture("explosion82.png"),
                loadTexture("explosion83.png"),
                loadTexture("explosion84.png"),
                loadTexture("explosion85.png"),
                loadTexture("explosion86.png"),
                loadTexture("explosion87.png"),
                loadTexture("explosion88.png"),
                loadTexture("explosion89.png"),
                loadTexture("explosion90.png")
        };
        shipTravelAnimation = new Animation(shipTravelFrames, 20);
        shipDamagedAnimation = new Animation(shipDamagedFrames, 20);
        shipCriticalAnimation = new Animation(shipCriticalFrames, 20);
        rocketTravelAnimation = new Animation(rocketTravelFrames, 20);
        asteroidTravelAnimation = new Animation(asteroidTravelFrames, 20);
        explosionAnimation = new Animation(explosionFrames, 2);
    }

     /***
      *
      * @param textureName
      * @return
      */
     protected Image loadTexture(String textureName){
         ImageIcon i = new ImageIcon(textureName);
         return i.getImage();
     }

    public void onThreadClosed(){

    }

    public void setModel(Model model){
        this.model = model;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    protected void addView(GameObjectView view){
        if (view instanceof ShipView){
            System.out.println("Ship created");
            view.addAnimation("TRAVEL", shipTravelAnimation);
            view.addAnimation("DAMAGED", shipDamagedAnimation);
            view.addAnimation("CRITICAL", shipCriticalAnimation);
        } else if (view instanceof RocketView){
            view.addAnimation("TRAVEL", rocketTravelAnimation);
        } else if (view instanceof AsteroidView){
            view.addAnimation("TRAVEL", asteroidTravelAnimation);
        }
        view.addAnimation("EXPLOSION", explosionAnimation);
        view.setAnimation(view.animations.get("TRAVEL"));
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