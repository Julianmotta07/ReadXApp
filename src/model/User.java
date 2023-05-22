package model;
import java.util.Calendar;

public abstract class User{

    //attribute
    private String name;
    private String id;
    private Calendar vinculationDate;
    private String[][] library;

    //constant
    private final int LIBRARY_SIZE=5;

    public User(String name, String id){
        this.name=name;
        this.id=id;
        vinculationDate = Calendar.getInstance();
        library= new String[LIBRARY_SIZE][LIBRARY_SIZE]; 
    }

    public String displayLibrary(){
        String matrix="\n     0  |  1  |  2  |  3  |  4 \n";
        for (int i = 0; i < library.length; i++) {
            matrix+=i+" ";
            for (int j = 0; j < library[i].length; j++) {
              matrix+="| "+(library[i][j] + " ");
            }
            matrix+="\n";
        }
        return matrix;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String[][] getLibrary(){
        return library;
    }

    public String toString(){
        return "Name: " + name + "\n" +
        "ID: " + id + "\n";
    }
}