package ui;

import java.util.Scanner;
import model.Company;

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
            System.out.println("-----------Welcome to the menu----------");
            System.out.println("------------Select an option------------");
            System.out.println("1: Register user........................");
            System.out.println("2: Register product.....................");
            System.out.println("3: Edit product.........................");
            System.out.println("4: Delete product.......................");
            System.out.println("5: Generate object......................");
            System.out.println("6: Buy book.............................");
            System.out.println("7: Subscribe book.......................");
            System.out.println("8: Display my library...................");
            System.out.println("9: Report pages read by product.........");
            System.out.println("10: Report genre and category most read.");
            System.out.println("11: Report Top 5 most read products.....");
            System.out.println("12: Report total number sales and total."); 
            System.out.println("    sales per genre.....................");
            System.out.println("13: Report active subscriptions number..");
            System.out.println("    and total paid per category.........");
            System.out.println("0: Exit.................................");
            System.out.println("----------------------------------------");
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
                    generateObject();
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
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 9:
                    reportPagesReadByProduct();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 10:
                    reportGenreAndCategoryMostRead();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 11:
                    reportTop5MostReadProducts();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 12:
                    soldNumAndTotalPaidPerGenre();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 13:
                    actSubsNumAndTotalPaidPerCategory();
                    System.out.println("Press Enter to return to the menu...");
                    lector.nextLine();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option, try again!");
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
        String publicationDate=lector.nextLine();
        System.out.println("Enter repository URL:");
        String url=lector.nextLine();
        System.out.println("Select product type \n 1: Book \n 2: Magazine");
        int productType=lector.nextInt();
        lector.nextLine();

        if (productType==1){
            System.out.println("Enter sale value:");
            double value=lector.nextDouble();
            lector.nextLine();
            System.out.println("Enter short review:");
            String review=lector.nextLine();
            System.out.println("Select genre \n 1: Sci-fi \n 2: Fantasy \n 3: Historical novel");
            int genreOpt=lector.nextInt();
            lector.nextLine();

            String message= company.addProduct(name, pagesNum, publicationDate, url, productType, value, review, genreOpt, null, 0);
            System.out.println(message);

        } else {
            System.out.println("Enter subscription value:");
            double value=lector.nextDouble();
            lector.nextLine();
            System.out.println("Enter issuance frequency:");
            String issuanceFrequency=lector.nextLine();
            System.out.println("Select category \n 1: Varieties \n 2: Design \n 3: Scientific");
            int categoryOpt=lector.nextInt();
            lector.nextLine();

            String message= company.addProduct(name, pagesNum, publicationDate, url, productType, value, null, 0, issuanceFrequency, categoryOpt);
            System.out.println(message);

        }

    }

    public void editProduct(){

    }

    public void deleteProduct(){

    }

    public void generateObject(){

    }

    public void buyBook(){

    }

    public void subscribeMagazine(){
        
    }

    public void displayMyLibrary(){

    }

    public void reportPagesReadByProduct(){
        
    }

    public void reportGenreAndCategoryMostRead(){

    }

    public void reportTop5MostReadProducts(){

    }

    public void soldNumAndTotalPaidPerGenre(){

    }

    public void actSubsNumAndTotalPaidPerCategory(){

    }
}