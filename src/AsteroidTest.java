import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.geom.Area;
import java.util.Observer;
import java.util.Random;
import java.util.Vector;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class AsteroidTest {
    @Mock
    Random rnd;
    @Mock
    Area collisionBox;
    @Mock
    Vector<Observer> obs;
    @InjectMocks
    Asteroid asteroid;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testImpact() throws Exception {
        asteroid.impact();
    }

    @Test
    public void testUpdate() throws Exception {
        asteroid.update();
    }

    @Test
    public void testSetRandomPropierties() throws Exception {
        asteroid.setRandomPropierties();
    }

    @Test(expected=NullPointerException.class)
    public void testCollidesWith() throws Exception {
        boolean result = asteroid.collidesWith(null);
        Assert.assertEquals(true, result);
        exception.expect(NullPointerException.class);
    }

    @Test
    public void testAddObserver() throws Exception {
        asteroid.addObserver(null);
    }

    @Test
    public void testDeleteObserver() throws Exception {
        asteroid.deleteObserver(null);
    }

    @Test
    public void testNotifyObservers() throws Exception {
        asteroid.notifyObservers();
    }

    @Test
    public void testNotifyObservers2() throws Exception {
        asteroid.notifyObservers(null);
    }

    @Test
    public void testDeleteObservers() throws Exception {
        asteroid.deleteObservers();
    }

    @Test
    public void testHasChanged() throws Exception {
        boolean result = asteroid.hasChanged();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCountObservers() throws Exception {
        int result = asteroid.countObservers();
        Assert.assertEquals(0, result);
    }
}