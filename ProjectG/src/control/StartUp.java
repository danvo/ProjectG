package control;

import model.AccountStorage;
import view.GUI;

public class StartUp
{
    public static String name()
    {
        return "Hallo fabi, du geile sau!";
    }

    public static void main(String[] args)
    {
        AccountStorage aStorage = new AccountStorage();
        GUI gui = new GUI();
        gui.initializeGUI();
        
        MainControl input = new MainControl(aStorage, gui);
    }
}
