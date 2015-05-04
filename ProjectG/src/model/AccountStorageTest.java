package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountStorageTest
{
    AccountStorage as;
    public AccountStorageTest()
    {
        as = new AccountStorage();
        as.wipeAllData();
    }
    
    @Test
    public void testeWipe() {
        try
        {
            as.addData("Test");
        }
        catch (DoubleAccountException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        as.wipeAllData();
        assertTrue(as.getData().size() == 0);
    }

    @Test
    public void testeSaveAndGet()
    {
        try
        {
            as.addData("Test");
        }
        catch (DoubleAccountException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(as.getData().size());
        assertTrue(as.getData().size() == 1);
        
        AccountStorage as2 = new AccountStorage();
        System.out.println(as2.getData().size());
        assertTrue(as2.getData().size() == 1);
    }
    
    @Test
    public void testeDataNotFound() 
    {
        as.wipeAllData();
        try
        {
            as.addData("Test");
        }
        catch (DoubleAccountException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try
        {
            as.deleteData("Test2"); 
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        assertTrue(as.getData().size() == 1);

    }

}
