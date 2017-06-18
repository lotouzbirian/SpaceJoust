/**
 * @author Juan Bensadon
 * Thread específico para ejecutar el dibujo (y actualización) de la view.
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
}
