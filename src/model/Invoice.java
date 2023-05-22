package model;
import java.util.Calendar;
import java.util.Date;

public class Invoice{

    //atributes
    private double amountPaid;
    private Calendar operationDate;

    //relations
    private User user;
    private Product product;

    public Invoice(double amountPaid, User user, Product product){
        this.amountPaid=amountPaid;
        this.user=user;
        this.product=product;
        operationDate= Calendar.getInstance();
    }

    public double getAmountPaid(){
        return amountPaid;
    }

    public Product getProduct(){
        return product;
    }

    public String toString(){
        Date date = operationDate.getTime();
        return "User name: " + user.getName() + "\n" +
        "Product name: " + product.getName() + "\n" +
        "Operation date: " + date + "\n" +
        "Amount paid: $" + amountPaid + "\n";
    }
}