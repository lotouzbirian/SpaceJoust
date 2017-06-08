import java.awt.*;

/**
 * Created by Bensas on 6/7/17.
 */
public class AsteroidView extends GameObjectView {
    private static final String TEXTURE_PATH = "asteroid.png";

    public AsteroidView(){
        Image[] frames = new Image[]{
                loadTexture(TEXTURE_PATH)
        };
        animation = new Animation(frames, 20);
    }
}
