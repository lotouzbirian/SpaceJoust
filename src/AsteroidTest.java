import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leandro Otouzbirian y Juan Bensadon
 */
public class AsteroidTest {
    Asteroid asteroid;
    int COLLISION_WIDTH = 20, COLLISION_HEIGHT = 20;

    @Before
    public void setUp() {
        asteroid = new Asteroid(COLLISION_WIDTH, COLLISION_HEIGHT);
    }

    @Test
    public void testImpact() throws Exception {
        asteroid.setState(GameObject.STATE_TRAVELING);
        asteroid.impact();
        Assert.assertEquals(GameObject.STATE_EXPLODING, asteroid.getState());
    }

    @Test
    public void testSetRandomPropierties() throws Exception {
        asteroid.setRandomPropierties();
    }

}