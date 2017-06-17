/**
 * @author Juan Bensadon
 * This thread performs a certain set of actions sixty times every second.
 * Said actions are contained in the doUpdate() method.
 * It also provides a method to be executed when the thread is stopped.
 */
public abstract class GameThread extends Thread {
    private boolean isRunning;
    private int targetFPS= 60;
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
            } catch (Exception e){
                e.printStackTrace();
            }finally{
                onThreadClosed();
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

    //Set running boolean method
    public void setIsRunning(boolean isRunning) {
        this.isRunning= isRunning;
    }

    public abstract void doUpdate();

    public abstract void onThreadClosed();

}