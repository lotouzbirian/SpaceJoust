import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * @author Juan Bensadon
 */
public class GameObjectViewTest {
    GameObject dummyObject;
    GameObjectView dummyView;
    int COLLISION_WIDTH = 20, COLLISION_HEIGHT = 20;

    @Before
    public void setUp() {
        dummyObject = new GameObject(COLLISION_WIDTH, COLLISION_HEIGHT, 0.1f) {
            @Override
            public void impact() {}
        };
        dummyView = new GameObjectView() {};
        dummyObject.addObserver(dummyView);
    }

    @Test
    public void testUpdate(){
        dummyView.setPositionX(0);
        dummyView.setPositionY(0);
        dummyObject.setPositionX(10);
        dummyObject.setPositionY(10);
        dummyObject.notifyObservers();
        Assert.assertEquals(10, dummyView.getPositionX());
        Assert.assertEquals(10, dummyView.getPositionY());
    }

}