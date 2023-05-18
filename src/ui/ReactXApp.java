package ui;
import java.util.Scanner;
import model.Company;
import java.util.Calendar;

public class ReactXApp {

	public static Company company;
    public static Scanner lector;

	public ReactXApp(String name) {
		company = new Company(name);
		lector = new Scanner(System.in);
	}

	public static void main(String[] args) {
		ReactXApp objMain = new ReactXApp("ReactX");
		objMain.menu();
	}

    public void menu(){
        int option;
        do{
            System.out.println("--------------Welcome to the menu------------");
            System.out.println("---------------Select an option--------------");
            System.out.println("1: Register user.............................");
            System.out.println("2: Register product..........................");
            System.out.println("3: Edit product..............................");
            System.out.println("4: Delete product............................");
            System.out.println("5: Generate objects..........................");
            System.out.println("6: Buy book..................................");
            System.out.println("7: Subscribe magazine........................");
            System.out.println("8: Display my library........................");
            System.out.println("9: Simulate reading session..................");
            System.out.println("10: Report pages read per product type.......");
            System.out.println("11: Report genre and category most read......");
            System.out.println("12: Report Top 5 most read products..........");
            System.out.println("13: Report total number sales and total sales"); 
            System.out.println("    per genre................................");
            System.out.println("14: Report active subscriptions number and...");
            System.out.println("    total paid per category..................");
            System.out.println("0: Exit......................................");
            System.out.println("---------------------------------------------");
            option=lector.nextInt();
            lector.nextLine();
            switch(option){
                case 1:
                    registerUser();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 2:
                    registerProduct();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 3:
                    editProduct();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 4:
                    deleteProduct();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 5:
                    generateObjects();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 6:
                    buyBook();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 7:
                    subscribeMagazine();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 8:
                    displayMyLibrary();
                    break;
                case 9:
                    simulateReadingSession();
                    break;
                case 10:
                    reportPagesReadPerProduct();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 11:
                    reportGenreAndCategoryMostRead();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 12:
                    reportTop5MostReadProductsPerType();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 13:
                    soldNumAndTotalPaidPerGenre();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 14:
                    actSubsNumAndTotalPaidPerCategory();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option, try again!");
                    lector.nextLine();
            }
        } while (option!=0);
    }

    public void registerUser(){
        System.out.println("Enter name:");
        String name=lector.nextLine();
        System.out.println("Enter identification:");
        int id=lector.nextInt();
        lector.nextLine();
        System.out.println("Select user type \n 1: Regular \n 2: Premium");
        int userType=lector.nextInt();
        lector.nextLine();

        String message= company.addUser(name, id, userType);
        System.out.println(message);
    }

    public void registerProduct(){
        System.out.println("Enter name:");
        String name=lector.nextLine();
        System.out.println("Enter pages number:");
        int pagesNum=lector.nextInt();
        lector.nextLine();

        System.out.println("Enter publication date (dd/mm/yyyy):");
        String input = lector.nextLine();
        String[] parts = input.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1;
        int year = Integer.parseInt(parts[2]);
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);

        System.out.println("Enter repository URL:");
        String url=lector.nextLine();
        System.out.println("Select product type \n 1: Book \n 2: Magazine");
        int productType=lector.nextInt();
        lector.nextLine();

        if (productType==1){
            System.out.println("Enter hexadecimal identifier:");
            String id=lector.nextLine();
            System.out.println("Enter sale value:");
            double value=lector.nextDouble();
            lector.nextLine();
            System.out.println("Enter short review:");
            String review=lector.nextLine();
            System.out.println("Select genre \n 1: Sci-fi \n 2: Fantasy \n 3: Historical novel");
            int genreOpt=lector.nextInt();
            lector.nextLine();

            String message= company.addProduct(id, name, pagesNum, date, url, value, review, genreOpt);
            System.out.println(message);

        } else {
            System.out.println("Enter alphanumeric identifier:");
            String id=lector.nextLine();
            System.out.println("Enter subscription value:");
            double value=lector.nextDouble();
            lector.nextLine();
            System.out.println("Select issuance frequency: \n 1: Weekly \n 2: Monthly \n 3: Yearly");
            int issuanceFreqOpt=lector.nextInt();
            lector.nextLine();
            System.out.println("Select category: \n 1: Varieties \n 2: Design \n 3: Scientific");
            int categoryOpt=lector.nextInt();
            lector.nextLine();

            String message= company.addProduct(id, name, pagesNum, date, url, value, issuanceFreqOpt, categoryOpt);
            System.out.println(message);
        }
    }

    public void editProduct(){
        System.out.println("Enter identifier:");
        String id=lector.nextLine();
        System.out.println("Enter new pages number:");
        int pagesNum=lector.nextInt();
        lector.nextLine();

        System.out.println("Enter new publication date (dd/mm/yyyy):");
        String input = lector.nextLine();
        String[] parts = input.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1;
        int year = Integer.parseInt(parts[2]);
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);

        System.out.println("Enter new repository URL:");
        String url=lector.nextLine();
        System.out.println("Select product type \n 1: Book \n 2: Magazine");
        int productType=lector.nextInt();
        lector.nextLine();

        if (productType==1){
            System.out.println("Enter new sale value:");
            double value=lector.nextDouble();
            lector.nextLine();
            System.out.println("Enter new short review:");
            String review=lector.nextLine();
            System.out.println("Select new genre \n 1: Sci-fi \n 2: Fantasy \n 3: Historical novel");
            int genreOpt=lector.nextInt();
            lector.nextLine();

            String message= company.editProduct(id, pagesNum, date, url, value, review, genreOpt, 0, 0);
            System.out.println(message);

        } else {
            System.out.println("Enter new subscription value:");
            double value=lector.nextDouble();
            lector.nextLine();
            System.out.println("Select new issuance frequency: \n 1: Weekly \n 2: Monthly \n 3: Yearly");
            int issuanceFreqOpt=lector.nextInt();
            lector.nextLine();
            System.out.println("Select new category: \n 1: Varieties \n 2: Design \n 3: Scientific");
            int categoryOpt=lector.nextInt();
            lector.nextLine();

            String message= company.editProduct(id, pagesNum, date, url, value, null, 0, issuanceFreqOpt, categoryOpt);
            System.out.println(message);
        }
    }

    public void deleteProduct(){
        System.out.println("Enter identifier:");
        String id=lector.nextLine();

        String message= company.deleteProduct(id);
        System.out.println(message);
    }

    public void generateObjects(){
        String message= company.generateObjects();
        System.out.println(message);
    }

    public void buyBook(){
        System.out.println("Enter user identification:");
        int userId=lector.nextInt();
        lector.nextLine();
        System.out.println("Enter book identifier:");
        String bookId=lector.nextLine();

        String message= company.buyBook(userId, bookId);
        System.out.println(message);
    }

    public void subscribeMagazine(){
        System.out.println("Enter user identification:");
        int userId=lector.nextInt();
        lector.nextLine();
        System.out.println("Enter magazine identifier:");
        String magazineId=lector.nextLine();

        String message= company.subscribeMagazine(userId, magazineId);
        System.out.println(message);
    }

    public void displayMyLibrary(){
        System.out.println("Enter user identification:");
        int userId=lector.nextInt();
        lector.nextLine();

        int pageNum=0;
        boolean exit=false;
        do {
            String library= company.displayMyLibrary(userId, pageNum);
            System.out.println(library);
            if ((!library.equals("Error: A user with the entered ID does not exist."))){                
                System.out.println("Enter S to go to the next page");
                if (pageNum>=1){
                    System.out.println("Enter A to return to the previous page");
                }
                System.out.println("Enter M to return to the menu");
                char option = lector.next().charAt(0);
                lector.nextLine();
                if (option!='M'){
                    if(option=='S'){
                        pageNum++;
                    } else if (option=='A'){
                        pageNum--;
                    } else {
                        System.out.println("Invalid character. Press Enter and try again.");
                        lector.nextLine();
                    }
                } else {
                    exit=true;
                }
            } else {
                exit=true;
                System.out.println("Press Enter to return to the menu...");
                lector.nextLine();
            }
        } while (!exit);
    }

    public void simulateReadingSession(){
        System.out.println("Enter user identification:");
        int userId=lector.nextInt();
        lector.nextLine();

        boolean exit=false;
        char pageOpt='S';
        int pageNum=0;
        do {
            String library= company.displayMyLibrary(userId, pageNum);
            System.out.println(library);
            if ((!library.equals("Error: A user with the entered ID does not exist."))){ 
                System.out.println("Enter M to return to the menu");
                System.out.println("Enter S to go to the next page");
                if (pageNum>=1){
                    System.out.println("Enter A to return to the previous page");
                }
                System.out.println("How do you want to select your product? \n I: Identifier \n C: Coordinate");
                char input = lector.next().charAt(0);
                lector.nextLine();
                switch(input){
                    default:
                        if (input=='I' || input=='C'){
                            String productId=""; 
                            int xCoord=-1; int yCoord=-1; 
                            if (input=='I'){
                                System.out.println("Enter identifier:");
                                productId = lector.nextLine();
                            } else {
                                System.out.println("Enter X coordinate:");
                                xCoord = lector.nextInt();
                                lector.nextLine();
                                System.out.println("Enter Y coordinate:");
                                yCoord = lector.nextInt();
                                lector.nextLine();
                            }
                            String sesion="";
                            int page=1; int pagesCount=1;
                            do {
                                if (!productId.equals("")){
                                    sesion=company.simulateReadingSesion(userId, productId, pageOpt, page, pagesCount);
                                } else {
                                    sesion=company.simulateReadingSesion(userId, xCoord, yCoord, pageOpt, page, pagesCount);
                                }
                                System.out.println(sesion);
                                if (!sesion.equals("Error: Product not found.")){
                                    if (!sesion.equals("\n\nEnd. \n\n")){
                                        System.out.println("Enter S to go to the next page");
                                    }
                                    if (page>1){
                                        System.out.println("Enter A to return to the previous page");
                                    }
                                    System.out.println("Enter L to return to the library");
                                    pageOpt=lector.next().charAt(0);
                                    lector.nextLine();
                                    if (pageOpt=='S'){
                                        page++;
                                    } else if (pageOpt=='A'){
                                        page--;
                                    }
                                    pagesCount++;
                                } else {
                                    System.out.println("Enter L to return to the library");
                                    pageOpt=lector.next().charAt(0);
                                    lector.nextLine();
                                }
                            } while (pageOpt!='L');
                        } else {
                            pageOpt='L';
                            System.out.println("Invalid character. Press Enter and try again.");
                            lector.nextLine();
                        }   
                        break;
                    case 'M':
                        exit=true;
                        break;
                    case 'S':
                        pageNum++;
                        pageOpt='L';
                        break;
                    case 'A':
                        pageNum--;
                        pageOpt='L';
                        break;
                }   
            } else {
                System.out.println("Press Enter to return to the menu...");
                lector.nextLine();
            }
        } while (pageOpt=='L' && !exit);
    }

    public void reportPagesReadPerProduct(){
        String message= company.getPagesReadPerProductType();
        System.out.println(message);
    }

    public void reportGenreAndCategoryMostRead(){
        String message= company.getGenreAndCategoryMostRead();
        System.out.println(message);
    }

    public void reportTop5MostReadProductsPerType(){
        String message= company.getTop5MostReadProductsPerType();
        System.out.println(message);
    }

    public void soldNumAndTotalPaidPerGenre(){
        String message= company.getSoldNumAndTotalPaidPerGenre();
        System.out.println(message);
    }

    public void actSubsNumAndTotalPaidPerCategory(){
        String message= company.getActSubsNumAndTotalPaidPerCategory();
        System.out.println(message);
    }
}