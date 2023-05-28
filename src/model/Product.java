package model;
import java.util.Calendar;

public abstract class Product{

    //Attributes
    private String id;
    private String name;
    private int pagesNumber;
    private Calendar publicationDate;
    private String url;
    private double value;
    private int pagesRead;

    /**
	 * Constructor for the Product class.
	 * 
	 * <br>post:</br> A new instance of Product subclasses is created.
	 *
	 * @param id The identifier of the product.
	 * @param name The name of the product.
	 * @param pagesNumber The pages number of the product.
	 * @param publicationDate The publication date of the product.
     * @param url The URL of the repository with the product cover.
	 * @param value The value of the product.
	 */
    public Product(String id, String name, int pagesNumber, Calendar publicationDate, String url, double value){
        this.id=id;
        this.name=name;
        this.pagesNumber=pagesNumber;
        this.publicationDate=publicationDate;
        this.url=url;
        this.value=value;
        pagesRead=0;
    }

    /**
 	 * Gets the identifier of the product.
     *
 	 * @return The identifier of the product.
 	 */
    public String getId(){
        return id;
    }

    /**
 	 * Gets the name of the product.
     *
 	 * @return The name of the product.
 	 */
    public String getName(){
        return name;
    }

    /**
	 * Sets the name of the product.
	 * 
	 * @param name The name of the product.
	 */
    public void setName(String name){
        this.name=name;
    }

    /**
 	 * Gets the pages number of the product.
     *
 	 * @return The pages number of the product.
 	 */
    public int getPagesNumber(){
        return pagesNumber;
    }

    /**
	 * Sets the pages number of the product.
	 * 
	 * @param pagesNumber The pages number of the product.
	 */
    public void setPagesNumber(int pagesNumber){
        this.pagesNumber=pagesNumber;
    }

    /**
 	 * Gets the publication date of the product.
     *
 	 * @return The publication date of the product.
 	 */
    public Calendar getPublicationDate(){
        return publicationDate;
    }

    /**
 	 * Sets the publication date of the product.
     *
 	 * @param publicationDate The publication date of the product.
 	 */
    public void setPublicationDate(Calendar publicationDate){
        this.publicationDate=publicationDate;
    }

    /**
 	 * Sets the url of the repository with the product cover.
     *
 	 * @param url The url of the repository with the product cover.
 	 */
    public void setUrl(String url){
        this.url=url;
    }

    /**
 	 * Gets the value of the product.
     *
 	 * @return The value of the product.
 	 */
    public double getValue(){
        return value;
    }

    /**
 	 * Sets the value of the product.
     *
 	 * @param value The value of the product.
 	 */
    public void setValue(double value){
        this.value=value;
    }

    /**
 	 * Gets the pages read number of the product.
     *
 	 * @return The pages read number of the product.
 	 */
    public int getPagesRead(){
        return pagesRead;
    }

    /**
 	 * Sets the pages read number of the product.
     *
 	 * @param pagesRead The pages read number of the product.
 	 */
    public void setPagesRead(int pagesRead){
        this.pagesRead=pagesRead;
    }

    /**
 	 * Returns the string representation of the product.
     *
 	 * @return The string representation of the product.
 	 */
    public String toString(){
        return "Name: " + name + "\n" +
        "ID: " + id + "\n" +
        "Pages number: " + pagesNumber + "\n";
    }
}