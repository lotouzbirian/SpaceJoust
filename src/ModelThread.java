/**
 * Created by Bensas on 6/3/17.
 */
public class ModelThread extends GameThread {
    Model model;

    public ModelThread(Model model){
        this.model= model;
    }

    @Override
    public void doUpdate() {
        model.update();
    }

    @Override
    public void onThreadClosed() {
        model.onThreadClosed();
    }
}
