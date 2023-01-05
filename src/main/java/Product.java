import java.util.ArrayList;

public class Product {
    private String label;
    private double price;

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    //Constructor for product with default values
    Product(){
        this.label = "radio";
        this.price = 35.99;
    }

    //Constructor for product with custom values
    Product(String label,double price){
        this.label = label;
        this.price = price;
    }

    //Method for product details(Label and Price)
    private String productDetails(){
        return String.format("Product label is:%s. \n The product price is: %2d",getLabel(),getPrice());
    }

    //Display the product details in the console
    public void productDetailsToConsole(){
        System.out.println(productDetails());
    }
}