import java.awt.*;

/**
 * Created by Bensas on 5/28/17.
 */
public class RocketView extends GameObjectView {
    private static final String TEXTURE_PATH = "rocket.png";

    public RocketView(){
        Image[] frames = new Image[]{
                loadTexture("rocket1.png"),
                loadTexture("rocket2.png"),
                loadTexture("rocket3.png"),
                loadTexture("rocket4.png"),
                loadTexture("rocket5.png"),
                loadTexture("rocket6.png"),
                loadTexture("rocket7.png"),
                loadTexture("rocket8.png")
        };
        animation = new Animation(frames, 20);
    }
}
