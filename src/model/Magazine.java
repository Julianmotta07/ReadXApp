package model;

public class Magazine extends Product{

    //attribute
    private double subscriptionValue;
    private String issuanceFrequency;
    private int activeSubscriptions;

    //relations
    private Category category;

    public Magazine(String name, int pagesNumber, String publicationDate, String url, double subscriptionValue, String issuanceFrequency, int categoryOpt){
        super(name, pagesNumber, publicationDate, url);
        this.subscriptionValue=subscriptionValue;
        this.issuanceFrequency=issuanceFrequency;
        activeSubscriptions=0;
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

    @Override
    public String toString(){
        return super.toString()+"Subscription value: $"+ subscriptionValue +"\n" +
        "Issuance frequency: "+ issuanceFrequency+ "\n" +
        "Active subscriptions: "+ activeSubscriptions+ "\n" +
        "Category: " + category.name() + "\n";
    }
}