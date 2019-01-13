
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import javax.swing.JButton;

public class MenuButton extends JButton {

    //instance variables
    private String price;
    private String item;

    public String getItem() {
        return this.item;
    }//end getItem

    public void setItem(String item) {
        this.item = item;
    }//end setItem

    public String getPrice() {
        return this.price;
    }//end getPrice

    public void setPrice(String price) {
        this.price = price;
    }//end setPrice

    public MenuButton(String item, String price) {
        super(item);
        this.setItem(item);
        this.setPrice(price);
    }//end MenuButton constructor
}//end MenuButton class
