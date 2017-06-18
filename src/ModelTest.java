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
public class ModelTest {
    @Mock
    View view;
    @Mock
    ModelThread thread;
    @Mock
    java.util.ArrayList<Button> mainMenuButtons;
    @Mock
    java.util.ArrayList<Button> newGameButtons;
    @Mock
    java.util.ArrayList<Button> gameOverButtons;
    @Mock
    java.util.ArrayList<GameObject> gameObjects;
    @InjectMocks
    Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitGame() throws Exception {
        model.initGame();
    }

    @Test
    public void testCreateRocketWithView() throws Exception {
        Rocket result = model.createRocketWithView(null, null);
        Assert.assertEquals(new Rocket(0, 0, null, null), result);
    }

    @Test
    public void testUpdate() throws Exception {
        model.update();
    }

    @Test
    public void testUpdateGameObjects() throws Exception {
        model.updateGameObjects();
    }

    @Test
    public void testCheckForShipCollision() throws Exception {
        model.checkForShipCollision(new Ship(0, 0), new Ship(0, 0));
    }

    @Test
    public void testGetPlayer() throws Exception {
        Ship result = model.getPlayer(0);
        Assert.assertEquals(new Ship(0, 0), result);
    }

    @Test
    public void testOnThreadClosed() throws Exception {
        model.onThreadClosed();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme