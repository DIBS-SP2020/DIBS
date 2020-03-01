package com.example.dibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class StartScreen extends AppCompatActivity {
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    String url = getText(R.string.server_url).toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
    }

    public void login(View view) {
        EditText usernameTextField = (EditText) findViewById(R.id.name);
        EditText passwordTextField = (EditText) findViewById(R.id.password);
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        //JsonObjectRequest request = new JsonObjectRequest();
        if(username.equals("Admin") && password.equals("Admin")) {
            Intent intent = new Intent(StartScreen.this, Home.class);
            startActivity(intent);
        }
    }
}
