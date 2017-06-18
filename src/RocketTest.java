import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.geom.Area;
import java.util.Observer;
import java.util.Vector;

/**
 * Created by leandro on 6/17/17.
 */
public class RocketTest {
    int COLLISION_WIDTH = 20, COLLISION_HEIGHT = 20;
    GameObject dummyTarget;
    GameObject dummyOrigin;
    GameObject dummyOther;
    Rocket dummyRocket;

    @Before
    public void setUp() {
        dummyOrigin = new GameObject(COLLISION_WIDTH, COLLISION_HEIGHT, 0.1f) {
            @Override
            public void impact() {}
        };
        dummyTarget = new GameObject(COLLISION_WIDTH, COLLISION_HEIGHT, 0.1f) {
            @Override
            public void impact() {}
        };
        dummyOther = new GameObject(COLLISION_WIDTH, COLLISION_HEIGHT, 0.1f) {
            @Override
            public void impact() {}
        };
        dummyRocket = new Rocket(COLLISION_WIDTH, COLLISION_HEIGHT, dummyOrigin, dummyTarget);
        dummyOrigin.setPositionX(0);
        dummyOrigin.setPositionY(0);
        dummyTarget.setPositionX(0);
        dummyTarget.setPositionY(0);
        dummyOther.setPositionX(0);
        dummyOther.setPositionY(0);
        dummyRocket.setPositionX(0);
        dummyRocket.setPositionY(0);
    }

    @Test
    public void testImpact() throws Exception {
        dummyRocket.setState(GameObject.STATE_TRAVELING);
        dummyRocket.impact();
        Assert.assertEquals(GameObject.STATE_EXPLODING, dummyRocket.getState());
    }

    @Test
    public void testUpdate() throws Exception {
        dummyRocket.update();
    }


    @Test
    public void testCollidesWithTarget() throws Exception {
        boolean result = dummyRocket.collidesWith(dummyTarget);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCollidesWithOrigin() throws Exception {
        boolean result = dummyRocket.collidesWith(dummyTarget);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testCollidesWithOtherObject() throws Exception {
        boolean result = dummyRocket.collidesWith(dummyOther);
        Assert.assertEquals(true, result);
    }
}
