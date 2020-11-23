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
public class AccountList {

    private ArrayList<Account> AccountList;

    private int totalLines;
    private int firstLine;
    private int lastLine;

    public AccountList() {
        AccountList = new ArrayList<>();
        loadXMLList();

        totalLines = 5;
        firstLine = 0;
        lastLine = 4;

    }

    public ArrayList<Account> getAccountList() {
        return AccountList;
    }

    public void setAccountList(ArrayList<Account> AccountList) {
        this.AccountList = AccountList;
    }

    public int getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(int totalLines) {
        this.totalLines = totalLines;
    }

    public int getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    public int getLastLine() {
        return lastLine;
    }

    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }

    //@Override
    public void loadXMLList() {
        try {
            XMLDecoder de = new XMLDecoder(new BufferedInputStream(new FileInputStream("accounts.xml")));
            setAccountList((ArrayList<Account>) de.readObject());
            de.close();

        } catch (Exception xx) {
            xx.printStackTrace();
        }
    }

    //@Override
    public void saveXMLList() {
        try {
            XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("accounts.xml")));
            xe.writeObject(getAccountList());
            xe.close();

        } catch (Exception xx) {
            xx.printStackTrace();
        }
    }

    //adds a new recipe to RecipeList ArrayList
    public void addAccount(Account input) {
        getAccountList().add(input);
    }

    //removes a recipe from RecipeList ArrayList
    public void removeAccount(Account input) {
        getAccountList().remove(input);
    }

}
