package model;

public class DataNotFoundException extends Exception
{
    
    public DataNotFoundException()
    {
        super("Dieser Account ist nicht vorhanden");
    }

}
