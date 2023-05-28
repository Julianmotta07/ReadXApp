package model;
import java.util.*;

public class PremiumUser extends User{

    //Relation
    private ArrayList<Product> userProducts;

    /**
	 * Constructor for the PremiumUser class.
	 * 
	 * <br>post:</br> A new instance of the PremiumUser class is created.
	 *
	 * @param name The name of the premium user.
	 * @param id The identification of the premium user.
	 */
    public PremiumUser(String name, String id){
        super(name, id);
        userProducts= new ArrayList<>();
    }

    /**
	 * Adds a product to the premium user's product list.
	 *
	 * @param product The product to be added.
     * @return A message indicating the result of the operation.
	 */
    public String addProduct(Product product){
        String message="\nBook successfully purchased!.";
        if (userProducts.contains(product)) {
            message="Error: The user already has this product";
        } else {
            userProducts.add(product);
            if (product instanceof Magazine){
                message="\nMagazine subscription successfully completed!.";
            }
        }
        return message;
    }

    /**
	 * Removes a magazine subscription from the premium user's product list.
	 *
	 * @param magazine The magazine to be removed.
     * @return A message indicating the result of the operation.
	 */
    public String removeMagazine(Magazine magazine){
        String message="Magazine subscription successfully cancelled!.";
        if (userProducts.contains(magazine)){
            userProducts.remove(magazine);
        } else {
            message="Error: The user has not subscribed to this magazine.";
        }
        return message;
    }

    /**
     * Generates the display of the premium user's library based on the specified page number.
     * 
     * @param pageNum The page number to generate the library display for.
     * @return A string representing the library display.
     */
    public String showLibrary(int pageNum){
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
	 * Searches for a product in the premium user's product list based on the provided identifier.
	 *
	 * @param id The identifier of the product to search for.
     * @return The found product or null if not found.
	 */
    public Product searchProduct(String id){
        Product productFound=null;
        boolean found=false;;
        for (int i=0; i < userProducts.size() && !found; i++) {
            Product product = userProducts.get(i);
            if(product.getId().equals(id)) {
                productFound=product;
                found=true;
            }
        }
        return productFound;
    }

    /**
     * Gets the premium user's product list.
     * 
     * @return The premium user's product list.
     */
    public ArrayList<Product> getProducts() {
        return userProducts;
    }
}