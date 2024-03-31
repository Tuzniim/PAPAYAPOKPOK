
public class MenuItem {
    private String name;
    private int price;

    // Constructor
    public MenuItem(String name,int price) {
        this.name = name;
        this.price = (int) price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }
}
