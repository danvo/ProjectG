package view;

import javax.swing.*;

public class GUI
{
	public void initializeWindow()
	{
		
		JFrame mainFrame = new JFrame ("Project G");
		mainFrame.setSize(400, 400);
		JPanel panel = new JPanel();
		JButton button = new JButton("Push me!");
		button.setEnabled(true);
		button.addActionListener(null);
		
		panel.add(button);
		mainFrame.add(panel);
		//mainFrame.add(new JLabel ("Thats the Project G."));
		mainFrame.setVisible(true);
	}
	public void chooseFile()
	{
		JFileChooser chooser = new JFileChooser();
		int rueckgabewert = chooser.showOpenDialog(null);
		if (rueckgabewert == JFileChooser.APPROVE_OPTION)
		{
			System.out.println ("Die zu öffnende Datei ist: " + chooser.getSelectedFile().getName());
		}
		JOptionPane.showInputDialog("Dies ist ein Input Dialog");
		JOptionPane.showOptionDialog(null, "Dies ist ein Optionsdialog","Optionsdialog",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE, null, 
                new String[]{"A", "B", "C"}, "B");
	}
	//aufm Button öffnen irgendwie file.getName().
	//mainFrame.getContentPane().add(chooser);
			//JColorChooser colorChooser = new JColorChooser();
//mainFrame.getContentPane().add(colorChooser);
	//JFileChooser chooser = new JFileChooser();
}
