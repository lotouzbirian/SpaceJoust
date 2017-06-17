/**
 * @author Juan Bensadon
 * Specific Thread class for executing model updates.
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
