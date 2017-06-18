import org.junit.Test;

import java.awt.*;

/**
 * Created by leandro on 6/17/17.
 */
public class AnimationTest {
    Animation animation = new Animation(new Image[]{null}, 0);

    @Test
    public void testUpdate() throws Exception {
        animation.update();
    }
}