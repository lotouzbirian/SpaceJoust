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
public class ButtonTest {
    @Mock
    java.awt.Rectangle rectangle;
    @Mock
    java.awt.geom.Area collisionBox;
    @Mock
    java.util.Vector<java.util.Observer> obs;
    @InjectMocks
    Button button;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCollidesWith() throws Exception {
        boolean result = button.collidesWith(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testUpdate() throws Exception {
        button.update();
    }

    @Test
    public void testAddObserver() throws Exception {
        button.addObserver(null);
    }

    @Test
    public void testDeleteObserver() throws Exception {
        button.deleteObserver(null);
    }

    @Test
    public void testNotifyObservers() throws Exception {
        button.notifyObservers();
    }

    @Test
    public void testNotifyObservers2() throws Exception {
        button.notifyObservers(null);
    }

    @Test
    public void testDeleteObservers() throws Exception {
        button.deleteObservers();
    }

    @Test
    public void testHasChanged() throws Exception {
        boolean result = button.hasChanged();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCountObservers() throws Exception {
        int result = button.countObservers();
        Assert.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme