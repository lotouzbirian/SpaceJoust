import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.awt.geom.Area;
import java.util.Observer;
import java.util.Vector;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class ShipTest {
    Ship dummyShip, dummyShip2;
    int COLLISION_WIDTH = 50, COLLISION_HEIGHT = 120;


    @Before
    public void setUp() {
        dummyShip = new Ship(COLLISION_WIDTH, COLLISION_HEIGHT);
        dummyShip2 = new Ship(COLLISION_WIDTH, COLLISION_HEIGHT);
    }

    @Test
    public void testUpdate() throws Exception {
        dummyShip.update();
    }

    @Test
    public void testUpdateEnergyWithFullEnergy() throws Exception {
        dummyShip.setEnergy(Ship.MAX_ENERGY);
        dummyShip.updateEnergy();
        Assert.assertEquals(Ship.MAX_ENERGY, dummyShip.getEnergy());
    }

    @Test
    public void testUpdateShield() throws Exception {
        dummyShip.updateShield();
    }

    @Test
    public void testUpdatePositionAndRotation() throws Exception {
        dummyShip.updatePositionAndRotation();
    }

    @Test
    public void testUnshield() throws Exception {
        dummyShip.unshield();
    }

    @Test
    public void testAccelerateWithEnoughEnergy() throws Exception {
        dummyShip.setEnergy(Ship.ACCELERATION_COST);
        boolean result = dummyShip.accelerate();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAccelerateWithoutEnoughEnergy() throws Exception {
        dummyShip.setEnergy(0);
        boolean result = dummyShip.accelerate();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testShieldWithEnoughEnergy() throws Exception {
        dummyShip.setEnergy(Ship.SHIELD_COST);
        boolean result = dummyShip.shield();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testShieldWithoutEnoughEnergy() throws Exception {
        dummyShip.setEnergy(0);
        boolean result = dummyShip.shield();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testFireRocketWithEnoughEnergy() throws Exception {
        dummyShip.setEnergy(Ship.ROCKET_COST);
        boolean result = dummyShip.fireRocket();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFireRocketWithoutEnoughEnergy() throws Exception {
        dummyShip.setEnergy(0);
        boolean result = dummyShip.fireRocket();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testImpactWithShield() throws Exception {
        dummyShip.setEnergy(Ship.SHIELD_COST);
        dummyShip.setHealth(5);
        dummyShip.shield();
        dummyShip.impact();
        Assert.assertEquals(5, dummyShip.getHealth());
    }

    @Test
    public void testImpactWithoutShield() throws Exception {
        dummyShip.setHealth(5);
        dummyShip.impact();
        Assert.assertEquals(4, dummyShip.getHealth());
    }

    @Test
    public void testIsBehindShipWhenInSamePosition() throws Exception {
        dummyShip.setRadialPosition((float)Math.PI);
        dummyShip2.setRadialPosition((float)Math.PI);
        boolean result = dummyShip.isBehindShip(dummyShip2);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsBehindShipWhenBehindShip() throws Exception {
        dummyShip.setRadialPosition((float)Math.PI);
        dummyShip2.setRadialPosition((float)Math.PI + 0.1f);
        boolean result = dummyShip.isBehindShip(dummyShip2);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsBehindShipWhenBeforeShip() throws Exception {
        dummyShip.setRadialPosition((float)Math.PI + 0.1f);
        dummyShip2.setRadialPosition((float)Math.PI);
        boolean result = dummyShip.isBehindShip(dummyShip2);
        Assert.assertEquals(false, result);
    }
}