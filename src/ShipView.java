import java.awt.*;

/**
 * Created by Bensas on 5/28/17.
 */
public class ShipView extends ObjectView {
    private static final String TEXTURE_PATH = "ship1.png";

    public ShipView(){
        Image[] frames = new Image[]{
                loadTexture("ship1.png")
        };
        animation = new Animation(frames, 20);
    }
}
