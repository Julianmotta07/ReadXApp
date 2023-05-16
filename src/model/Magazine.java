package model;
import java.util.Calendar;

public class Magazine extends Product{

    //attribute
    private int activeSubscriptions;

    //relations
    private Category category;
    private IssuanceFrequency issuanceFreq;

    public Magazine(String id, String name, int pagesNumber, Calendar publicationDate, String url, double subscriptionValue, int issuanceFreqOpt, int categoryOpt){
        super(id, name, pagesNumber, publicationDate, url, subscriptionValue);
        switch(issuanceFreqOpt){
            case 1:
                this.issuanceFreq=IssuanceFrequency.WEEKLY;
                break;
            case 2:
                this.issuanceFreq=IssuanceFrequency.MONTHLY;
                break;
            case 3:
                this.issuanceFreq=IssuanceFrequency.YEARLY;
                break;
        }
        switch(categoryOpt){
            case 1:
                this.category=Category.VARIETIES;
                break;
            case 2:
                this.category=Category.DESIGN;
                break;
            case 3:
                this.category=Category.SCIENTIFIC;
                break;
        }
        activeSubscriptions=0;
    }

    public void setIssuaceFreq(int issuanceFreqOpt){
        switch(issuanceFreqOpt){
            case 1:
                this.issuanceFreq=IssuanceFrequency.WEEKLY;
                break;
            case 2:
                this.issuanceFreq=IssuanceFrequency.MONTHLY;
                break;
            case 3:
                this.issuanceFreq=IssuanceFrequency.YEARLY;
                break;
        }
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(int categoryOpt){
        switch(categoryOpt){
            case 1:
                this.category=Category.VARIETIES;
                break;
            case 2:
                this.category=Category.DESIGN;
                break;
            case 3:
                this.category=Category.SCIENTIFIC;
                break;
        } 
    }

    public int getActiveSubscriptions(){
       return activeSubscriptions;
    }

    public void setActiveSubcritions(int activeSubscriptions){
        this.activeSubscriptions=activeSubscriptions;
    }

    @Override
    public String toString(){
        return super.toString()+"Subscription value: $"+ super.getValue() +"\n" +
        "Issuance frequency: "+ issuanceFreq.name() + "\n" +
        "Category: " + category.name() + "\n" +
        "Active subscriptions: "+ activeSubscriptions+ "\n";
    }
}