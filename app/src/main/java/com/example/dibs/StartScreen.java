package com.example.dibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StartScreen extends AppCompatActivity {
    Context context;
    RequestQueue requestQueue;
    String url;
    Toast loginFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        // Load variables with data
        context = getApplicationContext();
        requestQueue = Volley.newRequestQueue(this);
        url = getText(R.string.server_url).toString() + "/login";
        loginFail = Toast.makeText(context, "Wrong username or password", Toast.LENGTH_LONG);
    }

    // Creates the listener and handler for the login request to server.
    Response.Listener<JSONObject> loginResponseListener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                if(response.getBoolean("loggedIn")) {
                    //TODO: Implement api key handling
                    response.getString("apiKey");
                    Intent intent = new Intent(StartScreen.this, Home.class);
                    startActivity(intent);
                } else {
                    //TODO: Implement more failed login functionality like too many attempts
                    loginFail.show();
                }
            } catch (JSONException e) {
                loginFail.show();
            }
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("LOGIN_ERROR", "Error: " +  error.getMessage());
        }
    };

    /**
     * Executes login by calling server with username and password.
     * @param view Login Button
     */
    public void login(View view) {
        EditText usernameTextField = (EditText) findViewById(R.id.name);
        EditText passwordTextField = (EditText) findViewById(R.id.password);
        String username = usernameTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        JSONObject json = new JSONObject();
        // Placed in try catch because by default, key can be empty.
        try {
            json.put("username", username);
            json.put("password", password);
        } catch (JSONException ignored) { }
        JsonObjectRequest request = new JsonObjectRequest(url, json, loginResponseListener, errorListener);
        requestQueue.add(request);
    }
}
