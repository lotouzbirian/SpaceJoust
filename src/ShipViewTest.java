import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.util.HashMap;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class ShipViewTest {
    @Mock
    SwingProgressBar healthBar;
    @Mock
    SwingProgressBar energyBar;
    @Mock
    HashMap<String, Animation> animations;
    @Mock
    Animation currentAnimation;
    @InjectMocks
    ShipView shipView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSwitchAnimation() throws Exception {
        shipView.switchAnimation(0);
    }

    @Test
    public void testUpdate() throws Exception {
        shipView.update(null, null);
    }

    @Test
    public void testDraw() throws Exception {
        shipView.draw(null);
    }

    @Test
    public void testAddAnimation() throws Exception {
        shipView.addAnimation("name", new Animation(new Image[]{null}, 0));
    }
}