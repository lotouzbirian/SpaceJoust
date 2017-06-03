/**
 * Created by Bensas on 5/27/17.
 */
public class Model {
    View view;

    GameThread thread;

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
        thread = new GameThread(this, view);
        thread.setIsRunning(true);
        thread.start();
    }
    private void initPlayers(){
        players = new Ship[]{
                createShipObjectAndView(),
                createShipObjectAndView()
        };
        players[1].setPositionX(1200);
        players[0].setPositionX(0);
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
        System.out.println(players[0].isAlive());
        checkForShipCollision(players[0], players[1]);
        players[0].setPositionX(players[0].getPositionX() + 1);
        //System.out.println(players[0].getPositionX());
    };

    public void checkForShipCollision(Ship ship1, Ship ship2){
        if (ship1.collidesWith(ship2)){
            ship1.setIsAlive();
            // if (ship1.isBehindShip(ship2))
            //     ship2.die();
            // else
            //     ship1.die();
        }
    }


    public void onThreadClosed(){

    };
}
