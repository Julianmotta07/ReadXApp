package model;
import java.util.Calendar;

public class Book extends Product{

    //Attributes
    private String review;
    private int copiesSold;

    //Relations
    private Genre genre;

    /**
	 * Constructor for the Book class.
	 * 
	 * <br>pre:</br> Parameter "genreOpt" must be an integer value between 1 and 3.
	 * <br>post:</br> A new instance of the Book class is created.
	 *
	 * @param id The identifier of the book.
	 * @param name The name of the book.
	 * @param pagesNumber The pages number of the book.
	 * @param publicationDate The publication date of the book.
     * @param url The URL of the repository with the book cover.
	 * @param saleValue The sale value of the book.
	 * @param review The review of the book.
	 * @param genreOpt The book genre option (1:SCI-FI, 2:FANTASY, 3:HISTORICAL NOVEL).
	 */
    public Book(String id, String name, int pagesNumber, Calendar publicationDate, String url, double saleValue, String review, int genreOpt){
        super(id, name, pagesNumber, publicationDate, url, saleValue);
        this.review=review;
        switch(genreOpt){
            case 1:
                genre=Genre.SCI_FI;
                break;
            case 2:
                genre=Genre.FANTASY;
                break;
            case 3:
                genre=Genre.HISTORICAL_NOVEL;
                break;
        }
        copiesSold=0;
    }

    /**
 	 * Gets the genre of the book.
     *
 	 * @return The genre of the book.
 	 */
    public Genre getGenre(){
        return genre;
    }

    /**
	 * Sets the genre of the book.
	 * 
	 * @param genreOpt The genre option to set for the book.
	 */
    public void setGenre(int genreOpt){
        switch(genreOpt){
            case 1:
                genre=Genre.SCI_FI;
                break;
            case 2:
                genre=Genre.FANTASY;
                break;
            case 3:
                genre=Genre.HISTORICAL_NOVEL;
                break;
        }
    }

    /**
 	 * Gets the copies sold number of the book.
     *
 	 * @return The copies sold number of the book.
 	 */
    public int getCopiesSold(){
        return copiesSold;
    }

    /**
	 * Sets the copies sold number of the book.
	 * 
	 * @param copiesSold The copies sold number of the book.
	 */
    public void setCopiesSold(int copiesSold){
        this.copiesSold=copiesSold;
    }

    /**
	 * Sets the review the book.
	 * 
	 * @param review The review of the book.
	 */
    public void setReview(String review){
        this.review=review;
    }

    /**
 	 * Returns the string representation of the book.
     *
 	 * @return The string representation of the book.
 	 */
    @Override
    public String toString(){
        return super.toString()+"Sale value: $"+ super.getValue() +"\n" +
        "Genre: " + genre.name() + "\n";
    }
}