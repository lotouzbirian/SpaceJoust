/**
 * Created by Bensas on 6/3/17.
 */
public class ModelThread extends GameThread {
    Model model;

    public ModelThread(Model model){
        this.model = model;
    }

    @Override
    public void doUpdate() {
        super.doUpdate();
    }

    @Override
    public void onThreadClosed() {
        super.onThreadClosed();
    }
}
