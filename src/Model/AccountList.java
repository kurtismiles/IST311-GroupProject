/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jordan
 */
public class AccountList
{
    private ArrayList<Account> AccountList;
    
    private int totalLines;
    private int firstLine;
    private int lastLine;
    
    public AccountList()
    {
       AccountList = new ArrayList<>();
       loadXMLList();
       
       totalLines = 5;
       firstLine = 0;
       lastLine = 4;
       
    }
    
    /**
     * @param recipeList the recipeList to set
     */
    public void setAccountList(ArrayList<Account> AccountList) {
        this.AccountList = AccountList;
    }
    
    public void loadXMLList()
    {          
        try
        {
          XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("recipes.xml")));
          setAccountList((ArrayList<Account>) de.readObject());
          de.close();
                
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }

    
    
    
    
}
