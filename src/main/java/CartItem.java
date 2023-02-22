public class CartItem{

    private Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Constructor for creating the CartItem object.
     * @param product - Product object
     * @param quantity - Any int type number which used for the quantity of any product in cart.
     */
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Calculate the sum of the one CartItem with the current quantity of the item.
     * @param quantity - quantity of the current CartItem object
     */
    public double calculateTotalSum(int quantity) {
        return this.product.getPrice() * quantity;
    }

    public String toString() {
        return String.format("Cart Item product has name : %s \nCart Item product has price: %s \nThe quantity is: %s",this.product.getLabel(),this.product.getPrice(),this.getQuantity());
    }

    /**
     * Prints the product details to the console.
     */
    public void CartItemDetailsToConsole() {
        System.out.println(toString());
    }
}