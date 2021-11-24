package com.example.pjrabotai2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<User> adapter;
    private EditText nameText, IDT, emailT;
    private List<User> users;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameT);
        IDT = findViewById(R.id.IDT);
        emailT = findViewById(R.id.emailT);
        listView = findViewById(R.id.list);
        users = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
    }

    public void addUser(View view){
        String name = nameText.getText().toString();
        int age = Integer.parseInt(IDT.getText().toString());
        String email = emailT.getText().toString();
        User user = new User(name, age,email);
        users.add(user);
        adapter.notifyDataSetChanged();
    }

    public void save(View view){

        boolean result = JSONHelper.exportToJSON(this, users);
        if(result){
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
    }
    public void open(View view){
        users = JSONHelper.importFromJSON(this);
        if(users!=null){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
            listView.setAdapter(adapter);
            Toast.makeText(this, "Данные восстановлены", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Не удалось открыть данные", Toast.LENGTH_LONG).show();
        }
    }
}