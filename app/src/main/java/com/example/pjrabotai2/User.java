package com.example.pjrabotai2;

public class User {

    private String name;
    private int id;
    private String email;

    User(String name, int id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return id;
    }

    public void setAge(int age) {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    @Override
    public  String toString(){
        return "Имя: " + name + " ид: " + id + " мыло: " + email;
    }
}
