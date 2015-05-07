package view;

import java.awt.Color;
import java.awt.FontMetrics;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 *  A NotificationPopup is used for errors or other notifications. Create an instance and use show() to show the notification.
 */
public class NotificationPopup extends JWindow{
	
	private JWindow _notification;
	private int _duration;
	private String _message;
	private JFrame _component;
	private int _width;

	private int _heigth;
	
	public static final int LENGTH_SHORT = 2000;
	public static final int LENGTH_LONG = 5000;
	
	/**
	 * Initializes a Notification Popup. Use show() to show the notification. 
	 * @param component JComponent on which it should open
	 * @param message Notification message
	 * @param duration duration of the message
	 */

	public NotificationPopup(JFrame component, String message, int duration) {
		_component = component;
		_message = message;
		_width = getNotificationWidth();
		_heigth = 35; 
		_duration = duration;
		initializeNotificationPopup();
	}
	

	private void initializeNotificationPopup() {
		//Initialize JFrame
		_notification = new JWindow(_component);
		_notification.setSize(_width, _heigth);
		_notification.setLayout(new GridBagLayout());
		setLocation();
		Color color = new Color(105,105,105);
		_notification.getContentPane().setBackground(color);
		_notification.setShape(new RoundRectangle2D.Double(10, 10, _width-10, _heigth-10, 5,5));
		_notification.setAutoRequestFocus(false);
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Set constraints for JLabel
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1.0f;
		constraints.weighty = 1.0f;
		constraints.insets =  new Insets(15, 22, 5, 10);
		constraints.fill = GridBagConstraints.BOTH;
		
		// Initialize and add JLabel
		JLabel messageLabel = new JLabel(_message);
		messageLabel.setForeground(Color.WHITE);
		_notification.add(messageLabel, constraints);
		
		// Set constraints for close-Button
		constraints.gridx++;
		constraints.weightx = 0f;
		constraints.weighty = 0f;
		//constraints.fill = GridBagConstraints.VERTICAL;
		constraints.insets =  new Insets(15, 0, 5, 10);
		constraints.anchor = GridBagConstraints.NORTH;
		
		//Initialize and add close-Button
		JButton closeButton = new JButton(new AbstractAction("X") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_notification.dispose(); 
			}
		});
		closeButton.setBackground(color);
		closeButton.setForeground(Color.WHITE);
		closeButton.setMargin(new Insets(1, 4, 1, 4));
		closeButton.setFocusable(false);
		closeButton.setBorder(null);
		_notification.add(closeButton, constraints);
		
		_notification.setFocusable(false);
		GUILocationBinder.addComponent(_notification);
	}
	
	
	private int getNotificationWidth() {
		FontMetrics fontMetrics = _component.getFontMetrics(_component.getFont());
		int lenght = fontMetrics.stringWidth(_message);
		return (int) (lenght + 65 +_message.length()/2); //funktioniert durch ausprobieren
	}
	
	
	/**
	 * Set the position of the popup.
	 */
	
	public void setLocation() {
		_notification.setLocationRelativeTo(_component);
		_notification.setLocation((int)_notification.getLocation().getX(), (int)_notification.getLocation().getY()+_component.getHeight()/2-_heigth);
	}
	
	/**
	 * Show the NotificationPopup for the duration set.
	 */
	public void show() 
	{
		new Thread() {
			@Override
			public void run() {
				try {
					_notification.setVisible(true);
					Thread.sleep(_duration);
					_notification.dispose();
				} catch (InterruptedException e) {
				}
			};
		}.start();
	}
}
