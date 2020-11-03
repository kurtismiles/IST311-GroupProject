/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Kurtis
 */
public class StarterModel
{

    private HashMap accounts;

    public StarterModel()
    {
        accounts = new HashMap();

        accounts.put("Sam@yahoo.com", "Puppies");
        accounts.put("Ben@yahoo.com", "Puppies");
        accounts.put("Meg@yahoo.com", "Puppies");
        accounts.put("Tim@yahoo.com", "Puppies");

    }

    public boolean Authorize(String inputUsername, String inputPassword)
    {
        if (accounts.containsKey(inputUsername))
        {
            System.out.println("Correct Username");

            if ((accounts.get(inputUsername)).equals(inputPassword))
            {
                System.out.println("Correct Password");
                return true;
            } else
            {
                System.out.println("Incorrect Password");
                return false;
            }
        } else
        {
            System.out.println("Incorrect Username");
            return false;
        }
    }

}
