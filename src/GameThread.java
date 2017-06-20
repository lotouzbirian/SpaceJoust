/**
 * @author Juan Bensadon
 * Este thread ejecuta una serie de acciones multiples veces por segundo
 * Dichas accionas están contenidas en el método doUpdate()
 */
public abstract class GameThread extends Thread {
    private boolean isRunning;
    private int targetFPS= 70;
    private float averageFPS;

    @Override
    public void run() {
        long startTime;
        long timeMilliseconds;
        long waitTime;
        long totalTime= 0;
        long frameCount= 0;
        long targetTime= 1000 / targetFPS;

        while (isRunning){
            startTime= System.nanoTime();
            try{
                doUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

            timeMilliseconds= (System.nanoTime()-startTime)/1000000;
            waitTime= targetTime - timeMilliseconds;

            try{
                Thread.sleep(waitTime);
            }catch(Exception e){}

            totalTime+= System.nanoTime() - startTime;
            frameCount++;

            if(frameCount == targetFPS){
                averageFPS= 1000/((totalTime/frameCount)/1000000);
                System.out.println("FPS= " + averageFPS);
                frameCount= 0;
                totalTime= 0;
            }
        }

    }

    /**
     * Setea el boolean necesario para que el thread corra.
     * @param isRunning
     */
    public void setIsRunning(boolean isRunning) {
        this.isRunning= isRunning;
    }

    /**
     * Acciones a ejecutar por el thread
     */
    public abstract void doUpdate();
}