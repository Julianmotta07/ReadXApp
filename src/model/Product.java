package model;
import java.util.Calendar;

public abstract class Product{

    //attribute
    private String id;
    private String name;
    private int pagesNumber;
    private Calendar publicationDate;
    private String url;
    private double value;
    private int pagesRead;

    public Product(String id, String name, int pagesNumber, Calendar publicationDate, String url, double value){
        this.id=id;
        this.name=name;
        this.pagesNumber=pagesNumber;
        this.publicationDate=publicationDate;
        this.url=url;
        this.value=value;
        pagesRead=0;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getPagesNumber(){
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber){
        this.pagesNumber=pagesNumber;
    }

    public Calendar getPublicationDate(){
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate){
        this.publicationDate=publicationDate;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value=value;
    }

    public int getPagesRead(){
        return pagesRead;
    }

    public void setPagesRead(int pagesRead){
        this.pagesRead=pagesRead;
    }

    public String toString(){
        return "Name: " + name + "\n" +
        "ID: " + id + "\n" +
        "Pages number: " + pagesNumber + "\n";
    }
}