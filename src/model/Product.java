package model;

public abstract class Product{

    //attribute
    private String name;
    private int pagesNumber;
    private String publicationDate;
    private String url;
    private int pagesRead;

    public Product(String name, int pagesNumber, String publicationDate, String url){
        this.name=name;
        this.pagesNumber=pagesNumber;
        this.publicationDate=publicationDate;
        this.url=url;
        pagesRead=0;
    }

    public String toString(){
        return "Name: " + name + "\n" +
        "Pages number: " + pagesNumber + "\n" +
        "Publication Date: $" + publicationDate + "\n" +
        "Repository URL: " + url + " \n" +
        "Accumulated pages read: " + pagesRead + " \n";
    }
}