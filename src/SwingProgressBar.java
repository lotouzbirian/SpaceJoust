import java.awt.*;

/**
 * @author Juan Bensadon
 * Simple loading-bar style object, used in Space Joust as a health/energy bar.
 */
public class SwingProgressBar {
    private static final int BAR_WIDTH = 80, BAR_HEIGHT = 10, BAR_DIVISION_WIDTH = 3;
    private int sectionWidth;
    private int maxValue, currentValue;
    private Color color;

    /**
      *Constructor de la clase que crea el ancho de la barra.
      *@param maxValue es el valor máximo de la barra.
      *@param currentValue es el valor actual de la barra.
      *@param color es el color de la barra.
    */
    public SwingProgressBar(int maxValue, int currentValue, Color color){
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        this.color = color;
        setSectionWidth();
    }

    /**
      *Setea el ancho de la barra.
    */
    private void setSectionWidth(){
        sectionWidth = (BAR_WIDTH - BAR_DIVISION_WIDTH * (maxValue + 1)) / maxValue;
    }

    /**
      *@return Devuelve el ancho de la barra.
    */    
    private int getSectionWidth() {return sectionWidth;}

    /**
      * @param currentValue es el valor actual de la barra.
    */
    public void setCurrentValue(int currentValue) {this.currentValue = currentValue;}

    /**
      *@return Devuelve el color de la barra.
    */
    private Color getColor() {return color;}

    /**
      *Dibuja la barra.
      *@param posX es la posición X en donde graficarla.
      *@param posY es la posición Y en donde graficarla.
    */
    public void draw(Graphics2D g, int posX, int posY){
        g.setColor(Color.GRAY);
        g.fillRect(posX - BAR_WIDTH/2, posY - BAR_HEIGHT/2, BAR_WIDTH, BAR_HEIGHT);
        g.setColor(getColor());
        for (int i = 0; i < currentValue; i++){
            g.fillRect(posX - BAR_WIDTH/2 + BAR_DIVISION_WIDTH + (BAR_DIVISION_WIDTH + getSectionWidth()) * i,
                    posY - BAR_HEIGHT/2 + BAR_DIVISION_WIDTH,
                    getSectionWidth(),
                    BAR_HEIGHT - 2*BAR_DIVISION_WIDTH);
        }
    }

}
