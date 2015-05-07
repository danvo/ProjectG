package model;

import java.util.List;

public interface Storage
{
     
    public void addData(String data) throws DoubleAccountException, InvalidEntryException;
    public void addData(String[] dataArray);
    
    public List<String> getData();
    
    public void wipeAllData();
    
    public void deleteData(String data) throws DataNotFoundException;
    
}
