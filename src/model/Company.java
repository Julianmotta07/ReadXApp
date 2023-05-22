package model;
import java.util.*;

public class Company{

    //attribute
    private String name;
    
    //relations
    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Invoice> invoices;

    public Company(String name){
        this.name=name;
        users= new ArrayList<>();
        products= new ArrayList<>();
        invoices= new ArrayList<>();
    }

    public String addUser(String name, String id, int userType){
        String message="";
        if (searchUser(id)!=null){
            message="Error: A user with the entered ID already exists.";
        } else if (userType==1){
            RegularUser regularUser = new RegularUser(name, id);
            users.add(regularUser);
            message="New regular user successfully registered.";
        } else if (userType==2){
            PremiumUser premiumUser = new PremiumUser(name, id);
            users.add(premiumUser);
            message="New premium user successfully registered.";
        }
        return message;
    }

    public String addProduct(String id, String name, int pagesNum, Calendar publicationDate, String url, double saleValue, String review, int genreOpt){
        String message="New book successfully registered!.";
        if (searchProduct(id)!=null){
            message="Error: A product with the entered ID already exists.";
        } else {
            Book book = new Book(id, name, pagesNum, publicationDate, url, saleValue, review, genreOpt);
            products.add(book); 
        }
        return message;
    }

    public String addProduct(String id, String name, int pagesNum, Calendar publicationDate, String url, double subscriptionValue, int issuanceFreqOpt, int categoryOpt){
        String message="New magazine successfully registered!.";
        if (searchProduct(id)!=null){
            message="Error: A product with the entered ID already exists.";
        } else {
            Magazine magazine = new Magazine(id, name, pagesNum, publicationDate, url, subscriptionValue, issuanceFreqOpt, categoryOpt);
            products.add(magazine); 
        }
        return message;
    }

    public String editProduct(String id, String name, int pagesNum, Calendar publicationDate, String url, double value, String review, int genreOpt){
        String message="Book successfully updated.";
        Product product=searchProduct(id);
        if (product==null) {
            message="Error: A book with the entered ID does not exist.";
        } else {
            product.setName(name);
            product.setPagesNumber(pagesNum);
            product.setPublicationDate(publicationDate);
            product.setUrl(url);
            product.setValue(value);
            Book book = (Book) product;
            book.setReview(review);
            book.setGenre(genreOpt);
        }
        return message;
    }

    public String editProduct(String id, String name, int pagesNum, Calendar publicationDate, String url, double value, int issuanceFreqOpt, int categoryOpt){
        String message="Magazine successfully updated.";
        Product product=searchProduct(id);
        if (product==null) {
            message="Error: A magazine with the entered ID does not exist.";
        } else {
            product.setName(name);
            product.setPagesNumber(pagesNum);
            product.setPublicationDate(publicationDate);
            product.setUrl(url);
            product.setValue(value);
            Magazine magazine = (Magazine) product;
            magazine.setIssuanceFreq(issuanceFreqOpt);
            magazine.setCategory(categoryOpt);
        }
        return message;
    }

    public String deleteProduct(String id) {
        String message="Product successfully removed.";
        Product product=searchProduct(id);
        if (product==null) {
            message="Error: A product with the entered ID does not exist.";
        } else {
            products.remove(product);
        }
        return message;
    }

    public String generateObjects(){
        String message="Generated objects: \n";
        //Generates random 5-digit IDs
        int randomID1 = (int) (Math.random() * 90000) + 10000;
        String regularID = String.valueOf(randomID1);
        int randomID2 = (int) (Math.random() * 90000) + 10000;
        String premiumID = String.valueOf(randomID2);
        //Generates 3-character hexadecimal ID
        int randomID3 = (int) (Math.random() * 4096);
        String bookID = Integer.toHexString(randomID3).toUpperCase();
        if (bookID.length() < 3) {
            bookID = "0" + bookID;
        }
        //Creates a 3-character alphanumeric ID
        String MagazineID ="";
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 36);
            char randomChar;
            if (randomNumber < 10) {
                randomChar = (char) ('0' + randomNumber); // Numeric digit
            } else {
                randomChar = (char) ('A' + (randomNumber - 10)); // Alphabetic character
            }
            MagazineID+=randomChar;
        }
        //Creates the objects
        RegularUser regularUser = new RegularUser("Regular user test", regularID);
        PremiumUser premiumUser = new PremiumUser("Premium user test", premiumID);
        Book book = new Book(bookID, "Book test", 100, Calendar.getInstance(), "test.png", 15, "Review text", 1);
        Magazine magazine = new Magazine(MagazineID, "Magazine test", 100, Calendar.getInstance(), "test.png", 10, 1, 1);
        //Adds the objetcs
        users.add(regularUser);
        users.add(premiumUser);
        products.add(book);
        products.add(magazine);
        //Returns the information of each object
        message +="\n"+ regularUser.toString() + "\n" + premiumUser.toString() + "\n" + book.toString() + "\n" + magazine.toString();
        return message;
    }

    public String buyBook(String userId, String bookId){
        String message="";
        User user = searchUser(userId);
        Product product = searchProduct(bookId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else if (product==null || product instanceof Magazine ){
            message="Error: A book with the entered ID does not exist.";
        } else {
            Book book = (Book) product;
            if (user instanceof RegularUser){
            RegularUser regularUser = (RegularUser) user;
            message = regularUser.addBook(book);      
            } else {
            PremiumUser premiumUser = (PremiumUser) user;
            message = premiumUser.addBook(book);
            }
            if (message.equals("\nBook successfully purchased!.")){
                Invoice newInvoice= new Invoice(book.getValue(), user, product);
                invoices.add(newInvoice);
                book.setCopiesSold(book.getCopiesSold()+1);
                message+="\n\nInvoice: \n"+newInvoice.toString();
            }
        }
        return message;
    }

    public String subscribeMagazine(String userId, String magazineId){
        String message="";
        User user = searchUser(userId);
        Product product = searchProduct(magazineId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else if (product==null || product instanceof Book){
            message="Error: A magazine with the entered ID does not exist.";
        } else {
            Magazine magazine = (Magazine) product;
            if (user instanceof RegularUser){
            RegularUser regularUser = (RegularUser) user;
            message = regularUser.addMagazine(magazine);
            } else {
            PremiumUser premiumUser = (PremiumUser) user;
            message = premiumUser.addMagazine(magazine);
            }
            if (message.equals("\nMagazine subscription successfully completed!.")){
                Invoice newInvoice= new Invoice(magazine.getValue(), user, product);
                invoices.add(newInvoice);
                magazine.setActiveSubscriptions(magazine.getActiveSubscriptions()+1);
                message+="\n\nInvoice: \n"+newInvoice.toString();
            }
        }
        return message;
    }
    
    public String unsubscribeMagazine(String userId, String magazineId){
        String message="";
        User user = searchUser(userId);
        Product product = searchProduct(magazineId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else if (product==null || product instanceof Book){
            message="Error: A magazine with the entered ID does not exist.";
        } else {
            Magazine magazine = (Magazine) product;
            if (user instanceof RegularUser){
            RegularUser regularUser = (RegularUser) user;
            message = regularUser.removeMagazine(magazine);
            } else {
            PremiumUser premiumUser = (PremiumUser) user;
            message = premiumUser.removeMagazine(magazine);
            }
            if (message.equals("Magazine subscription successfully cancelled!.")){
                magazine.setActiveSubscriptions(magazine.getActiveSubscriptions()-1);
            }
        }
        return message;
    }
    
    public String displayMyLibrary(String userId, int pageNum){
        String message="";
        User user = searchUser(userId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else {
            if (user instanceof RegularUser) {
                RegularUser regularUser = (RegularUser) user;
                message+=regularUser.organizeLibrary(pageNum);
            } else {
                PremiumUser premiumUser = (PremiumUser) user;
                message+=premiumUser.organizeLibrary(pageNum);
            } 
        }    
        return message;
    }

    public String simulateReadingSesion(String userId, String productId, char pageOpt, int page, int pagesCount){
        String message="Reading session in progress... \n";
        User user = searchUser(userId);
        Product product=null;
        if (user instanceof RegularUser) {
            RegularUser regularUser = (RegularUser) user;
            product = regularUser.searchProduct(productId);
            if (product instanceof Book) {
                message+=regularUser.displayAds(1, pagesCount);
            } else {
                message+=regularUser.displayAds(2, pagesCount);
            }
        } else {
            PremiumUser premiumUser = (PremiumUser) user;
            product = premiumUser.searchProduct(productId);
        }
        if(product!=null){
            if (page <= product.getPagesNumber()) {
                message+="\nReading: "+product.getName()+"\n";
                message+="\nReading page "+page+" of "+product.getPagesNumber()+"\n";
                if (pageOpt=='S'){
                product.setPagesRead(product.getPagesRead()+1);
                }
            } else {
                message="\n\nEnd. \n\n";
            }
        } else {
            message="Error: Product not found.";
        }
        return message;
    }

    public String simulateReadingSesion(String userId, int xCoord, int yCoord, char pageOpt, int page, int pagesCount){
        String message="Reading session in progress... \n";
        User user = searchUser(userId);
        String[][] matrix = user.getLibrary();
        String productId= matrix[xCoord][yCoord];
        Product product=null;
        if (user instanceof RegularUser) {
            RegularUser regularUser = (RegularUser) user; 
            product = regularUser.searchProduct(productId);
            if (product instanceof Book) {
                message+=regularUser.displayAds(1, pagesCount);
            } else {
                message+=regularUser.displayAds(2, pagesCount);
            }
        } else {
            PremiumUser premiumUser = (PremiumUser) user;
            product = premiumUser.searchProduct(productId);
        }
        if(product!=null){
            if (page <= product.getPagesNumber()) {
                message+="\nReading: "+product.getName()+"\n";
                message+="\nReading page "+page+" of "+product.getPagesNumber()+"\n";
                if (pageOpt=='S'){
                product.setPagesRead(product.getPagesRead()+1);
                }
            } else {
                message="\n\nEnd. \n\n";
            }
        } else {
            message="Error: Product not found.";
        }
        return message;
    }

    public String getPagesReadPerProductType(){
        String list="Pages read per bibliographic product type: \n";
        if (products.isEmpty()){
            list="Error: No products registered yet.";
        } else {
            int bookSum=0; int magazineSum=0;
            for (int i=0; i < products.size(); i++) {
                Product product=products.get(i);
                if (product instanceof Book) {
                    bookSum=bookSum+product.getPagesRead();
                } else {
                    magazineSum=magazineSum+product.getPagesRead();
                }
            }
            list+="- Book: "+bookSum;
            list+="\n- Magazine: "+magazineSum;
        }
        return list;
    }

    public String getGenreAndCategoryMostRead(){
        String message="- Most read genre: ";
        if (products.isEmpty()){
            message="Error: No products registered yet.";
        } else {
            int[] genres= new int[3];
            int[] categories= new int[3];
            for (int i=0; i < products.size(); i++) {
                Product product=products.get(i);
                if (product instanceof Book) {
                    Book book = (Book) product;
                    if(book.getGenre()==Genre.SCI_FI) {
                        genres[0]=genres[0]+book.getPagesRead();
                    } else if (book.getGenre()==Genre.FANTASY){
                        genres[1]=genres[1]+book.getPagesRead();
                    } else {
                        genres[2]=genres[2]+book.getPagesRead();
                    }
                } else {
                    Magazine magazine = (Magazine) product;
                    if(magazine.getCategory()==Category.VARIETIES) {
                        categories[0]=categories[0]+magazine.getPagesRead();
                    } else if (magazine.getCategory()==Category.DESIGN){
                        categories[1]=categories[1]+magazine.getPagesRead();
                    } else {
                        categories[2]=categories[2]+magazine.getPagesRead();
                    }
                }
            }

            String[] genreNames = {"Sci-Fi", "Fantasy", "Historical novel"};
            String[] categoryNames = {"Varieties", "Design", "Scientific"};
            int maxIndexG = 0;
            for (int i = 0; i < genres.length; i++) {
                if (genres[i] > genres[maxIndexG]) {
                    maxIndexG = i;
                }
            }
            int maxIndexC = 0;
            for (int i = 0; i < categories.length; i++) {
                if (categories[i] > categories[maxIndexC]) {
                    maxIndexC = i;
                }
            }

            if (genres[maxIndexG] > 0){
                message+=genreNames[maxIndexG]+"\n  Pages read: "+genres[maxIndexG];
            } else {
                message+="No books have been read yet.";
            }
            message+="\n- Most read category: ";
            if (categories[maxIndexC] > 0) {
                message+=categoryNames[maxIndexC]+"\n  Pages read: "+categories[maxIndexC];
            } else {
                message+="No magazines have been read yet.";
            }
        }
        return message;
    }

    public String getTop5MostReadProductsPerType(){
        String message="";
        if (products.isEmpty()){
            message="Error: No products registered yet.";
        } else {
            //Creates a list for each type of product and adds them to the list.
            ArrayList<Book> booksList = new ArrayList<>();
            ArrayList<Magazine> magazinesList = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if (product.getPagesRead() > 0){
                    if (product instanceof Book){
                        Book book = (Book) product;
                        booksList.add(book);
                    } else {
                        Magazine magazine = (Magazine) product;
                        magazinesList.add(magazine);
                    }
                }
            }
            
            String topBooks="Top 5 most read books: \n"; 
            if (booksList.isEmpty()){
                topBooks+="No books have been read yet. \n";
            } else {
                //Sorts the list of books according to the number of pages read.
                for (int i = 0; i < booksList.size(); i++) {
                    for (int j = i + 1; j < booksList.size(); j++) {
                        Book book1 = booksList.get(i);
                        Book book2 = booksList.get(j);
                        if (book2.getPagesRead() > book1.getPagesRead()) {
                            booksList.set(i, book2);
                            booksList.set(j, book1);
                        }
                    }
                }
                //Gets the name of the first books in the list
                for (int i = 0; i < Math.min(5, booksList.size()); i++) {
                    Book book = booksList.get(i);
                    topBooks+="-"+(i+1)+". "+book.getName()+"\n";
                }
            }

            String topMagazines="Top 5 most read magazines: \n";
            if (magazinesList.isEmpty()){
                topMagazines+="No magazines have been read yet. \n";
            } else {
                //Sorts the list of magazines according to the number of pages read.
                for (int i = 0; i < magazinesList.size(); i++) {
                    for (int j = i + 1; j < magazinesList.size(); j++) {
                        Magazine magazine1 = magazinesList.get(i);
                        Magazine magazine2 = magazinesList.get(j);
                        if (magazine2.getPagesRead() > magazine1.getPagesRead()) {
                            magazinesList.set(i, magazine2);
                            magazinesList.set(j, magazine1);
                        }
                    }
                }
                //Gets the name of the first magazines in the list
                for (int i = 0; i < Math.min(5, magazinesList.size()); i++) {
                    Magazine magazine = magazinesList.get(i);
                    topMagazines+="-"+(i+1)+". "+magazine.getName()+"\n";
                }
            }
            message=topBooks+topMagazines;
        }
        return message;
    }

    public String getSoldNumAndTotalPaidPerGenre(){
        String list="";
        if (invoices.isEmpty()){
            list="Error: No products have been sold yet";
        } else {
            int salesTotals[] = new int[3];
            double valuesTotals[] = new double[3];
            for (int i = 0; i < invoices.size(); i++) {
                Invoice invoice = invoices.get(i);
                Product product = invoice.getProduct();
                if (invoice.getProduct() instanceof Book) {
                    Book book = (Book) product;
                    if(book.getGenre()==Genre.SCI_FI) {
                        valuesTotals[0]=valuesTotals[0]+invoice.getAmountPaid();
                        salesTotals[0]++;
                    } else if (book.getGenre()==Genre.FANTASY){
                        valuesTotals[1]=valuesTotals[1]+invoice.getAmountPaid();
                        salesTotals[1]++;
                    } else {
                        valuesTotals[2]=valuesTotals[2]+invoice.getAmountPaid();
                        salesTotals[2]++;
                    }
                }
            }
            String[] genreNames = {"- Sci-Fi:", "- Fantasy:", "- Historical novel:"};
            for (int i = 0; i < 3; i++) {
                list+=genreNames[i]+"\n  Copies sold: "+salesTotals[i]+"\n  Total sales value: $"+valuesTotals[i]+"\n";
            }
        }
        return list;
    }

    public String getActSubsAndTotalPaidPerCategory(){
        String list="";
        if (invoices.isEmpty()){
            list="Error: No products have been sold yet";
        } else {
            int activeSubs[] = new int[3];
            double valuesTotals[] = new double[3];
            for (int i = 0; i < invoices.size(); i++) {
                Invoice invoice = invoices.get(i);
                Product product = invoice.getProduct();
                if (invoice.getProduct() instanceof Magazine) {
                    Magazine magazine = (Magazine) product;
                    if(magazine.getCategory()==Category.VARIETIES) {
                        activeSubs[0]=activeSubs[0]+magazine.getActiveSubscriptions();
                        valuesTotals[0]=valuesTotals[0]+invoice.getAmountPaid();
                    } else if (magazine.getCategory()==Category.DESIGN){
                        activeSubs[1]=activeSubs[1]+magazine.getActiveSubscriptions();
                        valuesTotals[1]=valuesTotals[1]+invoice.getAmountPaid();
                    } else {
                        activeSubs[2]=activeSubs[2]+magazine.getActiveSubscriptions();
                        valuesTotals[2]=valuesTotals[2]+invoice.getAmountPaid();
                    }
                }
            }
            String[] categoryNames = {"- Varieties:", "- Design:", "- Scientific:"};
            for (int i = 0; i < 3; i++) {
                list+=categoryNames[i]+"\n  Active subscriptions: "+activeSubs[i]+"\n  Total sales value: $"+valuesTotals[i]+"\n";
            }
        }
        return list;
    }

    private User searchUser(String id){
        User userFound=null;
        boolean found=false;
        for (int i=0; i < users.size() && !found; i++) {
            User user=users.get(i);
            if (user.getId().equals(id)){
                userFound=user;
                found=true;
            }
        }
        return userFound;
    }

    private Product searchProduct(String id){
        Product productFound=null;
        boolean found=false;
        for (int i=0; i < products.size() && !found; i++) {
            Product product=products.get(i);
            if (product.getId().equals(id)){
                productFound=product;
                found=true;
            }
        }
        return productFound;
    }
}  