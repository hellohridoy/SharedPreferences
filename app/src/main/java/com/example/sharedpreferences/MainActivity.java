package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button save,load;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        save = findViewById(R.id.save);
        load = findViewById(R.id.load);
        textView = findViewById(R.id.showDetaisl);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = username.getText().toString();
                String pass = password.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("my", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userNameKey",name);
                editor.putString("passwordKey",pass);
                editor.commit();
                Toast.makeText(getApplicationContext(), "data saved", Toast.LENGTH_SHORT).show();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("my", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("userNameKey","data not faound");
                String pass = sharedPreferences.getString("passwordKey","data not faound");
                textView.setText(name+"\n"+pass);
            }
        });
    }
}