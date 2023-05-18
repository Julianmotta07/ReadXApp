package model;
import java.util.*;

public class PremiumUser extends User{

    private ArrayList<Book> books;
    private ArrayList<Magazine> magazines;

    public PremiumUser(String name, int id){
        super(name, id);
        books= new ArrayList<>();
        magazines= new ArrayList<>();
    }

    public String addBook(Book book){
        String message="Book successfully purchased!.";
        if (books.contains(book)) {
            message="Error: The user has already purchased this book.";
        } else {
            books.add(book);
        }
        return message;
    }

    public String addMagazine(Magazine magazine){
        String message="Magazine subscription successfully completed!.";
        if (magazines.contains(magazine)) {
            message="Error: The user has already subscribed to this magazine.";
        } else {
            magazines.add(magazine);
        }
        return message;
    }

    public String showLibrary(int pageNum){
        String library="Library of "+super.getName()+": \nPage "+(pageNum+1);
        ArrayList<Product> userProducts = new ArrayList<>();
        userProducts.addAll(books);
        userProducts.addAll(magazines);
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

        int startIndex = pageNum * 25;
        int endIndex = Math.min(startIndex + 25, userProducts.size());

        for (int i = 0; i < super.getLibrary().length; i++) {
            for (int j = 0; j < super.getLibrary()[i].length; j++) {
                if (i * super.getLibrary().length + j < endIndex - startIndex) {
                    Product product = userProducts.get(startIndex + i * super.getLibrary().length + j);
                    super.getLibrary()[i][j] = product.getId();
                } else {
                    super.getLibrary()[i][j] = "___";
                }
            }
        }
        library += super.displayLibrary();
        return library; 
    }

    public Product searchProduct(String id){
        Product productFound=null;
        boolean found=false;
        ArrayList<Product> userProducts = new ArrayList<>();
        userProducts.addAll(books);
        userProducts.addAll(magazines);
        for (int i=0; i < userProducts.size() && !found; i++) {
            Product product = userProducts.get(i);
            if(product.getId().equals(id)) {
                productFound=product;
                found=true;
            }
        }
        return productFound;
    }
}