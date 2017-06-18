import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.awt.RequestFocusController;
import sun.java2d.pipe.Region;
import sun.util.logging.PlatformLogger;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.VolatileImage;
import java.awt.peer.ComponentPeer;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.mockito.Mockito.*;

/**
 * Created by leandro on 6/17/17.
 */
public class ViewTest {
    @Mock
    Model model;
    @Mock
    Controller controller;
    @Mock
    ViewThread thread;
    @Mock
    Animation circleAnimation;
    @Mock
    Image backgroundImage;
    @Mock
    ArrayList<GameObjectView> gameObjectViews;
    @Mock
    Hashtable<ObjectInputStream, JComponent.ReadObjectCallback> readObjectCallbacks;
    @Mock
    Set<KeyStroke> managingFocusForwardTraversalKeys;
    @Mock
    Set<KeyStroke> managingFocusBackwardTraversalKeys;
    @Mock
    Object INPUT_VERIFIER_SOURCE_KEY;
    @Mock
    ComponentUI ui;
    @Mock
    EventListenerList listenerList;
    @Mock
    ArrayTable clientProperties;
    @Mock
    VetoableChangeSupport vetoableChangeSupport;
    @Mock
    Border border;
    @Mock
    InputVerifier inputVerifier;
    @Mock
    Component paintingChild;
    @Mock
    JPopupMenu popupMenu;
    @Mock
    AtomicBoolean revalidateRunnableScheduled;
    @Mock
    java.util.List<Rectangle> tempRectangles;
    @Mock
    InputMap focusInputMap;
    @Mock
    InputMap ancestorInputMap;
    @Mock
    ComponentInputMap windowInputMap;
    @Mock
    ActionMap actionMap;
    @Mock
    Component componentObtainingGraphicsFrom;
    @Mock
    Object componentObtainingGraphicsFromLock;
    @Mock
    Object aaTextInfo;
    @Mock
    RequestFocusController focusController;
    @Mock
    PlatformLogger log;
    @Mock
    PlatformLogger eventLog;
    @Mock
    List<Component> component;
    @Mock
    LayoutManager layoutMgr;
    @Mock
    LightweightDispatcher dispatcher;
    @Mock
    FocusTraversalPolicy focusTraversalPolicy;
    @Mock
    Set<Thread> printingThreads;
    @Mock
    ContainerListener containerListener;
    @Mock
    Color preserveBackgroundColor;
    @Mock
    PlatformLogger mixingLog;
    @Mock
    Component modalComp;
    //Field modalAppContext of type AppContext - was not mocked since Mockito doesn't mock a Final class
    @Mock
    PlatformLogger log;
    @Mock
    PlatformLogger eventLog;
    @Mock
    PlatformLogger focusLog;
    @Mock
    PlatformLogger mixingLog;
    @Mock
    ComponentPeer peer;
    @Mock
    Container parent;
    @Mock
    Color foreground;
    @Mock
    Color background;
    @Mock
    Font font;
    @Mock
    Font peerFont;
    @Mock
    Cursor cursor;
    @Mock
    GraphicsConfiguration graphicsConfig;
    @Mock
    BufferStrategy bufferStrategy;
    @Mock
    DropTarget dropTarget;
    @Mock
    Vector<PopupMenu> popups;
    @Mock
    Object LOCK;
    @Mock
    Dimension minSize;
    @Mock
    Dimension prefSize;
    @Mock
    Dimension maxSize;
    //Field componentOrientation of type ComponentOrientation - was not mocked since Mockito doesn't mock a Final class
    @Mock
    ComponentListener componentListener;
    @Mock
    FocusListener focusListener;
    @Mock
    HierarchyListener hierarchyListener;
    @Mock
    HierarchyBoundsListener hierarchyBoundsListener;
    @Mock
    KeyListener keyListener;
    @Mock
    MouseListener mouseListener;
    @Mock
    MouseMotionListener mouseMotionListener;
    @Mock
    MouseWheelListener mouseWheelListener;
    @Mock
    InputMethodListener inputMethodListener;
    @Mock
    RuntimeException windowClosingException;
    @Mock
    PropertyChangeSupport changeSupport;
    @Mock
    Object objectLock;
    @Mock
    Region compoundShape;
    @Mock
    Region mixingCutoutRegion;
    //Field eventCache of type EventQueueItem[] - was not mocked since Mockito doesn't mock arrays
    @Mock
    Map<Class<?>, Boolean> coalesceMap;
    @Mock
    RequestFocusController requestFocusController;
    @Mock
    AccessibleContext accessibleContext;
    @InjectMocks
    View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadFramess() throws Exception {
        view.loadFramess();
    }

    @Test
    public void testLoadTexture() throws Exception {
        Image result = view.loadTexture("textureName");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testOnThreadClosed() throws Exception {
        view.onThreadClosed();
    }

    @Test
    public void testAddView() throws Exception {
        view.addView(null);
    }

    @Test
    public void testPaintComponent() throws Exception {
        view.paintComponent(null);
    }

    @Test
    public void testActionPerformed() throws Exception {
        view.actionPerformed(null);
    }

    @Test
    public void testUpdateUI() throws Exception {
        view.updateUI();
    }

    @Test
    public void testUpdateUI2() throws Exception {
        view.updateUI();
    }

    @Test
    public void testUpdate() throws Exception {
        view.update(null);
    }

    @Test
    public void testPaint() throws Exception {
        view.paint(null);
    }

    @Test
    public void testPrintAll() throws Exception {
        view.printAll(null);
    }

    @Test
    public void testPrint() throws Exception {
        view.print(null);
    }

    @Test
    public void testRequestFocus() throws Exception {
        view.requestFocus();
    }

    @Test
    public void testRequestFocus2() throws Exception {
        boolean result = view.requestFocus(true);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testRequestFocusInWindow() throws Exception {
        boolean result = view.requestFocusInWindow();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGrabFocus() throws Exception {
        view.grabFocus();
    }

    @Test
    public void testGetFontMetrics() throws Exception {
        FontMetrics result = view.getFontMetrics(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testContains() throws Exception {
        boolean result = view.contains(0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetInsets() throws Exception {
        Insets result = view.getInsets(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testRegisterKeyboardAction() throws Exception {
        view.registerKeyboardAction(null, "aCommand", null, 0);
    }

    @Test
    public void testRegisterKeyboardAction2() throws Exception {
        view.registerKeyboardAction(null, null, 0);
    }

    @Test
    public void testUnregisterKeyboardAction() throws Exception {
        view.unregisterKeyboardAction(null);
    }

    @Test
    public void testGetConditionForKeyStroke() throws Exception {
        int result = view.getConditionForKeyStroke(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetActionForKeyStroke() throws Exception {
        ActionListener result = view.getActionForKeyStroke(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testResetKeyboardActions() throws Exception {
        view.resetKeyboardActions();
    }

    @Test
    public void testSetInputMap() throws Exception {
        view.setInputMap(0, new InputMap());
    }

    @Test
    public void testGetInputMap() throws Exception {
        InputMap result = view.getInputMap(0);
        Assert.assertEquals(new InputMap(), result);
    }

    @Test
    public void testGetBaseline() throws Exception {
        int result = view.getBaseline(0, 0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testRequestDefaultFocus() throws Exception {
        boolean result = view.requestDefaultFocus();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetToolTipText() throws Exception {
        String result = view.getToolTipText(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetToolTipLocation() throws Exception {
        Point result = view.getToolTipLocation(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetPopupLocation() throws Exception {
        Point result = view.getPopupLocation(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateToolTip() throws Exception {
        JToolTip result = view.createToolTip();
        Assert.assertEquals(new JToolTip(), result);
    }

    @Test
    public void testScrollRectToVisible() throws Exception {
        view.scrollRectToVisible(null);
    }

    @Test
    public void testEnable() throws Exception {
        view.enable();
    }

    @Test
    public void testDisable() throws Exception {
        view.disable();
    }

    @Test
    public void testGetClientProperty() throws Exception {
        Object result = view.getClientProperty(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testPutClientProperty() throws Exception {
        view.putClientProperty(null, null);
    }

    @Test
    public void testSetFocusTraversalKeys() throws Exception {
        view.setFocusTraversalKeys(0, new HashSet<? extends AWTKeyStroke>(Arrays.asList(null)));
    }

    @Test
    public void testIsLightweightComponent() throws Exception {
        boolean result = View.isLightweightComponent(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testReshape() throws Exception {
        view.reshape(0, 0, 0, 0);
    }

    @Test
    public void testGetBounds() throws Exception {
        Rectangle result = view.getBounds(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetSize() throws Exception {
        Dimension result = view.getSize(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetLocation() throws Exception {
        Point result = view.getLocation(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testComputeVisibleRect() throws Exception {
        view.computeVisibleRect(null);
    }

    @Test
    public void testFirePropertyChange() throws Exception {
        view.firePropertyChange("propertyName", true, true);
    }

    @Test
    public void testFirePropertyChange2() throws Exception {
        view.firePropertyChange("propertyName", 0, 0);
    }

    @Test
    public void testFirePropertyChange3() throws Exception {
        view.firePropertyChange("propertyName", 'a', 'a');
    }

    @Test
    public void testAddVetoableChangeListener() throws Exception {
        view.addVetoableChangeListener(null);
    }

    @Test
    public void testRemoveVetoableChangeListener() throws Exception {
        view.removeVetoableChangeListener(null);
    }

    @Test
    public void testAddAncestorListener() throws Exception {
        view.addAncestorListener(null);
    }

    @Test
    public void testRemoveAncestorListener() throws Exception {
        view.removeAncestorListener(null);
    }

    @Test
    public void testGetListeners() throws Exception {
        T[] result = view.getListeners(null);
        Assert.assertArrayEquals(new T[]{new T()}, result);
    }

    @Test
    public void testAddNotify() throws Exception {
        view.addNotify();
    }

    @Test
    public void testRemoveNotify() throws Exception {
        view.removeNotify();
    }

    @Test
    public void testRepaint() throws Exception {
        view.repaint(0L, 0, 0, 0, 0);
    }

    @Test
    public void testRepaint2() throws Exception {
        view.repaint(null);
    }

    @Test
    public void testRevalidate() throws Exception {
        view.revalidate();
    }

    @Test
    public void testPaintImmediately() throws Exception {
        view.paintImmediately(0, 0, 0, 0);
    }

    @Test
    public void testPaintImmediately2() throws Exception {
        view.paintImmediately(null);
    }

    @Test
    public void testHide() throws Exception {
        view.hide();
    }

    @Test
    public void testCountComponents() throws Exception {
        int result = view.countComponents();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetComponent() throws Exception {
        Component result = view.getComponent(0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testInsets() throws Exception {
        Insets result = view.insets();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testAdd() throws Exception {
        Component result = view.add(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testAdd2() throws Exception {
        Component result = view.add("name", null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testAdd3() throws Exception {
        Component result = view.add(null, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetComponentZOrder() throws Exception {
        view.setComponentZOrder(null, 0);
    }

    @Test
    public void testGetComponentZOrder() throws Exception {
        int result = view.getComponentZOrder(null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testAdd4() throws Exception {
        view.add(null, null);
    }

    @Test
    public void testAdd5() throws Exception {
        view.add(null, null, 0);
    }

    @Test
    public void testRemove() throws Exception {
        view.remove(0);
    }

    @Test
    public void testRemove2() throws Exception {
        view.remove(null);
    }

    @Test
    public void testRemoveAll() throws Exception {
        view.removeAll();
    }

    @Test
    public void testDoLayout() throws Exception {
        view.doLayout();
    }

    @Test
    public void testLayout() throws Exception {
        view.layout();
    }

    @Test
    public void testInvalidate() throws Exception {
        view.invalidate();
    }

    @Test
    public void testValidate() throws Exception {
        view.validate();
    }

    @Test
    public void testPreferredSize() throws Exception {
        Dimension result = view.preferredSize();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testMinimumSize() throws Exception {
        Dimension result = view.minimumSize();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testPaint2() throws Exception {
        view.paint(null);
    }

    @Test
    public void testUpdate2() throws Exception {
        view.update(null);
    }

    @Test
    public void testPrint2() throws Exception {
        view.print(null);
    }

    @Test
    public void testPaintComponents() throws Exception {
        view.paintComponents(null);
    }

    @Test
    public void testPrintComponents() throws Exception {
        view.printComponents(null);
    }

    @Test
    public void testAddContainerListener() throws Exception {
        view.addContainerListener(null);
    }

    @Test
    public void testRemoveContainerListener() throws Exception {
        view.removeContainerListener(null);
    }

    @Test
    public void testGetListeners2() throws Exception {
        T[] result = view.getListeners(null);
        Assert.assertArrayEquals(new T[]{new T()}, result);
    }

    @Test
    public void testDeliverEvent() throws Exception {
        view.deliverEvent(null);
    }

    @Test
    public void testGetComponentAt() throws Exception {
        Component result = view.getComponentAt(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testLocate() throws Exception {
        Component result = view.locate(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetComponentAt2() throws Exception {
        Component result = view.getComponentAt(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetMousePosition() throws Exception {
        Point result = view.getMousePosition(true);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindComponentAt() throws Exception {
        Component result = view.findComponentAt(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testFindComponentAt2() throws Exception {
        Component result = view.findComponentAt(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testAddNotify2() throws Exception {
        view.addNotify();
    }

    @Test
    public void testRemoveNotify2() throws Exception {
        view.removeNotify();
    }

    @Test
    public void testIsAncestorOf() throws Exception {
        boolean result = view.isAncestorOf(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testList() throws Exception {
        view.list(null, 0);
    }

    @Test
    public void testList2() throws Exception {
        view.list(null, 0);
    }

    @Test
    public void testSetFocusTraversalKeys2() throws Exception {
        view.setFocusTraversalKeys(0, new HashSet<? extends AWTKeyStroke>(Arrays.asList(null)));
    }

    @Test
    public void testGetFocusTraversalKeys() throws Exception {
        Set<AWTKeyStroke> result = view.getFocusTraversalKeys(0);
        Assert.assertEquals(new HashSet<AWTKeyStroke>(Arrays.asList(null)), result);
    }

    @Test
    public void testAreFocusTraversalKeysSet() throws Exception {
        boolean result = view.areFocusTraversalKeysSet(0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsFocusCycleRoot() throws Exception {
        boolean result = view.isFocusCycleRoot(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testTransferFocusDownCycle() throws Exception {
        view.transferFocusDownCycle();
    }

    @Test
    public void testApplyComponentOrientation() throws Exception {
        view.applyComponentOrientation(null);
    }

    @Test
    public void testAddPropertyChangeListener() throws Exception {
        view.addPropertyChangeListener(null);
    }

    @Test
    public void testAddPropertyChangeListener2() throws Exception {
        view.addPropertyChangeListener("propertyName", null);
    }

    @Test
    public void testEnable2() throws Exception {
        view.enable();
    }

    @Test
    public void testEnable3() throws Exception {
        view.enable(true);
    }

    @Test
    public void testDisable2() throws Exception {
        view.disable();
    }

    @Test
    public void testEnableInputMethods() throws Exception {
        view.enableInputMethods(true);
    }

    @Test
    public void testShow() throws Exception {
        view.show();
    }

    @Test
    public void testShow2() throws Exception {
        view.show(true);
    }

    @Test
    public void testHide2() throws Exception {
        view.hide();
    }

    @Test
    public void testLocation() throws Exception {
        Point result = view.location();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetLocation() throws Exception {
        view.setLocation(0, 0);
    }

    @Test
    public void testMove() throws Exception {
        view.move(0, 0);
    }

    @Test
    public void testSize() throws Exception {
        Dimension result = view.size();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetSize() throws Exception {
        view.setSize(0, 0);
    }

    @Test
    public void testResize() throws Exception {
        view.resize(0, 0);
    }

    @Test
    public void testResize2() throws Exception {
        view.resize(null);
    }

    @Test
    public void testBounds() throws Exception {
        Rectangle result = view.bounds();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetBounds() throws Exception {
        view.setBounds(0, 0, 0, 0);
    }

    @Test
    public void testReshape2() throws Exception {
        view.reshape(0, 0, 0, 0);
    }

    @Test
    public void testGetBounds2() throws Exception {
        Rectangle result = view.getBounds(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetSize2() throws Exception {
        Dimension result = view.getSize(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetLocation2() throws Exception {
        Point result = view.getLocation(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testPreferredSize2() throws Exception {
        Dimension result = view.preferredSize();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testMinimumSize2() throws Exception {
        Dimension result = view.minimumSize();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetBaseline2() throws Exception {
        int result = view.getBaseline(0, 0);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testDoLayout2() throws Exception {
        view.doLayout();
    }

    @Test
    public void testLayout2() throws Exception {
        view.layout();
    }

    @Test
    public void testValidate2() throws Exception {
        view.validate();
    }

    @Test
    public void testInvalidate2() throws Exception {
        view.invalidate();
    }

    @Test
    public void testRevalidate2() throws Exception {
        view.revalidate();
    }

    @Test
    public void testGetFontMetrics2() throws Exception {
        FontMetrics result = view.getFontMetrics(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testPaint3() throws Exception {
        view.paint(null);
    }

    @Test
    public void testUpdate3() throws Exception {
        view.update(null);
    }

    @Test
    public void testPaintAll() throws Exception {
        view.paintAll(null);
    }

    @Test
    public void testRepaint3() throws Exception {
        view.repaint();
    }

    @Test
    public void testRepaint4() throws Exception {
        view.repaint(0L);
    }

    @Test
    public void testRepaint5() throws Exception {
        view.repaint(0, 0, 0, 0);
    }

    @Test
    public void testRepaint6() throws Exception {
        view.repaint(0L, 0, 0, 0, 0);
    }

    @Test
    public void testPrint3() throws Exception {
        view.print(null);
    }

    @Test
    public void testPrintAll2() throws Exception {
        view.printAll(null);
    }

    @Test
    public void testImageUpdate() throws Exception {
        boolean result = view.imageUpdate(null, 0, 0, 0, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCreateImage() throws Exception {
        Image result = view.createImage(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateImage2() throws Exception {
        Image result = view.createImage(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateVolatileImage() throws Exception {
        VolatileImage result = view.createVolatileImage(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testCreateVolatileImage2() throws Exception {
        VolatileImage result = view.createVolatileImage(0, 0, null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testPrepareImage() throws Exception {
        boolean result = view.prepareImage(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPrepareImage2() throws Exception {
        boolean result = view.prepareImage(null, 0, 0, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCheckImage() throws Exception {
        int result = view.checkImage(null, null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCheckImage2() throws Exception {
        int result = view.checkImage(null, 0, 0, null);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testContains2() throws Exception {
        boolean result = view.contains(0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testInside() throws Exception {
        boolean result = view.inside(0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testContains3() throws Exception {
        boolean result = view.contains(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetComponentAt3() throws Exception {
        Component result = view.getComponentAt(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testLocate2() throws Exception {
        Component result = view.locate(0, 0);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetComponentAt4() throws Exception {
        Component result = view.getComponentAt(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeliverEvent2() throws Exception {
        view.deliverEvent(null);
    }

    @Test
    public void testDispatchEvent() throws Exception {
        view.dispatchEvent(null);
    }

    @Test
    public void testPostEvent() throws Exception {
        boolean result = view.postEvent(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAddComponentListener() throws Exception {
        view.addComponentListener(null);
    }

    @Test
    public void testRemoveComponentListener() throws Exception {
        view.removeComponentListener(null);
    }

    @Test
    public void testAddFocusListener() throws Exception {
        view.addFocusListener(null);
    }

    @Test
    public void testRemoveFocusListener() throws Exception {
        view.removeFocusListener(null);
    }

    @Test
    public void testAddHierarchyListener() throws Exception {
        view.addHierarchyListener(null);
    }

    @Test
    public void testRemoveHierarchyListener() throws Exception {
        view.removeHierarchyListener(null);
    }

    @Test
    public void testAddHierarchyBoundsListener() throws Exception {
        view.addHierarchyBoundsListener(null);
    }

    @Test
    public void testRemoveHierarchyBoundsListener() throws Exception {
        view.removeHierarchyBoundsListener(null);
    }

    @Test
    public void testAddKeyListener() throws Exception {
        view.addKeyListener(null);
    }

    @Test
    public void testRemoveKeyListener() throws Exception {
        view.removeKeyListener(null);
    }

    @Test
    public void testAddMouseListener() throws Exception {
        view.addMouseListener(null);
    }

    @Test
    public void testRemoveMouseListener() throws Exception {
        view.removeMouseListener(null);
    }

    @Test
    public void testAddMouseMotionListener() throws Exception {
        view.addMouseMotionListener(null);
    }

    @Test
    public void testRemoveMouseMotionListener() throws Exception {
        view.removeMouseMotionListener(null);
    }

    @Test
    public void testAddMouseWheelListener() throws Exception {
        view.addMouseWheelListener(null);
    }

    @Test
    public void testRemoveMouseWheelListener() throws Exception {
        view.removeMouseWheelListener(null);
    }

    @Test
    public void testAddInputMethodListener() throws Exception {
        view.addInputMethodListener(null);
    }

    @Test
    public void testRemoveInputMethodListener() throws Exception {
        view.removeInputMethodListener(null);
    }

    @Test
    public void testGetListeners3() throws Exception {
        T[] result = view.getListeners(null);
        Assert.assertArrayEquals(new T[]{new T()}, result);
    }

    @Test
    public void testHandleEvent() throws Exception {
        boolean result = view.handleEvent(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMouseDown() throws Exception {
        boolean result = view.mouseDown(null, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMouseDrag() throws Exception {
        boolean result = view.mouseDrag(null, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMouseUp() throws Exception {
        boolean result = view.mouseUp(null, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMouseMove() throws Exception {
        boolean result = view.mouseMove(null, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMouseEnter() throws Exception {
        boolean result = view.mouseEnter(null, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testMouseExit() throws Exception {
        boolean result = view.mouseExit(null, 0, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testKeyDown() throws Exception {
        boolean result = view.keyDown(null, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testKeyUp() throws Exception {
        boolean result = view.keyUp(null, 0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAction() throws Exception {
        boolean result = view.action(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAddNotify3() throws Exception {
        view.addNotify();
    }

    @Test
    public void testRemoveNotify3() throws Exception {
        view.removeNotify();
    }

    @Test
    public void testGotFocus() throws Exception {
        boolean result = view.gotFocus(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testLostFocus() throws Exception {
        boolean result = view.lostFocus(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testSetFocusTraversalKeys3() throws Exception {
        view.setFocusTraversalKeys(0, new HashSet<? extends AWTKeyStroke>(Arrays.asList(null)));
    }

    @Test
    public void testGetFocusTraversalKeys2() throws Exception {
        Set<AWTKeyStroke> result = view.getFocusTraversalKeys(0);
        Assert.assertEquals(new HashSet<AWTKeyStroke>(Arrays.asList(null)), result);
    }

    @Test
    public void testAreFocusTraversalKeysSet2() throws Exception {
        boolean result = view.areFocusTraversalKeysSet(0);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testRequestFocus3() throws Exception {
        view.requestFocus();
    }

    @Test
    public void testRequestFocusInWindow2() throws Exception {
        boolean result = view.requestFocusInWindow();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsFocusCycleRoot2() throws Exception {
        boolean result = view.isFocusCycleRoot(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testTransferFocus() throws Exception {
        view.transferFocus();
    }

    @Test
    public void testNextFocus() throws Exception {
        view.nextFocus();
    }

    @Test
    public void testTransferFocusBackward() throws Exception {
        view.transferFocusBackward();
    }

    @Test
    public void testTransferFocusUpCycle() throws Exception {
        view.transferFocusUpCycle();
    }

    @Test
    public void testHasFocus() throws Exception {
        boolean result = view.hasFocus();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testAdd6() throws Exception {
        view.add(null);
    }

    @Test
    public void testRemove3() throws Exception {
        view.remove(null);
    }

    @Test
    public void testToString() throws Exception {
        String result = view.toString();
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testList3() throws Exception {
        view.list();
    }

    @Test
    public void testList4() throws Exception {
        view.list(null);
    }

    @Test
    public void testList5() throws Exception {
        view.list(null, 0);
    }

    @Test
    public void testList6() throws Exception {
        view.list(null);
    }

    @Test
    public void testList7() throws Exception {
        view.list(null, 0);
    }

    @Test
    public void testAddPropertyChangeListener3() throws Exception {
        view.addPropertyChangeListener(null);
    }

    @Test
    public void testRemovePropertyChangeListener() throws Exception {
        view.removePropertyChangeListener(null);
    }

    @Test
    public void testAddPropertyChangeListener4() throws Exception {
        view.addPropertyChangeListener("propertyName", null);
    }

    @Test
    public void testRemovePropertyChangeListener2() throws Exception {
        view.removePropertyChangeListener("propertyName", null);
    }

    @Test
    public void testGetPropertyChangeListeners() throws Exception {
        PropertyChangeListener[] result = view.getPropertyChangeListeners("propertyName");
        Assert.assertArrayEquals(new PropertyChangeListener[]{null}, result);
    }

    @Test
    public void testFirePropertyChange4() throws Exception {
        view.firePropertyChange("propertyName", (byte) 0, (byte) 0);
    }

    @Test
    public void testFirePropertyChange5() throws Exception {
        view.firePropertyChange("propertyName", 'a', 'a');
    }

    @Test
    public void testFirePropertyChange6() throws Exception {
        view.firePropertyChange("propertyName", (short) 0, (short) 0);
    }

    @Test
    public void testFirePropertyChange7() throws Exception {
        view.firePropertyChange("propertyName", 0L, 0L);
    }

    @Test
    public void testFirePropertyChange8() throws Exception {
        view.firePropertyChange("propertyName", 0f, 0f);
    }

    @Test
    public void testFirePropertyChange9() throws Exception {
        view.firePropertyChange("propertyName", 0d, 0d);
    }

    @Test
    public void testApplyComponentOrientation2() throws Exception {
        view.applyComponentOrientation(null);
    }
}