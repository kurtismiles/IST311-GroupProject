package View;

/**
 *
 * @author Kurtis
 */
public class ShoppingListView {

    private ShoppingListPanel shoppingPanel;

    public ShoppingListView() {
        shoppingPanel = new ShoppingListPanel();
    }

    /**
     * @return the shoppingPanel
     */
    public ShoppingListPanel getShoppingPanel() {
        return shoppingPanel;
    }

    /**
     * @param shoppingPanel the shoppingPanel to set
     */
    public void setShoppingPanel(ShoppingListPanel shoppingPanel) {
        this.shoppingPanel = shoppingPanel;
    }
}
