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

    public SwingProgressBar(int maxValue, int currentValue, Color color){
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        this.color = color;
        setSectionWidth();
    }

    private void setSectionWidth(){
        sectionWidth = (BAR_WIDTH - BAR_DIVISION_WIDTH * (maxValue + 1)) / maxValue;
    }
    private int getSectionWidth() {return sectionWidth;}

    public void setCurrentValue(int currentValue) {this.currentValue = currentValue;}

    private Color getColor() {return color;}

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
