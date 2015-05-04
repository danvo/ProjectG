package control;

import view.GUI;

public class StartUp
{
    public static String name()
    {
        return "Hallo fabi, du geile sau!";
    }

    public static void main(String[] args)
    {
        GUI gui = new GUI();
        gui.initializeWindow();
        //gui.chooseFile();
        
        
    }
}
