package view;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 *	GUILocationBinder binds the location of the GUI to other JWindows.
 */
public class GUILocationBinder {
	
	private static ArrayList<JWindow> _jComponents = new ArrayList<>();
	private static JFrame mainFrame;
	
	/**
	 * Add the Main Frame that other windows should relocate with.
	 * @param gui
	 */
	public static void addMainFrame(GUI gui) {
		mainFrame = gui.getFrame();
		gui.addComponentListener(new ComponentListener() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
			@Override
			public void componentResized(ComponentEvent e) {
				relocate();	
			}
			@Override
			public void componentMoved(ComponentEvent e) {
				relocate();
			}
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
	}
	
	/**
	 * Add the components that should relocate with the main gui added with {@code addMainFrame(GUI gui)}.
	 * @param window
	 */
	public static void addComponent(JWindow window) {
		_jComponents.add(window);
	}
	
	private static void relocate() {
		for (JWindow jc : _jComponents) {
			jc.setLocation(mainFrame.getLocationOnScreen().x + (mainFrame.getWidth()-jc.getWidth())/2, mainFrame.getLocationOnScreen().y + mainFrame.getHeight() - jc.getHeight() - 20);
		}
	}
	
}
