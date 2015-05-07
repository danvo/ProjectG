
package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import view.GUI;
import view.NotificationPopup;
import model.AccountStorage;
import model.DataNotFoundException;
import model.DoubleAccountException;
import model.InvalidEntryException;

public class MainControl 
{
    AccountStorage _as;
    GUI _gui;
    ArrayList<String> _accounts;
    public MainControl(AccountStorage as, GUI gui)
    {
        _as = as;
        _gui = gui;
        

        addListeners();
        updateView();
    }
    
    private void addListeners()
    {
    	_gui.addDeleteSelectedSummonersListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent e)
    		{
    			int[] indices = _gui.getSelectedIndices();
    			for (int i = indices.length - 1; i>=0 ; i--  ) {
    				try {
						_as.deleteData(_accounts.get(indices[i]));
					} 
    				catch (DataNotFoundException e1) {
						_gui.showDataNotFoundError(_accounts.get(indices[i]));
					}
    				finally
    				{
    					updateView();
    				}
    			}
    		};
    	});
        _gui.addDeleteSummonerListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _as.wipeAllData();
                updateView();
            }
        });
        
        _gui.addSummonerListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    _as.addData(_gui.getSummoner());
                }
                catch (DoubleAccountException ex)
                {
                    NotificationPopup nPopup = new NotificationPopup(_gui.getFrame(), ex.getMessage(), NotificationPopup.LENGTH_SHORT);
                    nPopup.show();
                }
                catch (InvalidEntryException ex)
                {
                	_gui.showInvalidEntryError(_gui.getSummoner());
                }
                finally
                {
                	_gui.resetTextfield();
                	updateView();
                }
            }
        }); 
    }

    private void updateView()
    {
        _accounts = _as.getData();
        Collections.sort(_accounts, String.CASE_INSENSITIVE_ORDER);
        String datalist[] = new String[_accounts.size()];
        int i = 0;
        for (String account: _accounts) {
        	datalist[i] = account;
        	i++;
        }
        _gui.setList(datalist);
    }
}
