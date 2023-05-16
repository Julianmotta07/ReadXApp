package model;
import java.util.Calendar;

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
    
}