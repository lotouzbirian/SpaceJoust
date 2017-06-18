import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leandro on 6/17/17.
 */
public class GameObjectTest {
    GameObject dummy1, dummy2;
    int COLLISION_WIDTH = 20, COLLISION_HEIGHT = 20;

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
        dummy1.setPositionX(0);
        dummy1.setPositionY(0);
        dummy2.setPositionX(0);
        dummy2.setPositionY(0);

    }

    @Test
    public void testCollidesWith() throws Exception {
        boolean result = dummy1.collidesWith(dummy2);
        Assert.assertEquals(true, result);
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
