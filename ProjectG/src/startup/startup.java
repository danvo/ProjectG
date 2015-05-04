package startup;

import view.GUI;

public class startup
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
