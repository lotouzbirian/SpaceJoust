/**
 * @author Juan Bensadon
 * Specific Thread class for executing view updates.
 */
public class ViewThread extends GameThread {
    View view;

    public ViewThread(View view){
        this.view= view;
    }

    @Override
    public void doUpdate() {
        view.repaint();
    }

    @Override
    public void onThreadClosed() {
        view.onThreadClosed();
    }
}
