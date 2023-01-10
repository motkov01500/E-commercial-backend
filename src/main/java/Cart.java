import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> items = new ArrayList<>();
    private int deliveryFee;
    
   public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * Calculate the VAT.
     * @param itemFullPrice - Sum of all cart items without delivery fee.
     */
    private Double calculateVAT(double itemFullPrice) {
        return itemFullPrice * 0.2 ;
    }

    /**
     * Calculate the delivery fee of the cart.
     * @param sum - Sum of the all cart items.
     */
    public void calculateDeliveryFee(double sum) {
        if(sum > 0) {
            if (sum < 100) {
                setDeliveryFee(10);
            } else if (sum < 200) {
                setDeliveryFee(5);
            } else {
                setDeliveryFee(0);
            }
        }else{
            System.out.println("Your cart is empty. Please add an item to calculate!");
        }
    }

    /**
     *Calculate the final price of all products
     */
    private Double calculateFinalPrice() {
        double sum = 0;
        for (var item: items) {
            sum += item.calculateTotalSum(item.getQuantity());
        }
        calculateDeliveryFee(sum);
        return (sum + getDeliveryFee()) + calculateVAT(sum);
    }

    /**
     * Add the cartItem object to the cart.
     */
    public void addItemToCart(CartItem cartItem) {
        items.add(cartItem);
    }

    /**
     * @variable item: searches in the cartItems ArrayList the cartItem object which is gived as parameter.
     * @variable itemQuantity:get the quantity of the current CartItem object
     * Also, if the quantity is below than zero the item will be removed from the ArrayList.
     * Finally, if we call the method below again for the item which is already deleted it, it throws sample custom exception.
     */
    public void deleteItemFromCart(CartItem cartItem) throws NullPointerException {
        try {
            var item =items.stream()
                    .filter(cartitem-> cartitem.getProduct().getLabel().equals(cartItem.getProduct().getLabel()))
                    .findAny();
            int itemQuantity = item.get().getQuantity();
            itemQuantity--;
            if (itemQuantity < 1) {
                items.remove(item.get());
            }
            item.get().setQuantity(itemQuantity);
        }catch (Exception exception){
            throw new NullPointerException ("Item is not founded in the cart.");
        }
    }

    /**
     * Display in the console number of the cart different items with their quantity and products details which is in the cart and final price $.
     */
    public String toString() {
        String cartSize = String.format("There are %s elements in cart\n",items.size());
        String cartItemByItem = "";
        for (int i = 0;i< items.size();i++) {
            cartItemByItem +=String.format("Item %s is:\n%s \n --------------------------------\n",i+1,items.get(i).toString());
        }
        String cartFinalPrice = String.format("The final price is: %s$",calculateFinalPrice());
        return cartSize + cartItemByItem + cartFinalPrice;
    }

    /**
     * Display the details of the Cart object to the console.
     */
    public void CartItemDetails() {
        System.out.println(toString());
    }
}
