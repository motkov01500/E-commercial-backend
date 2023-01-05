public class CartItem{
    private Product product;
    private int quantity;

    public Product getProduct(){
        return product;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Constructor for creating the CartItem object with the given any product and quantity from it
    public CartItem (Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    //Calculate the sum of the one CartItem with the current quantity of the item.
    public double calculateTheFinalSumWithQuantity(int quantity){
        return this.product.getPrice() * quantity;
    }

    //Method for details about CartItem(Quantity and Product).
    private String CartItemDetails(){
        return String.format("Cart Item product has name : %s \nCart Item product has price: %s \n The quantity is: %s",this.product.getLabel(),this.product.getPrice(),this.getQuantity());
    }

    //Method to print the details about CartItem to the console.
    public void CartItemDetailsToConsole(){
        System.out.println(CartItemDetails());
    }
}