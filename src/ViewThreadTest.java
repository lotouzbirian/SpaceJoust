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
public class ViewThreadTest {
    @Mock
    View view;
    @Mock
    java.lang.Thread threadQ;
    @Mock
    java.lang.Runnable target;
    @Mock
    java.lang.ThreadGroup group;
    @Mock
    java.lang.ClassLoader contextClassLoader;
    //Field inheritedAccessControlContext of type AccessControlContext - was not mocked since Mockito doesn't mock a Final class
    @Mock
    java.lang.ThreadLocal.ThreadLocalMap threadLocals;
    @Mock
    java.lang.ThreadLocal.ThreadLocalMap inheritableThreadLocals;
    @Mock
    java.lang.Object parkBlocker;
    @Mock
    sun.nio.ch.Interruptible blocker;
    @Mock
    java.lang.Object blockerLock;
    @Mock
    java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    @Mock
    java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    @InjectMocks
    ViewThread viewThread;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoUpdate() throws Exception {
        viewThread.doUpdate();
    }

    @Test
    public void testOnThreadClosed() throws Exception {
        viewThread.onThreadClosed();
    }

    @Test
    public void testRun() throws Exception {
        viewThread.run();
    }

    @Test
    public void testCurrentThread() throws Exception {
        java.lang.Thread result = ViewThread.currentThread();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testYield() throws Exception {
        ViewThread.yield();
    }

    @Test
    public void testSleep() throws Exception {
        ViewThread.sleep(0L);
    }

    @Test
    public void testSleep2() throws Exception {
        ViewThread.sleep(0L, 0);
    }

    @Test
    public void testStart() throws Exception {
        viewThread.start();
    }

    @Test
    public void testRun2() throws Exception {
        viewThread.run();
    }

    @Test
    public void testStop() throws Exception {
        viewThread.stop();
    }

    @Test
    public void testStop2() throws Exception {
        viewThread.stop(null);
    }

    @Test
    public void testInterrupt() throws Exception {
        viewThread.interrupt();
    }

    @Test
    public void testInterrupted() throws Exception {
        boolean result = ViewThread.interrupted();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testDestroy() throws Exception {
        viewThread.destroy();
    }

    @Test
    public void testSuspend() throws Exception {
        viewThread.suspend();
    }

    @Test
    public void testResume() throws Exception {
        viewThread.resume();
    }

    @Test
    public void testActiveCount() throws Exception {
        int result = ViewThread.activeCount();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testEnumerate() throws Exception {
        int result = ViewThread.enumerate(new java.lang.Thread[]{null});
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCountStackFrames() throws Exception {
        int result = viewThread.countStackFrames();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testJoin() throws Exception {
        viewThread.join(0L);
    }

    @Test
    public void testJoin2() throws Exception {
        viewThread.join(0L, 0);
    }

    @Test
    public void testJoin3() throws Exception {
        viewThread.join();
    }

    @Test
    public void testDumpStack() throws Exception {
        ViewThread.dumpStack();
    }

    @Test
    public void testCheckAccess() throws Exception {
        viewThread.checkAccess();
    }

    @Test
    public void testToString() throws Exception {
        java.lang.String result = viewThread.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testHoldsLock() throws Exception {
        boolean result = ViewThread.holdsLock(null);
        Assert.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme