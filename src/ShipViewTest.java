import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by leandro on 6/17/17.
 */
public class ShipViewTest {
    ShipView shipView;

    @Before
    public void setUp() {

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