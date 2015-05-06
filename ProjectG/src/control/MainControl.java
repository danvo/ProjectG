
package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import view.GUI;
import model.AccountStorage;
import model.DoubleAccountException;
import model.InvalidEntryException;

public class MainControl 
{
    AccountStorage _as;
    GUI _gui;
    public MainControl(AccountStorage as, GUI gui)
    {
        _as = as;
        _gui = gui;
        

        addListeners();
        updateView();
    }
    
    private void addListeners()
    {
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
                    _gui.showDoubleError(_gui.getSummoner());
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
        ArrayList<String> accounts = _as.getData();
        Collections.sort(_as.getData(), String.CASE_INSENSITIVE_ORDER);
        String datalist[] = new String[20];
        int i = 0;
        for (String account: accounts) {
        	datalist[i] = account;
        	i++;
        }
        _gui.setList(datalist);
    }
}