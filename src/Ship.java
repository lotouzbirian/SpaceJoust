/**
 * @author Jose Torreguitar
 * Clase de la nave controlada por un jugador.
 */
public class Ship extends GameObject{

    protected static final int STATE_DAMAGED= 3, STATE_CRITICAL= 4;

     static final int TRAJECTORY_RADIUS= 200;
     static final int STARTING_HEALTH= 3;
     static final int STARTING_ENERGY= 5;
     static final int MAX_ENERGY= 10;
     static final int ROCKET_COST= 2;
     static final int SHIELD_COST= 3;
     static final int SHIELD_DURATION= 120;
     static final int ACCELERATION_COST= 2;
     static final float ACCELERATION_FACTOR= 11f;
     static final float DECELERATION_FACTOR= 0.002f;
     static final float DEFAULT_SPEED_FACTOR= 0.005f;

    private float radialPosition;
    private boolean isAlive= true;
    private int health= STARTING_HEALTH;
    private int energy= STARTING_ENERGY, energyRegenTimer = 0;
    private boolean shielded= false;
    private int shieldTimer = 0;


    /**
     *Constructor de la clase
     *@param collisionWidth es el ancho colisionable de la nave.
     *@apram collisionHeight es el alto colisionable de la nave.
     */
    public Ship(int collisionWidth, int collisionHeight){
        super(collisionWidth, collisionHeight, DEFAULT_SPEED_FACTOR);
    }


    /**
     *Updatea el estado de la nave, su barra de energía y vida, su posición y velocidad,
     * y, si es activado, el escudo.
     */
    @Override
    public void update(){
        if (getIsAlive()){
            updatePositionAndRotation();
            updateEnergy();

            if (getSpeedFactor() > DEFAULT_SPEED_FACTOR){
                setSpeedFactor(getSpeedFactor() - DECELERATION_FACTOR);
            } else {
                setSpeedFactor(DEFAULT_SPEED_FACTOR);
            }

            updateShield();

            if (getIsAlive() && getHealth() <= 0){
                setIsAlive(false);
                setState(STATE_EXPLODING);
            }
        }
        super.update();
    }


    /**
     *Regenera energía con el tiempo hasta que llega a su máximo.
     */
    public void updateEnergy(){
        energyRegenTimer++;
        if (energyRegenTimer >= 60 && getEnergy() <= MAX_ENERGY){
            setEnergy(getEnergy() + 1);
            energyRegenTimer = 0;
        }
    }


    /**
     *Si el escudo se encuentra activo, luego de un tiempo, lo desactiva.
     */
    public void updateShield(){
        if (isShielded()){
            shieldTimer++;
            if (shieldTimer > SHIELD_DURATION){
                unshield();
                shieldTimer = 0;
            }
        }
    }


    /**
     *Updatea la posición de la nave y su rotación.
     */
    public void updatePositionAndRotation(){
        setRadialPosition(getRadialPosition() + getSpeedFactor());
        if (getRadialPosition() >= 2 * Math.PI)
            setRadialPosition(0f);
        setPositionX(SpaceJoust.GAME_WIDTH/2 - (int)(TRAJECTORY_RADIUS * Math.cos(getRadialPosition())));
        setPositionY(SpaceJoust.GAME_HEIGHT/2 - (int)(TRAJECTORY_RADIUS * Math.sin(getRadialPosition())));
        setRotation(getRadialPosition());
    }

    /**
     *@return Devuelve la posición de la nave en el círculo.
     */
    public float getRadialPosition(){return radialPosition;}


    /**
     *@param radialPosition es la posición actual de la nave en el círculo.
     */
    public void setRadialPosition(float radialPosition){
        this.radialPosition= radialPosition;
    }


    /**
     *@return Devuelve verdadero si la nave sigue viva, o false si no.
     */
    public boolean getIsAlive(){
        return isAlive;
    }


    /**
     *@param isAlive es el estado de la nave actual, en cuanto a si está vivo o no.
     */
    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}


    /**
     *@return Devuelve la vida de la nave.
     */
    public int getHealth(){return health;}


    /**
     *@param health es la vida actual de la nave y con respecto a él, setea el estado de la nave.
     */
    public void setHealth(int health){
        this.health= health;
        if (health == 2)
            setState(STATE_DAMAGED);
        else if (health == 1)
            setState(STATE_CRITICAL);
    }


    /**
     *@return Devuelve la energía de la nave.
     */
    public int getEnergy(){return energy;}


    /**
     *@param energy es la energía actual de la nave, no mayor a la determinada.
     */
    public void setEnergy(int energy){
        if (energy <= MAX_ENERGY)
            this.energy= energy;
        else
            this.energy= MAX_ENERGY;
    }


    /**
     *Acelera la nave si tiene suficiente energía y no está acelerando.
     *@return Devuelve verdadero si la nave pudo acelerar, o falso en caso contrario.
     */
    public boolean accelerate(){
        if (getEnergy() >= ACCELERATION_COST && getSpeedFactor() == DEFAULT_SPEED_FACTOR){
            setEnergy(getEnergy() - ACCELERATION_COST);
            setSpeedFactor(getSpeedFactor() * ACCELERATION_FACTOR);
            return true;
        }
        return false;
    }


    /**
     *Activa el escudo si tiene energía y no lo tiene activado.
     *@return Devuelve verdadero si pudo activar el escudo, y falso si no.
     */
    public boolean shield(){
        if (getEnergy() >= SHIELD_COST && !isShielded()){
            setEnergy(getEnergy() - SHIELD_COST);
            shielded=true;
            return true;
        }
        return false;
    }


    /**
     *Desactiva el escudo.
     */
    public void unshield(){
        shielded=false;
    }


    /**
     *@return Devuelve verdadero si la nave tiene el escudo activado, y falso si no.
     */
    public boolean isShielded() {return shielded;}


    /**
     *Dispara el misil si tiene suficiente energía.
     *@return Devuelve verdadero su disparo el misil, y falso si no.
     */
    public boolean fireRocket(){
        if (getEnergy() >= ROCKET_COST){
            setEnergy(getEnergy() - ROCKET_COST);
            return  true;
        }
        return false;
    }


    /**
     *Maneja los impactos de la nave. Si tiene el escudo activado, recupera energía, sino pierde vida.
     */
    public void impact(){
        if (!isShielded())
            setHealth(getHealth() - 1);
        else{
            unshield();
            setEnergy(getEnergy() + 2);
        }
    }


    /**
     *@return Devuelve verdadero si se enceuntra detrás de la otra nave, y falso si no.
     */
    public boolean isBehindShip(Ship otherShip){
        if (otherShip.getRadialPosition() > getRadialPosition() ||
                getRadialPosition() - otherShip.getRadialPosition() > Math.PI)
            return true;
        return false;
    }
}