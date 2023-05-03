package model;

public class Company{

    //attribute
    private String name;
    
    //relations
    private User[] arrayUsers;

    //constant
    private final int MAX_USERS=50;

    public Company(String name){
        this.name=name;
        this.arrayUsers= new User[MAX_USERS];
    }

    public String addUser(String name, int id, int userType){
        String message="";
        if (searchUser(id)!=null){
            message="Error: A user with the entered ID already exists.";
        } else {
            boolean added=false;
            for (int i=0; i<arrayUsers.length && !added; i++){
                if (arrayUsers[i]==null){
                    if (userType==1){
                        arrayUsers[i]=new RegularUser(name, id);
                        message="Regular user sucessfully added!.";
                        added=true;
                    } else {
                        arrayUsers[i]=new PremiumUser(name, id);
                        message="Premium user sucessfully added!.";
                        added=true;
                    }
                }
            }
            if (!added){
                message="Error: No available space for more users.";
            }
        }
        return message;
    }


    public User searchUser(int id){
        User userFound=null;
        boolean found=false;
        for (int i = 0; i < arrayUsers.length && !found; i++) {
            if (arrayUsers[i]!=null && arrayUsers[i].getId()==id) {
                userFound=arrayUsers[i];
                found=true;
            }
        }
        return userFound;
    }

    public String addProduct(String name, int pagesNum, String publicationDate, String url, int productType, double value, String review, int genreOpt, String issuanceFrequency, int categoryOpt){
        String message="";
        return message;
    }
}  