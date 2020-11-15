/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kurtis
 */
public interface Scrollable {
     
    public int getTotalLines();

    public void setTotalLines(int totalLines);

    public int getFirstLine();

    public void setFirstLine(int firstLine);

    public int getLastLine();

    public void setLastLine(int lastLine);
    
}
