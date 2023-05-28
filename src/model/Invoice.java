package model;
import java.util.Calendar;
import java.util.Date;

public class Invoice{

    //Attributes
    private double amountPaid;
    private Calendar operationDate;

    //Relations
    private User user;
    private Product product;

    /**
	 * Constructor for the Invoice class.
	 * 
	 * <br>post:</br> A new instance of Invoice class is created.
	 *
	 * @param amountPaid The amount paid on the invoice.
	 * @param user The user of the invoice.
	 * @param product The product of the invoice.
	 */
    public Invoice(double amountPaid, User user, Product product){
        this.amountPaid=amountPaid;
        this.user=user;
        this.product=product;
        operationDate= Calendar.getInstance();
    }

    /**
 	 * Gets the amount paid of the invoice.
     *
 	 * @return The amount paid of the invoice.
 	 */
    public double getAmountPaid(){
        return amountPaid;
    }

    /**
 	 * Gets the product of the invoice.
     *
 	 * @return The product of the invoice.
 	 */
    public Product getProduct(){
        return product;
    }

    /**
 	 * Returns the string representation of the invoice.
     *
 	 * @return The string representation of the invoice.
 	 */
    public String toString(){
        Date date = operationDate.getTime();
        return "User name: " + user.getName() + "\n" +
        "Product name: " + product.getName() + "\n" +
        "Operation date: " + date + "\n" +
        "Amount paid: $" + amountPaid + "\n";
    }
}