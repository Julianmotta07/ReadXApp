package model;
import java.util.Calendar;

public class Invoice{

    //atributes
    private double amountPaid;
    private Calendar operationDate;

    public Invoice(double amountPaid, Calendar operationDate){
        this.amountPaid=amountPaid;
        this.operationDate=operationDate;
    }
    
}