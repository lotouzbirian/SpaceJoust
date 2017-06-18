import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class SwingProgressBarTest {
    @Mock
    Color color;
    @InjectMocks
    SwingProgressBar swingProgressBar;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDraw() throws Exception {
        swingProgressBar.draw(null, 0, 0);
    }
}
