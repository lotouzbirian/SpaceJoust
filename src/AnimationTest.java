package PACKAGE_NAME;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 6/17/17.
 */
public class AnimationTest {
    //Field frames of type Image[] - was not mocked since Mockito doesn't mock arrays
    Animation animation= new Animation(new java.awt.Image[]{null}, 0);

    @Test
    public void testUpdate() throws Exception {
        animation.update();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme