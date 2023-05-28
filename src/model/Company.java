package model;
import java.util.*;

public class Company{

    //Attribute
    private String name;
    
    //Relations
    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Invoice> invoices;

    /**
	 * Constructor for the Company class.
	 * 
	 * <br>post:</br> A new instance of the Company class is created.
	 * 
	 * @param name The name of the company.
	 */
    public Company(String name){
        this.name=name;
        users= new ArrayList<>();
        products= new ArrayList<>();
        invoices= new ArrayList<>();
    }

    /**
     * Adds a new user to the company's user list.
     * 
     * <br>pre:</br> Parameter "userType" must be an integer value between 1 and 2.
     * <br>post:</br> A new user is added to the company's user list.
     *
     * @param name The name of the user.
     * @param id The identification of the user.
     * @param userType The type of user (1:REGULAR USER, 2: PREMIUM USER).
     * @return A string message indicating the result of the user addition.
     */
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

    /**
     * Adds a new book to the company's product list.
     * 
     * <br>pre:</br> Parameter "genreOpt" must be an integer value between 1 and 3.
     * <br>post:</br> A new book is added to the company's product list.
     *
     * @param id The identifier of the book.
	 * @param name The name of the book.
	 * @param pagesNum The pages number of the book.
	 * @param publicationDate The publication date of the book.
     * @param url The URL of the repository with the book cover.
	 * @param saleValue The sale value of the book.
	 * @param review The review of the book.
	 * @param genreOpt The book genre option (1:SCI-FI, 2:FANTASY, 3:HISTORICAL NOVEL).
     * @return A string message indicating the result of the book addition.
     */
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

    /**
     * Adds a new magazine to the company's product list.
     * 
     * <br>pre:</br> Parameters "issuanceFreqOpt" and "categoryOpt" must be an integer value between 1 and 3.
     * <br>post:</br> A new magazine is added to the company's product list.
     *
     * @param id The identifier of the magazine.
	 * @param name The name of the magazine.
	 * @param pagesNum The pages number of the magazine.
	 * @param publicationDate The publication date of the magazine.
     * @param url The URL of the repository with the magazine cover.
	 * @param subscriptionValue The subscription value of the magazine.
	 * @param issuanceFreqOpt The magazine issuance frequency option (1:WEEKLY, 2:MONTHLY, 3:YEARLY).
	 * @param categoryOpt The magazine category option (1:VARIETIES, 2:DESIGN, 3:SCIENTIFIC).
     * @return A string message indicating the result of the magazine addition.
     */
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

    /**
     * Edits an existing book in the company's product list.
     * 
     * <br>pre:</br> Parameter "genreOpt" must be an integer value between 1 and 3.
     * <br>post:</br> The information in the book is updated.
     *
     * @param id The identifier of the book to be edited.
     * @param name The new name of the book.
     * @param pagesNum The new number of pages of the book.
     * @param publicationDate The new publication date of the book.
     * @param url The new URL of the book's cover.
     * @param value The new sale value of the book.
     * @param review The new review of the book.
     * @param genreOpt The new genre option of the book (1:SCI-FI, 2:FANTASY, 3:HISTORICAL NOVEL).
     * @return A string message indicating the result of the book edit.
     */
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

    /**
     * Edits an existing magazine in the company's product list.
     * 
     * <br>pre:</br> Parameters "issuanceFreqOpt" and "categoryOpt" must be an integer value between 1 and 3.
     * <br>post:</br> The information in the magazine is updated.
     *
     * @param id The identifier of the magazine to be edited.
     * @param name The new name of the magazine.
     * @param pagesNum The new number of pages of the magazine.
     * @param publicationDate The new publication date of the magazine.
     * @param url The new URL of the magazine's cover.
     * @param value The new subscription value of the magazine.
     * @param issuanceFreqOpt The new issuance frequency option of the magazine (1:VARIETIES, 2:DESIGN, 3:SCIENTIFIC).
     * @param categoryOpt The new category option of the magazine (1:VARIETIES, 2:DESIGN, 3:SCIENTIFIC).
     * @return A string message indicating the result of the magazine edit.
     */
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

    /**
     * Deletes a product from the company's product list.
     * 
     * <br>post:</br> The product is removed from the company's product list.
     *
     * @param id The identifier of the product to be deleted.
     * @return A string message indicating the result of the product deletion.
     */
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

    /**
     * Generates objects for testing purposes.
     * 
     * <br>post:</br> The generated objects are added to the corresponding company lists.
     *
     * @return A string message containing the information of the generated objects.
     */
    public String generateObjects(){
        String message="Generated objects: \n";
        //Generate random 5-digit IDs
        int randomID1 = (int) (Math.random() * 90000) + 10000;
        String regularID = String.valueOf(randomID1);
        int randomID2 = (int) (Math.random() * 90000) + 10000;
        String premiumID = String.valueOf(randomID2);
        //Generate 3-character hexadecimal ID
        int randomID3 = (int) (Math.random() * 4096);
        String bookID = Integer.toHexString(randomID3).toUpperCase();
        if (bookID.length() < 3) {
            bookID = "0" + bookID;
        }
        //Create a 3-character alphanumeric ID
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
        //Create the objects
        RegularUser regularUser = new RegularUser("Regular user "+regularID, regularID);
        PremiumUser premiumUser = new PremiumUser("Premium user "+premiumID, premiumID);
        Book book = new Book(bookID, "Book "+bookID, 100, Calendar.getInstance(), "test.png", 15, "Review text", 1);
        Magazine magazine = new Magazine(MagazineID, "Magazine "+MagazineID, 100, Calendar.getInstance(), "test.png", 10, 1, 1);
        //Add the objetcs
        users.add(regularUser);
        users.add(premiumUser);
        products.add(book);
        products.add(magazine);
        //Get the information of each object
        message +="\n"+ regularUser.toString() + "\n" + premiumUser.toString() + "\n" + book.toString() + "\n" + magazine.toString();
        return message;
    }

    /**
     * Processes the purchase of a book by a user.
     * 
     * <br>post:</br> The book is added to the user's product list or books array and an invoice is created with the transaction information.
     *
     * @param userId The identification of the user making the purchase.
     * @param bookId The identifier of the book being purchased.
     * @return A string message indicating the result of the operation and the invoice information generated in case of success.
     */
    public String buyBook(String userId, String bookId){
        String message="\nBook catalog:\n";
        User user = searchUser(userId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else if (bookId==null){
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if (product instanceof Book){
                    message+="\n"+product.toString();
                }
            }
        } else {
            Product product = searchProduct(bookId);
            if (product==null || product instanceof Magazine ){
                message="Error: A book with the entered ID does not exist.";
            } else {
                Book book = (Book) product;
                if (user instanceof RegularUser){
                RegularUser regularUser = (RegularUser) user;
                message = regularUser.addBook(book);      
                } else {
                PremiumUser premiumUser = (PremiumUser) user;
                message = premiumUser.addProduct(book);
                }
                if (message.equals("\nBook successfully purchased!.")){
                    Invoice newInvoice= new Invoice(book.getValue(), user, product);
                    invoices.add(newInvoice);
                    book.setCopiesSold(book.getCopiesSold()+1);
                    message+="\n\nInvoice: \n"+newInvoice.toString();
                }
            }
        }
        return message;
    }

    /**
     * Processes the subscription of a magazine by a user.
     * 
     * <br>post:</br> The magazine is added to the user's product list or magazines array and an invoice is created with the transaction information.
     *
     * @param userId The identification of the user subscribing to the magazine.
     * @param magazineId The identifier of the magazine being subscribed to.
     * @return A string message indicating the result of the operation and the invoice information generated in case of success.
     */
    public String subscribeMagazine(String userId, String magazineId){
        String message="\nMagazine catalog:\n";
        User user = searchUser(userId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else if (magazineId==null){
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                if (product instanceof Magazine){
                    message+="\n"+product.toString();
                }
            }
        } else {
            Product product = searchProduct(magazineId);
            if (product==null || product instanceof Book){
                message="Error: A magazine with the entered ID does not exist.";
            } else {
                Magazine magazine = (Magazine) product;
                if (user instanceof RegularUser){
                RegularUser regularUser = (RegularUser) user;
                message = regularUser.addMagazine(magazine);
                } else {
                PremiumUser premiumUser = (PremiumUser) user;
                message = premiumUser.addProduct(magazine);
                }
                if (message.equals("\nMagazine subscription successfully completed!.")){
                    Invoice newInvoice= new Invoice(magazine.getValue(), user, product);
                    invoices.add(newInvoice);
                    magazine.setActiveSubscriptions(magazine.getActiveSubscriptions()+1);
                    message+="\n\nInvoice: \n"+newInvoice.toString();
                }
            } 
        }
        return message;
    }
    
    /**
     * Processes the unsubscription of a magazine by a user.
     * 
     * <br>post:</br> The magazine is removed from the user's product list or magazines array.
     *
     * @param userId The identification of the user unsubscribing from the magazine.
     * @param magazineId The identifier of the magazine being unsubscribed from.
     * @return A string message indicating the result of the operation.
     */
    public String unsubscribeMagazine(String userId, String magazineId){
        String message="\nCurrent user subscriptions:\n";
        User user = searchUser(userId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else if (magazineId==null){
            boolean foundMagazine=false;
            if (user instanceof RegularUser){
                RegularUser regularUser = (RegularUser) user;
                for (int i = 0; i < regularUser.getMagazines().length; i++) {
                    if (regularUser.getMagazines()[i]!=null){
                        message+="\n Name: "+regularUser.getMagazines()[i].getName()+"\n ID: "+regularUser.getMagazines()[i].getId()+"\n";
                        foundMagazine=true;
                    }
                }
            } else {
                PremiumUser premiumUser = (PremiumUser) user;
                for (int i = 0; i < premiumUser.getProducts().size(); i++) {
                    Product product = products.get(i);
                    if (product instanceof Magazine){
                        message+="\n Name: "+product.getName()+"\n ID: "+product.getId()+"\n";
                        foundMagazine=true;
                    }
                }
            }
            if (!foundMagazine){
                message="Error: The user has not subscribed to any magazine.";
            }
        } else {
            Product product = searchProduct(magazineId);
            if (product==null || product instanceof Book){
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
        }
        return message;
    }
    
    /**
     * Displays the library of a user.
     *
     * @param userId The identification of the user whose library is to be displayed.
     * @param pageNum The page number of the library to be displayed.
     * @return A string message displaying the user's library.
     */
    public String displayMyLibrary(String userId, int pageNum){
        String message="";
        User user = searchUser(userId);
        if (user==null){
            message="Error: A user with the entered ID does not exist."; 
        } else {
            if (user instanceof RegularUser) {
                RegularUser regularUser = (RegularUser) user;
                message+=regularUser.showLibrary(pageNum);
            } else {
                PremiumUser premiumUser = (PremiumUser) user;
                message+=premiumUser.showLibrary(pageNum);
            } 
        }    
        return message;
    }

    /**
     * Simulates a reading session for a user.
     *
     * @param userId The identification of the user.
     * @param productId The identifier of the product to read.
     * @param pageOpt The navigation option in the simulation ('S' for next page).
     * @param page The current page being read.
     * @param pagesCount The product's page count read.
     * @return A string message simulating the reading session.
     */
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

    /**
     * Simulates a reading session for a user.
     *
     * @param userId The identification of the user.
     * @param xCoord The x-coordinate of the product in the library.
     * @param yCoord The y-coordinate of the product in the library.
     * @param pageOpt The navigation option in the simulation ('S' for next page).
     * @param page The current page being read.
     * @param pagesCount The product's page count read.
     * @return A string message simulating the reading session.
     */
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

    /**
     * Retrieves the total number of pages read per bibliographic product type.
     *
     * @return A string listing the pages read per product type.
     */
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

    /**
     * Retrieves the most read genre and category based on the accumulated page counts of products.
     *
     * @return A string indicating the most read genre and category, along with the corresponding page counts.
     */
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

    /**
     * Retrieves the top 5 most read products per type (books and magazines).
     *
     * @return A string indicating the top 5 most read books and magazines.
     */
    public String getTop5MostReadProductsPerType(){
        String message="";
        if (products.isEmpty()){
            message="Error: No products registered yet.";
        } else {
            //Create a list for each type of product and adds them to the list.
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
                //Sort the list of books according to the number of pages read.
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
                //Get the name of the first books in the list
                for (int i = 0; i < Math.min(5, booksList.size()); i++) {
                    Book book = booksList.get(i);
                    topBooks+="-"+(i+1)+". "+book.getName()+"\n";
                }
            }

            String topMagazines="Top 5 most read magazines: \n";
            if (magazinesList.isEmpty()){
                topMagazines+="No magazines have been read yet. \n";
            } else {
                //Sort the list of magazines according to the number of pages read.
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
                //Get the name of the first magazines in the list
                for (int i = 0; i < Math.min(5, magazinesList.size()); i++) {
                    Magazine magazine = magazinesList.get(i);
                    topMagazines+="-"+(i+1)+". "+magazine.getName()+"\n";
                }
            }
            message=topBooks+topMagazines;
        }
        return message;
    }

    /**
     * Retrieves the number of books sold and the total amount paid per genre.
     *
     * @return A string indicating the number of books sold and the total sales value per genre.
     */
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

    /**
     * Retrieves the number of active subscriptions and the total amount paid in subscriptions per magazine category.
     *
     * @return A string indicating the number of active subscriptions and the total amount paid in subscriptions per magazine category.
     */
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

    /**
     * Retrieves the company's current product list.
     *
     * @return a message containing the company's current product list.
     */
    public String showProductList(){
        String message="Current product list: \n";
        if (products.isEmpty()){
            message="Error: No products registered yet.";
        } else {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                message+="\n Name: "+product.getName()+"\n ID: "+product.getId()+"\n";
            }
        }
        return message;
    }

    /**
	 * Searches for a user in the company's user list based on the identification provided.
	 *
	 * @param id The identification of the user to search for.
     * @return The found user or null if not found.
	 */
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

    /**
	 * Searches for a product in the company's product list based on the identifier provided.
	 *
	 * @param id The identifier of the product to search for.
     * @return The found product or null if not found.
	 */
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