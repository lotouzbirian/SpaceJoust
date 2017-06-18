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
    Ship ship;
    int COLLISION_WIDTH = 50, COLLISION_HEIGHT = 120;


    @Before
    public void setUp() {
        ship = new Ship(COLLISION_WIDTH, COLLISION_HEIGHT);
    }

    @Test
    public void testUpdate() throws Exception {
        ship.update();
    }

    @Test
    public void testUpdateEnergyWithFullEnergy() throws Exception {
        ship.setEnergy(Ship.MAX_ENERGY);
        ship.updateEnergy();
        Assert.assertEquals(Ship.MAX_ENERGY, ship.getEnergy());
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
    public void testUnshield() throws Exception {
        ship.unshield();
    }

    @Test
    public void testAccelerateWithEnoughEnergy() throws Exception {
        ship.setEnergy(Ship.ACCELERATION_COST);
        boolean result = ship.accelerate();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAccelerateWithoutEnoughEnergy() throws Exception {
        ship.setEnergy(0);
        boolean result = ship.accelerate();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testShieldWithEnoughEnergy() throws Exception {
        ship.setEnergy(Ship.SHIELD_COST);
        boolean result = ship.shield();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testShieldWithoutEnoughEnergy() throws Exception {
        ship.setEnergy(0);
        boolean result = ship.shield();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testFireRocketWithEnoughEnergy() throws Exception {
        ship.setEnergy(Ship.ROCKET_COST);
        boolean result = ship.fireRocket();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testFireRocketWithoutEnoughEnergy() throws Exception {
        ship.setEnergy(0);
        boolean result = ship.fireRocket();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testImpactWithShield() throws Exception {
        ship.setEnergy(Ship.SHIELD_COST);
        ship.setHealth(5);
        ship.shield();
        ship.impact();
        Assert.assertEquals(5, ship.getHealth());
    }

    @Test
    public void testImpactWithoutShield() throws Exception {
        ship.setHealth(5);
        ship.impact();
        Assert.assertEquals(4, ship.getHealth());
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
}