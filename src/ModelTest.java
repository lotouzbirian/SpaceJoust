import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class ModelTest {
    @Mock
    View view;
    @Mock
    ModelThread thread;
    @Mock
    ArrayList<Button> mainMenuButtons;
    @Mock
    ArrayList<Button> newGameButtons;
    @Mock
    ArrayList<Button> gameOverButtons;
    @Mock
    ArrayList<GameObject> gameObjects;
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