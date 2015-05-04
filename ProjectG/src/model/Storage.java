package model;

import java.util.List;

public interface Storage
{
    
    public void saveData(String accounts); 
    
    public List<String> getData();
    
}
