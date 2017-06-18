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
public class ShieldViewTest {
    @Mock
    HashMap<String, Animation> animations;
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
        shieldView.addAnimation("name", new Animation(new Image[]{null}, 0));
    }
}