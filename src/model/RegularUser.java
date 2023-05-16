package model;
import java.util.*;

public class RegularUser extends User implements Announceable{

    private int availableBooks;
    private int availableMagazines;

    private final int MAX_BOOKS=5;
    private final int MAX_MAGAZINES=2;

    Book[] books;
    Magazine[] magazines;

    public RegularUser(String name, int id){
        super(name, id);
        books= new Book[MAX_BOOKS]; 
        magazines= new Magazine[MAX_MAGAZINES]; 
        availableBooks=5;
        availableMagazines=2;
    }

    public String addBook(Book book){
        String message="Book successfully purchased!.";
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
                availableBooks=availableBooks-1;
                finish=true;
            }  
        }
        return message;
    }

    public String addMagazine(Magazine magazine){
        String message="Magazine subscription successfully completed!.";
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
                availableMagazines=availableMagazines-1;
                finish=true;
            }  
        }
        return message;
    }

    public String showLibrary(int pageNum){
        String library="Library of "+super.getName()+": \nPage "+(pageNum+1);
        if (books[0]==null && magazines[0]==null){
            library="Error: The user has no products yet.";
        } else {
            ArrayList<Product> userProducts = new ArrayList<>();
            for (int i=0; i < books.length; i++){
                if(books[i]!=null){
                    userProducts.add(books[i]);
                }
            }
            for (int i=0; i < magazines.length; i++){
                if(magazines[i]!=null){
                    userProducts.add(magazines[i]);
                }
            }
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
                        if (product != null) {
                            super.getLibrary()[i][j] = product.getId();
                        } else {
                            super.getLibrary()[i][j] = "___";
                        }
                    } else {
                        super.getLibrary()[i][j] = "___";
                    }
                }
            }
            library += super.displayLibrary();
        }  
        return library;
    }

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
                if (pagesCount%5==0){
                    ad="\nAdvertisement: \n"+ads[randomIndex]+"\n";
                }
            break;  
        }
        return ad;
    }
}