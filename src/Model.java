import java.util.ArrayList;

/**
 * @author Juan Bensadon
 */
public class Model {
    View view;

    ModelThread thread;

    final static int SHIP_COLLISION_HEIGHT=120, SHIP_COLLISION_WIDTH = 50;
    final static int ROCKET_COLLISION_HEIGHT=20, ROCKET_COLLISION_WIDTH = 20;
    final static int ASTEROID_COLLISION_HEIGHT=10, ASTEROID_COLLISION_WIDTH = 10;

    final static int NUMBER_OF_PLAYERS = 2;

    public ArrayList<GameObject> gameObjects = new ArrayList<>();

    private boolean playing = false;
    private int winner;

    private int asteroidTimer = 0;

    /**
      *@return Devuelve la View.
    */
    private View getView(){
        return view;
    }

    /**
      *@param view setea la View.
    */
    public void setView(View view){
        this.view = view;
    }

    /**
     * Setea si el juego está corriendo(Ningún jugador ha perdido)
     * @param playing
     */
    public void setPlaying(boolean playing) {this.playing = playing;}

    /**
     * Devuelve el ganador de la partida
     * @return el número de jugador del ganador de la partida
     */
    public int getWinner() {return winner;}

    /**
     * Setea el ganadore de la partida
     * @param winner
     */
    protected void setWinner(int winner) {this.winner = winner;}

    /**
     * Crea los jugadores, crea el Thread y lo inicia.
     */
    public void initGame(){
        gameObjects = new ArrayList<>();
        initPlayers();
        if (thread == null){
            thread = new ModelThread(this);
            thread.setIsRunning(true);
            thread.start();
        }
    }

    /**
     * Crea los jugadores y los posiciona en los lugares iniciales
     */
    private void initPlayers(){
        createShipWithView();
        createShipWithView();
        getPlayer(1).setRadialPosition(0);
        getPlayer(2).setRadialPosition((float)Math.PI);
    }

    /**
     * Crea un objeto Ship, sus respectivas ShipView y ShieldView,
     * y lo agrega a la lista de GameObjects. Tambien agrega las Views a la lista de GameObjectViews.
     * @return Ship
     */
    private Ship createShipWithView(){
        Ship ship = new Ship(SHIP_COLLISION_WIDTH, SHIP_COLLISION_HEIGHT);
        ShipView shipView = new ShipView();
        ShieldView shieldView = new ShieldView();
        ship.addObserver(shipView);
        ship.addObserver(shieldView);
        gameObjects.add(ship);
        getView().addView(shipView);
        getView().addView(shieldView);
        return ship;
    }

    /**
     * Crea un objeto Asteroid con su respectiva View y lo agrega a la lista de GameObjects.
     * Tambien agrega las View a la lista de GameObjectViews.
     * @return Asteroid
     */
    private Asteroid createAsteroidWithView(){
        Asteroid asteroid = new Asteroid(ASTEROID_COLLISION_WIDTH, ASTEROID_COLLISION_HEIGHT);
        AsteroidView asteroidView = new AsteroidView();
        asteroid.addObserver(asteroidView);
        gameObjects.add(asteroid);
        getView().addView(asteroidView);
        return asteroid;
    }

    /**
     * Crea un objeto Rocket con su respectiva View y lo agrega a la lista de GameObjects.
     * Tambien agrega las View a la lista de GameObjectViews.
     * @param origin
     * @param target
     * @return Rocket
     */
    public Rocket createRocketWithView(GameObject origin, GameObject target){
        Rocket rocket = new Rocket(ROCKET_COLLISION_WIDTH, ROCKET_COLLISION_HEIGHT, target, origin);
        RocketView rocketView = new RocketView();
        rocket.addObserver(rocketView);
        gameObjects.add(rocket);
        getView().addView(rocketView);
        return rocket;
    }

    /**
     * Ejecuta la actualizacion general del juego.
     */
    public void update(){
        if (playing){
            updateGameObjects();
            checkForShipCollisionAndDeath(getPlayer(1), getPlayer(2));
            updateAsteroidTimer();
            cleanupObjects();
        }
    }

    /**
     * Revisa la lista de objetos en busca de objetos inactivos y los remueve.
     */
    private void cleanupObjects(){
        ArrayList<Integer> toBeRemovedIndexes = new ArrayList<Integer>();
        for (GameObject gameObject: gameObjects){
            if (gameObject.getState() == GameObject.STATE_EXPLODING)
                toBeRemovedIndexes.add(gameObjects.indexOf(gameObject));
        }
        for (Integer i: toBeRemovedIndexes)
            try{
                gameObjects.remove(i.intValue());
            }catch (IndexOutOfBoundsException e){
                System.out.println("Failed to remove GameObject");
            }
    }

    /**
     * Actualza el timer para la creación de asteroides
     */
    private void updateAsteroidTimer(){
        asteroidTimer++;
        if (asteroidTimer >= 200){
            createAsteroidWithView();
            asteroidTimer = 0;
        }
    }

    /**
     * Actualiza los GameObjects y chequea las colisiones.
     */
    public void updateGameObjects(){
        for (GameObject object: gameObjects){
            if (object != null){
                object.update();
                if (object instanceof Ship)
                    if (!((Ship) object).getIsAlive()){
                        setPlaying(false);
                        setWinner(gameObjects.indexOf(object)==0?2:1);
                        getView().setState(View.STATE_GAME_OVER);
                    }
                if (object instanceof Rocket){
                    if (((Rocket) object).getTarget() == null)
                        gameObjects.remove(object);
                    if (object.collidesWith(((Rocket)object).getTarget())){
                        ((Rocket)object).getTarget().impact();
                        object.impact();
                    }
                } else if (object instanceof Asteroid){
                    if (object.isOffScreen())
                        object.impact();
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

    /**
     * Chequea si dos naves entran en colisión y destruye a la nave que esté adelante.
     * @param ship1
     * @param ship2
     */
    public void checkForShipCollisionAndDeath(Ship ship1, Ship ship2){
        if (ship2.collidesWith(ship1)){
             if (ship1.isBehindShip(ship2))
                 ship2.setHealth(0);
             else
                 ship1.setHealth(0);
        }
    }

    /**
     * Devuelve el jugador especificado.
     * @param playerNumber
     * @return Ship
     */
    public Ship getPlayer(int playerNumber){
        if (playerNumber < 1 || playerNumber > NUMBER_OF_PLAYERS || !(gameObjects.get(playerNumber-1) instanceof Ship))
            return null;
        else
            try{
                return (Ship)gameObjects.get(playerNumber - 1);
            } catch (IndexOutOfBoundsException e){
                return  null;
            }
    }


}
