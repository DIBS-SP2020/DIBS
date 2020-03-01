package com.example.dibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartScreen extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        Name = (EditText)findViewById(R.id.name);
        Password = (EditText)findViewById(R.id.password);
        Login = (Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    validate(Name.getText().toString(), Password.getText().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void validate (View view) throws InterruptedException {
        if ((view.findViewById().equals("Admin")) && (userPassword.equals("Admin"))) {
            Intent intent = new Intent(StartScreen.this, Home.class);
            startActivity(intent);
        }
    }
}
