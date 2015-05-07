package view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JWindow;
import javax.swing.ListCellRenderer;

public class AccountListRenderer extends JLabel implements ListCellRenderer<String> {

	
    public AccountListRenderer() {
        setOpaque(true);
    }
	@Override
	public Component getListCellRendererComponent(JList<? extends String> list,
			String value, int index, boolean isSelected, boolean cellHasFocus) {
		
		setText(value);
		setFont(new Font(getFont().getFontName(), Font.ROMAN_BASELINE, 25));
		 
        if (isSelected) {
        	setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
		return this;
	}

}
