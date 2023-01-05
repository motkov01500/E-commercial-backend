import exceptions.NotFoundInArrayList;

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
    
    public Cart(){
    }

    //Calculate the VAT
    private Double calculateVAT(double itemFullPrice){
        return itemFullPrice * 0.2 ;
    }

    //Calculate the final price of all products
    private Double calculateFinalPrice(){
        double sum = 0;
        for (var item: items) {
            sum += item.calculateTheFinalSumWithQuantity(item.getQuantity());
        }
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
        return (sum + getDeliveryFee()) - calculateVAT(sum);
    }

    //Add the item to the cart
    public void addItemToCart(CartItem cartItem){
        items.add(cartItem);
    }

    /**
     * @variable item: searches in the cartItems ArrayList the cartItem object which is gived as parameter.
     * @variable itemQuantity:get the quantity of the current CartItem object
     * Also, if the quantity is below than zero the item will be removed from the ArrayList.
     * Finally, if we call the method below again for the item which is already deleted it, it throws sample custom exception.
     */
    public void deleteItemFromCart(CartItem cartItem) throws NotFoundInArrayList {
        try {
            var item =items.stream().filter(x-> x.getProduct().getLabel() == cartItem.getProduct().getLabel()).findAny();
            int itemQuantity = (int)item.get().getQuantity();
            itemQuantity--;
            if (itemQuantity < 1) {
                items.remove(items.indexOf(item.get()));
            }
            item.get().setQuantity(itemQuantity);
        }catch (Exception exception){
            throw new NotFoundInArrayList ("Item is not founded in the cart.");
        }
    }

    //Display in the console number of the cart different items without their quantity and products details which is in the cart and final price $.
    public void CartItemsDetails(){
        System.out.println(String.format("There are %s elements in cart",items.size()));
        for (int i = 0;i< items.size();i++) {
            System.out.println(String.format("Item %s is:",i+1));
            items.get(i).CartItemDetailsToConsole();
            System.out.println("----------------------------------");
        }
        System.out.println(String.format("The final price is: %s$",this.calculateFinalPrice()));
    }
}
