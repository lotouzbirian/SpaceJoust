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
public class ShipTest {
    @Mock
    Area collisionBox;
    @Mock
    Vector<Observer> obs;
    @InjectMocks
    Ship ship;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdate() throws Exception {
        ship.update();
    }

    @Test
    public void testUpdateEnergy() throws Exception {
        ship.updateEnergy();
    }

    @Test
    public void testUpdateShield() throws Exception {
        ship.updateShield();
    }

    @Test
    public void testUpdatePositionAndRotation() throws Exception {
        ship.updatePositionAndRotation();
    }

    @Test
    public void testAccelerate() throws Exception {
        boolean result = ship.accelerate();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testShield() throws Exception {
        boolean result = ship.shield();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testUnshield() throws Exception {
        ship.unshield();
    }

    @Test
    public void testFireRocket() throws Exception {
        boolean result = ship.fireRocket();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testImpact() throws Exception {
        ship.impact();
    }

    @Test
    public void testIsBehindShip() throws Exception {
        boolean result = ship.isBehindShip(new Ship(0, 0));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCollidesWith() throws Exception {
        boolean result = ship.collidesWith(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAddObserver() throws Exception {
        ship.addObserver(null);
    }

    @Test
    public void testDeleteObserver() throws Exception {
        ship.deleteObserver(null);
    }

    @Test
    public void testNotifyObservers() throws Exception {
        ship.notifyObservers();
    }

    @Test
    public void testNotifyObservers2() throws Exception {
        ship.notifyObservers(null);
    }

    @Test
    public void testDeleteObservers() throws Exception {
        ship.deleteObservers();
    }

    @Test
    public void testHasChanged() throws Exception {
        boolean result = ship.hasChanged();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCountObservers() throws Exception {
        int result = ship.countObservers();
        Assert.assertEquals(0, result);
    }
}