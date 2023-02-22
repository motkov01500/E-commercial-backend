import java.util.ArrayList;

/**
 * Class which we use to create new instances for Products and added it's to the CartItem object.
 */
public class Product {

    private String label;
    private double price;

    /**
     * Constructor for product with default values
     */
    public Product() {
        this.label = "radio";
        this.price = 35.99;
    }

    /**
     * Constructor for product with custom values.
     * @param label - The name of the product.
     * @param price - The price of the product.
     */
    public Product(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Method about details of the Product object
     */
    @Override
    public String toString() {
        return "Product label is:" + getLabel() + ". The product price is: " + getPrice();
    }

    /**
     * Display the product details in the console.
     */
    public void productDetailsToConsole() {
        System.out.println(toString());
    }
}