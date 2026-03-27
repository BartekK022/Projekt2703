package com.example.projekt2703;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    ListView listView;
    //moze byc konieczny import klasy ListView
    ArrayList<String> arrayListowoce;
    ArrayAdapter<String> arrayAdapter;

    //lista w strings.xml!!! na dwa


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);
        arrayListowoce = new ArrayList<>();
        arrayListowoce.add("banan");
        arrayListowoce.add("arbuz");
        arrayListowoce.add("malina");
        arrayListowoce.add("truskawski");
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayListowoce);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      //zmienia kolor jak nacisniesz:
                        // view.setBackgroundColor(Color.GREEN);
                        //usuwa rekord jak go nacisniesz:
                        arrayListowoce.remove(position);
                        arrayAdapter.notifyDataSetChanged();

                    }
                }
        );

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String owoc = editText.getText().toString();
                        arrayListowoce.add(owoc);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );

    }
}