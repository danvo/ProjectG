package model;

public class DataNotFoundException extends Exception
{
    
    public DataNotFoundException()
    {
        super("Account is not in list.");
    }

}
