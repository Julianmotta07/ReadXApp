package model;

public abstract class User{

    //attribute
    private String name;
    private int id;

    public User(String name, int id){
        this.name=name;
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "Name: " + name + "\n" +
        "ID: " + id + "\n";
    }
}