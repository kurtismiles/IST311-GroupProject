package Model;

import java.util.HashMap;

/**
 *
 * @author Kurtis
 */
public class StarterModel {

    private HashMap accounts;

    public StarterModel() {
        accounts = new HashMap();

        accounts.put("Sam@yahoo.com", "Puppies");
        accounts.put("Ben@yahoo.com", "Puppies");
        accounts.put("Meg@yahoo.com", "Puppies");
        accounts.put("Tim@yahoo.com", "Puppies");
        accounts.put("test", "test");

    }

    //tests the input to see if it matches any username&password combo in accounts map
    public boolean Authorize(String inputUsername, String inputPassword) {
        if (accounts.containsKey(inputUsername)) {

            if ((accounts.get(inputUsername)).equals(inputPassword)) {
                return true;
            } else {
                System.out.println("Incorrect Password");
                return false;
            }
        } else {
            System.out.println("Incorrect Username");
            return false;
        }
    }

}
