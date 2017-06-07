/**
 * Created by Bensas on 5/27/17.
 */
public class Model {
    View view;

    ModelThread thread;

    final static int SHIP_COLLISION_HEIGHT=30, SHIP_COLLISION_WIDTH = 20;

    public Ship[] players;
    private Rocket[] rockets;
    private Asteroid[] asteroids;

    public Model(){

    }

    private View getView(){
        return view;
    }

    public void setView(View view){
        this.view = view;
    }

    public void initGame(){
        rockets = new Rocket[10];
        asteroids = new Asteroid[10];
        initPlayers();
        thread = new ModelThread(this);
        thread.setIsRunning(true);
        thread.start();
    }
    private void initPlayers(){
        players = new Ship[]{
                createShipObjectAndView(),
                createShipObjectAndView()
        };
        players[0].setRadialPosition(0);
        players[1].setRadialPosition((float)Math.PI);
    }

    private Ship createShipObjectAndView(){
        Ship ship = new Ship(SHIP_COLLISION_WIDTH, SHIP_COLLISION_HEIGHT);
        ShipView shipView = new ShipView();
        ship.addObserver(shipView);
        getView().addView(shipView);
        return  ship;
    }

    public void update(){
        for (Ship player: players){
            player.update();
        }
        for (Rocket rocket: rockets){
            if (rocket != null){
                rocket.update();
                if (rocket.collidesWith(rocket.getTarget())){
                    rocket.getTarget().explode();
                    rocket.explode();
                }
            }
        }
        for (Asteroid asteroid: asteroids){
            if (asteroid != null){
                asteroid.update();
                for (Ship player: players){
                    player.explode();
                    asteroid.explode();
                }
                for (Rocket rocket: rockets){
                    if (asteroid.collidesWith(rocket)){
                        rocket.explode();
                        asteroid.explode();
                    }
                }
                for (Asteroid otherAsteroid: asteroids){
                    if (!otherAsteroid.equals(asteroid) && asteroid.collidesWith(otherAsteroid)){
                        otherAsteroid.explode();
                        asteroid.explode();
                    }
                }
            }
        }
        checkForShipCollision(players[0], players[1]);
    };

    public void checkForShipCollision(Ship ship1, Ship ship2){
        if (ship1.collidesWith(ship2)){
             if (ship1.isBehindShip(ship2))
                 ship2.setIsAlive(false);
             else
                 ship1.setIsAlive(false);
        }
    }


    public void onThreadClosed(){

    };
}