package model;
import java.util.*;

public class RegularUser extends User implements Announceable{

    //Attributes
    private int availableBooks;
    private int availableMagazines;

    //Constants
    private final int MAX_BOOKS=5;
    private final int MAX_MAGAZINES=2;

    //Relations
    Book[] books;
    Magazine[] magazines;

    /**
	 * Constructor for the RegularUser class.
	 * 
	 * <br>post:</br> A new instance of RegularUser class is created.
	 *
	 * @param name The name of the regular user.
	 * @param id The identification of the regular user.
	 */
    public RegularUser(String name, String id){
        super(name, id);
        books= new Book[MAX_BOOKS]; 
        magazines= new Magazine[MAX_MAGAZINES]; 
        availableBooks=5;
        availableMagazines=2;
    }

    /**
	 * Adds a book to the regular user's book array.
	 *
	 * @param book The book to be added.
     * @return A message indicating the result of the operation.
	 */
    public String addBook(Book book){
        String message="\nBook successfully purchased!.";
        if (availableBooks==0){
            message="Error: The user has reached his book limit.";
        }   
        boolean finish=false;
        for (int i=0; i <books.length && !finish; i++){
            if (books[i]!=null && books[i].getId().equals(book.getId())){
                message="Error: The user has already purchased this book.";
                finish=true;
            } else if (books[i]==null) {
                books[i]=book;
                availableBooks--;
                finish=true;
            }  
        }
        return message;
    }

    /**
	 * Adds a magazine to the regular user's magazine array.
	 *
	 * @param magazine The magazine to be added.
     * @return A message indicating the result of the operation.
	 */
    public String addMagazine(Magazine magazine){
        String message="\nMagazine subscription successfully completed!.";
        if (availableMagazines==0){
            message="Error: The user has reached his magazine limit.";
        }   
        boolean finish=false;
        for (int i=0; i <magazines.length && !finish; i++){
            if (magazines[i]!=null && magazines[i].getId().equals(magazine.getId())){
                message="Error: The user has already subscribed to this magazine.";
                finish=true;
            } else if (magazines[i]==null) {
                magazines[i]=magazine;
                availableMagazines--;
                finish=true;
            }  
        }
        return message;
    }

    /**
	 * Removes a magazine subscription from the regular user's magazine array.
	 *
	 * @param magazine The magazine to be removed.
     * @return A message indicating the result of the operation.
	 */
    public String removeMagazine(Magazine magazine){
        String message="Magazine subscription successfully cancelled!.";
        boolean finish=false;
        for (int i=0; i <magazines.length && !finish; i++){
            if (magazines[i]!=null && magazines[i].getId().equals(magazine.getId())){
                magazines[i]=null;
                availableMagazines++;
                finish=true;
            }  
        }
        if (!finish){
            message="Error: The user has not subscribed to this magazine.";
        }
        return message;
    }

    /**
     * Generates the display of the regular user's library based on the specified page number.
     * 
     * @param pageNum The page number to generate the library display for.
     * @return A string representing the library display.
     */
    public String showLibrary(int pageNum){
        ArrayList<Product> userProducts = new ArrayList<>();
        // Collect all books into userProducts
        for (int i=0; i < books.length; i++){
            if(books[i]!=null){
                userProducts.add(books[i]);
            }
        }
        // Collect all magazines into userProducts
        for (int i=0; i < magazines.length; i++){
            if(magazines[i]!=null){
                userProducts.add(magazines[i]);
            }
        }
        // Sort userProducts based on publication date
        for (int i = 0; i < userProducts.size(); i++) {
            for (int j = i + 1; j < userProducts.size(); j++) {
                Product product1 = userProducts.get(i);
                Product product2 = userProducts.get(j);
                if (product2.getPublicationDate().before(product1.getPublicationDate())) {
                    userProducts.set(i, product2);
                    userProducts.set(j, product1);
                }
            }
        }
        // Call fillLibrary to generate the library display based on userProducts and pageNum
        String library = super.fillLibrary(userProducts, pageNum);
        return library;
    }

    /**
	 * Searches for a product in the regular user's book and magazine arrays based on the identifier provided.
	 *
	 * @param id The identifier of the product to search for.
     * @return The found product or null if not found.
	 */
    public Product searchProduct(String id){
        Product productFound=null;
        boolean found=false;
        for (int i=0; i < books.length && !found; i++) {
            if(books[i]!=null && books[i].getId().equals(id)) {
                productFound=books[i];
                found=true;
            }
        }
        if (!found){
            for (int i=0; i < magazines.length && !found; i++) {
                if (magazines[i]!=null && magazines[i].getId().equals(id)) {
                    productFound=magazines[i];
                    found=true;
                }
            }
        }
        return productFound;
    }

    /**
     * Gets the regular user's magazine array.
     * 
     * @return The regular user's magazine array.
     */
    public Magazine[] getMagazines(){
        return magazines;
    }

    /**
     * Generates a display advertisement based on the specified product type and page count.
     * 
     * @param productType The type of product (1:BOOK, 2:MAGAZINE).
     * @param pagesCount The product's page count read.
     * @return A string representing the display advertisement.
     */
    public String displayAds(int productType, int pagesCount){
        String ad="";
        String[] ads = {
            "Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!", 
            "Now your pets have a favorite app: Laika. The best products for your furry friend.", 
            "It's our anniversary! Visit your nearest Exito and be surprised with the best offers."
        };
        int randomIndex = (int) (Math.random() * ads.length);
        switch(productType){
            case 1:
                if (pagesCount%20==0 || pagesCount==1){
                    ad="\nAdvertisement: \n"+ads[randomIndex]+"\n";
                }
            break;
            case 2:
                if (pagesCount%5==0 || pagesCount==1){
                    ad="\nAdvertisement: \n"+ads[randomIndex]+"\n";
                }
            break;  
        }
        return ad;
    }
}