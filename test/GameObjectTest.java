import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leandro on 6/17/17.
 */
public class GameObjectTest {
    GameObject dummy1, dummy2;
    int COLLISION_WIDTH = 20, COLLISION_HEIGHT = 50;

    @Before
    public void setUp() {
        dummy1 = new GameObject(COLLISION_WIDTH, COLLISION_HEIGHT, 0.1f) {
            @Override
            public void impact() {}
        };

        dummy2 = new GameObject(COLLISION_WIDTH, COLLISION_HEIGHT, 0.1f) {
            @Override
            public void impact() {}
        };
    }

    @Test
    public void testCollidesWith() throws Exception {
        dummy1.setPositionX(0);
        dummy1.setPositionY(0);
        dummy2.setPositionX(0);
        dummy2.setPositionY(0);
        dummy1.update();
        dummy2.update();
        boolean result = dummy1.collidesWith(dummy2);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCollidesWithRotated() throws Exception {
        dummy1.setPositionX(0);
        dummy1.setPositionY(COLLISION_HEIGHT -1);
        dummy2.setPositionX(0);
        dummy2.setPositionY(0);
        dummy1.setRotation((float)Math.PI/3);
        dummy2.setRotation((float)Math.PI/3);
        dummy1.update();
        dummy2.update();
        boolean result = dummy1.collidesWith(dummy2);
        Assert.assertEquals(false, result);
    }

    @Test(expected = NullPointerException.class)
    public void testCollidesWithNullObject() throws Exception {
        boolean result = dummy1.collidesWith(null);
    }


    @Test
    public void testUpdate() throws Exception {
        dummy1.update();
    }
}
