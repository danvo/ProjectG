package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AccountStorage implements Storage
{
    private static String FILENAME = "accounts.txt";
    private ArrayList<String> _accounts;

    /**
     * Creates a new AccountStorage and loads saved data if available.
     */
    public AccountStorage()
    {
        _accounts = new ArrayList<String>();
        loadData();
    }

    /**
     * @return all accounts saved
     */
    @Override
    public ArrayList<String> getData()
    {
        return _accounts;
    }

    /**
     * Adds the account.
     * @param data account
     */
    @Override
    public void addData(String data)
    {
        _accounts.add(data);
        saveData();
    }

    /**
     * Adds the array of accounts.
     * @param dataArray Array of accounts
     */
    @Override
    public void addData(String[] dataArray)
    {
        for (String s : dataArray)
        {
            _accounts.add(s);
        }
        saveData();
    }
    
    /**
     * Deletes the account given as data.
     * @param data Account to delete
     * @throws DataNotFoundException if the account is not available
     */
    
    @Override
    public void deleteData(String data) throws DataNotFoundException {
        if (_accounts.contains(data)) {
            _accounts.remove(data);
        } else {
            throw new DataNotFoundException();
        }

    }
    
    /**
     * Deletes all the Data.
     */
    @Override
    public void wipeAllData()
    {
        _accounts.clear();
        
        deleteFile();
    }
    
    private void deleteFile() {
        if(doesFileExist()) {
            new File(FILENAME).delete();
        }
    }
    
    private boolean doesFileExist() {
        File file = new File(FILENAME);
        return file.exists() && !file.isDirectory();
    }
    

    private void saveData()
    {
        if (_accounts.size() > 0)
        {
           deleteFile();
            try (FileWriter fw = new FileWriter(FILENAME, false))
            {
                for (String s : _accounts)
                {
                    fw.write(s + System.getProperty("line seperator"));
                }
            }
            catch (Exception e)
            {
            }
        }
    }

    private void loadData()
    {
        if (doesFileExist())
        {
            // Data input from file
            FileInputStream fstream = null;
            try
            {
                fstream = new FileInputStream(FILENAME);
            }
            catch (FileNotFoundException e1)
            {
                e1.printStackTrace();
            }

            if (fstream != null)
            {
                String strLine;

                // Read the file line by line (one account per line)
                try (BufferedReader br = new BufferedReader(new InputStreamReader(
                        fstream)))
                {
                    while ((strLine = br.readLine()) != null)
                    {
                        _accounts.add(strLine);
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }
}
