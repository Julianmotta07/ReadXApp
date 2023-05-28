package model;
import java.util.Calendar;
import java.util.*;

public abstract class User{

    //Attributes
    private String name;
    private String id;
    private Calendar vinculationDate;
    private String[][] library;

    //Constant
    private final int LIBRARY_SIZE=5;

    /**
	 * Constructor for the User class.
	 * 
	 * <br>post:</br> A new instance of User subclasses is created.
	 *
	 * @param name The name of the user.
	 * @param id The identification of the user.
	 */
    public User(String name, String id){
        this.name=name;
        this.id=id;
        vinculationDate = Calendar.getInstance();
        library= new String[LIBRARY_SIZE][LIBRARY_SIZE]; 
    }

    /**
     * Fills and formats the library display with the user's products based on the specified page number.
     * 
     * @param userProducts The list of user's products.
     * @param pageNum The page number to display.
     * @return A string representing the filled library display.
     */
    public String fillLibrary(ArrayList<Product>userProducts, int pageNum){
        String myLibrary="\nLibrary of "+name+": \nPage "+(pageNum+1)+"\n";
        myLibrary+="\n     0  |  1  |  2  |  3  |  4 \n";
        int startIndex = pageNum * 25;
        int endIndex = Math.min(startIndex + 25, userProducts.size());
        for (int i = 0; i < library.length; i++) {
            myLibrary += i + " ";
            for (int j = 0; j < library[i].length; j++) {
                if (i * library.length + j < endIndex - startIndex) {
                    Product product = userProducts.get(startIndex + i * library.length + j);
                    library[i][j] = product.getId();
                } else {
                    library[i][j] = "___";
                }
                myLibrary += "| " + (library[i][j] + " ");
            }
            myLibrary+="\n";
        }
        return myLibrary;
    }

    /**
 	 * Gets the identification of the user.
     *
 	 * @return The identification of the user.
 	 */
    public String getId(){
        return id;
    }

    /**
 	 * Gets the name of the user.
     *
 	 * @return The name of the user.
 	 */
    public String getName(){
        return name;
    }

    /**
 	 * Gets the library of the user.
     *
 	 * @return The library of the user.
 	 */
    public String[][] getLibrary(){
        return library;
    }

    /**
 	 * Returns the string representation of the user.
     *
 	 * @return The string representation of the user.
 	 */
    public String toString(){
        return "Name: " + name + "\n" +
        "ID: " + id + "\n";
    }
}