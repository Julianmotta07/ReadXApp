package model;
import java.util.Calendar;

public class Book extends Product{

    //attribute
    private String review;
    private int copiesSold;

    //relations
    private Genre genre;

    public Book(String id, String name, int pagesNumber, Calendar publicationDate, String url, double saleValue, String review, int genreOpt){
        super(id, name, pagesNumber, publicationDate, url, saleValue);
        this.review=review;
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
        copiesSold=0;
    }

    public Genre getGenre(){
        return genre;
    }

    public void setGenre(int genreOpt){
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

    public int getCopiesSold(){
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold){
        this.copiesSold=copiesSold;
    }

    public void setReview(String review){
        this.review=review;
    }

    @Override
    public String toString(){
        return super.toString()+"Sale value: $"+ super.getValue() +"\n" +
        "Genre: " + genre.name() + "\n";
    }
}