/**
 * Created by Bensas on 6/3/17.
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
