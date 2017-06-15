import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Bensas on 5/27/17.
 */
public class Model {
    View view;

    ModelThread thread;

    final static int SHIP_COLLISION_HEIGHT=128, SHIP_COLLISION_WIDTH = 64;
    final static int ROCKET_COLLISION_HEIGHT=20, ROCKET_COLLISION_WIDTH = 20;
    final static int ASTEROID_COLLISION_HEIGHT=30, ASTEROID_COLLISION_WIDTH = 30;

    public Ship[] players;
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Asteroid> asteroids = new ArrayList<>();

    public Model(){

    }

    private View getView(){
        return view;
    }

    public void setView(View view){
        this.view = view;
    }

    public void initGame(){
        initPlayers();
        thread = new ModelThread(this);
        thread.setIsRunning(true);
        thread.start();
    }
    private void initPlayers(){
        players = new Ship[]{
                createShipWithView(),
                createShipWithView()
        };
        players[0].setRadialPosition(0);
        players[1].setRadialPosition((float)Math.PI);
    }

    /***
     *
     * @return
     */
    private Ship createShipWithView(){
        Ship ship = new Ship(SHIP_COLLISION_WIDTH, SHIP_COLLISION_HEIGHT);
        ShipView shipView = new ShipView();
        ship.addObserver(shipView);
        getView().addView(shipView);
        return ship;
    }

    private Asteroid createAsteroid(){
        Asteroid asteroid = new Asteroid(ASTEROID_COLLISION_WIDTH, ASTEROID_COLLISION_HEIGHT);
        AsteroidView asteroidView = new AsteroidView();
        asteroid.addObserver(asteroidView);
        asteroids.add(asteroid);
        getView().addView(asteroidView);
        return asteroid;
    }

    public Rocket createRocket(GameObject origin, GameObject target){
        Rocket rocket = new Rocket(ROCKET_COLLISION_WIDTH, ROCKET_COLLISION_HEIGHT, target, origin);
        RocketView rocketView = new RocketView();
        rocket.addObserver(rocketView);
        rockets.add(rocket);
        getView().addView(rocketView);
        return rocket;
    }

    public void update(){
        for (Ship player: players){
            player.update();
        }
        for (Rocket rocket: rockets){
            if (rocket != null){
                rocket.update();
                if (rocket.getState() != GameObject.STATE_EXPLODING && rocket.collidesWith(rocket.getTarget())){
                    rocket.getTarget().impact();
                    rocket.impact();
                }
            }
        }
        for (Asteroid asteroid: asteroids){
            if (asteroid != null){
                asteroid.update();
                for (Ship player: players){
                    player.impact();
                    asteroid.impact();
                }
                for (Rocket rocket: rockets){
                    if (asteroid.collidesWith(rocket)){
                        rocket.impact();
                        asteroid.impact();
                    }
                }
                for (Asteroid otherAsteroid: asteroids){
                    if (!otherAsteroid.equals(asteroid) && asteroid.collidesWith(otherAsteroid)){
                        otherAsteroid.impact();
                        asteroid.impact();
                    }
                }
            }
        }
        checkForShipCollision(players[0], players[1]);
    };

    public void checkForShipCollision(Ship ship1, Ship ship2){
        if (ship2.collidesWith(ship1)){
             if (ship1.isBehindShip(ship2))
                 ship2.setHealth(0);
             else
                 ship1.setHealth(0);
        }
    }


    public void onThreadClosed(){

    };
}
