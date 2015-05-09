package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import model.DataNotFoundException;

public class GUI
{
	private JFrame mainDialog;
	
	
	private JTextField textfield;
	private JButton addSummonerButton;
	private JTextArea summonersList;
	private JMenuItem deleteAllSummoners;
	private JList<String> sl;
	private JPanel panellol;
	private JPanel panelmusic;
	private boolean stateLoL;
	private JToggleButton musicButton;
	private JToggleButton lolButton;
	private JPopupMenu _deletePopup;
	private JMenuItem _deletePopupItem;
	
	public void initializeGUI()
	{
		mainDialog = new JFrame();
		mainDialog.setTitle("Project G");
		mainDialog.setSize(800,600);
		mainDialog.setLocationRelativeTo(null);
		
		// Menu erstellen
		
		JMenuBar mBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		lolButton =  new JToggleButton("League of Legends");
		lolButton.setSelected(true);
		lolButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!stateLoL) {
					mainDialog.getContentPane().removeAll();
					mainDialog.validate();
					mainDialog.repaint();
					mainDialog.getContentPane().add(panellol);
					stateLoL = true;
					musicButton.setSelected(false);
				} else {
					lolButton.setSelected(true);
				}
			}
		});
		musicButton = new JToggleButton("Music");
		musicButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (stateLoL) {
					mainDialog.getContentPane().remove(panellol);
					mainDialog.validate();
					mainDialog.repaint();
					mainDialog.getContentPane().add(panelmusic);
					mainDialog.repaint();
					stateLoL = false;
					lolButton.setSelected(false);
				} else {
					musicButton.setSelected(true);
				}
			}
		});

		deleteAllSummoners = new JMenuItem("Delete all Summoners");
		menu.add(deleteAllSummoners);
		mBar.add(menu);
		mBar.add(Box.createHorizontalGlue());
		mBar.add(lolButton);
		mBar.add(musicButton);
		mainDialog.setJMenuBar(mBar);
		
		
		//Panelerstellung
		panellol = new JPanel();
		panellol.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		mainDialog.add(panellol);
		stateLoL = true;
		
		panelmusic = new JPanel();
		panelmusic.add(new JLabel("Music"));

		
		//Textbox, Button und Textfield
		
		JLabel lolTitle = new JLabel(); 
		lolTitle.setText("League of Legends");
		lolTitle.setFont(new Font(lolTitle.getFont().getFontName(), Font.BOLD, 40));
		lolTitle.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 50, 40, 50);
		panellol.add(lolTitle, c);
		
		
		textfield = new JTextField();
		textfield.setColumns(30);
		textfield.setPreferredSize(new Dimension(50, 40));
		textfield.setFont(new Font(textfield.getFont().getFontName(), Font.BOLD, 20));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(true);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.insets = new Insets(0, 50, 0, 50);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		panellol.add(textfield,c);
		
		
		c.gridy = 2;
		c.weightx = 0;
		c.weighty = 0;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(10, 50, 10, 50);
		addSummonerButton = new JButton("Add Summoner");
		addSummonerButton.setFont(new Font(addSummonerButton.getFont().getFontName(), Font.ROMAN_BASELINE, 18));
		addSummonerButton.setEnabled(true);
		panellol.add(addSummonerButton, c);

		
		c.gridy = 3;
		c.weightx = 0;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 50, 10, 50);
		sl = new JList<String> ();
		sl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		sl.setFont(new Font(sl.getFont().getFontName(), Font.ROMAN_BASELINE, 18));
		sl.setCellRenderer(new AccountListRenderer());
		panellol.add(sl, c);
		_deletePopup = new JPopupMenu();
		_deletePopupItem = new JMenuItem("Delete selected Summoner(s)");
		sl.addMouseListener(new MouseListener() {
			
			int posX;
			int posY;
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("MouseClicked");
				if (e.getButton() == MouseEvent.BUTTON3) {
					_deletePopup = new JPopupMenu();
					_deletePopup.add(_deletePopupItem);
					_deletePopup.show(sl, posX, posY);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				posX = (int)(sl.getMousePosition().getX());
				posY = (int)(sl.getMousePosition().getY());
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("MouseClicked");
				if (e.getButton() == MouseEvent.BUTTON3) {
					_deletePopup = new JPopupMenu();
					_deletePopup.add(_deletePopupItem);
					_deletePopup.show(sl, (int)(sl.getMousePosition().getX()), (int)(sl.getMousePosition().getY()));
			}
			}
		}
		);
		sl.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) { 
            	 if (e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_QUOTE) {
            		 System.out.println("button pushed");
            }
            }

			@Override
			public void keyTyped(KeyEvent e) {				
			}
			});
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
		_deletePopupItem.addActionListener(listenforDelete);
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

	
