
package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.GUI;
import model.AccountStorage;

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
                _as.addData(_gui.getSummoner());
                updateView();
            }
        });
    }

    private void updateView()
    {
        ArrayList<String> accounts = _as.getData(); 
        StringBuffer buffer = new StringBuffer();
        for (String account: accounts) {
            buffer.append(account);
            buffer.append("\n");
        }
        _gui.setTextfield(buffer.toString());
        System.out.println(buffer.toString());
    }
}