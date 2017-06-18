import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.nio.ch.Interruptible;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class GameThreadTest {
    @Mock
    Thread threadQ;
    @Mock
    Runnable target;
    @Mock
    ThreadGroup group;
    @Mock
    ClassLoader contextClassLoader;
    //Field inheritedAccessControlContext of type AccessControlContext - was not mocked since Mockito doesn't mock a Final class
    @Mock
    ThreadLocal.ThreadLocalMap threadLocals;
    @Mock
    ThreadLocal.ThreadLocalMap inheritableThreadLocals;
    @Mock
    Object parkBlocker;
    @Mock
    Interruptible blocker;
    @Mock
    Object blockerLock;
    @Mock
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    @Mock
    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    @InjectMocks
    GameThread gameThread;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRun() throws Exception {
        gameThread.run();
    }

    @Test
    public void testCurrentThread() throws Exception {
        Thread result = GameThread.currentThread();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testYield() throws Exception {
        GameThread.yield();
    }

    @Test
    public void testSleep() throws Exception {
        GameThread.sleep(0L);
    }

    @Test
    public void testSleep2() throws Exception {
        GameThread.sleep(0L, 0);
    }

    @Test
    public void testStart() throws Exception {
        gameThread.start();
    }

    @Test
    public void testStop() throws Exception {
        gameThread.stop();
    }

    @Test
    public void testStop2() throws Exception {
        gameThread.stop(null);
    }

    @Test
    public void testInterrupt() throws Exception {
        gameThread.interrupt();
    }

    @Test
    public void testInterrupted() throws Exception {
        boolean result = GameThread.interrupted();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testDestroy() throws Exception {
        gameThread.destroy();
    }

    @Test
    public void testSuspend() throws Exception {
        gameThread.suspend();
    }

    @Test
    public void testResume() throws Exception {
        gameThread.resume();
    }

    @Test
    public void testActiveCount() throws Exception {
        int result = GameThread.activeCount();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testEnumerate() throws Exception {
        int result = GameThread.enumerate(new Thread[]{null});
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCountStackFrames() throws Exception {
        int result = gameThread.countStackFrames();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testJoin() throws Exception {
        gameThread.join(0L);
    }

    @Test
    public void testJoin2() throws Exception {
        gameThread.join(0L, 0);
    }

    @Test
    public void testJoin3() throws Exception {
        gameThread.join();
    }

    @Test
    public void testDumpStack() throws Exception {
        GameThread.dumpStack();
    }

    @Test
    public void testCheckAccess() throws Exception {
        gameThread.checkAccess();
    }

    @Test
    public void testToString() throws Exception {
        String result = gameThread.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testHoldsLock() throws Exception {
        boolean result = GameThread.holdsLock(null);
        Assert.assertEquals(true, result);
    }
}