package PACKAGE_NAME;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class GameObjectTest {
    @Mock
    java.awt.geom.Area collisionBox;
    @Mock
    java.util.Vector<java.util.Observer> obs;
    @InjectMocks
    GameObject gameObject;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCollidesWith() throws Exception {
        boolean result = gameObject.collidesWith(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testUpdate() throws Exception {
        gameObject.update();
    }

    @Test
    public void testAddObserver() throws Exception {
        gameObject.addObserver(null);
    }

    @Test
    public void testDeleteObserver() throws Exception {
        gameObject.deleteObserver(null);
    }

    @Test
    public void testNotifyObservers() throws Exception {
        gameObject.notifyObservers();
    }

    @Test
    public void testNotifyObservers2() throws Exception {
        gameObject.notifyObservers(null);
    }

    @Test
    public void testDeleteObservers() throws Exception {
        gameObject.deleteObservers();
    }

    @Test
    public void testHasChanged() throws Exception {
        boolean result = gameObject.hasChanged();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCountObservers() throws Exception {
        int result = gameObject.countObservers();
        Assert.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme