package model;

public class Book extends Product{

    //attribute
    private double saleValue;
    private String review;
    private int copiesSold;

    //relations
    private Genre genre;

    public Book(String name, int pagesNumber, String publicationDate, String url, double saleValue, String review, int genreOpt){
        super(name, pagesNumber, publicationDate, url);
        this.saleValue=saleValue;
        this.review=review;
        copiesSold=0;
        switch(genreOpt){
            case 1:
                this.genre=Genre.SCI_FI;
                break;
            case 2:
                this.genre=Genre.FANTASY;
                break;
            case 3:
                this.genre=Genre.HISTORICAL_NOVEL;
                break;
        }
    }

    @Override
    public String toString(){
        return super.toString()+"Sale value: $"+ saleValue +"\n" +
        "Review: "+ review+ "\n" +
        "Copies sold: "+ copiesSold+ "\n" +
        "Genre: " + genre.name() + "\n";
    }
}