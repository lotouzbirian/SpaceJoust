import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.geom.Area;
import java.util.Observer;
import java.util.Vector;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class RocketTest {
    @Mock
    GameObject target;
    @Mock
    GameObject origin;
    @Mock
    Area collisionBox;
    @Mock
    Vector<Observer> obs;
    @InjectMocks
    Rocket rocket;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testImpact() throws Exception {
        rocket.impact();
    }

    @Test
    public void testUpdate() throws Exception {
        rocket.update();
    }

    @Test
    public void testSetMovement() throws Exception {
        float result = rocket.setMovement(0f, 0f);
        Assert.assertEquals(0f, result);
    }

    @Test
    public void testCollidesWith() throws Exception {
        boolean result = rocket.collidesWith(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAddObserver() throws Exception {
        rocket.addObserver(null);
    }

    @Test
    public void testDeleteObserver() throws Exception {
        rocket.deleteObserver(null);
    }

    @Test
    public void testNotifyObservers() throws Exception {
        rocket.notifyObservers();
    }

    @Test
    public void testNotifyObservers2() throws Exception {
        rocket.notifyObservers(null);
    }

    @Test
    public void testDeleteObservers() throws Exception {
        rocket.deleteObservers();
    }

    @Test
    public void testHasChanged() throws Exception {
        boolean result = rocket.hasChanged();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCountObservers() throws Exception {
        int result = rocket.countObservers();
        Assert.assertEquals(0, result);
    }
}
