package model;

public class DoubleAccountException extends Exception
{
    
    public DoubleAccountException(String name) {
        super(name + " has already been added.");
    }

}
