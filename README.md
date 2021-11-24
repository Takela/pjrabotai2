# pjrabotai2

DataBase(JSON)
Это не sql с метанита + одну строку добавил



![Screenshot](https://github.com/Takela/pjrabotai2/blob/master/app/src/1.png?raw=true)

![Screenshot](https://github.com/Takela/pjrabotai2/blob/master/app/src/2.png?raw=true)

![Screenshot](https://github.com/Takela/pjrabotai2/blob/master/app/src/3.png?raw=true)

(Добавил user)Код:


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

JSONHelper :


package com.example.pjrabotai2;

import android.content.Context;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class JSONHelper {

    private static final String FILE_NAME = "data.json";

    static boolean exportToJSON(Context context, List<User> dataList) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setUsers(dataList);
        String jsonString = gson.toJson(dataItems);

        try(FileOutputStream fileOutputStream =
                    context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    static List<User> importFromJSON(Context context) {

        try(FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            InputStreamReader streamReader = new InputStreamReader(fileInputStream)){

            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(streamReader, DataItems.class);
            return  dataItems.getUsers();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    private static class DataItems {
        private List<User> users;

        List<User> getUsers() {
            return users;
        }
        void setUsers(List<User> users) {
            this.users = users;
        }
    }
}
