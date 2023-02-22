public class Application {
    public static void main(String[] args) {
        Product pasta = new Product ("pasta",13);
        Product radio = new Product();
        Product pizza = new Product("pizza",15);
        Product chair = new Product("chair",149.99);

        CartItem itemOne = new CartItem(pasta,2);
        CartItem itemTwo = new CartItem(radio,1);
        CartItem itemThree = new CartItem(pizza,15);
        CartItem itemFour = new CartItem(chair,20);

        Cart cart = new Cart();

        cart.addItemToCart(itemOne);
        cart.addItemToCart(itemTwo);
        cart.addItemToCart(itemThree);

        cart.cartItemDetails();

        System.out.println("=========================================================");

        cart.deleteItemFromCart(itemTwo);
        cart.deleteItemFromCart(itemThree);

        cart.cartItemDetails();
    }
}