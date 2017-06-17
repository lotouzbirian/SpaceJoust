import java.util.ArrayList;

/**
 * Created by Bensas on 5/27/17.
 */
public class Model {
    View view;

    ModelThread thread;

    final static int SHIP_COLLISION_HEIGHT=120, SHIP_COLLISION_WIDTH = 40;
    final static int ROCKET_COLLISION_HEIGHT=20, ROCKET_COLLISION_WIDTH = 20;
    final static int ASTEROID_COLLISION_HEIGHT=10, ASTEROID_COLLISION_WIDTH = 10;

    public ArrayList<GameObject> gameObjects = new ArrayList<>();
    private int numberOfPlayers = 2;
    private int asteroidTimer = 0;

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
        gameObjects.add(createShipWithView());
        gameObjects.add(createShipWithView());
        ((Ship)gameObjects.get(0)).setRadialPosition(0);
        ((Ship)gameObjects.get(0)).setRadialPosition((float)Math.PI);
    }

    /***
     *
     * @return
     */
    private Ship createShipWithView(){
        Ship ship = new Ship(SHIP_COLLISION_WIDTH, SHIP_COLLISION_HEIGHT);
        ShipView shipView = new ShipView();
        ShieldView shieldView = new ShieldView();
        ship.addObserver(shipView);
        ship.addObserver(shieldView);
        getView().addView(shipView);
        getView().addView(shieldView);
        return ship;
    }

    private Asteroid createAsteroidWithView(){
        Asteroid asteroid = new Asteroid(ASTEROID_COLLISION_WIDTH, ASTEROID_COLLISION_HEIGHT);
        AsteroidView asteroidView = new AsteroidView();
        asteroid.addObserver(asteroidView);
        gameObjects.add(asteroid);
        getView().addView(asteroidView);
        return asteroid;
    }

    public Rocket createRocketWithView(GameObject origin, GameObject target){
        Rocket rocket = new Rocket(ROCKET_COLLISION_WIDTH, ROCKET_COLLISION_HEIGHT, target, origin);
        RocketView rocketView = new RocketView();
        rocket.addObserver(rocketView);
        gameObjects.add(rocket);
        getView().addView(rocketView);
        return rocket;
    }

    public void update(){
        updateGameObjects();
        checkForShipCollision(getPlayer(1), getPlayer(2));
        asteroidTimer++;
        if (asteroidTimer >= 200){
            createAsteroidWithView();
            asteroidTimer = 0;
        }
        //cleanupObjects();
    };

//    private void cleanupObjects(){
//        ArrayList<Integer> toBeRemovedIndexes = new ArrayList<Integer>();
//        for (GameObjectView gameObjectView: ){
//            if (gameObjectView.getState() == GameObjectView.STATE_INACTIVE)
//                toBeRemovedIndexes.add(gameObjectViews.indexOf(gameObjectView));
//        }
//        for (Integer i: toBeRemovedIndexes)
//            try{
//                gameObjectViews.remove(i.intValue());
//            }catch (IndexOutOfBoundsException e){
//                System.out.println("Failed to remove " + gameObjectViews.get(i).getClass().getSimpleName() + "(IndexOutOfBoundsException)");
//            }
//    }

    public void updateGameObjects(){
        for (GameObject object: gameObjects){
            if (object != null){
                object.update();
                if (object instanceof Rocket){
                    if (object.getState() != GameObject.STATE_EXPLODING && object.collidesWith(((Rocket)object).getTarget())){
                        ((Rocket)object).getTarget().impact();
                        object.impact();
                    }
                } else if (object instanceof Asteroid){
                    for (GameObject otherObject: gameObjects){
                        if (otherObject != null)
                            if (!otherObject.equals(object) && object.collidesWith(otherObject)){
                                otherObject.impact();
                                object.impact();
                            }
                    }
                }
            }
        }
    }

    public void checkForShipCollision(Ship ship1, Ship ship2){
        if (ship2.collidesWith(ship1)){
             if (ship1.isBehindShip(ship2))
                 ship2.setHealth(0);
             else
                 ship1.setHealth(0);
        }
    }

    public Ship getPlayer(int playerNumber){
        if (playerNumber < 1 || playerNumber > numberOfPlayers)
            return null;
        else
            return (Ship)gameObjects.get(playerNumber - 1);
    }

//    public void updatePlayers(){
//        for (Ship player: players){
//            player.update();
//        }
//        checkForShipCollision(players[0], players[1]);
//    }
//    public void updateRockets(){
//        for (Rocket rocket: rockets){
//            if (rocket != null){
//                rocket.update();
//                if (rocket.getState() != GameObject.STATE_EXPLODING && rocket.collidesWith(rocket.getTarget())){
//                    rocket.getTarget().impact();
//                    rocket.impact();
//                }
//            }
//        }
//    }
//
//    public void updateAsteroids(){
//        for (Asteroid asteroid: asteroids){
//            if (asteroid != null){
//                asteroid.update();
//                for (Ship player: players){
//                    if (asteroid.collidesWith(player)){
//                        player.impact();
//                        asteroid.impact();
//                    }
//                }
//                for (Rocket rocket: rockets){
//                    if (asteroid.collidesWith(rocket)){
//                        rocket.impact();
//                        asteroid.impact();
//                    }
//                }
//                for (Asteroid otherAsteroid: asteroids){
//                    if (!otherAsteroid.equals(asteroid) && asteroid.collidesWith(otherAsteroid)){
//                        otherAsteroid.impact();
//                        asteroid.impact();
//                    }
//                }
//            }
//        }
//    }


    public void onThreadClosed(){

    };
}
