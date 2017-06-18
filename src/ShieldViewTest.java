package PACKAGE_NAME;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class ShieldViewTest {
    @Mock
    java.util.HashMap<java.lang.String,Animation> animations;
    @Mock
    Animation currentAnimation;
    @InjectMocks
    ShieldView shieldView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception {
        shieldView.update(null, null);
    }

    @Test
    public void testDraw() throws Exception {
        shieldView.draw(null);
    }

    @Test
    public void testAddAnimation() throws Exception {
        shieldView.addAnimation("name", new Animation(new java.awt.Image[]{null}, 0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme