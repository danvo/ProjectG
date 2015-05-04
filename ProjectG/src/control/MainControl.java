
package control;


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
    }
    
    public void saveAccount(String account) 
    {
        _as.addData(account);
    }
    
    public ArrayList<String> getAccountList() {
        return _as.getData();
    }
    
}