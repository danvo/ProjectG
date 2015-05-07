package view;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

public class GUI
{
	private JFrame mainDialog;
	
	
	private JTextField textfield;
	private JButton addSummonerButton;
	private JTextArea summonersList;
	private JButton deleteSummoner;
	private JButton deleteAllSummoners;
	private JList<String> sl;
	private JPanel panellol;
	private JPanel panelmusic;

	
	
	public void initializeGUI()
	{
		mainDialog = new JFrame();
		mainDialog.setTitle("Project G");
		mainDialog.setSize(800,600);
		//Test
		
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
		deleteSummoner = new JButton("Delete selected Summoner(s)");
		deleteAllSummoners = new JButton("Delete all Summoners");
		
		summonersList = new JTextArea();
		sl = new JList<String> ();
		sl.setSelectionMode(
	    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
	    );
		
		
		panellol.add(textfield);
		panellol.add(addSummonerButton);
		panellol.add(sl);
		panellol.add(deleteSummoner);
		panellol.add(deleteAllSummoners);
		panellol.add(summonersList);
		
		mainDialog.setVisible(true);
		
		GUILocationBinder.addMainFrame(this);
	}
	
	public void addSummonerListener(ActionListener listenforSummoner) {
	    addSummonerButton.addActionListener(listenforSummoner);
	    textfield.addActionListener(listenforSummoner);
	}
	
	public void addDeleteSummonerListener(ActionListener listenforDelete) {
	    deleteAllSummoners.addActionListener(listenforDelete);
	}
	public void addDeleteSelectedSummonersListener(ActionListener listenforDelete){
		deleteSummoner.addActionListener(listenforDelete);
	}
	
	public String getSummoner() 
	{
	    return textfield.getText();
	}
	
	public void setTextarea(String list) 
	{
	    summonersList.setText(list);
	}
	
	public void setList(String[] list)
	{
		sl.setListData(list);
	}
	
	public void resetTextfield()
	{
		textfield.setText(null);
	}
	
	public void addComponentListener(ComponentListener listenForMove) {
		mainDialog.addComponentListener(listenForMove);
	}
	
	public JFrame getFrame() {
		return mainDialog;
	}
	
	public void showDataNotFoundError(String name)
	{
		JLabel ename = new JLabel(name + " is not in list.");
		panellol.add(ename);
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

	public int[] getSelectedIndices() {
		return sl.getSelectedIndices();
	}
}

	
	//mainFrame.getContentPane().add(chooser);
	//JColorChooser colorChooser = new JColorChooser();
	//mainFrame.getContentPane().add(colorChooser);
	//JFileChooser chooser = new JFileChooser();

	
