package model;

import java.util.ArrayList;
import java.util.List;

public class AccountStorage implements Storage
{

    private ArrayList<String> _accounts;

    public AccountStorage()
    {
        _accounts = new ArrayList<String>();
        loadData();
    }

    private void saveData(String[] data)
    {

    }

    @Override
    public List<String> getData()
    {
        return _accounts;
    }

    @Override
    public void addData(String data)
    {
        _accounts.add(data);
        
    }

    @Override
    public void addData(String[] dataArray)
    {
        for (String s : dataArray)
        {
            _accounts.add(s);
        }
        saveData(dataArray);
    }

    @Override
    public void wipeAllData()
    {
        _accounts.clear();
    }

    @Override
    public void loadData()
    {
        // TODO Auto-generated method stub
        
    }

}
