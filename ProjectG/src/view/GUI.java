package view;

import javax.swing.*;

import java.awt.event.ActionListener;

public class GUI
{
	private JDialog mainDialog;
	
	
	private JTextField textfield;
	private JButton addSummonerButton;
	private JTextArea summonersList;
	private JButton deleteSummoners;
	private JList sl;
	private JPanel panellol;
	private JPanel panelmusic;
	
	
	public void initializeWindow2()
	{
		mainDialog = new JDialog();
		mainDialog.setTitle("Project G");
		mainDialog.setSize(400,400);
		
		//Panelerstellung
		panellol = new JPanel();
		panelmusic = new JPanel();
		panellol.add(new JLabel("League of Legends"));
		panelmusic.add(new JLabel("Music"));
		panellol.setLayout( new java.awt.FlowLayout() );
		//Registerkarten
		JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabpane.addTab("League of Legends is da real shit!", panellol);
		tabpane.addTab("Music for da real kids!", panelmusic);
		mainDialog.add(tabpane);
		
		//Textbox, Button und TextArea
		textfield = new JTextField();
		textfield.setColumns(8);
		textfield.setEditable(true);

		addSummonerButton = new JButton("Add Summoner");
		addSummonerButton.setEnabled(true);
		
		deleteSummoners = new JButton("Delete Summoner");
		
		summonersList = new JTextArea();
		
		sl = new JList<String>();
		
		
		panellol.add(sl);
		panellol.add(textfield);
		panellol.add(addSummonerButton);
		panellol.add(deleteSummoners);
		panellol.add(summonersList);
		
		mainDialog.setVisible(true);
	}
	
	public void addSummonerListener(ActionListener listenforSummoner) {
	    addSummonerButton.addActionListener(listenforSummoner);
	}
	
	public void addDeleteSummonerListener(ActionListener listenforDelete) {
	    deleteSummoners.addActionListener(listenforDelete);
	}
	
	public String getSummoner() 
	{
	    return textfield.getText();
	}
	
	public void setTextarea(String list) 
	{
	    summonersList.setText(list);
	}
	
	public void resetTextfield()
	{
		textfield.setText(null);
	}
	
	public void showDoubleError(String name)
	{
		JLabel dname = new JLabel(name + "is already in the summonerslist!");
		panellol.add(dname);
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
	//mainFrame.getContentPane().add(chooser);
	//JColorChooser colorChooser = new JColorChooser();
	//mainFrame.getContentPane().add(colorChooser);
	//JFileChooser chooser = new JFileChooser();
}
