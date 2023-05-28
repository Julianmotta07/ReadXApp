package model;
import java.util.Calendar;

public class Magazine extends Product{

    //Attribute
    private int activeSubscriptions;

    //Relations
    private Category category;
    private IssuanceFrequency issuanceFreq;

    /**
	 * Constructor for the Magazine class.
	 * 
	 * <br>pre:</br> Parameters "IssuanceFreqOpt" and "categoryOpt" must be an integer value between 1 and 3.
	 * <br>post:</br> A new instance of the Magazine class is created.
	 *
	 * @param id The identifier of the magazine.
	 * @param name The name of the magazine.
	 * @param pagesNumber The pages number of the magazine.
	 * @param publicationDate The publication date of the magazine.
     * @param url The URL of the repository with the magazine cover.
	 * @param subscriptionValue The subscription value of the magazine.
	 * @param issuanceFreqOpt The magazine issuance frequency option (1:WEEKLY, 2:MONTHLY, 3:YEARLY).
	 * @param categoryOpt The magazine category option (1:VARIETIES, 2:DESIGN, 3:SCIENTIFIC).
	 */
    public Magazine(String id, String name, int pagesNumber, Calendar publicationDate, String url, double subscriptionValue, int issuanceFreqOpt, int categoryOpt){
        super(id, name, pagesNumber, publicationDate, url, subscriptionValue);
        switch(issuanceFreqOpt){
            case 1:
                issuanceFreq=IssuanceFrequency.WEEKLY;
                break;
            case 2:
                issuanceFreq=IssuanceFrequency.MONTHLY;
                break;
            case 3:
                issuanceFreq=IssuanceFrequency.YEARLY;
                break;
        }
        switch(categoryOpt){
            case 1:
                category=Category.VARIETIES;
                break;
            case 2:
                category=Category.DESIGN;
                break;
            case 3:
                category=Category.SCIENTIFIC;
                break;
        }
        activeSubscriptions=0;
    }

    /**
 	 * Gets the category of the magazine.
     *
 	 * @return The category of the magazine.
 	 */
    public Category getCategory(){
        return category;
    }

    /**
	 * Sets the category of the magazine.
	 * 
	 * @param categoryOpt The category option to set for the magazine.
	 */
    public void setCategory(int categoryOpt){
        switch(categoryOpt){
            case 1:
                category=Category.VARIETIES;
                break;
            case 2:
                category=Category.DESIGN;
                break;
            case 3:
                category=Category.SCIENTIFIC;
                break;
        } 
    }

    /**
 	 * Gets the active subscriptions number of the magazine.
     *
 	 * @return The active subscriptions number of the magazine.
 	 */
    public int getActiveSubscriptions(){
       return activeSubscriptions;
    }

    /**
	 * Sets the active subscriptions number of the magazine.
	 * 
	 * @param activeSubscriptions The active subscriptions number to set for the magazine.
	 */
    public void setActiveSubscriptions(int activeSubscriptions){
        this.activeSubscriptions=activeSubscriptions;
    }

    /**
	 * Sets the issuance frequency of the magazine.
	 * 
	 * @param issuanceFreqOpt The issuance frequency option to set for the magazine.
	 */
    public void setIssuanceFreq(int issuanceFreqOpt){
        switch(issuanceFreqOpt){
            case 1:
                issuanceFreq=IssuanceFrequency.WEEKLY;
                break;
            case 2:
                issuanceFreq=IssuanceFrequency.MONTHLY;
                break;
            case 3:
                issuanceFreq=IssuanceFrequency.YEARLY;
                break;
        }
    }

    /**
 	 * Returns the string representation of the magazine.
     *
 	 * @return The string representation of the magazine.
 	 */
    @Override
    public String toString(){
        return super.toString()+"Subscription value: $"+ super.getValue() +"\n" +
        "Category: " + category.name() + "\n";
    }
}