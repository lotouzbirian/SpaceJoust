/**
 * Created by Bensas on 5/27/17.
 */
public class Model {
    View view;

    ModelThread thread;

    final static int SHIP_COLLISION_HEIGHT=30, SHIP_COLLISION_WIDTH = 20;

    Ship[] players;
    Rocket[] rockets;


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
