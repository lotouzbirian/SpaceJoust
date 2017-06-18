/**
 * @author Juan Bensadon
 * Thread específico para ejecutar la actualización del model.
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
}
