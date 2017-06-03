/**
 * Created by Bensas on 5/31/17.
 */
public class GameThread extends Thread {
    private boolean isRunning;
    private int targetFPS = 60;
    private float averageFPS;
    private Model gameModel;
    private View gameView;

    //CONSTRUCTOR METHOD
    public GameThread(Model gameModel, View gameView)
    {
        super();
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    //RUN METHOD
    @Override
    public void run() {
        long startTime;
        long timeMilliseconds;
        long waitTime;
        long totalTime = 0;
        long frameCount = 0;
        long targetTime = 1000 / targetFPS;

        while (isRunning){
            startTime = System.nanoTime();
            try{
                gameModel.update();
                gameView.repaint();
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("DEBUG: failed to call update() on the model!");
            }finally{
                gameModel.onThreadClosed();
            }

            timeMilliseconds = (System.nanoTime()-startTime)/1000000;
            waitTime = targetTime - timeMilliseconds;

            try{
                Thread.sleep(waitTime);
            }catch(Exception e){}

            totalTime += System.nanoTime() - startTime;
            frameCount++;

            if(frameCount == targetFPS){
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                System.out.println("FPS= " + averageFPS);
                frameCount = 0;
                totalTime = 0;
            }
        }

    }

    //Set running boolean method
    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

}